package com.ernestorb.tmexample;

import com.ernestorb.tablistmanager.packets.TablistTemplate;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class MyListener implements Listener {

    private final Main plugin;
    private final TablistTemplate myTemplate = new TablistTemplate((tablistTemplate, player) -> {
        // this callback is used to update info every tick!
        tablistTemplate.setHeader("Hello!\nThis is great %player_name%\nThis is my %new_placeholder% (gamemode)");
        tablistTemplate.setFooter("§cYou are on %player_world%"); // built in player placeholders
        // register a placeholder (just replace it)
        tablistTemplate.setHeader(tablistTemplate.getHeader().replaceAll("%new_placeholder%", player.getGameMode().toString()));
    });

    public MyListener(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        this.plugin.getManager().getTablistHandler().setPlayerTablist(e.getPlayer(), this.myTemplate);
    }


}
