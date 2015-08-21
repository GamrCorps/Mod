package src.enigma.mod.template;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import src.enigma.mod.util.NBTTag;

import java.lang.reflect.Field;

public class TemplateTileEntity extends TileEntity{
    public TemplateTileEntity(){

    }

    @Override
    public void readFromNBT(NBTTagCompound p_145839_1_) {
        super.readFromNBT(p_145839_1_);
        Class logicClass = this.getClass();
        for (Field field : logicClass.getFields()){
            if (field.isAnnotationPresent(NBTTag.class)){
                NBTTag n = field.getAnnotation(NBTTag.class);
                String s = n.type();
                if (s.equals("int")) {
                    try {
                        field.setInt(this,p_145839_1_.getInteger(n.name()));
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    @Override
    public void writeToNBT(NBTTagCompound p_145841_1_) {
        super.writeToNBT(p_145841_1_);
        Class logicClass = this.getClass();
        for (Field field : logicClass.getFields()){
            if (field.isAnnotationPresent(NBTTag.class)){
                NBTTag n = field.getAnnotation(NBTTag.class);
                String s = n.type();
                if (s.equals("int")) {
                    try {
                        p_145841_1_.setInteger(n.name(),field.getInt(this));
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    @Override
    public void updateEntity() {
        super.updateEntity();

    }
}
