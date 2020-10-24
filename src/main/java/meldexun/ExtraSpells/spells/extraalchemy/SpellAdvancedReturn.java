package meldexun.ExtraSpells.spells.extraalchemy;

import electroblob.wizardry.spell.SpellBuff;
import electroblob.wizardry.util.SpellModifiers;
import meldexun.ExtraSpells.ExtraSpells;
import meldexun.ExtraSpells.integration.ExtraAlchemy;
import meldexun.ExtraSpells.potion.PotionPlaceholder;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class SpellAdvancedReturn extends SpellBuff {

	public SpellAdvancedReturn() {
		super(ExtraSpells.MOD_ID, "advanced_return", 0.5F, 0.5F, 0.5F, () -> new PotionPlaceholder("effect.return", true));
		if (ExtraSpells.extraAlchemyLoaded) {
			this.effects[0] = () -> ExtraAlchemy.getPotionReturn();
		}
	}

	@Override
	public boolean cast(World world, EntityPlayer caster, EnumHand hand, int ticksInUse, SpellModifiers modifiers) {
		if (EntityPlayer.getBedSpawnLocation(world, caster.getBedLocation(), false) != null) {
			return super.cast(world, caster, hand, ticksInUse, modifiers);
		}
		return false;
	}

}
