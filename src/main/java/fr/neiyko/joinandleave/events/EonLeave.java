package fr.neiyko.joinandleave.events;

import fr.neiyko.joinandleave.Main;
import net.luckperms.api.LuckPerms;
import net.luckperms.api.LuckPermsProvider;
import net.luckperms.api.cacheddata.CachedMetaData;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class EonLeave implements Listener {

    private Main main = Main.getInstance();
    LuckPerms luckpermapi = LuckPermsProvider.get();

    @EventHandler
    public void onLeave(PlayerQuitEvent e){
        Player p = e.getPlayer();

        CachedMetaData metaData = luckpermapi.getPlayerAdapter(Player.class).getMetaData(p);
        String lpPrefix = metaData.getPrefix();

        if (main.fileConfigConfiguration.getBoolean("leave.enable")) {
            for (Player players : Bukkit.getOnlinePlayers()) {
                if (main.getConfig("permission-plugin").equalsIgnoreCase("LuckPerms")) {
                    players.sendMessage(main.getMessages("leaveMessage").replace("%rank%", lpPrefix)
                            .replace("%player%", p.getName()).replace("&", "§"));
                }
            }
        }
    }
}
