package net.idk.mcdirt;

import net.neoforged.neoforge.common.ModConfigSpec;

public class Config {
    public static class common {
        public static final ModConfigSpec.Builder builder = new ModConfigSpec.Builder();
        public static final ModConfigSpec SPEC;
        public static final ModConfigSpec.BooleanValue ENABLE_DIRT_MINECRAFT;
        public static final ModConfigSpec.BooleanValue REMOVE_PACKAGE_COOLDOWN;

        static {
            builder.push("Basic Configs");
            ENABLE_DIRT_MINECRAFT = builder.comment("Enable Minecraft Dirt Edition").define("enable mcdirt", true);
            REMOVE_PACKAGE_COOLDOWN = builder.comment("Remove the Cooldown for Package - BETA").define("no package cooldown", false);
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
