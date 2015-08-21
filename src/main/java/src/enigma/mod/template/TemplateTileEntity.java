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
                try {
                    NBTTag n = field.getAnnotation(NBTTag.class);
                    String s = n.type().name().toLowerCase();
                    if (s.equals("int")) {
                        field.setInt(this, p_145839_1_.getInteger(n.name()));
                    } else if (s.equals("string")) {
                        field.set(this, p_145839_1_.getString(n.name()));
                    } else if (s.equals("double")) {
                        field.setDouble(this, p_145839_1_.getDouble(n.name()));
                    } else if (s.equals("boolean")) {
                        field.setBoolean(this, p_145839_1_.getBoolean(n.name()));
                    } else if (s.equals("float")) {
                        field.setFloat(this, p_145839_1_.getFloat(n.name()));
                    }
                } catch (Exception e){
                    e.printStackTrace();
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
                try {
                    NBTTag n = field.getAnnotation(NBTTag.class);
                    String s = n.type().name().toLowerCase();
                    if (s.equals("int")) {
                        p_145841_1_.setInteger(n.name(), field.getInt(this));
                    } else if (s.equals("string")) {
                        p_145841_1_.setString(n.name(), (String) field.get(this));
                    } else if (s.equals("double")) {
                        p_145841_1_.setDouble(n.name(), field.getDouble(this));
                    } else if (s.equals("boolean")) {
                        p_145841_1_.setBoolean(n.name(), field.getBoolean(this));
                    } else if (s.equals("float")) {
                        p_145841_1_.setFloat(n.name(), field.getFloat(this));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void updateEntity() {
        super.updateEntity();

    }
}
