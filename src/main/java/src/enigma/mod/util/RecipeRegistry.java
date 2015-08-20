package src.enigma.mod.util;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.ItemStack;

public class RecipeRegistry {
    public static void addShapelessRecipe(ItemStack result, ItemStack... recipe) {
        GameRegistry.addShapelessRecipe(result, recipe);
    }

    public static void addShapedRecipe(ItemStack result, Object... recipe) {
        GameRegistry.addShapedRecipe(result, recipe);
    }

    public static void addFurnaceRecipe(ItemStack input, ItemStack output, float xp){
        GameRegistry.addSmelting(input.getItem(), output, xp);
    }
}
