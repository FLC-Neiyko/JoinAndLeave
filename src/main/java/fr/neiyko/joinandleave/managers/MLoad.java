package fr.neiyko.joinandleave.managers;

import fr.neiyko.joinandleave.Main;
import org.bukkit.plugin.PluginManager;

import java.util.logging.Level;

public class MLoad {

    private Main main = Main.getInstance();

    public void pluginLoad() {
        PluginManager pm = main.getServer().getPluginManager();
        long start_timer = System.currentTimeMillis();

        main.logConsole(Level.INFO, "=== Beginning of loading ===");
        main.logConsole(Level.INFO, "Loading the plugin...");
        main.logConsole(Level.INFO, "---");

        //Vault verifaction
        try {
            if (Class.forName("net.milkbowl.vault.Vault") != null) {
                main.logConsole(Level.INFO, "Vault plugin present");
            }
        } catch (Exception e) {
            main.logConsole(Level.SEVERE, "Plugin vault not present! You must install it !");
            main.setError(true);
        }


        main.getCommandsManager().initCommands();
        main.getEventsManager().initEvents();
        main.getFileManager().initFile();
        //Startup end

        if (main.getError()) errorMSG();

        long end_timer = System.currentTimeMillis();
        main.logConsole(Level.INFO, "Loading completed in " + (start_timer-end_timer) + " ms");
        pluginEnable();
    }

    public void pluginEnable() {

        main.logConsole(Level.INFO, "----");
        main.logConsole(Level.INFO, "Plugin JoinAndLeave");
        main.logConsole(Level.INFO, "By Neiyko");
        main.logConsole(Level.INFO, "Status: Enabled");
        main.logConsole(Level.INFO, "----");

    }

    public void pluginDisable() {

        main.logConsole(Level.INFO, "----");
        main.logConsole(Level.INFO, "Plugin JoinAndLeave");
        main.logConsole(Level.INFO, "By Neiyko");
        main.logConsole(Level.INFO, "Status: Disabled");
        main.logConsole(Level.INFO, "----");

    }

    public void errorMSG() {
        main.logConsole(Level.INFO, "----");
        main.logConsole(Level.INFO, "Plugin JoinAndLeave");
        main.logConsole(Level.INFO, "By Neiyko");
        main.logConsole(Level.INFO, "Status: Error");
    }
}
