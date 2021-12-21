package aquila.aquilastestmod.common.block;

import aquila.aquilastestmod.AquilasTestMod;
import aquila.aquilastestmod.common.block.blocks.MiningNodeBlock;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.loading.FMLEnvironment;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    
    private static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS,
            AquilasTestMod.MOD_ID);
    
    public static final RegistryObject<Block> peacebloomBush = registerBlock("peacebloom_bush",
            () -> new FlowerBlock(MobEffects.MOVEMENT_SLOWDOWN, 1,
                    BlockBehaviour.Properties.of(Material.PLANT)
                                             .destroyTime(1.0f)
                                             .noCollission()
                                             .sound(SoundType.GRASS)
                                             .isSuffocating((blockState, blockGetter, blockPos) -> false)));
    
    public static final RegistryObject<Block> silverleafBush = registerBlock("silverleaf_bush",
            () -> new DoublePlantBlock(BlockBehaviour.Properties.of(Material.PLANT)
                                                                .destroyTime(1.0f)
                                                                .noCollission()
                                                                .sound(SoundType.GRASS)
                                                                .isSuffocating((blockState, blockGetter, blockPos) -> false)));
    
    public static final RegistryObject<Block> copperMiningNode = registerBlock("copper_node",
            () -> new MiningNodeBlock(MiningNodeBlock.PROPERTIES));
    
    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        return BLOCKS.register(name, block);
    }
    
    /**
     * This method is called on Mod instance construction, not when fml fires block registry
     * event. Do not add codes that should be executed when the actual event is fired to here.
     *
     * @param modLoadingContext Should be the Mod event bus. This is provided by the Mod class'
     *                          constructor.
     */
    public static void registerAll(IEventBus modLoadingContext) {
        AquilasTestMod.LOGGER.info("Registering blocks");
        BLOCKS.register(modLoadingContext);
    }
    
    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class Listeners {
        @SubscribeEvent
        public static void onBlocksRegistry(final RegistryEvent.Register<Block> blockRegistryEvent) {
            AquilasTestMod.LOGGER.info("HELLO from Register Block");
            if (FMLEnvironment.dist == Dist.CLIENT) {
                ItemBlockRenderTypes.setRenderLayer(peacebloomBush.get(), RenderType.cutout());
                ItemBlockRenderTypes.setRenderLayer(silverleafBush.get(), RenderType.cutout());
            }
        }
    }
    
}
