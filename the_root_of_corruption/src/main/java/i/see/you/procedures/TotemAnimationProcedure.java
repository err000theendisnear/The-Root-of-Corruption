package i.see.you.procedures;

import net.neoforged.neoforge.network.PacketDistributor;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.client.Minecraft;

import i.see.you.network.TotemPacket;

public class TotemAnimationProcedure {
	public static void execute(LevelAccessor world, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		try {
			if (world.isClientSide())
				Minecraft.getInstance().gameRenderer.displayItemActivation(itemstack);
			if (entity instanceof ServerPlayer) {
				ServerPlayer player = (ServerPlayer) entity;
				TotemPacket packet = new TotemPacket(itemstack);
				PacketDistributor.sendToPlayer(player, packet);
			}
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
}
