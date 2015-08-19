package src.enigma.mod.template;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;
import src.enigma.mod.EnigmaMod;

public class TemplateItem extends Item {
    public String texture;

    public TemplateItem(int stackSize, CreativeTabs creativeTab, String textureName) {
        super();
        this.maxStackSize = stackSize;
        this.setCreativeTab(creativeTab);
        this.texture = textureName;
        this.setTextureName(textureName);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister) {
        this.itemIcon = iconRegister.registerIcon(EnigmaMod.MODID + ":" + texture);
    }

    @Override
    public IIcon getIconFromDamage(int p_77617_1_) {
        return this.itemIcon;
    }
}