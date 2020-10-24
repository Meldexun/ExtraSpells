package meldexun.ExtraSpells.init;

import java.util.ArrayList;
import java.util.List;
import electroblob.wizardry.spell.Spell;
import meldexun.ExtraSpells.ExtraSpells;
import meldexun.ExtraSpells.spells.custom.SpellChargableStrike;
import meldexun.ExtraSpells.spells.custom.SpellScaleBless;
import meldexun.ExtraSpells.spells.custom.SpellSuperJump;
import meldexun.ExtraSpells.spells.custom.SpellThiefBless;
import meldexun.ExtraSpells.spells.custom.SpellTimeManipulator;
import meldexun.ExtraSpells.spells.custom.SpellTribalBless;
import meldexun.ExtraSpells.spells.custom.SpellVampirism;
import meldexun.ExtraSpells.spells.extraalchemy.SpellAdvancedReturn;
import meldexun.ExtraSpells.spells.extraalchemy.SpellPacifism;
import meldexun.ExtraSpells.spells.extraalchemy.SpellPhotosynthesis;
import meldexun.ExtraSpells.spells.extraalchemy.SpellTimeTravel;
import meldexun.ExtraSpells.spells.potioncore.SpellArmorPiercingMissile;
import meldexun.ExtraSpells.spells.potioncore.SpellHuntersRevenge;
import meldexun.ExtraSpells.spells.potioncore.SpellMagicShield;
import meldexun.ExtraSpells.spells.potioncore.SpellMagicalOffence;
import meldexun.ExtraSpells.spells.potioncore.SpellReturn;
import meldexun.ExtraSpells.spells.potioncore.SpellSolidCore;
import meldexun.ExtraSpells.spells.potioncore.SpellSurfaceTeleport;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
import net.minecraftforge.registries.IForgeRegistry;

@ObjectHolder(ExtraSpells.MOD_ID)
public class ModSpells {

	// Custom
	public static final Spell TIME_MANIPULATOR = null;
	public static final Spell VAMPITISM = null;
	public static final Spell SUPER_JUMP = null;
	public static final Spell CHARGEABLE_STRIKE = null;

	// HexxitGear
	public static final Spell TRIBAL_BLESS = null;
	public static final Spell SCALE_BLESS = null;
	public static final Spell THIEF_BLESS = null;

	// PotionCore
	public static final Spell RETURN = null;
	public static final Spell ARMOR_PIERCING_MISSILE = null;
	public static final Spell SURFACE_TELEPORT = null;
	public static final Spell MAGICAL_OFFENCE = null;
	public static final Spell HUNTERS_REVENGE = null;
	public static final Spell SOLID_CORE = null;
	public static final Spell MAGIC_SHIELD = null;

	// ExtraAlchemy
	public static final Spell ADVANCED_RETURN = null;
	public static final Spell TIME_TRAVEL = null;
	public static final Spell PACIFISM = null;
	public static final Spell PHOTOSYNTHESIS = null;

	@EventBusSubscriber(modid = ExtraSpells.MOD_ID)
	public static class SpellRegistrationHandler {

		public static final List<Spell> CUSTOM_SPELLS = new ArrayList<Spell>();
		public static final List<Spell> POTION_CORE_SPELLS = new ArrayList<Spell>();
		public static final List<Spell> EXTRA_ALCHEMY_SPELLS = new ArrayList<Spell>();

		@SubscribeEvent
		public static void registerSpells(RegistryEvent.Register<Spell> event) {
			IForgeRegistry<Spell> registry = event.getRegistry();

			final Spell[] customSpells = { new SpellTimeManipulator(), new SpellVampirism(), new SpellSuperJump(), new SpellChargableStrike(), new SpellTribalBless(), new SpellScaleBless(), new SpellThiefBless() };

			for (Spell spell : customSpells) {
				registry.register(spell);
				CUSTOM_SPELLS.add(spell);
			}

			final Spell[] potionCoreSpells = { new SpellReturn(), new SpellArmorPiercingMissile(), new SpellSurfaceTeleport(), new SpellMagicalOffence(), new SpellHuntersRevenge(), new SpellSolidCore(), new SpellMagicShield() };

			for (Spell spell : potionCoreSpells) {
				registry.register(spell);
				POTION_CORE_SPELLS.add(spell);
			}

			final Spell[] extraAlchemySpells = { new SpellAdvancedReturn(), new SpellTimeTravel(), new SpellPacifism(), new SpellPhotosynthesis(), };

			for (Spell spell : extraAlchemySpells) {
				registry.register(spell);
				EXTRA_ALCHEMY_SPELLS.add(spell);
			}
		}

	}

}
