package net.lukeiscoding.spigot.spigotrichpresence;

import net.lukeiscoding.spigot.spigotrichpresence.events.OnPlayerJoin;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class SpigotRichPresence extends JavaPlugin {

    @Override
    public void onEnable() {
        this.getConfig().options().copyDefaults(true);
        this.saveConfig();

        // check if discord-app-id is null in the config if so disable this plugin
        if (this.getConfig().getString("discord-app-id") == null) {
            Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.DARK_RED + "You did not set a Discord app id in the config.yml. Please go do that before starting your server again.");
            this.setEnabled(false);
        }

        registerEvents();
    }

    @Override
    public void onDisable() {
        this.saveConfig();
    }

    private void registerEvents() {
        this.getServer().getPluginManager().registerEvents(new OnPlayerJoin(), this);
    }
}
