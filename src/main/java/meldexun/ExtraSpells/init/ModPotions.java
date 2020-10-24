package meldexun.ExtraSpells.init;

import meldexun.ExtraSpells.ExtraSpells;
import meldexun.ExtraSpells.potion.PotionLeeching;
import meldexun.ExtraSpells.potion.PotionVampirism;
import net.minecraft.potion.Potion;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;

@ObjectHolder(ExtraSpells.MOD_ID)
public class ModPotions {

	public static final Potion LEECHING = null;
	public static final Potion VAMPIRISM = null;
	public static final Potion DECAYING = null;
	public static final Potion DISEASED = null;
	public static final Potion EVADING = null;

	@EventBusSubscriber(modid = ExtraSpells.MOD_ID)
	public static class PotionRegistrationHandler {

		@SubscribeEvent
		public static void register(RegistryEvent.Register<Potion> event) {
			final Potion[] potions = { setPotionName(new PotionLeeching(false, 0), "leeching"), setPotionName(new PotionVampirism(false, 0), "vampirism") };

			event.getRegistry().registerAll(potions);
		}

		private static Potion setPotionName(Potion potion, String name) {
			return potion.setRegistryName(ExtraSpells.MOD_ID, name).setPotionName("potion." + potion.getRegistryName().toString());
		}

	}

}
