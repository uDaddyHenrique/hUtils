package me.henrique.utils.commands

import me.henrique.utils.spawn.SpawnManager
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

class SetSpawnCommand : CommandExecutor{
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        if(sender is Player){
            var p : Player = sender;
            if(!p.hasPermission("setspawn.cmd")){
                p.sendMessage("§cVocê não tem permissão para executar esse comando.")
            }else{
                if(args.isEmpty()){
                    SpawnManager.setSpawn(p)
                    p.sendMessage("§aVocê setou o spawn com sucesso.")
                }
            }
        }
        return true
    }
}