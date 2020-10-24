package meldexun.ExtraSpells.spells.potioncore;

import electroblob.wizardry.spell.SpellBuff;
import meldexun.ExtraSpells.ExtraSpells;
import meldexun.ExtraSpells.integration.PotionCore;
import meldexun.ExtraSpells.potion.PotionPlaceholder;

public class SpellMagicalOffence extends SpellBuff {

	public SpellMagicalOffence() {
		super(ExtraSpells.MOD_ID, "magical_offence", 0.5F, 0.5F, 0.5F, () -> new PotionPlaceholder("magic_focus"), () -> new PotionPlaceholder("vulnerable"));
		if (ExtraSpells.potionCoreLoaded) {
			this.effects[0] = () -> PotionCore.getPotionMagicFocus();
			this.effects[1] = () -> PotionCore.getPotionVulnerable();
		}
	}

}
