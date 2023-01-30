package com.ernestorb.tmexample;

import com.ernestorb.tablistmanager.packets.fake.FakePlayer;
import com.ernestorb.tmexample.templates.AnotherHelloTablist;
import com.ernestorb.tmexample.templates.HelloTablist;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.HashMap;

public class MyListener implements Listener {

    private final Main plugin;

    HashMap<String, FakePlayer> playerList = new HashMap<>();

    public MyListener(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        if(Math.random() < 0.5) {
            this.plugin.getManager().getTablistHandler().setPlayerTablist(e.getPlayer(), HelloTablist.getInstance());
        } else {
            this.plugin.getManager().getTablistHandler().setPlayerTablist(e.getPlayer(), AnotherHelloTablist.getInstance());
        }
        FakePlayer slot = new FakePlayer(e.getPlayer().getName() + "2", e.getPlayer().getName() + ":)");
        playerList.put(e.getPlayer().getName(), slot);
        slot.getTablistAddPacket().sendPacketOnce(e.getPlayer());
    }

    @EventHandler
    public void onPlayerLeave(PlayerQuitEvent e) {
        if(playerList.containsKey(e.getPlayer().getName())) {
            FakePlayer slot = playerList.get(e.getPlayer().getName());
            slot.getTablistRemovePacket().sendPacketOnce(e.getPlayer());
            playerList.remove(e.getPlayer().getName());
        }
    }

}
