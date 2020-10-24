package meldexun.ExtraSpells.spells.custom;

import electroblob.wizardry.spell.SpellBuff;
import meldexun.ExtraSpells.ExtraSpells;
import net.minecraft.init.MobEffects;

public class SpellThiefBless extends SpellBuff {

	public SpellThiefBless() {
		super(ExtraSpells.MOD_ID, "thief_bless", 0.1F, 0.4F, 0.6F, () -> MobEffects.STRENGTH, () -> MobEffects.NIGHT_VISION, () -> MobEffects.SPEED);
	}

}
