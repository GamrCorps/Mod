package com.example.examplemod;

import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;

@Mod(modid = ExampleMod.MODID, version = ExampleMod.VERSION)
public class ExampleMod
{
    public static final String MODID = "enigma";
    public static final String VERSION = "081615r0";
    public static final Block testBlock = new TestBlock().setHardness(50F).setStepSound(Block.soundTypeAnvil).setBlockName("testBlock").setCreativeTab(CreativeTabs.tabRedstone);
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
		// some example code
        System.out.println("DIRT BLOCK >> "+Blocks.dirt.getUnlocalizedName());
        GameRegistry.registerBlock(testBlock, "testBlock");
        GameRegistry.registerTileEntity(TestTileEntity.class,"testTileEntity");
    }

    @EventHandler
    public void preInit(FMLPreInitializationEvent event){

    }
}
