package net.cassidy.recrafted.block;

import net.cassidy.recrafted.Recrafted;
import net.cassidy.recrafted.item.ModItems;
import net.minecraft.client.color.block.BlockColor;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.GrassColor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.rmi.registry.Registry;
import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, Recrafted.MOD_ID);

    public static final RegistryObject<Block> FORGED_IRON_BLOCK = registerBlock("forged_iron_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(6f).requiresCorrectToolForDrops().sound(SoundType.NETHERITE_BLOCK)));

    //TURFS
    public static final RegistryObject<Block> GRASS_TURF = registerBlock("turf",
            () -> new Block(BlockBehaviour.Properties.of(Material.GRASS)
                    .strength(0.6f)
                    .sound(SoundType.GRASS)));
    /*
    public static final RegistryObject<Block> PATH_TURF = registerBlock("path_turf",
            () -> new Block(BlockBehaviour.Properties.of(Material.GRASS)
                    .strength(0.6f).sound(SoundType.GRASS)));
    public static final RegistryObject<Block> PODZOL_TURF = registerBlock("podzol_turf",
            () -> new Block(BlockBehaviour.Properties.of(Material.GRASS)
                    .strength(0.6f).sound(SoundType.GRASS)));
    public static final RegistryObject<Block> MYCELIUM_TURF = registerBlock("mycelium_turf",
            () -> new Block(BlockBehaviour.Properties.of(Material.GRASS)
                    .strength(0.6f).sound(SoundType.GRASS)));
    public static final RegistryObject<Block> CRIMSON_TURF = registerBlock("crimson_turf",
            () -> new Block(BlockBehaviour.Properties.of(Material.GRASS)
                    .strength(0.6f).sound(SoundType.GRASS)));
    public static final RegistryObject<Block> WARPED_TURF = registerBlock("warped_turf",
            () -> new Block(BlockBehaviour.Properties.of(Material.GRASS)
                    .strength(0.6f).sound(SoundType.GRASS)));
*/
    private static <T extends Block>RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block>RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
