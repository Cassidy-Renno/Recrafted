package net.cassidy.recrafted;

import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.FoliageColor;
import net.minecraft.world.level.GrassColor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.cassidy.recrafted.block.ModBlocks;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Recrafted.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)

public class ColorHandler {
    @SubscribeEvent
    public static void registerItemColors(RegisterColorHandlersEvent.Item event)
    {
        event.getItemColors().register((stack, tintIndex) -> {
            BlockState state = ((BlockItem)stack.getItem()).getBlock().defaultBlockState();
            return event.getBlockColors().getColor(state, null, null, tintIndex); },
                ModBlocks.TURF.get(), ModBlocks.GRASS_GROWTH.get());
    }

    @SubscribeEvent
    public static void registerBlockColors(RegisterColorHandlersEvent.Block event)
    {
        //Grass Coloring
        event.getBlockColors().register((state, world, pos, tintIndex) ->
                        world != null && pos != null ? BiomeColors.getAverageGrassColor(world, pos) : GrassColor.get(0.5D, 1.0D), ModBlocks.TURF.get(), ModBlocks.GRASS_GROWTH.get());

        //Foliage Coloring
        //event.getBlockColors().register((state, world, pos, tintIndex) ->
        //                world != null && pos != null ? BiomeColors.getAverageFoliageColor(world, pos) : FoliageColor.getDefaultColor(),);
    }
}
