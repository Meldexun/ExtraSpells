package meldexun.ExtraSpells.spells.potioncore;

import electroblob.wizardry.spell.SpellBuff;
import meldexun.ExtraSpells.ExtraSpells;
import meldexun.ExtraSpells.integration.PotionCore;
import meldexun.ExtraSpells.potion.PotionPlaceholder;

public class SpellReturn extends SpellBuff {

	public SpellReturn() {
		super(ExtraSpells.MOD_ID, "return", 0.5F, 0.5F, 0.5F, () -> new PotionPlaceholder("teleport_spawn"));
		if (ExtraSpells.potionCoreLoaded) {
			this.effects[0] = () -> PotionCore.getPotionTeleportSpawn();
		}
	}

}
