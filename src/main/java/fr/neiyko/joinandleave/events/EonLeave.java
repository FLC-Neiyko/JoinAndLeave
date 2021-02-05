package fr.neiyko.joinandleave.events;

import fr.neiyko.joinandleave.Main;
import net.milkbowl.vault.chat.Chat;
import net.milkbowl.vault.permission.Permission;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;


public class EonLeave implements Listener {

    private Main main = Main.getInstance();
    private Chat chat;
    private Permission perms;

    @EventHandler
    public void onLeave(PlayerQuitEvent e){
        Player p = e.getPlayer();
        //Vault API
        String primaryGroup = perms.getPrimaryGroup(p);
        String prefix = chat.getGroupPrefix(p.getWorld(), primaryGroup);

        e.setQuitMessage(p.getName() + " a quitté le serveur");
        //If leave.enable = true in config.yml
        if (main.fileConfigConfiguration.getBoolean("leave.enable")) {

                e.setQuitMessage(main.getMessages("leaveMessage").replace("%rank%", prefix)
                        .replace("%player%", p.getName()).replace("&", "§"));
        }
        System.out.println((primaryGroup));
        System.out.println(prefix);
    }
}
