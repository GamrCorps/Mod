package com.example.examplemod;

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
public class TestBlock extends BlockContainer {

    public TestBlock() {
        super(Material.ground);
    }

    @Override
    public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
        return new TestTileEntity();
    }

    /*
    @Override
    public int getRenderType() {
        return 3;
    }
    */

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int meta, float fx, float fy, float fz) {
        if (player.worldObj.isRemote) return false;
        try {
            if (player.getHeldItem().getItem().equals(Items.stick)) {
                ((TestTileEntity) world.getTileEntity(x, y, z)).playerName = player.getDisplayName();
                player.addChatComponentMessage(new ChatComponentText("Player set to: " + player.getDisplayName()));
                return true;
            } else if (player.getHeldItem() != null) {
                player.addChatComponentMessage(new ChatComponentText(((TestTileEntity) world.getTileEntity(x, y, z)).getStringMessage()));
                return true;
            }
        } catch (Exception e) {
            player.addChatComponentMessage(new ChatComponentText("Error writing to TileEntity data."));
            return false;
        }
        return false;
    }
}
