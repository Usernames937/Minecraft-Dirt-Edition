package net.idk.mcdirt;

import net.neoforged.neoforge.common.ModConfigSpec;

public class Config {
    public static class common {
        public static final ModConfigSpec.Builder builder = new ModConfigSpec.Builder();
        public static final ModConfigSpec SPEC;
        public static final ModConfigSpec.BooleanValue ENABLE_DIRT_MINECRAFT;

        static {
            builder.push("Basic Configs");
            ENABLE_DIRT_MINECRAFT = builder.comment("Enable Minecraft Dirt Edition").define("enable", true);
            builder.pop();

            SPEC = builder.build();
        }
    }
    public static class client {
        public static final ModConfigSpec.Builder builder = new ModConfigSpec.Builder();
        public static final ModConfigSpec SPEC;

        static {
            builder.push("Basic Configs");
            builder.pop();

            SPEC = builder.build();
        }
    }
    public static class server {
        public static final ModConfigSpec.Builder builder = new ModConfigSpec.Builder();
        public static final ModConfigSpec SPEC;

        static {
            builder.push("Basic Configs");
            builder.pop();

            SPEC = builder.build();
        }
    }
}
