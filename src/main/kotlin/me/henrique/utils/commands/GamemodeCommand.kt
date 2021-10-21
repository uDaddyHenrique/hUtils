package me.henrique.utils.commands

import org.bukkit.GameMode
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player


class GamemodeCommand : CommandExecutor {
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        if(sender is Player){
            var p : Player = sender
            if(!p.hasPermission("gamemode.admin")){
                p.sendMessage("§cVocê não tem permissão para isso amigo. :(")
                return false
            }
            if(args.size == 0) {
                p.sendMessage("§cUtilize: /gm <modo>")
                return false
            }
            if(args.size == 1) {
                if(args[0].equals("1") || args[0].equals("creative")){
                    p.gameMode = GameMode.CREATIVE
                    p.sendMessage("§3Você entrou no modo §eCRIATIVO.")
                    return true
                }
                if (args[0].equals("2") || args[0].equals("adventure")) {
                        p.gameMode = GameMode.ADVENTURE
                        p.sendMessage("§3Você entrou no modo §eAVENTURA.")
                        return true
                    }
                if (args[0].equals("3") || args[0].equals("spectator")) {
                    p.gameMode = GameMode.SPECTATOR
                    p.sendMessage("§3Você entrou no modo §eESPECTADOR.")
                    return true
                }
                if (args[0].equals("0") || args[0].equals("survival")) {
                    p.gameMode = GameMode.SURVIVAL
                    p.sendMessage("§3Você entrou no modo §eSOBREVIVÊNCIA.")
                    return true
                }
                if(!args[0].equals("1") ||
                    !args[0].equals("2") ||
                    !args[0].equals("3") ||
                    !args[0].equals("0")){
                    p.sendMessage("§cEsse modo de jogo não é válido.")
                }
            }
        }
        return true;
    }
}