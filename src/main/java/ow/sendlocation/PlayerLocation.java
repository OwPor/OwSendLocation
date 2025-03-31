package ow.sendlocation;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class PlayerLocation implements CommandExecutor, Listener {
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("sc")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                Location loc = player.getLocation();

                String pEnv = player.getWorld().getEnvironment().toString();

                if (pEnv == "NORMAL") {
                    pEnv = "Overworld";
                } else if (pEnv == "NETHER") {
                    pEnv = "Nether";
                } else if (pEnv == "THE_END") {
                    pEnv = "End";
                }

                String message = ChatColor.GREEN + player.getDisplayName() + ChatColor.RESET + "'s current coordinates: " + ChatColor.RED + pEnv + ChatColor.RESET + " - "
                        + ChatColor.AQUA + "X: " + (int) loc.getX() + ", Y: " + (int) loc.getY() + ", Z: " + (int) loc.getZ();
                Bukkit.broadcastMessage(message);
                return true;
            } else {
                sender.sendMessage(ChatColor.RED + "You must be a player to use this command.");
                return false;
            }
        }
        return false;
    }

}