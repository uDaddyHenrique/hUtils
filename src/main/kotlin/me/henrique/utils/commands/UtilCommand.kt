package me.henrique.utils.commands

import org.bukkit.GameMode
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player


class UtilCommand : CommandExecutor {
    override fun onCommand(sender: CommandSender?, command: Command?, label: String?, args: Array<out String>?): Boolean {
        if(sender is Player){
            var p : Player = sender
            if(!p.hasPermission("util.admin")){
                p.sendMessage("§cVocê não tem permissão para isso amigo. :(")
            }
                p.sendMessage("§aQue plugin util seloco.")
                p.gameMode = GameMode.SURVIVAL
        }
        return true;
    }
}