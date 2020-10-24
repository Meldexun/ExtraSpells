package meldexun.ExtraSpells.spells.custom;

import electroblob.wizardry.spell.SpellBuff;
import meldexun.ExtraSpells.ExtraSpells;
import meldexun.ExtraSpells.init.ModPotions;

public class SpellVampirism extends SpellBuff {

	public SpellVampirism() {
		super(ExtraSpells.MOD_ID, "vampirism", 0.6F, 0.1F, 0.4F, () -> ModPotions.VAMPIRISM);
	}

}
