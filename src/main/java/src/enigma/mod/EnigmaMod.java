package src.enigma.mod;

import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import org.apache.logging.log4j.Logger;
import src.enigma.andrew.registry.AndrewRegistry;
import src.enigma.calin.registry.CalinRegistry;
import src.enigma.evan.registry.EvanRegistry;
import src.enigma.matthew.proxy.CommonProxy;
import src.enigma.matthew.registry.MatthewRegistry;

@Mod(modid = EnigmaMod.MODID, name = EnigmaMod.MODNAME, version = EnigmaMod.VERSION)
public class EnigmaMod {
    public static final String MODID = "enigma";
    public static final String MODNAME = "The Enigma Mod";
    public static final String VERSION = "081615r0";

    @SidedProxy(clientSide = "src.enigma.matthew.proxy.ClientProxy", serverSide = "src.enigma.matthew.proxy.ServerProxy")
    public static CommonProxy matthewProxy;
    @SidedProxy(clientSide = "src.enigma.andrew.proxy.ClientProxy", serverSide = "src.enigma.andrew.proxy.ServerProxy")
    public static src.enigma.andrew.proxy.CommonProxy andrewProxy;
    @SidedProxy(clientSide = "src.enigma.calin.proxy.ClientProxy", serverSide = "src.enigma.calin.proxy.ServerProxy")
    public static src.enigma.calin.proxy.CommonProxy calinProxy;
    @SidedProxy(clientSide = "src.enigma.evan.proxy.ClientProxy", serverSide = "src.enigma.evan.proxy.ServerProxy")
    public static src.enigma.evan.proxy.CommonProxy evanProxy;

    public static Logger logger;

    @Mod.Instance(MODID)
    public static EnigmaMod mod;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        logger = event.getModLog();
        int preInitStages = 2;
        logger.info("PRE-INIT STAGE 1 (Registry) of " + preInitStages);
        MatthewRegistry.preInit();
        CalinRegistry.preInit();
        EvanRegistry.preInit();
        AndrewRegistry.preInit();
        logger.info("PRE-INIT STAGE 2 (Proxy) of " + preInitStages);
        matthewProxy.preInit();
        andrewProxy.preInit();
        calinProxy.preInit();
        evanProxy.preInit();
        logger.info("PRE-INIT COMPLETE");
    }
    @EventHandler
    public void init(FMLInitializationEvent event) {
        int initStages = 2;
        logger.info("INIT STAGE 1 (Registry) of " + initStages);
        MatthewRegistry.init();
        CalinRegistry.init();
        EvanRegistry.init();
        AndrewRegistry.init();
        logger.info("INIT STAGE 2 (Proxy) of " + initStages);
        matthewProxy.init();
        andrewProxy.init();
        calinProxy.init();
        evanProxy.init();
        logger.info("INIT COMPLETE");
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        int postInitStages = 2;
        logger.info("POST-INIT STAGE 1 (Registry) of " + postInitStages);
        MatthewRegistry.postInit();
        CalinRegistry.postInit();
        EvanRegistry.postInit();
        AndrewRegistry.postInit();
        logger.info("POST-INIT STAGE 2 (Proxy) of " + postInitStages);
        matthewProxy.postInit();
        andrewProxy.postInit();
        calinProxy.postInit();
        evanProxy.postInit();
        logger.info("POST-INIT COMPLETE");
    }
}
