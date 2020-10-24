package meldexun.ExtraSpells.proxy;

import meldexun.ExtraSpells.client.audio.MovingSoundSpell;
import meldexun.ExtraSpells.spells.AbstractSpellChargable;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityLivingBase;

public class ClientProxy implements IProxy {

	@Override
	public void preInit() {

	}

	@Override
	public void init() {

	}

	@Override
	public void postInit() {

	}

	@Override
	public void startLoopSound(AbstractSpellChargable spell, EntityLivingBase caster) {
		Minecraft.getMinecraft().getSoundHandler().playSound(new MovingSoundSpell(spell.getSounds()[1], caster, spell));
	}

}
