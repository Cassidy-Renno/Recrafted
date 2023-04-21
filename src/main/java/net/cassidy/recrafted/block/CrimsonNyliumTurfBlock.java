package net.cassidy.recrafted.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.IPlantable;

public class CrimsonNyliumTurfBlock extends Block {

    public CrimsonNyliumTurfBlock(Properties properties) {
        super(properties);
    }

    @Override
    public boolean canSustainPlant(BlockState state, BlockGetter world, BlockPos pos, Direction facing, IPlantable plantable) {
        BlockState plant = plantable.getPlant(world, pos.relative(facing));
        return Blocks.CRIMSON_NYLIUM.canSustainPlant(state,world,pos,facing,plantable);
    }
}
