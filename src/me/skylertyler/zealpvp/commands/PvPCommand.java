package me.skylertyler.zealpvp.commands;

import me.skylertyler.zealpvp.ZealPvP;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;

public class PvPCommand implements CommandExecutor {

	public ZealPvP zealPvP;
	
	public PvPCommand(ZealPvP zealPvP) {
		this.zealPvP = zealPvP;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label,
			String[] arg3) {
		if(sender instanceof Player){
			Player player = (Player) sender;
			if(label.equalsIgnoreCase("pvp")){
				//armor
				ItemStack ironhelmet = new ItemStack(Material.IRON_HELMET);
				ItemMeta ironhelmeta = ironhelmet.getItemMeta();
				ironhelmeta.setDisplayName(ChatColor.GRAY+"["
				+ChatColor.LIGHT_PURPLE+"Kit PvP Helmet"+ChatColor.GRAY+"]");
				ironhelmet.setItemMeta(ironhelmeta);
				

				ItemStack ironchestplate = new ItemStack(Material.IRON_CHESTPLATE);
				ItemMeta ironchstplatemeta = ironhelmet.getItemMeta();
				ironchstplatemeta.setDisplayName(ChatColor.GRAY+"["+
				ChatColor.LIGHT_PURPLE+"Kit PvP Chestplate"+ChatColor.GRAY+"]");
				ironchestplate.setItemMeta(ironchstplatemeta);
				

				ItemStack ironleggions = new ItemStack(Material.IRON_LEGGINGS);
				ItemMeta ironleggionsmeta = ironleggions.getItemMeta();
				ironleggionsmeta.setDisplayName(ChatColor.GRAY+"["+
						ChatColor.LIGHT_PURPLE+"Kit PvP Leggings"+ChatColor.GRAY+"]");
				ironleggions.setItemMeta(ironleggionsmeta);
				
				
				ItemStack ironboots = new ItemStack(Material.IRON_BOOTS);
				ItemMeta ironbootsmeta = ironboots.getItemMeta();
				ironbootsmeta.setDisplayName(ChatColor.GRAY+"["+
						ChatColor.LIGHT_PURPLE+"Kit PvP Boots"+ChatColor.GRAY+"]");
				ironboots.setItemMeta(ironbootsmeta);
				
				
				ItemStack mushroomsoup = new ItemStack(Material.MUSHROOM_SOUP,1920);
				ItemMeta mushroomsoupMeta = mushroomsoup.getItemMeta();
				mushroomsoupMeta.setDisplayName(ChatColor.GRAY+"["+
				ChatColor.LIGHT_PURPLE+"Kit PvP Soup"+ChatColor.GRAY+"]");
				mushroomsoup.setItemMeta(mushroomsoupMeta);
			     		    
			
				ItemStack Diamondsword = new ItemStack(Material.DIAMOND_SWORD);
				ItemMeta Diamondswordmeta = Diamondsword.getItemMeta();
				Diamondsword.setItemMeta(Diamondswordmeta);
				Diamondswordmeta.setDisplayName(ChatColor.GRAY+"["+ChatColor.LIGHT_PURPLE+"Kit PvP Sword"+ChatColor.GRAY+"]");
				Diamondsword.addEnchantment(Enchantment.DAMAGE_ALL, 1);
				
				//adding to inventory
	            PlayerInventory pi = player.getInventory();
	            pi.addItem(ironhelmet);
	            pi.addItem(ironchestplate);
	            pi.addItem(ironleggions);
	            pi.addItem(ironboots);
	            pi.addItem(Diamondsword);
	            pi.addItem(mushroomsoup);
	            player.closeInventory();
				player.sendMessage(ChatColor.LIGHT_PURPLE+"You Choosed Kit PvP");
			}
		}else{
			sender.sendMessage(ChatColor.RED+"You need to be a player to do that!");
		}
		return false;
	}

}
