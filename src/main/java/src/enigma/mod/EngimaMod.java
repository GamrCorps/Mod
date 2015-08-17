package src.enigma.mod;

import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import src.enigma.andrew.registry.AndrewRegistry;
import src.enigma.calin.registry.CalinRegistry;
import src.enigma.evan.registry.EvanRegistry;
import src.enigma.matthew.registry.MatthewRegistry;

@Mod(modid = EngimaMod.MODID, version = EngimaMod.VERSION)
public class EngimaMod {
    public static final String MODID = "enigma";
    public static final String VERSION = "081615r0";

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        MatthewRegistry.preInit();
        CalinRegistry.preInit();
        EvanRegistry.preInit();
        AndrewRegistry.preInit();
    }
    @EventHandler
    public void init(FMLInitializationEvent event) {
        MatthewRegistry.init();
        CalinRegistry.init();
        EvanRegistry.init();
        AndrewRegistry.init();
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        MatthewRegistry.postInit();
        CalinRegistry.postInit();
        EvanRegistry.postInit();
        AndrewRegistry.postInit();
    }
}
