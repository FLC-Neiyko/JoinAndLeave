package fr.neiyko.joinandleave.events;

import fr.neiyko.joinandleave.JoinAndLeave;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;


public class EonLeave implements Listener {

    private final JoinAndLeave joinandleave = JoinAndLeave.getInstance();

    @EventHandler
    public void onLeave(PlayerQuitEvent e){
        Player p = e.getPlayer();
        //Vault API
        String primaryGroup = JoinAndLeave.getPerms().getPrimaryGroup(p);
        String prefix = JoinAndLeave.getChat().getGroupPrefix(p.getWorld(), primaryGroup);
        //If leave.enable = true in config.yml
        if (joinandleave.fileConfigConfiguration.getBoolean("leave.enable")) {
            e.setQuitMessage(joinandleave.getMessages("leaveMessage").replace("%rank%", prefix)
                    .replace("%player%", p.getName()).replace("&", "§"));
        }
    }
}
