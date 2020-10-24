package meldexun.ExtraSpells.init;

import meldexun.ExtraSpells.ExtraSpells;
import meldexun.ExtraSpells.entity.projectile.EntityArmorPiercingMissile;
import meldexun.ExtraSpells.entity.projectile.EntityChargableStrike;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.fml.common.registry.EntityEntryBuilder;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;

@ObjectHolder(ExtraSpells.MOD_ID)
public class ModEntities {

	public static final EntityEntry CHARGABLE_STRIKE_MISSILE = null;
	public static final EntityEntry ARMOR_PIERCING_MISSILE = null;

	@EventBusSubscriber(modid = ExtraSpells.MOD_ID)
	public static class EntityRegistrationHandler {

		private static int entityID = 0;

		@SubscribeEvent
		public static void registerEntities(RegistryEvent.Register<EntityEntry> event) {
			final EntityEntry[] entityEntries = {
					createEntityEntryWithoutEgg(EntityChargableStrike.class, "chargable_strike_missile", 64, 1, true),
					createEntityEntryWithoutEgg(EntityArmorPiercingMissile.class, "armor_piercing_missile", 64, 1, true) };

			event.getRegistry().registerAll(entityEntries);
		}

		private static EntityEntry createEntityEntry(Class<? extends Entity> entityClass, String name, int range, int updateFrequency, boolean sendVelocityUpdates, int eggColor1, int eggColor2) {
			return EntityEntryBuilder.create().entity(entityClass).id(new ResourceLocation(ExtraSpells.MOD_ID, name), entityID++).name(name).tracker(range, updateFrequency, sendVelocityUpdates).egg(eggColor1, eggColor2).build();
		}

		private static EntityEntry createEntityEntryWithoutEgg(Class<? extends Entity> entityClass, String name, int range, int updateFrequency, boolean sendVelocityUpdates) {
			return EntityEntryBuilder.create().entity(entityClass).id(new ResourceLocation(ExtraSpells.MOD_ID, name), entityID++).name(name).tracker(range, updateFrequency, sendVelocityUpdates).build();
		}

	}

}
