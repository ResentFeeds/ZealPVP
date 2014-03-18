package me.skylertyler.zealpvp.commands;

import me.skylertyler.zealpvp.ZealPvP;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class KitsCommand implements CommandExecutor {

	public ZealPvP zealPvP;

	public KitsCommand(ZealPvP zealPvP) {
		this.zealPvP = zealPvP;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label,
			String[] args) {
		if(sender instanceof Player){
			Player player = (Player) sender;
			player.sendMessage(ChatColor.GOLD+"[ZealPVP] "+ChatColor.GRAY+" pvp, archer , s");
		}else{
			sender.sendMessage(ChatColor.RED+"You need to be a player to do that!");
		}
		return false;
	}

}
