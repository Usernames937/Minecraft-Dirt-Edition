package net.idk.mcdirt;

public class Data {
    public static class installed_totem {
        public static boolean installed = false;
        public static void set(boolean v) {
            Data.installed_totem.installed = v;
        }
    }
}
