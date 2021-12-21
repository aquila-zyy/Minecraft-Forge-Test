package aquila.aquilastestmod.common.item;

import aquila.aquilastestmod.AquilasTestMod;
import aquila.aquilastestmod.common.block.ModBlocks;
import aquila.aquilastestmod.common.tab.ModTabs;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModItems {
    
    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS,
            AquilasTestMod.MOD_ID);
    
    // Items
    public static final RegistryObject<Item> malachite = registerItem("malachite",
            () -> new Item(new Item.Properties().tab(ModTabs.TEST_TAB).rarity(Rarity.RARE)));
    
    // BlockItems
    public static final RegistryObject<Item> peacebloom = registerItem("peacebloom",
            () -> new BlockItem(ModBlocks.peacebloomBush.get(),
                    new Item.Properties().tab(ModTabs.TEST_TAB)));
    public static final RegistryObject<Item> silverleaf = registerItem("silverleaf",
            () -> new BlockItem(ModBlocks.silverleafBush.get(),
                    new Item.Properties().tab(ModTabs.TEST_TAB)));
    
    public static RegistryObject<Item> registerItem(String name, Supplier<Item> item) {
        return ITEMS.register(name, item);
    }
    
    public static void registerAll(IEventBus modLoadingContext) {
        AquilasTestMod.LOGGER.info("Registering Items");
        ITEMS.register(modLoadingContext);
    }
}
