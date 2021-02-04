package fr.neiyko.joinandleave.events;

import fr.neiyko.joinandleave.Main;
import net.luckperms.api.LuckPerms;
import net.luckperms.api.LuckPermsProvider;
import net.luckperms.api.cacheddata.CachedMetaData;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class EonJoin implements Listener {

    private Main main = Main.getInstance();
    LuckPerms luckpermapi = LuckPermsProvider.get();

    @EventHandler
    public void onLeave(PlayerJoinEvent e){
        Player p = e.getPlayer();

        CachedMetaData metaData = luckpermapi.getPlayerAdapter(Player.class).getMetaData(p);
        String prefix = metaData.getPrefix();

        if (main.fileConfigConfiguration.getBoolean("join.enable")) {
            for (Player players : Bukkit.getOnlinePlayers()) {
                if (main.getConfig("permission-plugin").equalsIgnoreCase("LuckPerms")) {
                    players.sendMessage(main.getMessages("joinMessage").replace("%rank%", prefix)
                            .replace("%player%", p.getName()).replace("&", "§"));
                }
            }
        }
    }
}
