package src.enigma.calin.armor;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;


/**
 * Created by Calin on 8/17/2015.
 */
public class ArmorJihadVest extends Item
{
    public ArmorJihadVest()
    {
        setCreativeTab(CreativeTabs.tabCombat);
        setNoRepair();
        this.maxStackSize = 1;
    }
}

