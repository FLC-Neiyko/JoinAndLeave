package fr.neiyko.joinandleave.managers;

import fr.neiyko.joinandleave.JoinAndLeave;
import org.bukkit.plugin.PluginManager;

import java.util.logging.Level;

public class MLoad {

    private JoinAndLeave joinAndLeave = JoinAndLeave.getInstance();

    public void pluginLoad() {
        PluginManager pm = joinAndLeave.getServer().getPluginManager();
        long start_timer = System.currentTimeMillis();

        joinAndLeave.logConsole(Level.INFO, "=== Beginning of loading ===");
        joinAndLeave.logConsole(Level.INFO, "Loading the plugin...");
        joinAndLeave.logConsole(Level.INFO, "---");

        //Vault verifaction
        try {
            if (Class.forName("net.milkbowl.vault.Vault") != null) {
                joinAndLeave.logConsole(Level.INFO, "Vault plugin present");
            }
        } catch (Exception e) {
            joinAndLeave.logConsole(Level.SEVERE, "Plugin vault not present! You must install it !");
            joinAndLeave.setError(true);
        }


        joinAndLeave.getCommandsManager().initCommands();
        joinAndLeave.getEventsManager().initEvents();
        joinAndLeave.getFileManager().initFile();
        //Startup end

        if (joinAndLeave.getError()) errorMSG();

        long end_timer = System.currentTimeMillis();
        joinAndLeave.logConsole(Level.INFO, "Loading completed in " + (start_timer-end_timer) + " ms");
        pluginEnable();
    }

    public void pluginEnable() {

        joinAndLeave.logConsole(Level.INFO, "----");
        joinAndLeave.logConsole(Level.INFO, "Plugin JoinAndLeave");
        joinAndLeave.logConsole(Level.INFO, "By Neiyko");
        joinAndLeave.logConsole(Level.INFO, "Status: Enabled");
        joinAndLeave.logConsole(Level.INFO, "----");

    }

    public void pluginDisable() {

        joinAndLeave.logConsole(Level.INFO, "----");
        joinAndLeave.logConsole(Level.INFO, "Plugin JoinAndLeave");
        joinAndLeave.logConsole(Level.INFO, "By Neiyko");
        joinAndLeave.logConsole(Level.INFO, "Status: Disabled");
        joinAndLeave.logConsole(Level.INFO, "----");

    }

    public void errorMSG() {
        joinAndLeave.logConsole(Level.INFO, "----");
        joinAndLeave.logConsole(Level.INFO, "Plugin JoinAndLeave");
        joinAndLeave.logConsole(Level.INFO, "By Neiyko");
        joinAndLeave.logConsole(Level.INFO, "Status: Error");
    }
}
