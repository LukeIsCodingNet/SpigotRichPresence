package net.lukeiscoding.spigot.spigotrichpresence.init;

import net.arikia.dev.drpc.DiscordEventHandlers;
import net.arikia.dev.drpc.DiscordRPC;
import net.arikia.dev.drpc.DiscordRichPresence;
import net.arikia.dev.drpc.DiscordUser;
import net.arikia.dev.drpc.callbacks.ReadyCallback;
import net.lukeiscoding.spigot.spigotrichpresence.SpigotRichPresence;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

public class SetupDiscordRichPresence implements ReadyCallback {

    // get a instance of the main plugin class
    private static final SpigotRichPresence plugin = SpigotRichPresence.getPlugin(SpigotRichPresence.class);

    @Override
    public void apply(DiscordUser discordUser) {
        Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "");
    }

    public void setupDiscord() {
        DiscordEventHandlers handlers = new DiscordEventHandlers.Builder().setReadyEventHandler((discordUser -> {
            Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "Welcome " + discordUser.username + "#" + discordUser.discriminator + "!");
        })).build();

        DiscordRPC.discordInitialize(plugin.getConfig().getString("discord-app-id"), handlers, true);
    }

    public void createRichPresence() {
        DiscordRichPresence rich = new DiscordRichPresence.Builder("Playing Minecraft multiplayer on " + Bukkit.getServer().getName() + "!").setDetails(null).build();
        DiscordRPC.discordUpdatePresence(rich);
    }
}
