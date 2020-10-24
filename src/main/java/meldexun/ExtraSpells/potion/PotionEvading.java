package meldexun.ExtraSpells.potion;

import meldexun.ExtraSpells.ExtraSpells;
import meldexun.ExtraSpells.init.ModPotions;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.SoundEvents;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@EventBusSubscriber
public class PotionEvading extends Potion {

	private static final ResourceLocation ICON = new ResourceLocation(ExtraSpells.MOD_ID, "textures/potion/potion_icons.png");

	public PotionEvading(boolean isBadEffectIn, int liquidColorIn) {
		super(isBadEffectIn, liquidColorIn);
		this.setPotionName("potion." + ExtraSpells.MOD_ID + ":evading");
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void renderInventoryEffect(int x, int y, PotionEffect effect, Minecraft mc) {
		mc.renderEngine.bindTexture(ICON);
		mc.currentScreen.drawTexturedModalRect(x + 6, y + 7, 72, 0, 18, 18);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void renderHUDEffect(int x, int y, PotionEffect effect, Minecraft mc, float alpha) {
		mc.renderEngine.bindTexture(ICON);
		mc.ingameGUI.drawTexturedModalRect(x + 3f, y + 3f, 72, 0, 18, 18);
	}

	@Override
	public boolean isReady(int duration, int amplifier) {
		return false;
	}

	// @SubscribeEvent
	public static void dodgeAttack(LivingHurtEvent event) {
		if (event.getEntityLiving().isPotionActive(ModPotions.EVADING)) {
			if (event.getSource().getDamageType() == "player" || event.getSource().getDamageType() == "mob") {
				EntityLivingBase entity = event.getEntityLiving();

				if (event.getEntity().world.rand.nextInt(100) < 10 * (1 + entity.getActivePotionEffect(ModPotions.EVADING).getAmplifier())) {
					if (!entity.world.isRemote) {
						event.getEntity().world.playSound(null, entity.posX, entity.posY, entity.posZ, SoundEvents.BLOCK_CLOTH_FALL, SoundCategory.PLAYERS, 1.0F, 1.0F);
					}
					event.setCanceled(true);
				}
			}
		}
	}

}
