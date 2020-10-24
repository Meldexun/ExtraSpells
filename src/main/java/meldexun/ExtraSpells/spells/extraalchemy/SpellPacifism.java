package meldexun.ExtraSpells.spells.extraalchemy;

import electroblob.wizardry.spell.SpellBuff;
import meldexun.ExtraSpells.ExtraSpells;
import meldexun.ExtraSpells.integration.ExtraAlchemy;
import meldexun.ExtraSpells.potion.PotionPlaceholder;

public class SpellPacifism extends SpellBuff {

	public SpellPacifism() {
		super(ExtraSpells.MOD_ID, "pacifism", 0.5F, 0.5F, 0.5F, () -> new PotionPlaceholder("effect.pacifism"));
		if (ExtraSpells.extraAlchemyLoaded) {
			this.effects[0] = () -> ExtraAlchemy.getPotionPacifism();
		}
	}

}
