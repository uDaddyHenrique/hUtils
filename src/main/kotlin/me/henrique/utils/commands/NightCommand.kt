package me.henrique.utils.commands

import org.bukkit.Bukkit
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

class NightCommand : CommandExecutor {
    override fun onCommand(sender: CommandSender, commands: Command, label: String, args: Array<out String>): Boolean {
        if(sender is Player){
            var p : Player = sender;
            if(!p.hasPermission("night.cmd")){
                p.sendMessage("§cVocê não tem permissão para executor este comando.")
            }else{
                if(args.isEmpty()){
                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "time set night")
                    p.sendMessage("§aVocê setou o tempo para noite.")
                }
            }
        }
        return true;
    }
}