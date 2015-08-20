package src.enigma.calin.registry;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import src.enigma.calin.items.ItemFlyingCarpet;
import src.enigma.calin.items.ItemMolotov;
import src.enigma.calin.lib.Constants;

public class CalinRegistry {

    public static Item itemMolotov = new ItemMolotov().setUnlocalizedName(Constants.nameMolotov).setCreativeTab(CreativeTabs.tabCombat);
    public static Item itemFlyingCarpet = new ItemFlyingCarpet().setUnlocalizedName(Constants.nameFlyingCarpet).setCreativeTab(CreativeTabs.tabCombat);

    public static void preInit(){

    }

    public static void init()
    {
        registerItems();
    }

    public static void registerItems()
    {
        GameRegistry.registerItem(CalinRegistry.itemMolotov, Constants.nameMolotov);
        GameRegistry.registerItem(CalinRegistry.itemFlyingCarpet, Constants.nameFlyingCarpet);
    }

    public static void postInit(){

    }

}
