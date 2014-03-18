package me.skylertyler.zealpvp;

import me.skylertyler.zealpvp.Listeners.ZealPVPListener;
import me.skylertyler.zealpvp.commands.PvPCommand;
import me.skylertyler.zealpvp.commands.KitsCommand;

import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class ZealPvP extends JavaPlugin{
	
	@Override
	public void onEnable() {
	PluginDescriptionFile pdffile = this.getDescription();
	PluginManager pm = getServer().getPluginManager();
	System.out.println("[ZealPvP] "+pdffile.getVersion()+" is Enabled!");
	//Listeners!
	pm.registerEvents(new ZealPVPListener(this), this);
	//Commands
	getCommand("pvp").setExecutor(new PvPCommand(this));
	getCommand("kits").setExecutor(new KitsCommand(this));
	}
	
	@Override
	public void onDisable() {
	PluginDescriptionFile pdffile = this.getDescription();
	System.out.println("[ZealPvP] "+pdffile.getVersion()+" is Disabled!");
	}

}
