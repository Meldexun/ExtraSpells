package meldexun.ExtraSpells.spells.custom;

import electroblob.wizardry.registry.WizardrySounds;
import electroblob.wizardry.spell.Spell;
import electroblob.wizardry.util.SpellModifiers;
import meldexun.ExtraSpells.ExtraSpells;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.World;

public class SpellTimeManipulator extends Spell {

	public SpellTimeManipulator() {
		super(ExtraSpells.MOD_ID, "time_manipulator", EnumAction.NONE, false);
	}

	@Override
	protected SoundEvent[] createSounds() {
		return new SoundEvent[] { WizardrySounds.createSound("spell." + this.getRegistryName().getPath() + ".day"), WizardrySounds.createSound("spell." + this.getRegistryName().getPath() + ".night") };
	}

	@Override
	public boolean cast(World world, EntityPlayer caster, EnumHand hand, int ticksInUse, SpellModifiers modifiers) {
		if (caster.dimension == 0) {
			if (!world.isRemote) {
				long time = world.getWorldTime() % 24000L;
				if (time > 1000 && time < 13000) {
					caster.sendMessage(new TextComponentTranslation("spell.extra_spells:time_manipulator.night"));
					world.setWorldTime(13000);
					world.playSound(null, caster.posX, caster.posY + (double) caster.eyeHeight, caster.posZ, this.sounds[1], WizardrySounds.SPELLS, 0.8F, 1.0F);
				} else {
					caster.sendMessage(new TextComponentTranslation("spell.extra_spells:time_manipulator.day"));
					world.setWorldTime(1000);
					world.playSound(null, caster.posX, caster.posY + (double) caster.eyeHeight, caster.posZ, this.sounds[0], WizardrySounds.SPELLS, 0.8F, 1.0F);
				}
			}
			return true;
		}
		return false;
	}

}
