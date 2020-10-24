package meldexun.ExtraSpells.spells;

import java.util.Random;

import electroblob.wizardry.item.ItemWand;
import electroblob.wizardry.registry.WizardrySounds;
import electroblob.wizardry.spell.Spell;
import electroblob.wizardry.util.ParticleBuilder;
import electroblob.wizardry.util.SpellModifiers;
import electroblob.wizardry.util.WandHelper;
import meldexun.ExtraSpells.ExtraSpells;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public abstract class AbstractSpellChargable extends Spell {

	protected int tickLimit;
	protected int tickRate;
	protected float loopVolumeStart = 0.0F;
	protected float loopVolumeEnd = 1.0F;
	protected float loopPitchStart = 0.5F;
	protected float loopPitchEnd = 1.0F;
	protected int particleCount = 2;
	protected float r = 1.0F;
	protected float g = 1.0F;
	protected float b = 1.0F;
	protected final Random rand = new Random();

	public AbstractSpellChargable(String modID, String name, EnumAction action, int tickLimit, int tickRate) {
		super(modID, name, action, true);
		this.tickLimit = tickLimit;
		this.tickRate = tickRate;
	}

	@Override
	protected SoundEvent[] createSounds() {
		return this.createContinuousSpellSounds();
	}

	@Override
	public boolean cast(World world, EntityPlayer caster, EnumHand hand, int ticksInUse, SpellModifiers modifiers) {
		if (ticksInUse == 0) {
			this.startTick(world, caster, hand, ticksInUse, modifiers);
			if (world.isRemote) {
				ExtraSpells.proxy.startLoopSound(this, caster);
			}
		} else if (ticksInUse >= this.tickLimit) {
			caster.stopActiveHand();
		}
		if (ticksInUse % this.tickRate == 0) {
			this.tick(world, caster, hand, ticksInUse, modifiers);
			if (world.isRemote) {
				this.spawnParticles(world, caster, modifiers);
			}
			return true;
		}
		return false;
	}

	@Override
	public void finishCasting(World world, EntityLivingBase caster, double x, double y, double z, EnumFacing direction, int duration, SpellModifiers modifiers) {
		if (duration >= this.tickLimit) {
			this.finishTick(world, caster, caster.getActiveHand(), duration, modifiers);
			world.playSound(null, caster.posX, caster.posY + (double) caster.getEyeHeight(), caster.posZ, this.sounds[2], WizardrySounds.SPELLS, this.volume, this.getRandomPitch());

		}
	}

	public void startTick(World world, EntityLivingBase caster, EnumHand hand, int ticksInUse, SpellModifiers modifiers) {

	}

	public void tick(World world, EntityLivingBase caster, EnumHand hand, int ticksInUse, SpellModifiers modifiers) {

	}

	public void finishTick(World world, EntityLivingBase caster, EnumHand hand, int ticksInUse, SpellModifiers modifiers) {

	}

	protected void spawnParticles(World world, EntityLivingBase caster, SpellModifiers modifiers) {
		for (int i = 0; i < this.particleCount; i++) {
			Vec3d posVec = this.getWandVec(caster);
			Vec3d posVecOffset = new Vec3d(this.rand.nextDouble() - 0.5D, this.rand.nextDouble() - 0.5D, this.rand.nextDouble() - 0.5D);
			Vec3d velVec = new Vec3d(posVecOffset.x * 0.025D, posVecOffset.y * 0.025D, posVecOffset.z * 0.025D);

			ParticleBuilder.create(ParticleBuilder.Type.SPARKLE).pos(posVec.subtract(posVecOffset)).vel(velVec).clr(this.r, this.g, this.b).spawn(world);
		}
	}

	protected Vec3d getWandVec(EntityLivingBase caster) {
		Vec3d lookVec = caster.getLookVec();
		double yaw = (double) caster.rotationYaw + 90.0D;
		double sin = Math.sin(Math.toRadians(yaw));
		double cos = Math.cos(Math.toRadians(yaw));
		return new Vec3d(caster.posX + lookVec.x - 0.25D * sin, caster.posY + 0.5F * caster.height + lookVec.y, caster.posZ + lookVec.z + 0.25D * cos);
	}

	public int getTickLimit() {
		return this.tickLimit;
	}

	public int getTickRate() {
		return this.tickRate;
	}

	public float getLoopVolumeStart() {
		return this.loopVolumeStart;
	}

	public float getLoopVolumeEnd() {
		return this.loopVolumeEnd;
	}

	public float getLoopPitchStart() {
		return this.loopPitchStart;
	}

	public float getLoopPitchEnd() {
		return this.loopPitchEnd;
	}

	public float getRandomPitch() {
		return this.pitch - this.pitchVariation + 2.0F * (float) Math.random() * this.pitchVariation;
	}

	@EventBusSubscriber
	private static class Test {
		@SubscribeEvent
		public static void test(LivingEntityUseItemEvent.Stop event) {
			if (!event.getEntity().world.isRemote) {
				ItemStack stack = event.getItem();
				if (stack.getItem() instanceof ItemWand) {
					Spell spell = WandHelper.getCurrentSpell(stack);
					if (spell instanceof AbstractSpellChargable) {
						if (event.getDuration() < ((AbstractSpellChargable) spell).getTickLimit()) {
							WandHelper.setCurrentCooldown(stack, (int) (spell.getCooldown() * 0.5D));
						}
					}
				}
			}
		}
	}

}
