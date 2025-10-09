package io.github.username.myaddon

import io.github.pylonmc.pylon.core.addon.PylonAddon
import org.bukkit.Material
import org.bukkit.plugin.java.JavaPlugin
import java.util.Locale

@Suppress("unused")
class MyAddon : JavaPlugin(), PylonAddon {

    // Called when our plugin is enabled
    override fun onEnable() {
        _instance = this

        // Every Pylon addon must call this BEFORE doing anything Pylon-related
        registerWithPylon()
    }

    override val javaPlugin: JavaPlugin = this

    override val languages: Set<Locale> = setOf(Locale.ENGLISH)

    override val material: Material = Material.DEAD_BUSH

    companion object {
        // Stores the instance of the addon (there's only ever one)
        private var _instance: MyAddon? = null

        // The public-facing, non-null instance of the addon
        val instance: MyAddon
            get() = _instance ?: throw IllegalStateException("Plugin is not initialized yet")
    }
}
