package fr.neiyko.joinandleave.events;

import fr.neiyko.joinandleave.Main;
import net.luckperms.api.LuckPerms;
import net.luckperms.api.LuckPermsProvider;
import net.luckperms.api.cacheddata.CachedMetaData;
import org.anjocaido.groupmanager.GroupManager;
import org.anjocaido.groupmanager.permissions.AnjoPermissionsHandler;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class EonLeave implements Listener {

    private Main main = Main.getInstance();
    private GroupManager groupManager;


    LuckPerms luckpermapi = LuckPermsProvider.get();

    @EventHandler
    public void onLeave(PlayerQuitEvent e){
        Player p = e.getPlayer();

        AnjoPermissionsHandler handler = groupManager.getWorldsHolder().getWorldPermissions(e.getPlayer());
        String gmPrefix = handler.getUserPrefix(p.getName());

        //LuckPerm
        CachedMetaData metaData = luckpermapi.getPlayerAdapter(Player.class).getMetaData(p);
        String lpPrefix = metaData.getPrefix();
        //GroupManager


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
