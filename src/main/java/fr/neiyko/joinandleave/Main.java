package fr.neiyko.joinandleave;

import fr.neiyko.joinandleave.managers.MCommands;
import fr.neiyko.joinandleave.managers.MEvents;
import fr.neiyko.joinandleave.managers.MFiles;
import fr.neiyko.joinandleave.managers.MLoad;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.logging.Level;

public final class Main extends JavaPlugin {

    private static Main instance;
    private MLoad managerload;
    private MEvents eventsManager;
    private MCommands commandsManager;
    private MFiles fileManager;
    private boolean error;

    public static Main getInstance() {
        return instance;
    }

    public File configFile = new File(getDataFolder().getPath() + "/config.yml");
    public FileConfiguration fileConfigConfiguration;

    public File messagesFile = new File(getDataFolder().getPath() + "/messages.yml");
    public FileConfiguration fileConfigMessages;

    @Override
    public void onEnable() {
        instance = this;
        managerload = new MLoad();
        eventsManager = new MEvents();
        fileManager = new MFiles();
        commandsManager = new MCommands();
        managerload.pluginLoad();
    }

    @Override
    public void onDisable() {
        managerload.pluginDisable();
    }

    public MLoad getManagerload() {
        return managerload;
    }

    public MEvents getEventsManager() {
        return eventsManager;
    }

    public void logConsole(Level level, String msg) {
        getLogger().log(level, msg);
    }

    public MCommands getCommandsManager() {
        return commandsManager;
    }

    public MFiles getFileManager() {
        return fileManager;
    }

    public String getPermission(String perm) {
        return fileConfigConfiguration.getString(perm);
    }

    public String getConfig(String config) {
        return fileConfigConfiguration.getString(config);
    }

    public String getMessages(String msg) {
        return fileConfigMessages.getString(msg);
    }

    public boolean hasPermission(Player p, String action) {
        if (p.hasPermission(getPermission(action))) {
            return true;
        }
        return false;
    }

    public void setError(boolean status) {
        error = status;
    }

    public boolean getError() {
        return error;
    }
}
