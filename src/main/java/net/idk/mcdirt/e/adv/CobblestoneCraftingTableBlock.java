package net.idk.mcdirt.e.adv;

import com.mojang.serialization.MapCodec;
import net.idk.mcdirt.e.bEntity._0.CobblestoneCraftingMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.CraftingTableBlock;
import net.minecraft.world.level.block.state.BlockState;

public class CobblestoneCraftingTableBlock extends CraftingTableBlock {
    public static final MapCodec<CobblestoneCraftingTableBlock> CODEC = simpleCodec(CobblestoneCraftingTableBlock::new);
    private static final Component CONTAINER_TITLE = Component.translatable("container.crafting");

    @Override
    public MapCodec<? extends CraftingTableBlock> codec() {
        return CODEC;
    }

    public CobblestoneCraftingTableBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected MenuProvider getMenuProvider(BlockState state, Level level, BlockPos pos) {
        return new SimpleMenuProvider((containerId, playerInventory, player) -> new CobblestoneCraftingMenu(containerId, playerInventory, ContainerLevelAccess.create(level, pos)), CONTAINER_TITLE);
    }
}
