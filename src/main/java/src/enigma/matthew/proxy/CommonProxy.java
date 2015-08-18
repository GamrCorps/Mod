package src.enigma.matthew.proxy;

import cpw.mods.fml.common.registry.EntityRegistry;
import src.enigma.calin.entity.EntityMolotov;
import src.enigma.mod.EnigmaMod;

public class CommonProxy {
    public void preInit(){
        int modEntityID = 0;
        EntityRegistry.registerModEntity(EntityMolotov.class, "Molotov", ++modEntityID, EnigmaMod.mod, 64, 10, true);
    }

    public void init(){

    }

    public void postInit(){

    }
}
