package br.com.fragmentsgem.handlers;

import br.com.fragmentsgem.FragmentsGem;
import br.com.fragmentsgem.utils.ConfigUtil;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BlockHandler implements Listener {

    final double tierFiveFragment = 0.000005;
    final double tierFourFragment = 0.000010;
    final double tierThreeFragment = 0.00025;
    final double tierTwoFragment = 0.0005;
    final double tierOneFragment = 0.002;

    private final ItemStack tierOneFragmentStack = new ItemStack(Material.NETHER_STAR, 1);
    private final ItemStack tierTwoFragmentStack = new ItemStack(Material.NETHER_STAR, 1);
    private final ItemStack tierThreeFragmentStack = new ItemStack(Material.NETHER_STAR, 1);
    private final ItemStack tierFourFragmentStack = new ItemStack(Material.NETHER_STAR, 1);
    private final ItemStack tierFiveFragmentStack = new ItemStack(Material.NETHER_STAR, 1);

    public BlockHandler() {
        initializeItems();
    }

    private void initializeItems() {
        setItemMeta(tierOneFragmentStack, "1");
        setItemMeta(tierTwoFragmentStack, "2");
        setItemMeta(tierThreeFragmentStack, "3");
        setItemMeta(tierFourFragmentStack, "4");
        setItemMeta(tierFiveFragmentStack, "5");
    }

    private void setItemMeta(ItemStack itemStack, String tier) {
        List<String> Lore = new ArrayList<>();

        Lore.add(" ");
        Lore.add(ChatColor.WHITE + " Nível: " + ChatColor.GRAY + tier +" ");
        Lore.add(" ");

        itemStack.addUnsafeEnchantment(Enchantment.LURE, 1);

        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        itemMeta.setDisplayName(ChatColor.GOLD + "Fragmento");
        itemMeta.setLore(Lore);
        itemStack.setItemMeta(itemMeta);
    }

//    private String[] validBlocks = {}

    @EventHandler
    public void onBlockBreak(BlockBreakEvent e) {
        Player p = e.getPlayer();
        Block block = e.getBlock();
        World world = e.getPlayer().getWorld();

        ConfigUtil config = new ConfigUtil(FragmentsGem.getInstance(), "config.yml");

        if(!world.getName().equalsIgnoreCase(config.getConfig().get("world").toString())) {
            return;
        }

        System.out.println(p.hasPermission("fragmentsgem.use"));

        System.out.println(block.getType());
        System.out.println(Material.STONE.toString());

        double random = new Random().nextDouble();
        System.out.println(random);

       if(block.getType() == Material.STONE) {
           if(tierFiveFragment >= random) {
               p.sendMessage("§a Você encontrou um §cFragmento nível 5");

               p.getInventory().addItem(tierFiveFragmentStack);

           } else if (tierFourFragment >= random) {
               p.sendMessage("§a Você encontrou um §cFragmento nível 4");

               p.getInventory().addItem(tierFourFragmentStack);

           } else if (tierThreeFragment >= random) {
               p.sendMessage("§a Você encontrou um §cFragmento nível 3");

               p.getInventory().addItem(tierThreeFragmentStack);
           } else if(tierTwoFragment >= random) {
               p.sendMessage("§a Você encontrou um §cFragmento nível 2");

               p.getInventory().addItem(tierTwoFragmentStack);
           } else if(tierOneFragment >= random) {
               p.sendMessage("§a Você encontrou um §cFragmento nível 1");

               p.getInventory().addItem(tierOneFragmentStack);
           }
       }
    }
}
