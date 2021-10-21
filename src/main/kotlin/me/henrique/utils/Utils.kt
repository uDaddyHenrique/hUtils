package me.henrique.utils

import me.henrique.utils.commands.*
import me.henrique.utils.listeners.PlayerJoinListener
import org.bukkit.Bukkit
import org.bukkit.plugin.java.JavaPlugin

class Utils : JavaPlugin() {


    override fun onEnable() {
        makeCommands()
        makeListeners()
        Bukkit.getConsoleSender().sendMessage("§aPlugin ligado.")
        super.onEnable()
    }

    override fun onDisable() {
        Bukkit.getConsoleSender().sendMessage("§cPlugin desligado.")
        super.onDisable()
    }
    fun makeCommands(){
        getCommand("gm").executor = GamemodeCommand()
        getCommand("online").executor = OnlineCommand()
        getCommand("ping").executor = PingCommand()
        getCommand("day").executor = DayCommand()
        getCommand("night").executor = NightCommand()
        getCommand("setspawn").executor = SetSpawnCommand()
        getCommand("spawn").executor = SpawnCommand()
    }
    fun makeListeners(){
        var pm = Bukkit.getPluginManager()
        pm.registerEvents(PlayerJoinListener(), this)
    }
}

internal fun instance(): Utils = JavaPlugin.getPlugin(Utils::class.java)