package meldexun.ExtraSpells.client;

import electroblob.wizardry.client.renderer.entity.RenderMagicArrow;
import meldexun.ExtraSpells.ExtraSpells;
import meldexun.ExtraSpells.entity.projectile.EntityArmorPiercingMissile;
import meldexun.ExtraSpells.entity.projectile.EntityChargableStrike;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;

@EventBusSubscriber(modid = ExtraSpells.MOD_ID, value = Side.CLIENT)
public class EntityModels {

	@SubscribeEvent
	public static void register(ModelRegistryEvent event) {
		RenderingRegistry.registerEntityRenderingHandler(EntityArmorPiercingMissile.class, manager -> new RenderMagicArrow(manager, createTextureLocation("armor_piercing_missile"), false, 8.0, 4.0, 16, 5, false));
		RenderingRegistry.registerEntityRenderingHandler(EntityChargableStrike.class, manager -> new RenderMagicArrow(manager, createTextureLocation("chargable_strike_missile"), false, 8.0, 4.0, 16, 5, false));
	}

	private static ResourceLocation createTextureLocation(String name) {
		return new ResourceLocation(ExtraSpells.MOD_ID, "textures/entity/" + name + ".png");
	}

}
