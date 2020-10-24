package meldexun.ExtraSpells.entity.projectile;

import electroblob.wizardry.entity.projectile.EntityMagicArrow;
import electroblob.wizardry.util.MagicDamage;
import electroblob.wizardry.util.MagicDamage.DamageType;
import meldexun.ExtraSpells.ExtraSpells;
import meldexun.ExtraSpells.integration.PotionCore;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class EntityArmorPiercingMissile extends EntityMagicArrow {

	public EntityArmorPiercingMissile(World world) {
		super(world);
	}

	public EntityArmorPiercingMissile(EntityLivingBase caster, float damage) {
		super(caster.world);
		this.setCaster(caster);
		this.damageMultiplier = damage;
	}

	@Override
	public double getDamage() {
		return 3.0D;
	}

	@Override
	public void onEntityHit(EntityLivingBase entityHit) {
		if (!MagicDamage.isEntityImmune(DamageType.MAGIC, entityHit)) {
			if (ExtraSpells.potionCoreLoaded) {
				entityHit.addPotionEffect(new PotionEffect(PotionCore.getPotion("broken_armor"), 300, 0));
			}
		}
	}

	@Override
	public boolean doGravity() {
		return false;
	}

	@Override
	public boolean doDeceleration() {
		return false;
	}

	@Override
	public int getLifetime() {
		return 40;
	}

	@Override
	public void shoot(double x, double y, double z, float velocity, float inaccuracy) {

	}

	@Override
	protected void entityInit() {

	}

	@Override
	public void readEntityFromNBT(NBTTagCompound compound) {

	}

	@Override
	public void writeEntityToNBT(NBTTagCompound compound) {

	}

}
