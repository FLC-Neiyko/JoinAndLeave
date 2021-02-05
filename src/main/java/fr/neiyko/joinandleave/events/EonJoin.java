package fr.neiyko.joinandleave.events;

import fr.neiyko.joinandleave.JoinAndLeave;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class EonJoin implements Listener {

    private final JoinAndLeave joinAndLeave = JoinAndLeave.getInstance();

    @EventHandler
    public void onLeave(PlayerJoinEvent e){
        Player p = e.getPlayer();
        //Vault API
        String primaryGroup = JoinAndLeave.getPerms().getPrimaryGroup(p);
        String prefix = JoinAndLeave.getChat().getGroupPrefix(p.getWorld(), primaryGroup);
        //join.enable = true in config.yml
        if (joinAndLeave.fileConfigConfiguration.getBoolean("join.enable")) {
            e.setJoinMessage(joinAndLeave.getMessages("joinMessage").replace("%rank%", prefix)
            .replace("%player%", p.getName()).replace("&", "§"));
        }
    }
}
