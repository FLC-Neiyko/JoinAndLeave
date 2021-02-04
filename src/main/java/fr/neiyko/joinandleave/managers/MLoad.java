package fr.neiyko.joinandleave.managers;

import fr.neiyko.joinandleave.Main;

import java.util.logging.Level;

public class MLoad {

    private Main main = Main.getInstance();

    public void pluginLoad() {
        long start_timer = System.currentTimeMillis();

        main.logConsole(Level.INFO, "=== Beginning of loading ===");
        main.logConsole(Level.INFO, "Loading the plugin...");
        main.logConsole(Level.INFO, "---");

        main.getCommandsManager().initCommands();
        main.getEventsManager().initEvents();
        main.getFileManager().initFile();

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
}
