package fr.neiyko.joinandleave.managers;

import fr.neiyko.joinandleave.JoinAndLeave;
import fr.neiyko.joinandleave.commands.JALReload;

public class MCommands {

    private JoinAndLeave joinAndLeave = JoinAndLeave.getInstance();

    public void initCommands() {
        joinAndLeave.getCommand("jalreload").setExecutor(new JALReload());
    }
}
