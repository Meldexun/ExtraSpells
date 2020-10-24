package meldexun.ExtraSpells.spells.extraalchemy;

import electroblob.wizardry.spell.SpellBuff;
import meldexun.ExtraSpells.ExtraSpells;
import meldexun.ExtraSpells.integration.ExtraAlchemy;
import meldexun.ExtraSpells.potion.PotionPlaceholder;

public class SpellTimeTravel extends SpellBuff {

	public SpellTimeTravel() {
		super(ExtraSpells.MOD_ID, "time_travel", 0.5F, 0.5F, 0.5F, () -> new PotionPlaceholder("effect.recall"));
		if (ExtraSpells.extraAlchemyLoaded) {
			this.effects[0] = () -> ExtraAlchemy.getPotionRecall();
		}
	}

}
