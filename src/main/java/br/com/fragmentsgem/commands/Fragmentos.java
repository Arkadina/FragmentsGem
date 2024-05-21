package br.com.fragmentsgem.commands;

import br.com.fragmentsgem.utils.Message;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Fragmentos implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if(!(commandSender instanceof Player)) {
            Message.send(commandSender, "&cOnly players can use this command.");
            return true;
        }

        commandSender.sendMessage("Você usou o comando /fragmentos");
        return true;
    }
}
