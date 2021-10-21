package me.henrique.utils.api

import org.bukkit.entity.Player
import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.scoreboard.*

class ScoreAPI(title: String?) {
    private fun teamName(scoreBoard: Scoreboard): String {
        var teamName = "team"
        teamName = teamName + scoreBoard.teams.size + 1
        return teamName
    }

    val scoreBoard: Scoreboard
        get() = Companion.scoreBoard

    fun setScoreBoard(p: Player) {
        p.scoreboard = Companion.scoreBoard
    }

    fun setScoreBoard(vararg p: Player) {
        for (players in p) {
            players.scoreboard = Companion.scoreBoard
        }
    }

    companion object {
        private lateinit var objective: Objective
        private lateinit var scoreBoard: Scoreboard
        fun addLine(text: String, line: Int) {
            var text = text
            val score: Score
            text = if (text.isEmpty()) ChatColor.values()[line].toString() else text
            val lenght = text.length
            if (lenght <= 16) {
                score = objective.getScore(text)
            } else {
                var team = scoreBoard.getTeam(line.toString())
                if (team == null) {
                    team = scoreBoard.registerNewTeam(line.toString())
                }
                team!!.prefix = text.substring(0, 16)
                val entry: String
                if (lenght < 32) {
                    entry = text.substring(16)
                } else {
                    entry = text.substring(16, 32)
                    team.suffix = text.substring(32)
                }
                team.addEntry(entry)
                score = objective.getScore(entry)
            }
            score.score = line
        }
    }

    init {
        Companion.scoreBoard = Bukkit.getScoreboardManager().newScoreboard
        objective = Companion.scoreBoard.registerNewObjective("scoreapi", "dummy")
        objective.displayName = title
        objective.displaySlot = DisplaySlot.SIDEBAR
    }
}