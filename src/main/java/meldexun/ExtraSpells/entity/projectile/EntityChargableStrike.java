package meldexun.ExtraSpells.entity.projectile;

import electroblob.wizardry.entity.projectile.EntityMagicArrow;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class EntityChargableStrike extends EntityMagicArrow {

	public EntityChargableStrike(World world) {
		super(world);
	}

	public EntityChargableStrike(EntityLivingBase caster, float damage) {
		super(caster.world);
		this.damageMultiplier = damage;
	}

	@Override
	public double getDamage() {
		return 4.0D;
	}

	@Override
	public void onEntityHit(EntityLivingBase entityHit) {
		entityHit.setFire(3);
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

	public static void launch(World world, EntityLivingBase caster, double speed, float damage) {
		if (!world.isRemote) {
			EntityChargableStrike projectile = new EntityChargableStrike(caster, damage);

			projectile.rotationYaw = caster.rotationYaw;
			projectile.rotationPitch = caster.rotationPitch;
			projectile.posX = caster.posX + 0.4D * caster.getLookVec().x;
			projectile.posY = caster.posY + 0.4D * caster.getLookVec().y + caster.getEyeHeight();
			projectile.posZ = caster.posZ + 0.4D * caster.getLookVec().z;
			projectile.motionX = speed * caster.getLookVec().x;
			projectile.motionY = speed * caster.getLookVec().y;
			projectile.motionZ = speed * caster.getLookVec().z;

			world.spawnEntity(projectile);
		}
	}

}
