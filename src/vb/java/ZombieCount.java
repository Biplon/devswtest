package vb.java;

import org.bukkit.event.HandlerList;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import vb.java.api.APIZombieCount;
import vb.java.befehle.ZombieCountBefehl;
import vb.java.listener.*;
import vb.java.manager.PlayerZombieCountManager;

public class ZombieCount extends JavaPlugin
{
    //ZombieCount instance
    private static ZombieCount instance;

    //getter ZombieCount instance
    public static ZombieCount getInstance()
    {
        return instance;
    }

    //on enable create all class instances and reg commands events and co
    @Override
    public void onEnable()
    {
        instance = this;

        new APIZombieCount();

        new PlayerZombieCountManager();

        regEvents();

        regCommands();

    }

    //register all commands and the alias
    @SuppressWarnings("ConstantConditions")
    private void regCommands()
    {
        this.getCommand("zombies").setExecutor(new ZombieCountBefehl());
    }

    //register all event listener
    private void regEvents()
    {
        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(new OnEntityKillByPlayer(), this);
        pm.registerEvents(new OnPlayerQuit(), this);
        pm.registerEvents(new OnPlayerJoin(), this);
    }


    //unregister all event listener
    @Override
    public void onDisable()
    {
        HandlerList.unregisterAll(this);
    }
}