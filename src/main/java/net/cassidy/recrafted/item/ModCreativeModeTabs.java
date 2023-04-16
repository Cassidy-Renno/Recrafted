package net.cassidy.recrafted.item;

import net.cassidy.recrafted.Recrafted;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Recrafted.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModCreativeModeTabs {
    public static CreativeModeTab RECRAFTED_TAB;

    @SubscribeEvent
    public static void registerCreativeModeTabs(CreativeModeTabEvent.Register event) {
        RECRAFTED_TAB = event.registerCreativeModeTab(new ResourceLocation(Recrafted.MOD_ID, "recrafted_tab"),
                builder -> builder.icon(() -> new ItemStack(ModItems.FORGED_IRON_INGOT.get()))
                        .title(Component.translatable("creativemodetab.recrafted_tab")));
    }
}
