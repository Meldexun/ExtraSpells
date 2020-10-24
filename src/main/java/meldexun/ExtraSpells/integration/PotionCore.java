package meldexun.ExtraSpells.integration;

import com.tmtravlr.potioncore.PotionCoreEffects;
import com.tmtravlr.potioncore.potion.PotionArchery;
import com.tmtravlr.potioncore.potion.PotionBrokenArmor;
import com.tmtravlr.potioncore.potion.PotionMagicFocus;
import com.tmtravlr.potioncore.potion.PotionMagicShield;
import com.tmtravlr.potioncore.potion.PotionSolidCore;
import com.tmtravlr.potioncore.potion.PotionTeleportSpawn;
import com.tmtravlr.potioncore.potion.PotionTeleportSurface;
import com.tmtravlr.potioncore.potion.PotionVulnerable;

import net.minecraft.potion.Potion;

public class PotionCore {

	public static Potion getPotion(String key) {
		return PotionCoreEffects.POTIONS.get(key);
	}

	public static Potion getPotionBrokenArmor() {
		return PotionBrokenArmor.INSTANCE;
	}

	public static Potion getPotionArchery() {
		return PotionArchery.INSTANCE;
	}

	public static Potion getPotionMagicFocus() {
		return PotionMagicFocus.INSTANCE;
	}

	public static Potion getPotionMagicShield() {
		return PotionMagicShield.INSTANCE;
	}

	public static Potion getPotionTeleportSpawn() {
		return PotionTeleportSpawn.INSTANCE;
	}

	public static Potion getPotionSolidCore() {
		return PotionSolidCore.INSTANCE;
	}

	public static Potion getPotionTeleportSurface() {
		return PotionTeleportSurface.INSTANCE;
	}

	public static Potion getPotionVulnerable() {
		return PotionVulnerable.INSTANCE;
	}

}
