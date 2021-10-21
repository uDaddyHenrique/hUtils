package me.henrique.utils.scoreboard

import me.henrique.utils.api.ScoreAPI
import org.bukkit.Bukkit
import org.bukkit.entity.Player

object Scoreboard {
    fun updateScore(p: Player?) {
        val score = ScoreAPI("§a§lLOBBY")
        ScoreAPI.addLine("", 12)
        ScoreAPI.addLine("§aPlayer Online §f: " + Bukkit.getOnlinePlayers().size, 11)
        ScoreAPI.addLine("", 10)
        ScoreAPI.addLine("§7myserver.com.br", 9)
        if (p != null) {
            score.setScoreBoard(p)
        }
    }
}