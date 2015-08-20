package src.enigma.calin.items;
import cpw.mods.fml.common.Mod;
import net.minecraft.client.Minecraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import org.lwjgl.input.Keyboard;
import src.enigma.mod.EnigmaMod;
import net.minecraft.world.World;

/**
 * Created by Calin on 8/17/2015.
 */
public class ItemFlyingCarpet extends Item
{
    boolean isEnabled;
    boolean toggle;
    int x;
    int y;

    public ItemFlyingCarpet()
    {
        super();
        this.maxStackSize = 1;
        this.setCreativeTab(CreativeTabs.tabCombat);
        this.setTextureName(EnigmaMod.MODID + ":" + "flying carpet");
    }

    public void init()
    {
        this.isEnabled = false;
        this.toggle = false;
        int x = 0;
        y = -3;
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer thePlayer)
    {
        x += 1;

        if(x == 4)
        {
            x = 0;
        }

        return itemstack;
    }

    @Override
    public void onUpdate(ItemStack stack, World world, Entity thePlayer, int par4, boolean par5)
    {
        super.onUpdate(stack, world, thePlayer, par4, par5);
        {
            EntityPlayer player = (EntityPlayer) thePlayer;

            int sneak = Minecraft.getMinecraft().gameSettings.keyBindSneak.getKeyCode();

            //=== Possible implementation ===

            /*if (Keyboard.isKeyDown(sneak))
            {
                y = -4;
            }
            else
            {
                y = -3;
            }*/
            //===============================

            if(x == 2)
            {
                //=== Possible implementation ===
                //player.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 15, 3));
                //player.addPotionEffect(new PotionEffect(Potion.jump.id, 3, 3));
                //===============================

                world.setBlock((int) Math.round(player.posX), (int) Math.round(player.posY) + y, (int) Math.round(player.posZ), Blocks.glass, 0, 2);
                world.setBlock((int) Math.round(player.posX) + 1, (int) Math.round(player.posY) + y, (int) Math.round(player.posZ), Blocks.glass, 0, 2);
                world.setBlock((int) Math.round(player.posX) - 1, (int) Math.round(player.posY) + y, (int) Math.round(player.posZ), Blocks.glass, 0 ,2);
                world.setBlock((int) Math.round(player.posX), (int) Math.round(player.posY) + y, (int) Math.round(player.posZ + 1), Blocks.glass, 0 ,2);
                world.setBlock((int) Math.round(player.posX), (int) Math.round(player.posY) + y, (int) Math.round(player.posZ - 1), Blocks.glass, 0 ,2);
                world.setBlock((int) Math.round(player.posX + 1), (int) Math.round(player.posY) + y, (int) Math.round(player.posZ + 1), Blocks.glass, 0 ,2);
                world.setBlock((int) Math.round(player.posX + 1), (int) Math.round(player.posY) + y, (int) Math.round(player.posZ - 1), Blocks.glass, 0 ,2);
                world.setBlock((int) Math.round(player.posX - 1), (int) Math.round(player.posY) + y, (int) Math.round(player.posZ + 1), Blocks.glass, 0 ,2);
                world.setBlock((int) Math.round(player.posX + 1), (int) Math.round(player.posY) + y, (int) Math.round(player.posZ + 1), Blocks.glass, 0 ,2);

            }
        }
    }
}