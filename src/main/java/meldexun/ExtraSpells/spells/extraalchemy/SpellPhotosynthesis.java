package meldexun.ExtraSpells.spells.extraalchemy;

import electroblob.wizardry.spell.SpellBuff;
import meldexun.ExtraSpells.ExtraSpells;
import meldexun.ExtraSpells.integration.ExtraAlchemy;
import meldexun.ExtraSpells.potion.PotionPlaceholder;

public class SpellPhotosynthesis extends SpellBuff {

	public SpellPhotosynthesis() {
		super(ExtraSpells.MOD_ID, "photosynthesis", 0.5F, 0.5F, 0.5F, () -> new PotionPlaceholder("effect.photosynthesis"));
		if (ExtraSpells.extraAlchemyLoaded) {
			this.effects[0] = () -> ExtraAlchemy.getPotionPhotosynthesis();
		}
	}

}
