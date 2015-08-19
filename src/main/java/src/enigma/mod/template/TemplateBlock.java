package src.enigma.mod.template;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import src.enigma.mod.EnigmaMod;

public class TemplateBlock extends Block {
    public TemplateBlock(String unlocalizedName, Material material, CreativeTabs creativeTab, float hardness, String textureName){
        super(material);
        this.setBlockName(unlocalizedName);
        this.setCreativeTab(creativeTab);
        this.setHardness(hardness);
        this.setBlockTextureName(EnigmaMod.MODID + ":" + textureName);
    }
}
