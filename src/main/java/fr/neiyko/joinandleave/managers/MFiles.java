package fr.neiyko.joinandleave.managers;

import fr.neiyko.joinandleave.JoinAndLeave;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.logging.Level;

public class MFiles {

    private JoinAndLeave joinAndLeave = JoinAndLeave.getInstance();

    public void initFile() {

        ressourceSetup("config.yml", true);
        joinAndLeave.fileConfigConfiguration = YamlConfiguration.loadConfiguration(joinAndLeave.configFile);

        ressourceSetup("messages.yml", true);
        joinAndLeave.fileConfigMessages = YamlConfiguration.loadConfiguration(joinAndLeave.messagesFile);

    }

    public void ressourceSetup(String fileName, boolean reset) {
        InputStream in = joinAndLeave.getResource((fileName));

        if (in == null) {
            throw new IllegalArgumentException("The '" + fileName + "' resource was not found !");
        }

        File outDir = new File(joinAndLeave.getDataFolder(), "");
        if (!outDir.exists()) {
            outDir.mkdirs();
        }
        String fileNameString = fileName.toLowerCase();
        if (fileNameString.equals("config.yml") || fileName.equals("messages.yml")) {
            File outFile = new File(joinAndLeave.getDataFolder(), fileName);
            if (!outFile.exists()) {
                try {
                    OutputStream out = new FileOutputStream(outFile);
                    byte[] buf = new byte['?'];
                    int len;
                    while ((len = in.read(buf)) > 0) {
                        out.write(buf, 0, len);
                    }
                    out.close();
                    in.close();
                    return;
                } catch (Exception e) {
                    joinAndLeave.logConsole(Level.WARNING, "The '" + fileName + "' was not found !");
                }
            }
        }
    }
}
