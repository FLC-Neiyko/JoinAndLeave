package fr.neiyko.joinandleave.managers;

import fr.neiyko.joinandleave.JoinAndLeave;
import fr.neiyko.joinandleave.events.EonJoin;
import fr.neiyko.joinandleave.events.EonLeave;
import org.bukkit.plugin.PluginManager;

public class MEvents {

    private JoinAndLeave joinAndLeave = JoinAndLeave.getInstance();

    public void initEvents() {
        PluginManager pm = joinAndLeave.getServer().getPluginManager();
        pm.registerEvents(new EonJoin(), joinAndLeave);
        pm.registerEvents(new EonLeave(), joinAndLeave);
    }
}
