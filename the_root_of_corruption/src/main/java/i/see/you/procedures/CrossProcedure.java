package i.see.you.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.component.ResolvableProfile;
import com.mojang.authlib.GameProfile;
import java.util.UUID;
import java.util.Comparator;
import com.mojang.authlib.GameProfile;

public class CrossProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate) {
		ItemStack head = ItemStack.EMPTY;
		Entity player = null;
		String playername = "";
		world.setBlock(BlockPos.containing(x, y, z), blockstate, 3);
		world.setBlock(BlockPos.containing(x, y + 1, z), blockstate, 3);
		world.setBlock(BlockPos.containing(x, y + 2, z), blockstate, 3);
		player = (Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 1000, 1000, 1000), e -> true).stream().sorted(new Object() {
			Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
				return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
			}
		}.compareDistOf(x, y, z)).findFirst().orElse(null);
		if (!(player == null) && Mth.nextInt(RandomSource.create(), 0, 50) == 0) {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.generic.death")), SoundSource.PLAYERS, 100, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.generic.death")), SoundSource.PLAYERS, 100, 1, false);
				}
			}
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("ambient.cave")), SoundSource.VOICE, 100, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("ambient.cave")), SoundSource.VOICE, 100, 1, false);
				}
			}
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.bell.use")), SoundSource.VOICE, 100, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.bell.use")), SoundSource.VOICE, 100, 1, false);
				}
			}
			playername = player.getDisplayName().getString();
			if (IsOnlineProcedure.execute(player)) {
				head = new ItemStack(Blocks.PLAYER_HEAD).copy();
				GameProfile profile = new GameProfile(UUID.fromString(player.getStringUUID()), playername);
				ResolvableProfile resolvableProfile = new ResolvableProfile(profile);
				head.set(DataComponents.PROFILE, resolvableProfile);
			}
		}
		if (Mth.nextInt(RandomSource.create(), 1, 2) == 1) {
			world.setBlock(BlockPos.containing(x + -1, y + 2, z), blockstate, 3);
			world.setBlock(BlockPos.containing(x + 1, y + 2, z), blockstate, 3);
			world.setBlock(BlockPos.containing(x, y + 2, z + 1), (head.getItem() instanceof BlockItem _bi ? _bi.getBlock().defaultBlockState() : Blocks.AIR.defaultBlockState()), 3);
		} else {
			world.setBlock(BlockPos.containing(x, y + 2, z + -1), blockstate, 3);
			world.setBlock(BlockPos.containing(x, y + 2, z + 1), blockstate, 3);
			world.setBlock(BlockPos.containing(x + 1, y + 2, z), (head.getItem() instanceof BlockItem _bi ? _bi.getBlock().defaultBlockState() : Blocks.AIR.defaultBlockState()), 3);
		}
		world.setBlock(BlockPos.containing(x, y + 3, z), blockstate, 3);
	}
}
