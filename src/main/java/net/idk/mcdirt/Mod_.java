package net.idk.mcdirt;

import com.mojang.logging.LogUtils;
import net.idk.mcdirt.e.B;
import net.idk.mcdirt.e.C;
import net.idk.mcdirt.e.I;
import net.minecraft.util.Tuple;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.util.thread.SidedThreadGroups;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import net.neoforged.neoforge.event.tick.ServerTickEvent;
import org.slf4j.Logger;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

@Mod(Mod_.ID)
public class Mod_ {
    public static final String ID = "mcdirt";
    public static final String ID_C = ID + ":";
    private static final Logger LOGGER = LogUtils.getLogger();
    public Mod_(IEventBus e, ModContainer modContainer) {
        e.addListener(this::commonSetup);
        NeoForge.EVENT_BUS.register(this);
        e.addListener(this::addCreative);

        modContainer.registerConfig(ModConfig.Type.COMMON, Config.common.SPEC);
        modContainer.registerConfig(ModConfig.Type.SERVER, Config.server.SPEC);
        modContainer.registerConfig(ModConfig.Type.CLIENT, Config.client.SPEC);

        I.register(e);
        B.register(e);
        C.register(e);
    }

    private static final Collection<Tuple<Runnable, Integer>> workQueue = new ConcurrentLinkedQueue<>();
    public static void queueServer(int tick, Runnable action) {
        if (Thread.currentThread().getThreadGroup() == SidedThreadGroups.SERVER)
            workQueue.add(new Tuple<>(action, tick));
    }
    @SubscribeEvent
    public void tick(ServerTickEvent.Post event) {
        List<Tuple<Runnable, Integer>> actions = new ArrayList<>();
        workQueue.forEach(work -> {
            work.setB((Integer) (work.getB() - 1));
            if (work.getB() == 0)
                actions.add(work);
        });
        actions.forEach(e -> e.getA().run());
        workQueue.removeAll(actions);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
    }

    @EventBusSubscriber(modid = ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
        }
    }
}
