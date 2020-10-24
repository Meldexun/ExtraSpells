package meldexun.ExtraSpells;

import electroblob.wizardry.spell.Spell;
import meldexun.ExtraSpells.init.ModSpells;
import meldexun.ExtraSpells.proxy.IProxy;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = ExtraSpells.MOD_ID, name = ExtraSpells.NAME, version = ExtraSpells.VERSION, acceptedMinecraftVersions = ExtraSpells.ACCEPTED_VERSIONS, dependencies = ExtraSpells.DEPENDENCIES)
public class ExtraSpells {

	public static final String MOD_ID = "extra_spells";
	public static final String NAME = "Meldexun's Extra Spells";
	public static final String VERSION = "1.2.0";
	public static final String ACCEPTED_VERSIONS = "[1.12.2]";
	public static final String DEPENDENCIES = "required-after:ebwizardry@[4.3,); after:extraalchemy; after:potioncore";

	public static final String CLIENT_PROXY_CLASS = "meldexun.ExtraSpells.proxy.ClientProxy";
	public static final String SERVER_PROXY_CLASS = "meldexun.ExtraSpells.proxy.ServerProxy";

	@Instance(ExtraSpells.MOD_ID)
	public static ExtraSpells instance;

	@SidedProxy(clientSide = ExtraSpells.CLIENT_PROXY_CLASS, serverSide = ExtraSpells.SERVER_PROXY_CLASS)
	public static IProxy proxy;

	public static boolean potionCoreLoaded = false;
	public static boolean extraAlchemyLoaded = false;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		proxy.preInit();

		potionCoreLoaded = Loader.isModLoaded("potioncore");
		extraAlchemyLoaded = Loader.isModLoaded("extraalchemy");
	}

	@EventHandler
	public void Init(FMLInitializationEvent event) {
		proxy.init();

	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		proxy.postInit();

		disableSpells();
	}

	public static void disableSpells() {
		if (!potionCoreLoaded) {
			for (Spell spell : ModSpells.SpellRegistrationHandler.POTION_CORE_SPELLS) {
				spell.setEnabled(false);
			}
		}
		if (!extraAlchemyLoaded) {
			for (Spell spell : ModSpells.SpellRegistrationHandler.EXTRA_ALCHEMY_SPELLS) {
				spell.setEnabled(false);
			}
		}
	}

}
