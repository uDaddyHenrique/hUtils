package me.henrique.utils.commands

import me.henrique.utils.spawn.SpawnManager
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

class SpawnCommand : CommandExecutor{
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        if(sender is Player){
            var p : Player = sender;
            if(args.isEmpty()){
                SpawnManager.getSpawn(p)
                p.sendMessage("§aVocê foi teleportado ao spawn com sucesso.")
            }
        }
        return true
    }
}