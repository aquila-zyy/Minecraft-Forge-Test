package aquila.aquilastestmod.common.block.blocks;

import aquila.aquilastestmod.common.util.BoxCalculator;
import com.google.common.collect.ImmutableMap;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

public class MiningNodeBlock extends Block {
    
    public static final IntegerProperty REMAINING = IntegerProperty.create("remaining", 1, 3);
    public static final DirectionProperty FACING = DirectionProperty.create("facing");
    public static final BlockBehaviour.Properties PROPERTIES =
            BlockBehaviour.Properties.of(Material.DECORATION)
                                     .destroyTime(3.0f)
                                     .sound(SoundType.STONE)
                                     .noOcclusion();
    protected static final VoxelShape UP_AABB = Block.box(2, 0, 2, 14, 13, 14);
    protected static final VoxelShape DOWN_AABB = BoxCalculator.turnTo(UP_AABB, Direction.DOWN);
    protected static final VoxelShape NORTH_AABB = BoxCalculator.turnTo(UP_AABB, Direction.NORTH);
    protected static final VoxelShape SOUTH_AABB = BoxCalculator.turnTo(UP_AABB, Direction.SOUTH);
    protected static final VoxelShape WEST_AABB = BoxCalculator.turnTo(UP_AABB, Direction.WEST);
    protected static final VoxelShape EAST_AABB = BoxCalculator.turnTo(UP_AABB, Direction.EAST);
    
    public MiningNodeBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.defaultBlockState().setValue(REMAINING, 3).setValue(FACING, Direction.UP));
    }
    
    @Override
    public @NotNull VoxelShape getShape(@NotNull BlockState state, BlockGetter blockGetter, BlockPos pos, CollisionContext context) {
        switch (state.getValue(FACING)) {
            case DOWN -> {
                return DOWN_AABB;
            }
            case NORTH -> {
                return NORTH_AABB;
            }
            case SOUTH -> {
                return SOUTH_AABB;
            }
            case WEST -> {
                return WEST_AABB;
            }
            case EAST -> {
                return EAST_AABB;
            }
            default -> {
                return UP_AABB;
            }
        }
    }
    
    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(REMAINING).add(FACING);
    }
    
    @Override
    public boolean onDestroyedByPlayer(BlockState state, Level world, BlockPos pos, Player player, boolean willHarvest, FluidState fluid) {
        int remaining = state.getValue(REMAINING);
        if (willHarvest) {
            remaining--;
            if (remaining > 0) {
                world.setBlock(pos, state.setValue(REMAINING, remaining), 3);
                return false;
            } else {
                return super.onDestroyedByPlayer(state, world, pos, player, willHarvest, fluid);
            }
        } else {
            return super.onDestroyedByPlayer(state, world, pos, player, willHarvest, fluid);
        }
    }
}
