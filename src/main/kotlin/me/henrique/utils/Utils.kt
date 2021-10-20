package me.henrique.utils

import me.henrique.utils.commands.UtilCommand
import org.bukkit.Bukkit
import org.bukkit.plugin.java.JavaPlugin

class Utils : JavaPlugin() {

    override fun onEnable() {
        getCommand("util").setExecutor(UtilCommand())
        Bukkit.getConsoleSender().sendMessage("§aPlugin ligado.")
        super.onEnable()
    }

    override fun onDisable() {
        Bukkit.getConsoleSender().sendMessage("§cPlugin desligado.")
        super.onDisable()
    }
}

internal fun instance(): Utils = JavaPlugin.getPlugin(Utils::class.java)