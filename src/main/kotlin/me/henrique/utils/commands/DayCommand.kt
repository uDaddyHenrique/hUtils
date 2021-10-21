package me.henrique.utils.commands

import org.bukkit.Bukkit
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

class DayCommand : CommandExecutor {
    override fun onCommand(sender: CommandSender, cmd: Command, label: String, args: Array<out String>): Boolean {
        if(sender is Player){
            var p : Player = sender;
            if(!p.hasPermission("day.cmd")){
                p.sendMessage("§cVocê não tem permissão para executar este comando")
            } else {
                if(args.isEmpty()){
                    p.world.time = 0
                    p.sendMessage("§aVocê atualizou o tempo para dia.")
                }
            }
        }
        return true
    }
}