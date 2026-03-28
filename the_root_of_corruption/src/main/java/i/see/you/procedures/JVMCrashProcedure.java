package i.see.you.procedures;

import sun.misc.Unsafe;
import java.lang.reflect.Field;
import i.see.you.configuration.ConfigConfiguration;

public class JVMCrashProcedure {
	public static void execute() {
		if (ConfigConfiguration.CRASH.get()) {
    		try {
        		Field f = Unsafe.class.getDeclaredField("theUnsafe");
        		f.setAccessible(true);
        		Unsafe unsafe = (Unsafe) f.get(null);
        		unsafe.putAddress(0, 0);
    		} catch (Exception e) {
        		e.printStackTrace();
    		}
		}
	}
}
