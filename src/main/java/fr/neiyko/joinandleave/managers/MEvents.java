package fr.neiyko.joinandleave.managers;

import fr.neiyko.joinandleave.Main;
import fr.neiyko.joinandleave.events.EonJoin;
import fr.neiyko.joinandleave.events.EonLeave;
import org.bukkit.plugin.PluginManager;

public class MEvents {

    private Main main = Main.getInstance();

    public void initEvents() {
        PluginManager pm = main.getServer().getPluginManager();
        pm.registerEvents(new EonJoin(), main);
        pm.registerEvents(new EonLeave(), main);
    }
}
