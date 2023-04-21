package net.cassidy.recrafted;

import com.mojang.datafixers.types.templates.Tag;
import com.mojang.logging.LogUtils;
import net.cassidy.recrafted.block.ModBlocks;
import net.cassidy.recrafted.item.ModCreativeModeTabs;
import net.cassidy.recrafted.item.ModItems;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.data.tags.VanillaBlockTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.Tags;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(Recrafted.MOD_ID)
public class Recrafted {
    //comment!
    public static final String MOD_ID = "recrafted";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();
    // Create a Deferred Register to hold Blocks which will all be registered under the "examplemod" namespace
    public Recrafted()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);

        modEventBus.addListener(this::commonSetup);
        MinecraftForge.EVENT_BUS.register(this);

        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }

    private void addCreative(CreativeModeTabEvent.BuildContents event) {
        if(event.getTab() == ModCreativeModeTabs.RECRAFTED_TAB) {
            event.accept(ModItems.FORGED_IRON_INGOT);

            event.accept(ModBlocks.FORGED_IRON_BLOCK);
            event.accept(ModBlocks.TURF);
            event.accept(ModBlocks.PATH_TURF);
            event.accept(ModBlocks.PODZOL_TURF);
            event.accept(ModBlocks.MYCELIUM_TURF);
            event.accept(ModBlocks.CRIMSON_TURF);
            event.accept(ModBlocks.WARPED_TURF);
            event.accept(ModBlocks.FARMLAND_TURF);
            event.accept(ModBlocks.MOIST_FARMLAND_TURF);
            event.accept(ModBlocks.THATCH);
            event.accept(ModBlocks.AZALEA_GRASS);
            event.accept(ModBlocks.FLOWERING_AZALEA_GRASS);
            event.accept(ModBlocks.AZALEA_BUSH);
            event.accept(ModBlocks.FLOWERING_AZALEA_BUSH);
            event.accept(ModBlocks.CRATE);
            event.accept(ModBlocks.BOX);
            event.accept(ModBlocks.CAST_IRON);
            event.accept(ModBlocks.DARK_TILES);
            event.accept(ModBlocks.ERODED_DEEPSLATE);
            event.accept(ModBlocks.THIN_ICE);
            event.accept(ModBlocks.CHIPPED_ICE);
            event.accept(ModBlocks.CRACKED_ICE);
            event.accept(ModBlocks.SHATTERED_ICE);
            event.accept(ModBlocks.TOUGH_STONE);
            event.accept(ModBlocks.INSET_STONE);
            event.accept(ModBlocks.INSCRIBED_STONE);
            event.accept(ModBlocks.SHELF);
            event.accept(ModBlocks.RAW_MUSHROOM);
            event.accept(ModBlocks.BOLTED_PLANKS);
            event.accept(ModBlocks.CENTRIC_BASALT);
            event.accept(ModBlocks.COBBLED_BASALT);
            event.accept(ModBlocks.CENTRIC_QUARTZ);
            event.accept(ModBlocks.CENTRIC_PURPUR);
            event.accept(ModBlocks.STONE_SUPPORT);
            event.accept(ModBlocks.DEEPSLATE_FRAME);
            event.accept(ModBlocks.DEEPSLATE_CORE);
            event.accept(ModBlocks.VOIDED_OBSIDIAN);
            event.accept(ModBlocks.BASKET);
            event.accept(ModBlocks.SCULK_HEART);
            event.accept(ModBlocks.SCULK_CAGE);
            event.accept(ModBlocks.AZALEA_GROWTH);
            event.accept(ModBlocks.FLOWERING_AZALEA_GROWTH);
            event.accept(ModBlocks.GRASS_GROWTH);
        }
    }



    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {

        }
    }
}
