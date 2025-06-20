package net.idk.mcdirt.v;

import net.idk.mcdirt.Config;
import net.idk.mcdirt.Data;
import net.idk.mcdirt.Mod_;
import net.idk.mcdirt.e.I;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.EventBusSubscriber.Bus;
import net.neoforged.neoforge.event.RegisterCommandsEvent;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;

@EventBusSubscriber(modid = Mod_.ID, bus = Bus.GAME)
public class $ {
    @SubscribeEvent
    public static void _1e(RegisterCommandsEvent _p) {
        _p.getDispatcher().register(Commands.literal("download")
                .requires(q -> {
                    return q.isPlayer() && !Data.installed_totem.installed;
                }).then(Commands.literal("totem_action").executes(p -> {
                    if (p.getSource().getPlayer() != null) {
                        Player _sp = p.getSource().getPlayer();
                        String[] dList = {
                                "advancement builder",
                                "advancement getter",
                                "advancement constractor",
                                "advancement executor",
                                "item consumer",
                                "item functioner",
                                "item register",
                                "item setter",
                                "function builder",
                                "function register",
                                "function executor",
                                "calculator",
                                "starter",
                        };
                        for (int i = 0; i < dList.length; i++) {
                            _sp.displayClientMessage(Component.literal("downloading " + dList[i] + "..."), false);
                        }
                        _sp.displayClientMessage(Component.literal("Finishing..."), false);
                        if (!Config.common.ENABLE_DIRT_MINECRAFT.get()) {
                            _sp.displayClientMessage(Component.literal(ChatFormatting.RED + "\nWARNING: Minecraft Dirt Edition is NOT enabled," +
                                    "\nTo make this actually functional, enable minecraft dirt edition.\n\n\n"), false);
                        }
                        _sp.displayClientMessage(Component.literal("\n> Finished"), false);
                        Data.installed_totem.set(true);
                    }
                    return 0;
                })));
    }

    @SubscribeEvent
    public static void _2e(PlayerInteractEvent.RightClickItem _p) {
        ItemStack stack = _p.getItemStack();
        if (Data.installed_totem.installed && Config.common.ENABLE_DIRT_MINECRAFT.get() && stack.is(I.TOTEM_OF_COMPELETION)) {
            LivingEntity entity = _p.getEntity();
            Level l = entity.level();
            if (entity instanceof ServerPlayer s && l instanceof ServerLevel sl) {
                sl.getServer().getCommands().performPrefixedCommand(
                        new CommandSourceStack(CommandSource.NULL, s.getPosition(0), s.getRotationVector(),
                                s.level() instanceof ServerLevel ? (ServerLevel) s.level() : null, 4,
                                s.getName().getString(), s.getDisplayName(), s.getServer(), s),
                        "advancement grant " + s.getName().getString() + " everything"
                );
                stack.consume(1, entity);
                ServerLevel end = s.server.getLevel(Level.END);
                s.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 60, 4, false, false));
                s.teleportTo(end, 0, 100, 0, 180, 0);
                Minecraft.getInstance().gameRenderer.displayItemActivation(stack);
                sl.playSound(s, s.getX(), s.getY(), s.getZ(), SoundEvents.TOTEM_USE, SoundSource.MASTER);
                sl.sendParticles(ParticleTypes.TOTEM_OF_UNDYING, s.getX(), s.getY(), s.getZ(), 1000, 1.5, 1.5, 1.5, 1);
                ServerLevel overworld = s.server.getLevel(Level.OVERWORLD);
                Mod_.queueServer(100, new Runnable() {
                    @Override
                    public void run() {
                        sl.getServer().getCommands().performPrefixedCommand(
                                new CommandSourceStack(CommandSource.NULL, s.getPosition(0), s.getRotationVector(),
                                        s.level() instanceof ServerLevel ? (ServerLevel) s.level() : null, 4,
                                        s.getName().getString(), s.getDisplayName(), s.getServer(), s),
                                "damage @n[type=ender_dragon] 100000 minecraft:explosion"
                        );
                        //s.showEndCredits();
                        s.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 180 * 20, 4, false, false));
                        //Mod_.queueServer(20, () -> s.teleportTo(overworld, s.getX(), s.getY(), s.getZ(), 180, 0));
                    }
                });
                s.addItem(new ItemStack(Items.BEACON, 16));
                s.setExperienceLevels(Integer.MAX_VALUE - 1);
            }
        } else {
            return;
        }
    }
}
