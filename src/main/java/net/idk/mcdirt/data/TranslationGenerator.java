package net.idk.mcdirt.data;

import net.idk.mcdirt.Mod_;
import net.idk.mcdirt.e.B;
import net.idk.mcdirt.e.I;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;

public class TranslationGenerator {
    public static class en_us extends LanguageProvider {
        public en_us(PackOutput output, String locale) {
            super(output, Mod_.ID, locale);
        }

        @Override
        protected void addTranslations() {
            for (int i = 0; i < 25; i++) {
                int v = i + 1;
                addBlock(B.DIRTS[i], "Dirt " + v);
            }
            addItem(I.TOTEM_OF_COMPELETION, "Totem of Compeletion");
        }
    }
}
