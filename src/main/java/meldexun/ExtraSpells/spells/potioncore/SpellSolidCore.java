package meldexun.ExtraSpells.spells.potioncore;

import electroblob.wizardry.spell.SpellBuff;
import meldexun.ExtraSpells.ExtraSpells;
import meldexun.ExtraSpells.integration.PotionCore;
import meldexun.ExtraSpells.potion.PotionPlaceholder;
import net.minecraft.init.MobEffects;

public class SpellSolidCore extends SpellBuff {

	public SpellSolidCore() {
		super(ExtraSpells.MOD_ID, "solid_core", 0.5F, 0.5F, 0.5F, () -> new PotionPlaceholder("solid_core"), () -> MobEffects.SLOWNESS);
		if (ExtraSpells.potionCoreLoaded) {
			this.effects[0] = () -> PotionCore.getPotionSolidCore();
		}
	}

}
