package src.enigma.mod.util;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface NBTTag {
    enum Type {
        INT,
        BOOLEAN,
        STRING,
        DOUBLE,
        FLOAT;
    }
    String name();
    Type type() default Type.INT;
}
