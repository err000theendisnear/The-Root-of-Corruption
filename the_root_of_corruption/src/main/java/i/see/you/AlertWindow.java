package i.see.you;

import net.neoforged.fml.ModList;
import net.neoforged.fml.loading.FMLEnvironment;
import java.lang.Exception;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import i.see.you.TheRootOfCorruptionMod;
import org.checkerframework.common.reflection.qual.GetMethod;

public class AlertWindow {
    private final String title;
    private final String message;
    public AlertWindow(String title, String message) {
        this.title = title;
        this.message = message;
    }
    public void show() {
        if (!FMLEnvironment.dist.isClient()) {
            return;
        }
        Path javaBinDir = Paths.get(System.getProperty("java.home"), "bin").normalize();
        Path javaPath = findJavaExecutable(javaBinDir);
        if (javaPath == null) {
            throw new RuntimeException("Can't find java executable in " + javaBinDir);
        }

        String classpath;
        if (FMLEnvironment.production) {
        	classpath = ModList.get().getModFileById("the_root_of_corruption").getFile().getFilePath().toString();
        } else {
            classpath = System.getProperty("java.class.path");
        }
        List<String> command = new ArrayList<>();
        command.add(javaPath.toString());
        command.add("-Xmx100M");
        command.add("-cp");
        command.add(classpath);
        command.add(AlertWindowInner.class.getName()); 
        command.add(title);
        command.add(message);
        try {
            new ProcessBuilder(command)
                    .redirectOutput(ProcessBuilder.Redirect.INHERIT)
                    .redirectError(ProcessBuilder.Redirect.INHERIT)
                    .start();
        } catch (Exception e) {
            throw new RuntimeException("Failed to start alert window", e);
        }
        TheRootOfCorruptionMod.LOGGER.info("Show a AlertWindow, title: " + title + " message: " + message);
    }

    private Path findJavaExecutable(Path binDir) {
        String[] candidates = {"javaw.exe", "java.exe", "java"};
        for (String candidate : candidates) {
            Path path = binDir.resolve(candidate);
            if (Files.isRegularFile(path)) {
                return path;
            }
        }
        return null;
    }
    
    public String getTitle() {
    	return this.title;
    }

    public String getMessage() {
    	return this.message;
    }
}