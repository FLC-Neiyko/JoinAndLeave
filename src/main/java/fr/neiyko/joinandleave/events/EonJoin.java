package fr.neiyko.joinandleave.events;

import fr.neiyko.joinandleave.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class EonJoin implements Listener {

    private Main main = Main.getInstance();

    @EventHandler
    public void onLeave(PlayerJoinEvent e){
        Player p = e.getPlayer();

        if (main.fileConfigConfiguration.getBoolean("join.enable")) {

        }
    }
}
