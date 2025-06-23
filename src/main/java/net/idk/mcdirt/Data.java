package net.idk.mcdirt;

import java.util.Random;

public class Data {
    public static class installed_totem {
        public static boolean installed = false;
        public static void set(boolean v) {
            Data.installed_totem.installed = v;
        }
    }
    public static int randomInt(int max, int min) {
        return new Random().nextInt(max - min + min) + 1;
    }
}
