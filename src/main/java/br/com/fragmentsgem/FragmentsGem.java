package br.com.fragmentsgem;

import br.com.fragmentsgem.commands.Fragmentos;
import br.com.fragmentsgem.handlers.BlockHandler;
import br.com.fragmentsgem.utils.ConfigUtil;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class FragmentsGem extends JavaPlugin {

    List<String> ValidBlocks = Arrays.asList("STONE", "COAL_ORE", "LAPIS_ORE", "GOLD_ORE", "IRON_ORE", "DIAMOND_ORE", "REDSTONE_ORE", "EMERALD_ORE", "SMOOTH_BRICK");

    @Override
    public void onEnable() {
        Bukkit.getLogger().info("[FragmentsGem] enabled.");

        ConfigUtil config = new ConfigUtil(this, "config.yml");

        if(!config.getFile().exists()) {
            config.getConfig().set("world", "minerar");
            config.getConfig().set("valid-blocks", ValidBlocks);
            config.getConfig().set("is-user-blocks-valid", "false");
            config.save();
        }

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
