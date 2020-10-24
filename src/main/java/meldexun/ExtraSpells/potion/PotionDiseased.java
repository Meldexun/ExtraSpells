package meldexun.ExtraSpells.potion;

import meldexun.ExtraSpells.ExtraSpells;
import meldexun.ExtraSpells.init.ModPotions;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityLiving;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@EventBusSubscriber
public class PotionDiseased extends Potion {

	private static final ResourceLocation ICON = new ResourceLocation(ExtraSpells.MOD_ID, "textures/potion/potion_icons.png");

	public PotionDiseased(boolean isBadEffectIn, int liquidColorIn) {
		super(isBadEffectIn, liquidColorIn);
		this.setPotionName("potion." + ExtraSpells.MOD_ID + ":diseased");
		// registerPotionAttributeModifier(SharedMonsterAttributes.MAX_HEALTH,
		// "5D6F0BA2-1186-46AC-B896-C61C5CEE99CC", -1.0D, 0);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void renderInventoryEffect(int x, int y, PotionEffect effect, Minecraft mc) {
		mc.renderEngine.bindTexture(ICON);
		mc.currentScreen.drawTexturedModalRect(x + 6, y + 7, 54, 0, 18, 18);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void renderHUDEffect(int x, int y, PotionEffect effect, Minecraft mc, float alpha) {
		mc.renderEngine.bindTexture(ICON);
		mc.ingameGUI.drawTexturedModalRect(x + 3f, y + 3f, 54, 0, 18, 18);
	}

	@Override
	public boolean isReady(int duration, int amplifier) {
		return false;
	}

	/**
	 * Called when Entity is attacked Checks if attacker is diseased and reduces
	 * damage if so by 15% per level.
	 * 
	 * @param event
	 */
	// @SubscribeEvent
	public static void attackEntity(LivingHurtEvent event) {
		if (event.getSource().getTrueSource() instanceof EntityLiving && ((EntityLiving) event.getSource().getTrueSource()).isPotionActive(ModPotions.DISEASED)) {
			float i = 1.0F - (0.15F * (1.0F + ((EntityLiving) event.getSource().getTrueSource()).getActivePotionEffect(ModPotions.DISEASED).getAmplifier()));
			event.setAmount(event.getAmount() * i);
		}
	}
}
