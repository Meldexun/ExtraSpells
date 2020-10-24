package meldexun.ExtraSpells.potion;

import meldexun.ExtraSpells.ExtraSpells;
import net.minecraft.potion.Potion;

public class PotionPlaceholder extends Potion {

	private boolean instant;

	public PotionPlaceholder(String name) {
		this(name, false);
	}

	public PotionPlaceholder(String name, boolean instant) {
		super(false, 0);
		this.setPotionName(name);
		this.setRegistryName(ExtraSpells.MOD_ID, name);
		this.instant = instant;
	}

	@Override
	public boolean isInstant() {
		return this.instant;
	}

}
