package meldexun.ExtraSpells.spells.custom;

import electroblob.wizardry.registry.WizardryItems;
import electroblob.wizardry.util.SpellModifiers;
import meldexun.ExtraSpells.ExtraSpells;
import meldexun.ExtraSpells.entity.projectile.EntityChargableStrike;
import meldexun.ExtraSpells.spells.AbstractSpellChargable;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.EnumAction;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class SpellChargableStrike extends AbstractSpellChargable {

	public SpellChargableStrike() {
		super(ExtraSpells.MOD_ID, "chargable_strike", EnumAction.NONE, 60, 10);
		this.r = 0.1F;
		this.g = 0.6F;
		this.b = 0.85F;
	}

	@Override
	public void finishTick(World world, EntityLivingBase caster, EnumHand hand, int ticksInUse, SpellModifiers modifiers) {
		if (!world.isRemote) {
			EntityChargableStrike.launch(world, caster, 0.8D * (double) modifiers.get(WizardryItems.range_upgrade), 2.5F * modifiers.get(SpellModifiers.POTENCY));
		}
	}

}
