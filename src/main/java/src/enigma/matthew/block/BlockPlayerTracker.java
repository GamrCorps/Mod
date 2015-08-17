package src.enigma.matthew.block;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import src.enigma.matthew.tileentity.TileEntityPlayerTracker;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;

/**
 * Created by Matthew on 8/16/2015.
 */
public class BlockPlayerTracker extends BlockContainer {

    public BlockPlayerTracker() {
        super(Material.ground);
        setHardness(50F);
        setStepSound(Block.soundTypeAnvil);
        setBlockName("blockPlayerTracker");
        setCreativeTab(CreativeTabs.tabRedstone);
    }

    @Override
    public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
        return new TileEntityPlayerTracker();
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int meta, float fx, float fy, float fz) {
        if (player.worldObj.isRemote) return false;
        try {
            if (player.getHeldItem().getItem().equals(Items.stick)) {
                ((TileEntityPlayerTracker) world.getTileEntity(x, y, z)).playerName = player.getDisplayName();
                player.addChatComponentMessage(new ChatComponentText("Player set to: " + player.getDisplayName()));
                return true;
            } else if (player.getHeldItem() != null) {
                player.addChatComponentMessage(new ChatComponentText(((TileEntityPlayerTracker) world.getTileEntity(x, y, z)).getStringMessage()));
                return true;
            }
        } catch (Exception e) {
            player.addChatComponentMessage(new ChatComponentText("Error writing to TileEntity data."));
            return false;
        }
        return false;
    }
}
