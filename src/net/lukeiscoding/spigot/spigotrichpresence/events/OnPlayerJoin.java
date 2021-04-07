package net.lukeiscoding.spigot.spigotrichpresence.events;

import net.lukeiscoding.spigot.spigotrichpresence.init.SetupDiscordRichPresence;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class OnPlayerJoin implements Listener {

    private final SetupDiscordRichPresence discord = new SetupDiscordRichPresence();

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player p = event.getPlayer();

        if (p.isOnline()) {
            discord.createRichPresence();
        }
    }
}
