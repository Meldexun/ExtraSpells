package meldexun.ExtraSpells.potion;

import meldexun.ExtraSpells.ExtraSpells;
import meldexun.ExtraSpells.init.ModPotions;
import net.minecraft.client.Minecraft;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@EventBusSubscriber
public class PotionLeeching extends Potion {

	private static final ResourceLocation ICON = new ResourceLocation(ExtraSpells.MOD_ID, "textures/potion/potion_icons.png");

	public PotionLeeching(boolean isBadEffectIn, int liquidColorIn) {
		super(isBadEffectIn, liquidColorIn);
		this.setPotionName("potion." + ExtraSpells.MOD_ID + ":leeching");
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void renderInventoryEffect(int x, int y, PotionEffect effect, Minecraft mc) {
		mc.renderEngine.bindTexture(ICON);
		mc.currentScreen.drawTexturedModalRect(x + 6, y + 7, 0, 0, 18, 18);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void renderHUDEffect(int x, int y, PotionEffect effect, Minecraft mc, float alpha) {
		mc.renderEngine.bindTexture(ICON);
		mc.ingameGUI.drawTexturedModalRect(x + 3f, y + 3f, 0, 0, 18, 18);
	}

	@Override
	public boolean isReady(int duration, int amplifier) {
		return false;
	}

	/**
	 * Called when Player attacks Entity. Used to heal Player on attack.
	 * 
	 * @param event
	 */
	@SubscribeEvent
	public static void attackEntity(AttackEntityEvent event) {
		if (event.getEntityPlayer().isPotionActive(ModPotions.LEECHING) && event.getEntityPlayer().getHealth() < event.getEntityPlayer().getMaxHealth()) {
			event.getEntityPlayer().heal(1 + event.getEntityPlayer().getActivePotionEffect(ModPotions.LEECHING).getAmplifier());
		}
	}
}
