package fr.neiyko.joinandleave.commands;

import fr.neiyko.joinandleave.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;

public class JALReload implements CommandExecutor {

    Main main = Main.getInstance();

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {

        Player p = (Player) sender;

        if (main.hasPermission(p, "reload-permission")) {
            PluginManager pm = main.getServer().getPluginManager();
            long timer_start = System.currentTimeMillis();
            try {
                pm.disablePlugin(pm.getPlugin("JoinAndLeave"));
                pm.enablePlugin(pm.getPlugin("JoinAndLeave"));
            } catch (Exception e) {
                p.sendMessage(main.getMessages("reloadError").replace("&", "§"));
                return false;
            }
            long timer_end = System.currentTimeMillis();
            p.sendMessage(main.getMessages("reloadComplete").replace("&", "§").replace("%timerMS%", timer_end - timer_start + ""));
        } else {
            p.sendMessage(main.getMessages("permission.no-reload-perm").replace("&", "§"));
        }
        return false;
    }
}
