package src.enigma.calin.proxy;

import cpw.mods.fml.client.registry.RenderingRegistry;
import net.minecraft.client.renderer.entity.RenderSnowball;
import src.enigma.calin.entity.EntityMolotov;
import src.enigma.calin.registry.CalinRegistry;

public class ClientProxy extends CommonProxy {
    @Override
    public void preInit(){
        super.preInit();
        RenderingRegistry.registerEntityRenderingHandler(EntityMolotov.class, new RenderSnowball(CalinRegistry.itemMolotov, 0));
    }

    @Override
    public void init(){
        super.init();


    }

    @Override
    public void postInit(){
        super.postInit();


    }
}
