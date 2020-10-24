package meldexun.ExtraSpells.spells.custom;

import electroblob.wizardry.spell.SpellBuff;
import meldexun.ExtraSpells.ExtraSpells;
import net.minecraft.init.MobEffects;

public class SpellScaleBless extends SpellBuff {

	public SpellScaleBless() {
		super(ExtraSpells.MOD_ID, "scale_bless", 1.0F, 0.1F, 0.05F, () -> MobEffects.STRENGTH, () -> MobEffects.RESISTANCE, () -> MobEffects.FIRE_RESISTANCE);
	}

}
