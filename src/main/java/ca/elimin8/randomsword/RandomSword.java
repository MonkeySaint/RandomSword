package ca.elimin8.randomsword;

import org.bukkit.plugin.java.JavaPlugin;

public final class RandomSword extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getCommand("getrandomsword").setExecutor(new getSword());
        getServer().getPluginManager().registerEvents(new EventonClick(),this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
