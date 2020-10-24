package meldexun.ExtraSpells.client.audio;

import electroblob.wizardry.item.ItemWand;
import electroblob.wizardry.registry.WizardrySounds;
import electroblob.wizardry.util.WandHelper;
import meldexun.ExtraSpells.spells.AbstractSpellChargable;
import net.minecraft.client.audio.MovingSound;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.MathHelper;

public class MovingSoundSpell extends MovingSound {

	private final EntityLivingBase caster;
	private final AbstractSpellChargable spell;
	private int tick;

	public MovingSoundSpell(SoundEvent soundIn, EntityLivingBase caster, AbstractSpellChargable spell) {
		super(soundIn, WizardrySounds.SPELLS);
		this.repeat = true;
		this.repeatDelay = 0;
		this.volume = 1.0F;
		this.pitch = 1.0F;
		this.caster = caster;
		this.spell = spell;
	}

	@Override
	public void update() {
		if (!this.caster.isEntityAlive() || !this.isCastingSpell() || this.tick >= this.spell.getTickLimit()) {
			this.donePlaying = true;
			this.volume = 0.0F;
		} else {
			this.tick++;
			this.xPosF = (float) this.caster.posX;
			this.yPosF = (float) this.caster.posY + this.caster.getEyeHeight();
			this.zPosF = (float) this.caster.posZ;
			float f1 = (this.spell.getLoopVolumeEnd() - this.spell.getLoopVolumeStart()) * (float) this.tick / (float) this.spell.getTickLimit();
			this.volume = MathHelper.clamp(this.spell.getLoopVolumeStart() + f1, 0.001F, 1.0F);
			float f2 = (this.spell.getLoopPitchEnd() - this.spell.getLoopPitchStart()) * (float) this.tick / (float) this.spell.getTickLimit();
			this.pitch = this.spell.getLoopPitchStart() + f2;
		}
	}

	private boolean isCastingSpell() {
		ItemStack wand = this.caster.getActiveItemStack();
		if (!(wand.getItem() instanceof ItemWand)) {
			return false;
		}
		if (this.spell != WandHelper.getCurrentSpell(wand)) {
			return false;
		}
		boolean onCooldown = WandHelper.getCurrentCooldown(wand) > 0;
		if (!onCooldown) {
			return true;
		}
		return this.caster instanceof EntityPlayer ? ((EntityPlayer) this.caster).isCreative() : false;
	}

}
