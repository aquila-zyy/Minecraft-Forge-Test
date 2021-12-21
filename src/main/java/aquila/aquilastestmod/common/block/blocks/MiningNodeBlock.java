package aquila.aquilastestmod.common.block.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
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

public class MiningNodeBlock extends Block {
    
    public static final IntegerProperty REMAINING = IntegerProperty.create("remaining", 1, 3);
    public static final DirectionProperty FACING = DirectionProperty.create("facing");
    public static final BlockBehaviour.Properties PROPERTIES =
            BlockBehaviour.Properties.of(Material.STONE)
                                     .destroyTime(3.0f)
                                     .isSuffocating((state, getter, pos) -> true)
                                     .sound(SoundType.STONE);
    
    public MiningNodeBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.defaultBlockState().setValue(REMAINING, 3));
    }
    
    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> p_49915_) {
        p_49915_.add(REMAINING).add(FACING);
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
