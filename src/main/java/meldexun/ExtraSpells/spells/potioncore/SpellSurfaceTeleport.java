package meldexun.ExtraSpells.spells.potioncore;

import electroblob.wizardry.spell.SpellBuff;
import electroblob.wizardry.util.SpellModifiers;
import meldexun.ExtraSpells.ExtraSpells;
import meldexun.ExtraSpells.integration.PotionCore;
import meldexun.ExtraSpells.potion.PotionPlaceholder;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class SpellSurfaceTeleport extends SpellBuff {

	public SpellSurfaceTeleport() {
		super(ExtraSpells.MOD_ID, "surface_teleport", 0.5F, 0.5F, 0.5F, () -> new PotionPlaceholder("teleport_surface", true));
		if (ExtraSpells.potionCoreLoaded) {
			this.effects[0] = () -> PotionCore.getPotionTeleportSurface();
		}
	}

	@Override
	public boolean cast(World world, EntityPlayer caster, EnumHand hand, int ticksInUse, SpellModifiers modifiers) {
		if (!world.canBlockSeeSky(new BlockPos(caster.posX, caster.posY, caster.posZ))) {
			return super.cast(world, caster, hand, ticksInUse, modifiers);
		}
		return false;
	}

}
