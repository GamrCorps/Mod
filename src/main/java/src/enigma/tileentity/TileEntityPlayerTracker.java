package src.enigma.tileentity;

import cpw.mods.fml.client.FMLClientHandler;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.Packet;
import net.minecraft.server.MinecraftServer;
import net.minecraft.tileentity.TileEntity;

import java.util.List;

/**
 * Created by Matthew on 8/16/2015.
 */
public class TileEntityPlayerTracker extends TileEntity {
    public double X = 0, Y = 0, Z = 0;
    public static final double XD = 0, YD = 0, ZD = 0;

    public String playerName = "";
    public static final String playerNameD = "expertgamer16985";

    public boolean online = false;
    public static final boolean onlineD = false;

    @Override
    public void readFromNBT(NBTTagCompound nbtTagCompound) {
        X = nbtTagCompound.getDouble("X");
        Y = nbtTagCompound.getDouble("Y");
        Z = nbtTagCompound.getDouble("Z");
        playerName = nbtTagCompound.getString("playerName");
        online = nbtTagCompound.getBoolean("online");
        super.readFromNBT(nbtTagCompound);
    }

    @Override
    public void writeToNBT(NBTTagCompound nbtTagCompound) {
        nbtTagCompound.setDouble("X", X);
        nbtTagCompound.setDouble("Y", Y);
        nbtTagCompound.setDouble("Z", Z);
        nbtTagCompound.setString("playerName", playerName);
        nbtTagCompound.setBoolean("online", online);
        super.writeToNBT(nbtTagCompound);
    }

    @Override
    public void updateEntity() {
        List<EntityPlayerMP> playerList = MinecraftServer.getServer().getConfigurationManager().playerEntityList;
        for (EntityPlayerMP player : playerList) {
            if (player.getDisplayName().equals(playerName)) {
                this.online = true;
                this.X = player.posX;
                this.Y = player.posY;
                this.Z = player.posZ;
                return;
            }
        }
        this.online = onlineD;
        this.X = XD;
        this.Y = YD;
        this.Z = ZD;
    }

    public String getStringMessage(){
        return "Player: " + playerName + (online ? " (ONLINE) X:" + Math.floor(X) + " Y: " + Math.floor(Y) + " Z: " + Math.floor(Z) : "(OFFLINE)");
    }
}