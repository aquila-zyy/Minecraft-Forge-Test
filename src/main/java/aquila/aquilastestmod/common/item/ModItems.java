package aquila.aquilastestmod.common.item;

import aquila.aquilastestmod.AquilasTestMod;
import aquila.aquilastestmod.common.block.ModBlocks;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.renderer.block.model.ItemOverrides;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.client.event.ModelBakeEvent;
import net.minecraftforge.client.extensions.IForgeBakedModel;
import net.minecraftforge.client.model.ForgeModelBakery;
import net.minecraftforge.client.model.ModelLoaderRegistry;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.function.Supplier;

public class ModItems {
    
    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS,
            AquilasTestMod.MOD_ID);
    
    // Items
    
    // BlockItems
    public static final RegistryObject<Item> peacebloom = registerItem("peacebloom",
            () -> new BlockItem(ModBlocks.peacebloomNode.get(),
                    new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS)));
    public static final RegistryObject<Item> silverleaf = registerItem("silverleaf",
            () -> new BlockItem(ModBlocks.silverleafNode.get(),
                    new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS)));
    
    public static RegistryObject<Item> registerItem(String name, Supplier<Item> item) {
        return ITEMS.register(name, item);
    }
    
    public static void registerAll(IEventBus modLoadingContext) {
        AquilasTestMod.LOGGER.info("Registering Items");
        ITEMS.register(modLoadingContext);
    }
}
