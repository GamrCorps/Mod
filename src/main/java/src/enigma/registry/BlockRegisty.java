package src.enigma.registry;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import src.enigma.block.BlockPlayerTracker;
import src.enigma.tileentity.TileEntityPlayerTracker;

/**
 * Created by Matthew on 8/16/2015.
 */
public class BlockRegisty {
    public static final Block blockPlayerTracker = new BlockPlayerTracker();

    public static void registerBlocks(){
        GameRegistry.registerBlock(blockPlayerTracker, "blockPlayerTracker");
    }

    public static void registerTileEntities(){
        GameRegistry.registerTileEntity(TileEntityPlayerTracker.class,"tileEntityPlayerTracker");
    }
}
