package meldexun.ExtraSpells.integration;

import net.minecraft.potion.Potion;
import zabi.minecraft.extraalchemy.potion.PotionReference;

public class ExtraAlchemy {

	public static Potion getPotion(String key) {
		return null;
	}

	public static Potion getPotionReturn() {
		return PotionReference.INSTANCE.RETURN;
	}

	public static Potion getPotionPacifism() {
		return PotionReference.INSTANCE.PACIFISM;
	}

	public static Potion getPotionPhotosynthesis() {
		return PotionReference.INSTANCE.PHOTOSYNTHESIS;
	}

	public static Potion getPotionRecall() {
		return PotionReference.INSTANCE.RECALL;
	}

}
