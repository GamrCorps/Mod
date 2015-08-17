package src.enigma.calin.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import src.enigma.calin.entity.EntityMolotov;
import src.enigma.calin.lib.Constants;

public class ItemMolotov extends Item {
    public ItemMolotov()
    {
        super();
        this.maxStackSize = 8;
        this.setCreativeTab(CreativeTabs.tabCombat);
    }


    public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer player)
    {
        if (!player.capabilities.isCreativeMode)
        {
            --itemstack.stackSize;
        }

        world.playSoundAtEntity(player, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));

        if (!world.isRemote)
        {
            world.spawnEntityInWorld(new EntityMolotov(world, player));
        }

        return itemstack;
    }
    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister) {
        this.itemIcon = iconRegister.registerIcon(Constants.MODID + ":molotov");
    }
}
