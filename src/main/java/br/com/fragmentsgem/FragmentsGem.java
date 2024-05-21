package br.com.fragmentsgem;

import br.com.fragmentsgem.commands.Fragmentos;
import br.com.fragmentsgem.handlers.BlockHandler;
import br.com.fragmentsgem.utils.ConfigUtil;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class FragmentsGem extends JavaPlugin {

    @Override
    public void onEnable() {
        ConfigUtil config = new ConfigUtil(this, "config.yml");

        if(!config.getFile().exists()) {
            config.getConfig().set("world", "minerar");
            config.save();
        }

        Bukkit.getLogger().info("[FragmentsGem] enabled.");
        Bukkit.getPluginManager().registerEvents(new BlockHandler(), this);
        getCommand("fragmentos").setExecutor(new Fragmentos());

    }

    @Override
    public void onDisable() {
        Bukkit.getLogger().info("[FragmentsGem] disabled.");
        // Plugin shutdown logic
    }

    public static FragmentsGem getInstance() {
        return getPlugin(FragmentsGem.class);
    }
}
