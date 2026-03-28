package i.see.you.procedures;

import java.util.ArrayList;
import java.util.List;
import i.see.you.configuration.ConfigConfiguration;

public class MemoryDeathProcedure {

	private static final List<byte[]> KILLMEMORY = new ArrayList<>();
	
	public static void execute() {
		if (ConfigConfiguration.CRASH.get()) {
			for (int index0 = 0; index0 < 1024; index0++) {
				for (int index1 = 0; index1 < 1024; index1++) {
					KILLMEMORY.add(new byte[1024 * 1024]);
				}
			}
		}
	}
}
