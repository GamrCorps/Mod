package src.enigma.calin.entity;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.*;
import net.minecraft.init.Blocks;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import src.enigma.calin.registry.CalinRegistry;

import java.util.Random;

/**
 * Created by Calin on 8/17/2015.
 */
public class EntityMolotov extends EntityThrowable {
    public EntityMolotov(World world) {
        super(world);
    }

    public EntityMolotov(World world, EntityLivingBase xBase) {
        super(world, xBase);
    }

    public EntityMolotov(World world, double x, double y, double z) {
        super(world, x, y, z);
    }

    protected void onImpact(MovingObjectPosition xPosition) {
        this.playSound("dig.glass", 1f, 0f);
        for (int a = 0; a < 20; a++) {
            Random x = new Random();
            int ax = x.nextInt(6);
            int bx = x.nextInt(6);
            int cx = x.nextInt(6);
            if (this.worldObj.getBlock((int) this.posX + ax - 3, (int) this.posY + cx - 3, (int) this.posZ - bx + 3) == Blocks.air && this.worldObj.getBlock((int) this.posX + ax - 3, (int) this.posY + cx - 4, (int) this.posZ - bx + 3) != Blocks.air) {
                this.worldObj.setBlock((int) this.posX + ax - 3, (int) this.posY + cx - 3, (int) this.posZ - bx + 3, Blocks.fire, 0, 2);
            }
        }
        if (xPosition.entityHit != null) {
            byte b0 = 1;
            xPosition.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), (float) b0);
            EntityLivingBase temp = this.getThrower();
            if (temp instanceof EntityPlayer) {
                EntityPlayer temp2 = (EntityPlayer) temp;
                if (!temp2.capabilities.isCreativeMode) {
                    temp2.inventory.consumeInventoryItem(CalinRegistry.itemMolotov);
                }
            }
            if (!this.worldObj.isRemote) {
                this.setDead();
            }
        }
        for (int j = 0; j < 8; ++j) {
            this.worldObj.spawnParticle("blockcrack_20_20", this.posX, this.posY, this.posZ, 0.0, 0.0, 0.0);
        }

        if (!this.worldObj.isRemote) {
            this.setDead();
        }
    }

    @Override
    public void onUpdate() {
        super.onUpdate();
        this.worldObj.spawnParticle("smoke", this.posX, this.posY, this.posZ, 0.0, 0.0, 0.0);
    }
}