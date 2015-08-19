package src.enigma.matthew.registry;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import src.enigma.matthew.block.BlockPlayerTracker;
import src.enigma.matthew.item.ItemVeinPickaxe;
import src.enigma.matthew.tileentity.TileEntityPlayerTracker;
import src.enigma.mod.EnigmaMod;

public class MatthewRegistry {

    public static void preInit(){

    }

    public static void init(){
        registerBlocks();
        registerTileEntities();
        registerItems();
    }

    public static void postInit(){

    }

    public static final Block blockPlayerTracker = new BlockPlayerTracker();
    public static void registerBlocks(){
        GameRegistry.registerBlock(blockPlayerTracker, "blockPlayerTracker");
    }

    public static void registerTileEntities(){
        GameRegistry.registerTileEntity(TileEntityPlayerTracker.class, "tileEntityPlayerTracker");
    }

    public static final Item itemVeinPickaxe = new ItemVeinPickaxe().setUnlocalizedName("vein_pickaxe").setTextureName(EnigmaMod.MODID + ":" + "vein_pickaxe").setCreativeTab(CreativeTabs.tabTools);
    public static void registerItems(){
        GameRegistry.registerItem(itemVeinPickaxe, "vein_pickaxe");
    }
}
