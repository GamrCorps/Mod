package src.enigma.matthew.registry;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import src.enigma.matthew.block.BlockPlayerTracker;
import src.enigma.matthew.tileentity.TileEntityPlayerTracker;

/**
 * Created by Matthew on 8/16/2015.
 */
public class MatthewRegistry {

    public static void preInit(){

    }

    public static void init(){
        registerBlocks();
        registerTileEntities();
    }

    public static void postInit(){

    }

    public static final Block blockPlayerTracker = new BlockPlayerTracker();
    public static void registerBlocks(){
        GameRegistry.registerBlock(blockPlayerTracker, "blockPlayerTracker");
    }

    public static void registerTileEntities(){
        GameRegistry.registerTileEntity(TileEntityPlayerTracker.class,"tileEntityPlayerTracker");
    }
}
