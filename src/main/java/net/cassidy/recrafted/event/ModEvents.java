package net.cassidy.recrafted.event;
/*

 */

import net.cassidy.recrafted.Recrafted;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.common.Tags;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.cassidy.recrafted.block.ModBlocks;

import static org.openjdk.nashorn.internal.objects.NativeMath.random;

//@Mod.EventBusSubscriber(modid = Recrafted.MOD_ID)
public class ModEvents {
    @Mod.EventBusSubscriber(modid = Recrafted.MOD_ID)
    public static class ForgeEvents {
        @FunctionalInterface
        public interface InteractionEvent {
            InteractionResult run(Item i, ItemStack stack,
                BlockPos pos,
                BlockState state,
                Player player, Level level,
                InteractionHand hand,
                BlockHitResult hit);
        }

        @SubscribeEvent
        public static void onShearGrass(PlayerInteractEvent.RightClickBlock event) {
            Level level = event.getLevel();
            BlockPos pos = event.getHitVec().getBlockPos();
            if(level.getBlockState(pos).is(Blocks.GRASS_BLOCK) && event.getEntity().getMainHandItem().is(Items.SHEARS)) {
                event.getLevel().playSound((Player) null, event.getPos(), SoundEvents.SHEEP_SHEAR, SoundSource.BLOCKS, 1.0F, 1.0F);
                level.setBlockAndUpdate(pos, Blocks.DIRT.defaultBlockState());
                event.getEntity().swing(InteractionHand.MAIN_HAND);
                ItemStack droppedItem = new ItemStack(Item.byBlock(ModBlocks.GRASS_GROWTH.get()), 5);
                ItemEntity entityItem = new ItemEntity(level, pos.getX(), pos.getY(), pos.getZ(), droppedItem);
                level.addFreshEntity(entityItem);
                if(!event.getEntity().isCreative()) {
                    event.getEntity().getMainHandItem().setDamageValue(event.getEntity().getMainHandItem().getDamageValue()+1);
                }
            }
        }

        @SubscribeEvent
        public static void onShearAzalea(PlayerInteractEvent.RightClickBlock event) {
            Level level = event.getLevel();
            BlockPos pos = event.getHitVec().getBlockPos();
            if(event.getEntity().getMainHandItem().is(Items.SHEARS)) {
                if (level.getBlockState(pos).is(Blocks.AZALEA)) {
                    ItemStack droppedItem = new ItemStack(Item.byBlock(ModBlocks.AZALEA_GROWTH.get()), 5);
                    ItemEntity entityItem = new ItemEntity(level, pos.getX(), pos.getY(), pos.getZ(), droppedItem);
                    level.addFreshEntity(entityItem);
                    event.getLevel().playSound((Player) null, event.getPos(), SoundEvents.SHEEP_SHEAR, SoundSource.BLOCKS, 1.0F, 1.0F);
                    level.setBlockAndUpdate(pos, Blocks.AIR.defaultBlockState());
                    event.getEntity().swing(InteractionHand.MAIN_HAND);
                    if(!event.getEntity().isCreative()) {
                        event.getEntity().getMainHandItem().setDamageValue(event.getEntity().getMainHandItem().getDamageValue()+1);
                    }
                } else if(level.getBlockState(pos).is(Blocks.FLOWERING_AZALEA)) {
                    ItemStack droppedItem = new ItemStack(Item.byBlock(ModBlocks.FLOWERING_AZALEA_GROWTH.get()), 5);
                    ItemEntity entityItem = new ItemEntity(level, pos.getX(), pos.getY(), pos.getZ(), droppedItem);
                    level.addFreshEntity(entityItem);
                    event.getLevel().playSound((Player) null, event.getPos(), SoundEvents.SHEEP_SHEAR, SoundSource.BLOCKS, 1.0F, 1.0F);
                    level.setBlockAndUpdate(pos, Blocks.AIR.defaultBlockState());
                    event.getEntity().swing(InteractionHand.MAIN_HAND);
                    if(!event.getEntity().isCreative()) {
                        event.getEntity().getMainHandItem().setDamageValue(event.getEntity().getMainHandItem().getDamageValue()+1);
                    }
                }
            }
        }
        @SubscribeEvent
        public static void onShearAzaleaGrass(PlayerInteractEvent.RightClickBlock event) {
            Level level = event.getLevel();
            BlockPos pos = event.getHitVec().getBlockPos();
            if(event.getEntity().getMainHandItem().is(Items.SHEARS)) {
                if (level.getBlockState(pos).is(ModBlocks.AZALEA_GRASS.get())) {
                    ItemStack droppedItem = new ItemStack(Item.byBlock(ModBlocks.AZALEA_GROWTH.get()), 5);
                    ItemEntity entityItem = new ItemEntity(level, pos.getX(), pos.getY(), pos.getZ(), droppedItem);
                    level.addFreshEntity(entityItem);
                    event.getLevel().playSound((Player) null, event.getPos(), SoundEvents.SHEEP_SHEAR, SoundSource.BLOCKS, 1.0F, 1.0F);
                    level.setBlockAndUpdate(pos, Blocks.DIRT.defaultBlockState());
                    event.getEntity().swing(InteractionHand.MAIN_HAND);
                    if(!event.getEntity().isCreative()) {
                        event.getEntity().getMainHandItem().setDamageValue(event.getEntity().getMainHandItem().getDamageValue()+1);
                    }
                } else if(level.getBlockState(pos).is(ModBlocks.FLOWERING_AZALEA_GRASS.get())) {
                    ItemStack droppedItem = new ItemStack(Item.byBlock(ModBlocks.FLOWERING_AZALEA_GROWTH.get()), 5);
                    ItemEntity entityItem = new ItemEntity(level, pos.getX(), pos.getY(), pos.getZ(), droppedItem);
                    level.addFreshEntity(entityItem);
                    event.getLevel().playSound((Player) null, event.getPos(), SoundEvents.SHEEP_SHEAR, SoundSource.BLOCKS, 1.0F, 1.0F);
                    level.setBlockAndUpdate(pos, Blocks.DIRT.defaultBlockState());
                    event.getEntity().swing(InteractionHand.MAIN_HAND);
                    if(!event.getEntity().isCreative()) {
                        event.getEntity().getMainHandItem().setDamageValue(event.getEntity().getMainHandItem().getDamageValue()+1);
                    }
                }
            }
        }

        @SubscribeEvent
        public static void onScrapeDeepslate(PlayerInteractEvent.RightClickBlock event) {
            Level level = event.getLevel();
            BlockPos pos = event.getHitVec().getBlockPos();
            if(event.getEntity().getMainHandItem().getItem() instanceof PickaxeItem) {
                if (level.getBlockState(pos).is(Blocks.DEEPSLATE)) {
                    event.getLevel().playSound((Player) null, event.getPos(), SoundEvents.GRINDSTONE_USE, SoundSource.BLOCKS, 1.0F, 1.0F);
                    level.setBlockAndUpdate(pos, ModBlocks.ERODED_DEEPSLATE.get().defaultBlockState());
                    event.getEntity().swing(InteractionHand.MAIN_HAND);
                    if(!event.getEntity().isCreative()) {
                        event.getEntity().getMainHandItem().setDamageValue(event.getEntity().getMainHandItem().getDamageValue()+1);
                    }
                }
            }
        }

        @SubscribeEvent
        public static void onScrapeStone(PlayerInteractEvent.RightClickBlock event) {
            Level level = event.getLevel();
            BlockPos pos = event.getHitVec().getBlockPos();
            if(event.getEntity().getMainHandItem().getItem() instanceof PickaxeItem) {
                if (level.getBlockState(pos).is(ModBlocks.INSET_STONE.get())) {
                    event.getLevel().playSound((Player) null, event.getPos(), SoundEvents.GRINDSTONE_USE, SoundSource.BLOCKS, 1.0F, 1.0F);
                    level.setBlockAndUpdate(pos, ModBlocks.INSCRIBED_STONE.get().defaultBlockState());
                    event.getEntity().swing(InteractionHand.MAIN_HAND);
                    if(!event.getEntity().isCreative()) {
                        event.getEntity().getMainHandItem().setDamageValue(event.getEntity().getMainHandItem().getDamageValue()+1);
                    }
                }
            }
        }

        @SubscribeEvent
        public static void onStripMushroom(PlayerInteractEvent.RightClickBlock event) {
            Level level = event.getLevel();
            BlockPos pos = event.getHitVec().getBlockPos();
            if(event.getEntity().getMainHandItem().getItem() instanceof AxeItem) {
                if (level.getBlockState(pos).is(Blocks.MUSHROOM_STEM) || level.getBlockState(pos).is(Blocks.RED_MUSHROOM_BLOCK) || level.getBlockState(pos).is(Blocks.BROWN_MUSHROOM_BLOCK)) {
                    event.getLevel().playSound((Player) null, event.getPos(), SoundEvents.AXE_STRIP, SoundSource.BLOCKS, 1.0F, 1.0F);
                    level.setBlockAndUpdate(pos, ModBlocks.RAW_MUSHROOM.get().defaultBlockState());
                    event.getEntity().swing(InteractionHand.MAIN_HAND);
                    if(!event.getEntity().isCreative()) {
                        event.getEntity().getMainHandItem().setDamageValue(event.getEntity().getMainHandItem().getDamageValue()+1);
                    }
                }
            }
        }

        @SubscribeEvent
        public static void onOilWood(PlayerInteractEvent.RightClickBlock event) {
            Level level = event.getLevel();
            BlockPos pos = event.getHitVec().getBlockPos();
            if(event.getEntity().getMainHandItem().getItem().equals(Items.INK_SAC)) {
                if (level.getBlockState(pos).is(Blocks.DARK_OAK_PLANKS)) {
                    event.getLevel().playSound((Player) null, event.getPos(), SoundEvents.SLIME_SQUISH_SMALL, SoundSource.BLOCKS, 1.0F, 1.0F);
                    level.setBlockAndUpdate(pos, ModBlocks.OILED_WOOD.get().defaultBlockState());
                    event.getEntity().swing(InteractionHand.MAIN_HAND);
                    if(!event.getEntity().isCreative()) {
                        event.getEntity().getMainHandItem().setCount(event.getEntity().getMainHandItem().getCount()-1);
                    }
                }
            }
        }

        @SubscribeEvent
        public static void onPolish(PlayerInteractEvent.RightClickBlock event) {
            Level level = event.getLevel();
            BlockPos pos = event.getHitVec().getBlockPos();
            if(event.getEntity().getMainHandItem().getItem().equals(Items.HONEYCOMB)) {
                if (level.getBlockState(pos).is(Blocks.BIRCH_PLANKS)) {
                    event.getLevel().playSound((Player) null, event.getPos(), SoundEvents.HONEYCOMB_WAX_ON, SoundSource.BLOCKS, 1.0F, 1.0F);
                    level.setBlockAndUpdate(pos, ModBlocks.POLISHED_WOOD.get().defaultBlockState());
                    event.getEntity().swing(InteractionHand.MAIN_HAND);
                    if(!event.getEntity().isCreative()) {
                        event.getEntity().getMainHandItem().setCount(event.getEntity().getMainHandItem().getCount()-1);
                    }
                } else if (level.getBlockState(pos).is(Blocks.STONE)) {
                    event.getLevel().playSound((Player) null, event.getPos(), SoundEvents.HONEYCOMB_WAX_ON, SoundSource.BLOCKS, 1.0F, 1.0F);
                    level.setBlockAndUpdate(pos, ModBlocks.POLISHED_STONE.get().defaultBlockState());
                    event.getEntity().swing(InteractionHand.MAIN_HAND);
                    if(!event.getEntity().isCreative()) {
                        event.getEntity().getMainHandItem().setCount(event.getEntity().getMainHandItem().getCount()-1);
                    }
                }
            }
        }

    }
}

