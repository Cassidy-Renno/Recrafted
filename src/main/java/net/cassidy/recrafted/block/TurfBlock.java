package net.cassidy.recrafted.block;

import net.cassidy.recrafted.Recrafted;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.Tags;

public class TurfBlock extends Block {

    public TurfBlock(Properties properties) {
        super(properties);
    }

    @Override
    public boolean canSustainPlant(BlockState state, BlockGetter world, BlockPos pos, Direction facing, IPlantable plantable) {
        return Blocks.GRASS_BLOCK.canSustainPlant(state,world,pos,facing,plantable);
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos blockPos, Player player, InteractionHand hand, BlockHitResult result) {

        if(!level.isClientSide() && hand == InteractionHand.MAIN_HAND) {
            if(state.getBlock().equals(ModBlocks.TURF.get())) {
                if (player.getMainHandItem().getItem() instanceof ShovelItem) {
                    level.playSound((Player) null, blockPos, SoundEvents.SHOVEL_FLATTEN, SoundSource.BLOCKS, 1.0F, 1.0F);
                    level.setBlockAndUpdate(blockPos, ModBlocks.PATH_TURF.get().defaultBlockState());
                    if(!player.isCreative()) {
                        player.getMainHandItem().setDamageValue(player.getMainHandItem().getDamageValue()+1);
                    }
                    return InteractionResult.SUCCESS;
                } else if(player.getMainHandItem().getItem() instanceof HoeItem) {
                    level.playSound((Player) null, blockPos, SoundEvents.HOE_TILL, SoundSource.BLOCKS, 1.0F, 1.0F);
                    level.setBlockAndUpdate(blockPos, ModBlocks.FARMLAND_TURF.get().defaultBlockState());
                    if(!player.isCreative()) {
                        player.getMainHandItem().setDamageValue(player.getMainHandItem().getDamageValue()+1);
                    }
                    return InteractionResult.SUCCESS;
                }
            }
//            player.sendSystemMessage(Component.literal(state.getBlock().getName().getString()));
//            if(state.getBlock().equals(ModBlocks.FARMLAND_TURF.get())) {
//                if(PotionUtils.getPotion(player.getMainHandItem()) == Potions.WATER) {
//                    level.setBlockAndUpdate(blockPos, ModBlocks.MOIST_FARMLAND_TURF.get().defaultBlockState());
//                    level.playSound((Player) null, blockPos, SoundEvents.BOTTLE_EMPTY, SoundSource.BLOCKS, 1.0F, 1.0F);
//                    return InteractionResult.SUCCESS;
//                }
//            }
        }

        return super.use(state, level, blockPos, player, hand, result);
    }

    @Override
    public void tick(BlockState state, ServerLevel level, BlockPos blockPos, RandomSource source) {
        if (isNearWater(level, blockPos)) {
            level.setBlockAndUpdate(blockPos, ModBlocks.MOIST_FARMLAND_TURF.get().defaultBlockState());
        }
    }

    private static boolean isNearWater(LevelReader levelReader, BlockPos pos) {
        BlockState state = levelReader.getBlockState(pos);
        for(BlockPos blockpos : BlockPos.betweenClosed(pos.offset(-1, 0, -1), pos.offset(1, 1, 1))) {
            return true;
        }
        return net.minecraftforge.common.FarmlandWaterManager.hasBlockWaterTicket(levelReader, pos);
    }

}
