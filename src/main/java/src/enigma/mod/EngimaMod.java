package src.enigma.mod;

import src.enigma.block.BlockPlayerTracker;
import src.enigma.registry.BlockRegisty;
import src.enigma.tileentity.TileEntityPlayerTracker;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;

@Mod(modid = EngimaMod.MODID, version = EngimaMod.VERSION)
public class EngimaMod {
    public static final String MODID = "enigma";
    public static final String VERSION = "081615r0";

    @EventHandler
    public void init(FMLInitializationEvent event) {
        BlockRegisty.registerBlocks();
        BlockRegisty.registerTileEntities();
    }

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {

    }
}
