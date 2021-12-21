package aquila.aquilastestmod.common.tab;

import aquila.aquilastestmod.common.item.ModItems;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModTabs {
    
    public static final CreativeModeTab TEST_TAB = new CreativeModeTab("testTab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.peacebloom.get());
        }
    };
}
