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

        private static final String[] itemNames1 = {
                "Tool Package",
                "Armor Package",
                "Totem Package",
                "Food Package 1",
                "Food Package 2",
                "Pearl Package",
                "Material Package",
                "Flying Package",
        };
        @Override
        protected void addTranslations() {
            for (int i = 0; i < 25; i++) {
                int v = i + 1;
                addBlock(B.DIRTS[i], "Dirt " + v);
            }
            addItem(I.TOTEM_OF_COMPELETION, "Totem of Compeletion");
            for (int i = 0; i < I.PACKAGES.length; i++) {
                addItem(I.PACKAGES[i], itemNames1[i]);
            }
        }
    }
}
