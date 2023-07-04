package net.cassidy.recrafted.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.IceBlock;
import net.minecraft.world.level.block.SculkBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.BlockHitResult;

import static org.openjdk.nashorn.internal.objects.NativeMath.random;

public class CrackingIceBlock extends IceBlock {
    public static final IntegerProperty CRACKING = IntegerProperty.create("cracking", 0, 3);

    public CrackingIceBlock(Properties properties) {
        super(properties);
        registerDefaultState(this.defaultBlockState().setValue(CRACKING, 0));
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos blockPos, Player player, InteractionHand hand, BlockHitResult result) {

        if(!level.isClientSide() && hand == InteractionHand.MAIN_HAND && player.getMainHandItem().getItem() instanceof PickaxeItem) {
            if(!state.getValue(CRACKING).equals(3)) {
                level.setBlock(blockPos, state.cycle(CRACKING), 3);
                level.playSound((Player) null, blockPos, SoundEvents.GLASS_BREAK, SoundSource.BLOCKS, 1.0F, 1.0F);
                crackParticles(level, blockPos);
                if(!player.isCreative()) {
                    player.getMainHandItem().setDamageValue(player.getMainHandItem().getDamageValue()+1);
                }
            } else {
                level.destroyBlock(blockPos, true);
                if(!player.isCreative()) {
                    player.getMainHandItem().setDamageValue(player.getMainHandItem().getDamageValue()+1);
                }
            }
            return InteractionResult.SUCCESS;
        }

        return super.use(state, level, blockPos, player, hand, result);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(CRACKING);
    }

    private static void crackParticles(Level level, BlockPos pos) {
        for(int i = 0; i < 25; i++) {
            level.addParticle(new BlockParticleOption(ParticleTypes.BLOCK, Blocks.ICE.defaultBlockState()), pos.getX()+random(1), pos.getY()+random(1), pos.getZ()+random(1), 0.0D, 0.0D, 0.0D);
        }
    }
}
