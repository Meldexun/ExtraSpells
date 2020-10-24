package meldexun.ExtraSpells.spells.potioncore;

import electroblob.wizardry.spell.SpellBuff;
import meldexun.ExtraSpells.ExtraSpells;
import meldexun.ExtraSpells.integration.PotionCore;
import meldexun.ExtraSpells.potion.PotionPlaceholder;

public class SpellHuntersRevenge extends SpellBuff {

	public SpellHuntersRevenge() {
		super(ExtraSpells.MOD_ID, "hunters_revenge", 0.5F, 0.5F, 0.5F, () -> new PotionPlaceholder("archery"));
		if (ExtraSpells.potionCoreLoaded) {
			this.effects[0] = () -> PotionCore.getPotionArchery();
		}
	}

}
