package src.enigma.matthew.item;

import net.minecraft.block.Block;
import net.minecraft.block.BlockOre;
import net.minecraft.block.BlockRedstoneOre;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;

public class ItemVeinPickaxe extends ItemPickaxe {
    public ItemVeinPickaxe(){
        super(ToolMaterial.EMERALD);
    }

    @Override
    public boolean onBlockDestroyed(ItemStack itemStack, World world, Block block, int x, int y, int z, EntityLivingBase entity) {
        Queue<int[]> queue = new Queue<int[]>();
        queue.add(new int[]{x, y, z});
        while (true) {
            if (queue.isEmpty()) break;
            int[] coords = queue.getNext();
            if (world.getBlock(coords[0], coords[1], coords[2]) instanceof BlockOre) {
                Block block1 = world.getBlock(coords[0], coords[1], coords[2]);
                breakBlock(world,world.getBlock(coords[0], coords[1], coords[2]), coords[0], coords[1], coords[2]);
                for (int i = -1; i <= 1; i++) {
                    for (int j = -1; j <= 1; j++) {
                        for (int k = -1; k <= 1; k++) {
                            if (world.getBlock(coords[0] + i, coords[1] + j, coords[2] + k) == block1){
                                queue.add(new int[]{coords[0] + i, coords[1] + j, coords[2] + k});
                            }
                        }
                    }
                }
            } else if ( world.getBlock(coords[0], coords[1], coords[2]) instanceof BlockRedstoneOre) {
                breakBlock(world,world.getBlock(coords[0], coords[1], coords[2]), coords[0], coords[1], coords[2]);
                for (int i = -1; i <= 1; i++) {
                    for (int j = -1; j <= 1; j++) {
                        for (int k = -1; k <= 1; k++) {
                            if (world.getBlock(coords[0] + i, coords[1] + j, coords[2] + k) instanceof BlockRedstoneOre){
                                queue.add(new int[]{coords[0] + i, coords[1] + j, coords[2] + k});
                            }
                        }
                    }
                }
            }
        }
        return super.onBlockDestroyed(itemStack, world, block, x, y, z, entity);
    }

    private void breakBlock(World gameWorld_, Block block, int x, int y, int z) {
        ItemStack droppedItemStack = new ItemStack( block.getItemDropped(0, gameWorld_.rand, 0));
        EntityItem drop = new EntityItem(gameWorld_, x, y, z, droppedItemStack);
        gameWorld_.spawnEntityInWorld(drop);
        gameWorld_.setBlockToAir(x, y, z);
    }

} class Queue<T> {
    private List<T> queue;

    public Queue() {
        queue = new ArrayList<T>();
    }

    public void add(T object) {
        queue.add(object);
    }

    public T getNext() {
        T temp = queue.get(0);
        queue.remove(0);
        return temp;
    }

    public int size() {
        return queue.size();
    }

    public boolean isEmpty() {
        return !(queue.size() > 0);
    }
}