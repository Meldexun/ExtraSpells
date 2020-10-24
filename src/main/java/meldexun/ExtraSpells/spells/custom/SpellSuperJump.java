package meldexun.ExtraSpells.spells.custom;

import electroblob.wizardry.registry.WizardrySounds;
import electroblob.wizardry.spell.Spell;
import electroblob.wizardry.util.SpellModifiers;
import meldexun.ExtraSpells.ExtraSpells;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class SpellSuperJump extends Spell {

	public SpellSuperJump() {
		super(ExtraSpells.MOD_ID, "super_jump", EnumAction.NONE, false);
	}

	@Override
	public boolean cast(World world, EntityPlayer caster, EnumHand hand, int ticksInUse, SpellModifiers modifiers) {
		caster.motionY += 3.0D;
		world.playSound(null, caster.posX, caster.posY + (double) caster.eyeHeight, caster.posZ, this.sounds[0], WizardrySounds.SPELLS, 1.0F, 1.0F);
		return true;
	}

}
