package com.ernestorb.tmexample;

import com.ernestorb.tablistmanager.TablistManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    private TablistManager manager;

    @Override
    public void onEnable() {
        // Plugin startup logic
        this.manager = new TablistManager(this);
        this.getServer().getPluginManager().registerEvents(new MyListener(this), this);
    }

    public TablistManager getManager() {
        return manager;
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
