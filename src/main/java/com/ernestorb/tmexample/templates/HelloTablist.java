package com.ernestorb.tmexample.templates;

import com.ernestorb.tablistmanager.packets.TablistTemplate;

public class HelloTablist extends TablistTemplate {

    private HelloTablist() {
        super((tablistTemplate, player) -> tablistTemplate.setHeader(tablistTemplate.getHeader().replaceAll("%new_placeholder%", player.getGameMode().toString())));
        this.setHeader("&aHello!\n&eThis API is great %player_name%\nThis is my %new_placeholder% (gamemode)");
        this.setFooter("&cYou are on %player_world%"); // built in player placeholders
    }

    public static HelloTablist getInstance() {
        return new HelloTablist();
    }
}
