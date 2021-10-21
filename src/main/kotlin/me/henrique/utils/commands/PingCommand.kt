package me.henrique.utils.commands

import org.bukkit.Bukkit
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer
import org.bukkit.entity.Player
import sun.audio.AudioPlayer.player


class PingCommand : CommandExecutor {
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        if(sender is Player){
            var p : Player = sender;
            val pingP = (p as CraftPlayer).handle.ping.toDouble()
            if(args.size == 0){
                p.sendMessage("§aSeu ping é §b: " + pingP)
            }
            if(args.size == 1){
                var target : Player = Bukkit.getPlayer(args[0])
                val pingT = (target as CraftPlayer).handle.ping.toDouble()
                if(target == null){
                    p.sendMessage("§cEste jogador não está online.")
                }else{
                    p.sendMessage("§aO ping de " + target.name  + " é de §b: " + pingT)
                }
            }
        }
        return true
    }
}