package br.com.fragmentsgem.utils;

import org.bukkit.command.CommandSender;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Message {
    public static void send(CommandSender sender,String message) {
        send(sender, message, "&a");
    }

    public static void send(CommandSender sender, String message, String prefix) {
        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix + message));
    }
}

