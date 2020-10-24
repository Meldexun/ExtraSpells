package meldexun.ExtraSpells.spells.potioncore;

import electroblob.wizardry.util.SpellModifiers;
import meldexun.ExtraSpells.ExtraSpells;
import meldexun.ExtraSpells.integration.PotionCore;
import meldexun.ExtraSpells.spells.AbstractSpellChargable;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.EnumAction;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class SpellMagicShield extends AbstractSpellChargable {

	public SpellMagicShield() {
		super(ExtraSpells.MOD_ID, "magic_shield", EnumAction.NONE, 60, 10);
		this.r = 0.85F;
		this.g = 0.1F;
		this.b = 0.6F;
		this.loopPitchStart = 0.9F;
		this.loopPitchEnd = 0.9F;
	}

	@Override
	public void finishTick(World world, EntityLivingBase caster, EnumHand hand, int ticksInUse, SpellModifiers modifiers) {
		if (!world.isRemote) {
			if (ExtraSpells.potionCoreLoaded) {
				caster.addPotionEffect(new PotionEffect(PotionCore.getPotionMagicShield(), 300, 2));
			}
		}
	}

}
