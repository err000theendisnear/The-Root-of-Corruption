package i.see.you;

import net.neoforged.bus.api.Event;
import net.neoforged.bus.api.ICancellableEvent;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import i.see.you.network.TheRootOfCorruptionModVariables;
import javax.annotation.Nullable;
import net.minecraft.world.entity.player.Player;

public class TriggerRandomEvent extends Event implements ICancellableEvent {
	private final Entity Player;
	private final String EventName;
	private final double NextEventTime;
	public TriggerRandomEvent(Entity player, String eventname, double nexteventtime) {
		this.Player = player;
		this.EventName = eventname;
		this.NextEventTime = nexteventtime;
	}
	public Entity getPlayer() {
        return this.Player;
    }
    public String getEventName() {
        return this.EventName;
    }
    public double getNextEventTime() {
        return this.NextEventTime;
    }
    public void setNextEventTime(double time, @Nullable Level level) {
    	if (level == null) {
    		throw new NullPointerException("Level is null");
    	}
    	if (level instanceof LevelAccessor world) {
    		TheRootOfCorruptionModVariables.MapVariables.get(world).event_count = time;
			TheRootOfCorruptionModVariables.MapVariables.get(world).syncData(world);
    	} else {
    		throw new ClassCastException("Level cannot cast to LevelAccessor");
    	}
    }
    public void setNextEventTime(double time, @Nullable LevelAccessor world) {
    	if (world == null) {
    		throw new NullPointerException("LevelAccessor is null");
    	}
    	TheRootOfCorruptionModVariables.MapVariables.get(world).event_count = time;
		TheRootOfCorruptionModVariables.MapVariables.get(world).syncData(world);
    }
}
