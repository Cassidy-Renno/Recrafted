package net.cassidy.recrafted.block;

import com.mojang.datafixers.types.templates.Tag;
import net.cassidy.recrafted.Recrafted;
import net.cassidy.recrafted.item.ModItems;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, Recrafted.MOD_ID);

    public static final RegistryObject<Block> FORGED_IRON_BLOCK = registerBlock("forged_iron_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(6f).requiresCorrectToolForDrops().sound(SoundType.NETHERITE_BLOCK)));

    //TURFS

    public static final RegistryObject<Block> TURF = registerBlock("turf",
            () -> new TurfBlock(BlockBehaviour.Properties.of(Material.DIRT)
                    .strength(0.6f).sound(SoundType.GRASS)));


    public static final RegistryObject<Block> PATH_TURF = registerBlock("path_turf",
            () -> new TurfBlock(BlockBehaviour.Properties.of(Material.DIRT)
                    .strength(0.6f).sound(SoundType.GRASS)));
    public static final RegistryObject<Block> PODZOL_TURF = registerBlock("podzol_turf",
            () -> new TurfBlock(BlockBehaviour.Properties.of(Material.DIRT)
                    .strength(0.6f).sound(SoundType.GRASS)));
    public static final RegistryObject<Block> MYCELIUM_TURF = registerBlock("mycelium_turf",
            () -> new MyceliumBlock(BlockBehaviour.Properties.of(Material.DIRT)
                    .strength(0.6f).sound(SoundType.GRASS)));

    public static final RegistryObject<Block> CRIMSON_TURF = registerBlock("crimson_turf",
            () -> new CrimsonNyliumTurfBlock(BlockBehaviour.Properties.of(Material.DIRT)
                    .strength(0.6f).sound(SoundType.NYLIUM)));
    public static final RegistryObject<Block> WARPED_TURF = registerBlock("warped_turf",
            () -> new WarpedNyliumTurfBlock(BlockBehaviour.Properties.of(Material.DIRT)
                    .strength(0.6f).sound(SoundType.NYLIUM)));
    public static final RegistryObject<Block> FARMLAND_TURF = registerBlock("farmland_turf",
            () -> new Block(BlockBehaviour.Properties.of(Material.DIRT)
                    .strength(0.6f).sound(SoundType.GRASS)));
    public static final RegistryObject<Block> MOIST_FARMLAND_TURF = registerBlock("moist_farmland_turf",
            () -> new Block(BlockBehaviour.Properties.of(Material.DIRT)
                    .strength(0.6f).sound(SoundType.GRASS)));

    public static final RegistryObject<Block> THATCH = registerBlock("thatch",
            () -> new HayBlock(BlockBehaviour.Properties.of(Material.DIRT)
                    .strength(0.6f).sound(SoundType.GRASS)));

    public static final RegistryObject<Block> AZALEA_GRASS = registerBlock("azalea_grass",
            () -> new AzaleaGrassBlock(BlockBehaviour.Properties.of(Material.DIRT)
                    .strength(0.6f).sound(SoundType.GRASS)));
    public static final RegistryObject<Block> FLOWERING_AZALEA_GRASS = registerBlock("flowering_azalea_grass",
            () -> new AzaleaGrassBlock(BlockBehaviour.Properties.of(Material.DIRT)
                    .strength(0.6f).sound(SoundType.GRASS)));
    public static final RegistryObject<Block> AZALEA_BUSH = registerBlock("azalea_bush",
            () -> new MossBlock(BlockBehaviour.Properties.of(Material.MOSS)
                    .strength(0f).sound(SoundType.AZALEA).instabreak()));
    public static final RegistryObject<Block> FLOWERING_AZALEA_BUSH = registerBlock("flowering_azalea_bush",
            () -> new MossBlock(BlockBehaviour.Properties.of(Material.MOSS)
                    .strength(0f).sound(SoundType.AZALEA).instabreak()));
    public static final RegistryObject<Block> CRATE = registerBlock("crate",
            () -> new BarrelBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .strength(2f).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> BOX = registerBlock("box",
            () -> new BarrelBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .strength(2f).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> BLASTED_STONE = registerBlock("blasted_stone",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(3f).sound(SoundType.DEEPSLATE_BRICKS)));
    public static final RegistryObject<Block> CAST_IRON = registerBlock("cast_iron",
            () -> new Block(BlockBehaviour.Properties.of(Material.HEAVY_METAL)
                    .strength(3f).sound(SoundType.NETHERITE_BLOCK)));
    public static final RegistryObject<Block> DARK_TILES = registerBlock("dark_tiles",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(3f).sound(SoundType.DEEPSLATE_TILES)));
    public static final RegistryObject<Block> ERODED_DEEPSLATE = registerBlock("eroded_deepslate",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(3f).sound(SoundType.DEEPSLATE_TILES)));

    //Frosted ice

    public static final RegistryObject<Block> THIN_ICE = registerBlock("thin_ice",
            () -> new IceBlock(BlockBehaviour.Properties.of(Material.ICE)
                    .strength(0.5f).sound(SoundType.GLASS).friction(0.98f).noOcclusion()));
    public static final RegistryObject<Block> CHIPPED_ICE = registerBlock("chipped_ice",
            () -> new IceBlock(BlockBehaviour.Properties.of(Material.ICE)
                    .strength(0.5f).sound(SoundType.GLASS).friction(0.98f).noOcclusion()));
    public static final RegistryObject<Block> CRACKED_ICE = registerBlock("cracked_ice",
            () -> new IceBlock(BlockBehaviour.Properties.of(Material.ICE)
                    .strength(0.5f).sound(SoundType.GLASS).friction(0.98f).noOcclusion()));
    public static final RegistryObject<Block> SHATTERED_ICE = registerBlock("shattered_ice",
            () -> new IceBlock(BlockBehaviour.Properties.of(Material.ICE)
                    .strength(0.5f).sound(SoundType.GLASS).friction(0.98f).noOcclusion()));

    public static final RegistryObject<Block> TOUGH_STONE = registerBlock("tough_stone",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(3f).sound(SoundType.STONE)));
    public static final RegistryObject<Block> INSET_STONE = registerBlock("inset_stone",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(1.5f).sound(SoundType.STONE)));
    public static final RegistryObject<Block> INSCRIBED_STONE = registerBlock("inscribed_stone",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(1.5f).sound(SoundType.LODESTONE)));
    public static final RegistryObject<Block> SHELF = registerBlock("shelf",
            () -> new Block(BlockBehaviour.Properties.of(Material.WOOD)
                    .strength(1.5f).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> RAW_MUSHROOM = registerBlock("raw_mushroom",
            () -> new Block(BlockBehaviour.Properties.of(Material.WOOD)
                    .strength(0.2f).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> BOLTED_PLANKS = registerBlock("bolted_planks",
            () -> new Block(BlockBehaviour.Properties.of(Material.WOOD)
                    .strength(2f).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> CENTRIC_BASALT = registerBlock("centric_basalt",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(2f).sound(SoundType.BASALT)));
    public static final RegistryObject<Block> COBBLED_BASALT = registerBlock("cobbled_basalt",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(2f).sound(SoundType.BASALT)));
    public static final RegistryObject<Block> CENTRIC_QUARTZ = registerBlock("centric_quartz",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(2f).sound(SoundType.STONE)));
    public static final RegistryObject<Block> CENTRIC_PURPUR = registerBlock("centric_purpur",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(2f).sound(SoundType.STONE)));
    public static final RegistryObject<Block> STONE_SUPPORT = registerBlock("stone_support",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(2f).sound(SoundType.STONE)));
    public static final RegistryObject<Block> DEEPSLATE_FRAME = registerBlock("deepslate_frame",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(2f).sound(SoundType.DEEPSLATE)));
    public static final RegistryObject<Block> DEEPSLATE_CORE = registerBlock("deepslate_core",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(2f).sound(SoundType.DEEPSLATE)));
    public static final RegistryObject<Block> VOIDED_OBSIDIAN = registerBlock("voided_obsidian",
            () -> new VoidedObsidianBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(2f).sound(SoundType.STONE)
                    .lightLevel(state -> state.getValue(SculkCageBlock.LIT) ? 15 : 0)));
    public static final RegistryObject<Block> BASKET = registerBlock("basket",
            () -> new Block(BlockBehaviour.Properties.of(Material.BAMBOO)
                    .strength(2f).sound(SoundType.SCAFFOLDING).noOcclusion()));
    public static final RegistryObject<Block> SCULK_CAGE = registerBlock("sculk_cage",
            () -> new SculkCageBlock(BlockBehaviour.Properties.of(Material.SCULK)
                    .strength(2f).sound(SoundType.SCULK_SHRIEKER)
                    .lightLevel(state -> state.getValue(SculkCageBlock.LIT) ? 15 : 0)));
    public static final RegistryObject<Block> SCULK_HEART = registerBlock("sculk_heart",
            () -> new Block(BlockBehaviour.Properties.of(Material.SCULK)
                    .strength(2f).sound(SoundType.SCULK_CATALYST)));
    public static final RegistryObject<Block> AZALEA_GROWTH = registerBlock("azalea_growth",
            () -> new GlowLichenBlock(BlockBehaviour.Properties.of(Material.GRASS)
                    .strength(0f).sound(SoundType.GRASS).noOcclusion().noCollission()));
    public static final RegistryObject<Block> FLOWERING_AZALEA_GROWTH = registerBlock("flowering_azalea_growth",
            () -> new GlowLichenBlock(BlockBehaviour.Properties.of(Material.GRASS)
                    .strength(0f).sound(SoundType.GRASS).noOcclusion().noCollission()));
    public static final RegistryObject<Block> GRASS_GROWTH = registerBlock("grass_growth",
            () -> new GlowLichenBlock(BlockBehaviour.Properties.of(Material.GRASS)
                    .strength(0f).sound(SoundType.GRASS).noOcclusion().noCollission()));


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
