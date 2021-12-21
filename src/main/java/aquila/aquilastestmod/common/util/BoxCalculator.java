package aquila.aquilastestmod.common.util;

import net.minecraft.core.Direction;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.shapes.VoxelShape;

public class BoxCalculator {
    public static VoxelShape turnTo(VoxelShape original, Direction direction) {
        AABB bounds = original.bounds();
        AABB aabb = new AABB(bounds.minX * 16, bounds.minY * 16, bounds.minZ * 16, bounds.maxX * 16, bounds.maxY * 16,
                bounds.maxZ * 16);
        switch (direction) {
            case UP -> {
                return Block.box(aabb.minX, aabb.minY, aabb.minZ, aabb.maxX, aabb.maxY, aabb.maxZ);
            }
            case DOWN -> {
                return Block.box(16 - aabb.maxX, 16 - aabb.maxY, 16 - aabb.maxZ, 16 - aabb.minX, 16 - aabb.minY,
                        16 - aabb.minZ);
            }
            case NORTH -> {
                return Block.box(aabb.minX, aabb.minZ, 16 - aabb.maxY, aabb.maxX, aabb.maxZ, 16 - aabb.minY);
            }
            case SOUTH -> {
                return Block.box(aabb.minX, 16 - aabb.maxZ, aabb.minY, aabb.maxX, 16 - aabb.minZ, aabb.maxY);
            }
            case WEST -> {
                return Block.box(16 - aabb.maxY, aabb.minX, 16 - aabb.maxZ, 16 - aabb.minY, aabb.maxX, 16 - aabb.minZ);
            }
            case EAST -> {
                return Block.box(aabb.minY, aabb.minZ, aabb.minX, aabb.maxY, aabb.maxZ, aabb.maxX);
            }
        }
        return null;
    }
}
