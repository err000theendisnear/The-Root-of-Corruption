
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package i.see.you.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.common.extensions.IMenuTypeExtension;

import net.minecraft.world.inventory.MenuType;
import net.minecraft.core.registries.Registries;

import i.see.you.world.inventory.BehindyouMenu;
import i.see.you.TheRootOfCorruptionMod;

public class TheRootOfCorruptionModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(Registries.MENU, TheRootOfCorruptionMod.MODID);
	public static final DeferredHolder<MenuType<?>, MenuType<BehindyouMenu>> BEHINDYOU = REGISTRY.register("behindyou", () -> IMenuTypeExtension.create(BehindyouMenu::new));
}
