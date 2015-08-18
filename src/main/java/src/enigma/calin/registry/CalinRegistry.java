package src.enigma.calin.registry;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import src.enigma.calin.items.ItemMolotov;
import src.enigma.calin.lib.Constants;

/**
 * Created by Matthew on 8/16/2015.
 */
public class CalinRegistry {

    public static Item itemMolotov;

    public static void preInit(){

    }

    public static void init(){
        itemMolotov = new ItemMolotov().setUnlocalizedName(Constants.nameMolotov).setCreativeTab(CreativeTabs.tabCombat);
        registerItems();
    }

    public static void registerItems()
    {
        GameRegistry.registerItem(CalinRegistry.itemMolotov, Constants.nameMolotov);
    }

    public static void postInit(){

    }

}
