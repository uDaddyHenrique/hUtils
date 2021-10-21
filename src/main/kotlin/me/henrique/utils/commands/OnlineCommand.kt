package me.henrique.utils.commands

import org.bukkit.Bukkit
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

class OnlineCommand : CommandExecutor {
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {

        if(sender is Player){
            var p : Player = sender
            p.sendMessage("§aTotal de jogadores em nossa rede: §f" + Bukkit.getOnlinePlayers().size)
        }else {
            sender.sendMessage("§cVocê não é um player.")

        }
        return true
    }
}