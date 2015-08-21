package src.enigma.calin.items;
import cpw.mods.fml.common.Mod;
import jdk.nashorn.internal.ir.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
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
 **/
public class ItemFlyingCarpet extends Item
{
    boolean isEnabled;
    boolean toggle;
    int y;
    int toggleBlock;

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
        this.y = -3;
        this.toggleBlock = 0;
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer thePlayer)
    {

        if (thePlayer.worldObj.isRemote)
        {
            return itemstack;
        }

        this.toggle = !this.toggle;

        return itemstack;
    }

    @Override
    public void onUpdate(ItemStack stack, World world, Entity thePlayer, int par4, boolean par5)
    {
        super.onUpdate(stack, world, thePlayer, par4, par5);
        {
            EntityPlayer player = (EntityPlayer) thePlayer;
            this.y = -1;


            //=== Possible implementation ===

            /*int sneak = Minecraft.getMinecraft().gameSettings.keyBindSneak.getKeyCode();

            if (Keyboard.isKeyDown(sneak))
            {

            }
            else
            {

            }*/
            //===============================


            if (thePlayer.worldObj.isRemote)
            {
                return;
            }

            if(this.toggle)
            {
                    this.toggleBlock = 0;

                    world.setBlock((int) player.posX, (int) player.posY + y, (int) (player.posZ), Blocks.glass);
                    world.setBlock((int) Math.round(player.posX) + 1, (int) Math.round(player.posY) + y, (int) Math.round(player.posZ), Blocks.glass);
                    world.setBlock((int) Math.round(player.posX) - 1, (int) Math.round(player.posY) + y, (int) Math.round(player.posZ), Blocks.glass);
                    world.setBlock((int) Math.round(player.posX), (int) Math.round(player.posY) + y, (int) Math.round(player.posZ + 1), Blocks.glass);
                    world.setBlock((int) Math.round(player.posX), (int) Math.round(player.posY) + y, (int) Math.round(player.posZ - 1), Blocks.glass);
                    world.setBlock((int) Math.round(player.posX + 1), (int) Math.round(player.posY) + y, (int) Math.round(player.posZ + 1), Blocks.glass);
                    world.setBlock((int) Math.round(player.posX + 1), (int) Math.round(player.posY) + y, (int) Math.round(player.posZ - 1), Blocks.glass);
                    world.setBlock((int) Math.round(player.posX - 1), (int) Math.round(player.posY) + y, (int) Math.round(player.posZ - 1), Blocks.glass);
                world.setBlock((int) Math.round(player.posX - 1), (int) Math.round(player.posY) + y, (int) Math.round(player.posZ + 1), Blocks.glass);

                //=== Possible implementation ===
                //player.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 15, 3));
                //player.addPotionEffect(new PotionEffect(Potion.jump.id, 3, 3));
                //===============================
            }
        }
    }
}