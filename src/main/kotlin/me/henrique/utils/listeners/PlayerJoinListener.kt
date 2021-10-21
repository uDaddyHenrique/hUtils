package me.henrique.utils.listeners

import me.henrique.utils.scoreboard.Scoreboard.updateScore
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent

class PlayerJoinListener : Listener {
    @EventHandler
    fun onJoin(e: PlayerJoinEvent) {
        updateScore(e.player)
    }
}