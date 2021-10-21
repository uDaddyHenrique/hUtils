package me.henrique.utils.spawn

import me.henrique.utils.Utils
import org.bukkit.entity.Player
import org.bukkit.Bukkit
import org.bukkit.Location
import org.bukkit.World
import org.bukkit.plugin.java.JavaPlugin

object SpawnManager {

    fun instance(): Utils = JavaPlugin.getPlugin(Utils::class.java)


    fun setSpawn(p: Player) {

        instance().getConfig().set("Spawn.world", p.location.world.name)
        instance().getConfig().set("Spawn.x", java.lang.Double.valueOf(p.location.x))
        instance().getConfig().set("Spawn.y", java.lang.Double.valueOf(p.location.y))
        instance().getConfig().set("Spawn.z", java.lang.Double.valueOf(p.location.z))
        instance().getConfig().set("Spawn.yaw", java.lang.Double.valueOf(p.location.yaw.toDouble()))
        instance().getConfig().set("Spawn.pitch", java.lang.Double.valueOf(p.location.pitch.toDouble()))
        instance().saveConfig()
    }

    fun getSpawn(p: Player) {
        val w: World = Bukkit.getServer().getWorld(instance().getConfig().getString("Spawn.world")
        )
        val x: Double = instance().getConfig().getDouble("Spawn.x")
        val y: Double = instance().getConfig().getDouble("Spawn.y")
        val z: Double = instance().getConfig().getDouble("Spawn.z")
        val yaw: Float = instance().getConfig().getInt("Spawn.yaw").toFloat()
        val pitch: Float = instance().getConfig().getInt("Spawn.pitch").toFloat()
        p.teleport(Location(w, x, y, z, yaw, pitch))
    }
}