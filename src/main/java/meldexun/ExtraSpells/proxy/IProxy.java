package meldexun.ExtraSpells.proxy;

import meldexun.ExtraSpells.spells.AbstractSpellChargable;
import net.minecraft.entity.EntityLivingBase;

public interface IProxy {

	public void preInit();

	public void init();

	public void postInit();

	public void startLoopSound(AbstractSpellChargable spell, EntityLivingBase caster);

}
