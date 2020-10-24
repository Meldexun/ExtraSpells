package meldexun.ExtraSpells.potion;

import meldexun.ExtraSpells.ExtraSpells;
import meldexun.ExtraSpells.init.ModPotions;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class PotionVampirism extends Potion {

	private static final ResourceLocation ICON = new ResourceLocation(ExtraSpells.MOD_ID, "textures/potion/potion_icons.png");

	public PotionVampirism(boolean isBadEffectIn, int liquidColorIn) {
		super(isBadEffectIn, liquidColorIn);
		this.setPotionName("potion." + ExtraSpells.MOD_ID + ":vampirism");
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void renderInventoryEffect(int x, int y, PotionEffect effect, Minecraft mc) {
		mc.renderEngine.bindTexture(ICON);
		mc.currentScreen.drawTexturedModalRect(x + 6, y + 7, 18, 0, 18, 18);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void renderHUDEffect(int x, int y, PotionEffect effect, Minecraft mc, float alpha) {
		mc.renderEngine.bindTexture(ICON);
		mc.ingameGUI.drawTexturedModalRect(x + 3f, y + 3f, 18, 0, 18, 18);
	}

	@Override
	public void performEffect(EntityLivingBase entityLivingBaseIn, int amplifier) {
		if (entityLivingBaseIn.world.getWorldTime() >= 12517 && entityLivingBaseIn.world.getWorldTime() < 23450) {
			entityLivingBaseIn.addPotionEffect(new PotionEffect(ModPotions.LEECHING, 40, 1));
			entityLivingBaseIn.addPotionEffect(new PotionEffect(MobEffects.SPEED, 40, 1));
		} else if (entityLivingBaseIn.world.canSeeSky(entityLivingBaseIn.getPosition())) {
			entityLivingBaseIn.setFire(2);
		}
	}

	@Override
	public boolean isReady(int duration, int amplifier) {
		return true;
	}
}
