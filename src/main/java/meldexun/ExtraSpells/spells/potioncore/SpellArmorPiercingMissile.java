package meldexun.ExtraSpells.spells.potioncore;

import electroblob.wizardry.spell.SpellArrow;
import meldexun.ExtraSpells.ExtraSpells;
import meldexun.ExtraSpells.entity.projectile.EntityArmorPiercingMissile;

public class SpellArmorPiercingMissile extends SpellArrow<EntityArmorPiercingMissile> {

	public SpellArmorPiercingMissile() {
		super(ExtraSpells.MOD_ID, "armor_piercing_missile", EntityArmorPiercingMissile::new);
	}

}
