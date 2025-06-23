package net.idk.mcdirt.e.adv;

import net.idk.mcdirt.Config;
import net.idk.mcdirt.Data;
import net.idk.mcdirt.e.I;
import net.minecraft.core.component.DataComponents;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemCooldowns;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;

public class PackageItem extends Item {
    public PackageItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);
        if (!Config.common.REMOVE_PACKAGE_COOLDOWN.get()) {
            player.getCooldowns().addCooldown(this, 5);
        }
        if (!new ItemCooldowns().isOnCooldown(this)) {
            int pNumber = -1;
            for (int i = 0; i < I.PACKAGES.length; i++) {
                if (stack.is(I.PACKAGES[i])) {
                    pNumber = i;
                    break;
                }
            }
            if (pNumber != -1 && pNumber != 8) {
                for (int i = 0; i < PackageItem.packs[pNumber].length; i++) {
                    if (pNumber == 2 && i == 0)
                        PackageItem.setData_p2();
                    player.drop(PackageItem.packs[pNumber][i].copy(), true);
                    level.playSound(player, player.getX(), player.getY(), player.getZ(), SoundEvents.BUNDLE_DROP_CONTENTS, SoundSource.PLAYERS);
                }
                stack.consume(1, player);
            } else if (pNumber == 8) {
                for (int i = 0; i < 3; i++) {
                    int v = Data.randomInt(PackageItem.packs[pNumber].length, 0) - 1;
                    player.drop(PackageItem.packs[pNumber][v].copy(), true);
                }
                level.playSound(player, player.getX(), player.getY(), player.getZ(), SoundEvents.BUNDLE_DROP_CONTENTS, SoundSource.PLAYERS);
                stack.consume(1, player);
            }
        }
        return InteractionResultHolder.sidedSuccess(stack, level.isClientSide());
    }
    public static ItemStack[] pack0 = {
            new ItemStack(Items.NETHERITE_PICKAXE),
            new ItemStack(Items.NETHERITE_AXE),
            new ItemStack(Items.NETHERITE_SHOVEL),
            new ItemStack(Items.NETHERITE_SWORD),
            new ItemStack(Items.NETHERITE_HOE),
    };
    public static ItemStack[] pack1 = {
            new ItemStack(Items.NETHERITE_HELMET),
            new ItemStack(Items.NETHERITE_LEGGINGS),
            new ItemStack(Items.NETHERITE_CHESTPLATE),
            new ItemStack(Items.NETHERITE_BOOTS),
    };
    public static ItemStack[] pack2 = {
            new ItemStack(Items.TOTEM_OF_UNDYING, 32),
    };
    public static void setData_p2() {
        pack2[0].set(DataComponents.MAX_STACK_SIZE, 32);
    }
    public static ItemStack[] pack3 = {
            new ItemStack(Items.GOLDEN_CARROT, 64),
            new ItemStack(Items.GOLDEN_CARROT, 64),
    };
    public static ItemStack[] pack4 = {
            new ItemStack(Items.COOKED_BEEF, 64),
            new ItemStack(Items.COOKED_BEEF, 64),
    };
    public static ItemStack[] pack5 = {
            new ItemStack(Items.ENDER_PEARL, 16),
            new ItemStack(Items.ENDER_PEARL, 16),
    };
    public static ItemStack[] pack6 = {
            new ItemStack(Items.COBBLESTONE, 64),
            new ItemStack(Items.IRON_INGOT, 64),
            new ItemStack(Items.GOLD_INGOT, 64),
            new ItemStack(Items.DIAMOND, 32),
            new ItemStack(Items.OAK_LOG, 64),
    };
    public static ItemStack[] pack7 = {
            new ItemStack(Items.ELYTRA),
            new ItemStack(Items.FIREWORK_ROCKET, 64),
            new ItemStack(Items.FIREWORK_ROCKET, 64),
            new ItemStack(Items.FIREWORK_ROCKET, 64),
    };
    public static ItemStack[] pack8 = {
            new ItemStack(Items.BEDROCK, 8),
            new ItemStack(Items.COMMAND_BLOCK, 4),
            new ItemStack(Items.REPEATING_COMMAND_BLOCK, 4),
            new ItemStack(Items.CHAIN_COMMAND_BLOCK, 4),
            new ItemStack(Items.REINFORCED_DEEPSLATE, 32),
            new ItemStack(Items.DRAGON_EGG, 5),
            new ItemStack(Items.TRIAL_SPAWNER, 12),
            new ItemStack(Items.VAULT, 12),
    };
    public static ItemStack[][] packs = {
            pack0, pack1, pack2, pack3, pack4, pack5, pack6, pack7, pack8,
    };
}
