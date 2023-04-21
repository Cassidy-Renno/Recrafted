package net.cassidy.recrafted.block;

import com.mojang.datafixers.types.templates.Tag;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.Tags;

public class MyceliumTurfBlock extends Block {

    public MyceliumTurfBlock(Properties properties) {
        super(properties);
    }

    @Override
    public boolean canSustainPlant(BlockState state, BlockGetter world, BlockPos pos, Direction facing, IPlantable plantable) {
        BlockState plant = plantable.getPlant(world, pos.relative(facing));
        return Blocks.MYCELIUM.canSustainPlant(state,world,pos,facing,plantable);
    }
}
