package me.skylertyler.zealpvp.Listeners;

import java.util.ArrayList;
import me.skylertyler.zealpvp.ZealPvP;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;

public class ZealPVPListener implements Listener {
	public ZealPvP pvp;
	
//TODO Make the rest of the 
	
	public ZealPVPListener(ZealPvP pvp) {
		this.pvp = pvp;
	}
	
	private void openGUI(Player player){
      Inventory inv = Bukkit.createInventory(null, 45,ChatColor.GOLD+"Kit Selector");
	        ItemStack kitpvp = new ItemStack(Material.DIAMOND_SWORD);
			ItemMeta kitpvpMeta = kitpvp.getItemMeta();
			
			ItemStack archer = new ItemStack(Material.BOW);
			ItemMeta archermeta = archer.getItemMeta();
			
			ItemStack stonesword = new ItemStack(Material.STONE_SWORD);
			ItemMeta stoneswordmeta = stonesword.getItemMeta();
			//Close the Kit Selector!
			ItemStack endereye = new ItemStack(Material.EYE_OF_ENDER);
			ItemMeta endereyeMeta = endereye.getItemMeta();

			//Kit PvP
			kitpvpMeta.setDisplayName(ChatColor.LIGHT_PURPLE+"Kit PvP");
			kitpvp.setItemMeta(kitpvpMeta);
			
			endereyeMeta.setDisplayName(ChatColor.GOLD+"Close");
			endereye.setItemMeta(endereyeMeta);
			
			archermeta.setDisplayName(ChatColor.AQUA+"Archer Kit");
			archer.setItemMeta(archermeta);
			
			stoneswordmeta.setDisplayName(ChatColor.DARK_GREEN+"Sumo Kit");
			stonesword.setItemMeta(stoneswordmeta);
			inv.setItem(0, kitpvp);
			inv.setItem(1, archer);
			inv.setItem(2, stonesword);
			inv.setItem(44, endereye);
			
			player.openInventory(inv);
			
		}
	
	@EventHandler
	public void onPlayerRespawn(PlayerRespawnEvent event){
		Player player = event.getPlayer();
		player.getInventory().setItem(0, getCustName(Items.Book));
	}

	public enum Items{
		Book,
	}
	
	public ItemStack getCustName(Items item){
		ItemStack is = null;
		ItemMeta im;
		ArrayList<String> lore;
		switch(item){
		case Book:
			is = new ItemStack(Material.BOOK);
			im = is.getItemMeta();
			im.setDisplayName(ChatColor.GOLD+"Kit Selector");
			lore = new ArrayList<String>();
			lore.add(ChatColor.LIGHT_PURPLE+"Choose a kit");
			im.setLore(lore);
			is.setItemMeta(im);
			break;
		}
		return is;
	}
	
	@EventHandler
	public void onInventoryClick(InventoryClickEvent event){
		
		if(!ChatColor.stripColor(event.getInventory().getName()).equalsIgnoreCase("Kit Selector"))
			return;
		Player player = (Player) event.getWhoClicked();
		event.setCancelled(true);
		if(event.getCurrentItem()==null || event.getCurrentItem().getType() == Material.AIR ||!event.getCurrentItem().hasItemMeta()){
		player.closeInventory();
		return;
		}
		switch(event.getCurrentItem().getType()){
		case DIAMOND_SWORD:
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
			Diamondswordmeta.setDisplayName(ChatColor.GRAY+"["+ChatColor.LIGHT_PURPLE+"Kit PvP Sword"+ChatColor.GRAY+"]");
			Diamondsword.addEnchantment(Enchantment.DAMAGE_ALL, 1);
			Diamondsword.setItemMeta(Diamondswordmeta);
			
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
			break;
		case BOW:
			if(player.hasPermission("zealpvp.bow")){
			//armor
			ItemStack LeatherHelmet = new ItemStack(Material.LEATHER_HELMET);
			LeatherArmorMeta leatherArmorMeta = (LeatherArmorMeta) LeatherHelmet.getItemMeta();
			leatherArmorMeta.setDisplayName(ChatColor.GRAY+"["+ChatColor.AQUA+"Kit Archer Helmet"+ChatColor.GRAY+"]");
		    LeatherHelmet.setItemMeta(leatherArmorMeta);
		    
		    ItemStack Leatherchestplate = new ItemStack(Material.LEATHER_CHESTPLATE);
			LeatherArmorMeta LeatherchestplateMeta = (LeatherArmorMeta) Leatherchestplate.getItemMeta();
			LeatherchestplateMeta.setDisplayName(ChatColor.GRAY+"["+ChatColor.AQUA+"Kit Archer Leggings"+ChatColor.GRAY+"]");
			Leatherchestplate.setItemMeta(LeatherchestplateMeta);
			
		    ItemStack LeatherLeggings = new ItemStack(Material.LEATHER_LEGGINGS);
			LeatherArmorMeta LeatherLeggingsMeta = (LeatherArmorMeta) LeatherLeggings.getItemMeta();
			LeatherLeggingsMeta.setDisplayName(ChatColor.GRAY+"["+ChatColor.AQUA+"Kit Archer Leggings"+ChatColor.GRAY+"]");
			LeatherLeggings.setItemMeta(LeatherLeggingsMeta);
		    
		    ItemStack LeatherBoots = new ItemStack(Material.LEATHER_BOOTS);
			LeatherArmorMeta LeatherBootsMeta = (LeatherArmorMeta) LeatherBoots.getItemMeta();
			LeatherBootsMeta.setDisplayName(ChatColor.GRAY+"["+ChatColor.AQUA+"Kit Archer Boots"+ChatColor.GRAY+"]");
			LeatherBoots.setItemMeta(LeatherBootsMeta);
		    
		    ItemStack Bow = new ItemStack(Material.BOW);
			ItemMeta bowMeta = Bow.getItemMeta();
			bowMeta.setDisplayName(ChatColor.GRAY+"["+ChatColor.AQUA+"Kit Archer Bow"+ChatColor.GRAY+"]");
			Bow.setItemMeta(bowMeta);
			Bow.addEnchantment(Enchantment.ARROW_KNOCKBACK, 2);
			Bow.addEnchantment(Enchantment.ARROW_FIRE, 1);
			Bow.addEnchantment(Enchantment.ARROW_DAMAGE, 1);
			
			ItemStack arrow= new ItemStack(Material.ARROW,200);
			ItemMeta arrowMeta = arrow.getItemMeta();
			arrowMeta.setDisplayName(ChatColor.GRAY+"["+ChatColor.AQUA+"Kit Archer Arrows"+ChatColor.GRAY+"]");
			arrow.setItemMeta(bowMeta);
		    
		    ItemStack StoneSword = new ItemStack(Material.STONE_SWORD);
			ItemMeta StoneSwordMeta = StoneSword.getItemMeta();
			StoneSwordMeta.setDisplayName(ChatColor.GRAY+"["+ChatColor.AQUA+"Kit Archer Sword"+ChatColor.GRAY+"]");
			StoneSword.setItemMeta(StoneSwordMeta);
			StoneSword.addEnchantment(Enchantment.DAMAGE_ALL, 1);
		    
			PlayerInventory pi1 = player.getInventory();
			pi1.addItem(LeatherHelmet);
			pi1.addItem(Leatherchestplate);
		    pi1.addItem(LeatherLeggings);
		    pi1.addItem(LeatherBoots);
		    pi1.addItem(Bow);
		    pi1.addItem(StoneSword);
		    pi1.addItem(arrow);
	  		player.closeInventory();
	  		player.sendMessage(ChatColor.AQUA+"You Choosed Kit Archer");
			}else{
				player.sendMessage(ChatColor.RED+"You dont have Permssion!");
				player.closeInventory();
			}
	  		break;
		case STONE_SWORD:
			if(player.hasPermission("zealpvp.sumo")){
			ItemStack sumoHelmet = new ItemStack(Material.LEATHER_HELMET);
			LeatherArmorMeta sumoHelmetArmorMeta = (LeatherArmorMeta) sumoHelmet.getItemMeta();
		    sumoHelmetArmorMeta.addEnchant(Enchantment.PROTECTION_PROJECTILE, 4, true);
			sumoHelmetArmorMeta.addEnchant(Enchantment.DURABILITY, 3, true);
			sumoHelmet.setItemMeta(sumoHelmetArmorMeta);
			    
		    ItemStack sumochestplate = new ItemStack(Material.LEATHER_CHESTPLATE);
			LeatherArmorMeta sumochestplateMeta = (LeatherArmorMeta) sumochestplate.getItemMeta();
			sumochestplateMeta.addEnchant(Enchantment.PROTECTION_PROJECTILE, 4, true);
			sumochestplateMeta.addEnchant(Enchantment.DURABILITY, 3, true);
			sumochestplate.setItemMeta(sumochestplateMeta);
				
		    ItemStack sumoLeggings = new ItemStack(Material.LEATHER_LEGGINGS);
			LeatherArmorMeta sumoLeggingsMeta = (LeatherArmorMeta) sumoLeggings.getItemMeta();
			sumoLeggingsMeta.addEnchant(Enchantment.PROTECTION_PROJECTILE, 4, true);
			sumoLeggingsMeta.addEnchant(Enchantment.DURABILITY, 3, true);
			sumoLeggings.setItemMeta(sumoLeggingsMeta);
			    
			ItemStack sumoBoots = new ItemStack(Material.LEATHER_BOOTS);
			LeatherArmorMeta sumoBootsMeta = (LeatherArmorMeta) sumoBoots.getItemMeta();
			sumoBootsMeta.addEnchant(Enchantment.PROTECTION_PROJECTILE, 4, true);
			sumoBootsMeta.addEnchant(Enchantment.DURABILITY, 3, true);
			sumoBoots.setItemMeta(sumoBootsMeta);			
				
		    ItemStack sumoSword = new ItemStack(Material.STONE_SWORD);
		    ItemMeta sumoSwordMeta = sumoSword.getItemMeta();
		    sumoSword.setItemMeta(sumoSwordMeta);
			PlayerInventory pi2 = player.getInventory();
			pi2.addItem(sumoHelmet);
			pi2.addItem(sumochestplate);
			pi2.addItem(sumoLeggings);
		    pi2.addItem(sumoBoots);
			player.closeInventory();
			player.sendMessage(ChatColor.DARK_GREEN+"You Choosed Kit Sumo");
			}else{
			player.sendMessage(ChatColor.RED+"You dont have Permission!");
			player.closeInventory();
			}
			break;
		case EYE_OF_ENDER:
			player.closeInventory();
			break;
		default:
			break;
		}
	}
	
	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent event){
		Action a = event.getAction();
		ItemStack is = event.getItem();
	 if(a == Action.PHYSICAL || is == null || is.getType() == Material.AIR)
		return;
	 if( is.getType() ==Material.BOOK && is.hasItemMeta())
		 openGUI(event.getPlayer());
	}
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event){
		Player player = event.getPlayer();
		player.getInventory().setItem(1, getCustName(Items.Book));
	}
}
