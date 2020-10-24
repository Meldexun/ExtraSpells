package meldexun.ExtraSpells.spells.custom;

import electroblob.wizardry.spell.SpellBuff;
import meldexun.ExtraSpells.ExtraSpells;
import net.minecraft.init.MobEffects;

public class SpellTribalBless extends SpellBuff {

	public SpellTribalBless() {
		super(ExtraSpells.MOD_ID, "tribal_bless", 0.1F, 0.1F, 0.3F, () -> MobEffects.STRENGTH, () -> MobEffects.NIGHT_VISION, () -> MobEffects.JUMP_BOOST);
	}

}
