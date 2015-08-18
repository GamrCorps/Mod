package src.enigma.calin.render;

import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import src.enigma.calin.registry.CalinRegistry;
import src.enigma.mod.EnigmaMod;


public class RenderMolotov extends RenderSnowball {
    public RenderMolotov() {
        super(CalinRegistry.itemMolotov,0);
    }
    protected ResourceLocation getEntityTexture(Entity p_110775_1_)
    {
        return new ResourceLocation(EnigmaMod.MODID,":textures/items/molotov.png");
    }

    @Override
    protected void bindEntityTexture(Entity p_110777_1_) {
        super.bindEntityTexture(p_110777_1_);
    }

    @Override
    protected void bindTexture(ResourceLocation p_110776_1_) {
        super.bindTexture(getEntityTexture(null));
    }

}
