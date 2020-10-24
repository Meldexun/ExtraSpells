package meldexun.ExtraSpells.potion;

import meldexun.ExtraSpells.ExtraSpells;
import meldexun.ExtraSpells.init.ModPotions;
import net.minecraft.client.Minecraft;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.entity.living.LivingHealEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@EventBusSubscriber
public class PotionDecaying extends Potion {

	private static final ResourceLocation ICON = new ResourceLocation(ExtraSpells.MOD_ID, "textures/potion/potion_icons.png");

	public PotionDecaying(boolean isBadEffectIn, int liquidColorIn) {
		super(isBadEffectIn, liquidColorIn);
		this.setPotionName("potion." + ExtraSpells.MOD_ID + ":decaying");
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void renderInventoryEffect(int x, int y, PotionEffect effect, Minecraft mc) {
		mc.renderEngine.bindTexture(ICON);
		mc.currentScreen.drawTexturedModalRect(x + 6, y + 7, 36, 0, 18, 18);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void renderHUDEffect(int x, int y, PotionEffect effect, Minecraft mc, float alpha) {
		mc.renderEngine.bindTexture(ICON);
		mc.ingameGUI.drawTexturedModalRect(x + 3f, y + 3f, 36, 0, 18, 18);
	}

	@Override
	public boolean isReady(int duration, int amplifier) {
		return false;
	}

	/**
	 * Level 1: Healing is disabled Level 2: Healing is disabled and Entity takes
	 * damage equal to the healed amount
	 * 
	 * @param event
	 */
	// @SubscribeEvent
	public static void healEntity(LivingHealEvent event) {
		if (event.getEntityLiving().isPotionActive(ModPotions.DECAYING)) {
			if (event.getEntityLiving().getActivePotionEffect(ModPotions.DECAYING).getAmplifier() > 0) {
				event.getEntityLiving().attackEntityFrom(DamageSource.MAGIC, event.getAmount());
			}
			event.setCanceled(true);
		}
	}

}
