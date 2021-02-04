package fr.neiyko.joinandleave.managers;

import fr.neiyko.joinandleave.Main;
import fr.neiyko.joinandleave.commands.JALReload;

public class MCommands {

    private Main main = Main.getInstance();

    public void initCommands() {
        main.getCommand("jalreload").setExecutor(new JALReload());
    }
}
