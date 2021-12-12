package aquila.aquilastestmod.common.block;

import aquila.aquilastestmod.AquilasTestMod;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlocks {
    
    private static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS,
            AquilasTestMod.MOD_ID);
    
    public static final RegistryObject<Block> PeacebloomNode = BLOCKS.register("peacebloom_node",
            () -> new Block(BlockBehaviour.Properties.of(Material.GRASS).destroyTime(3.0f)));
    
    public static void registerBlocks(IEventBus modLoadingContext) {
        AquilasTestMod.LOGGER.info("Registering blocks");
        BLOCKS.register(modLoadingContext);
    }
}
