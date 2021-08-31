package vb.java.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import vb.java.manager.PlayerZombieCountManager;

public class OnPlayerJoin implements Listener
{
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event)
    {
        PlayerZombieCountManager.getInstance().loadPlayer(event.getPlayer().getUniqueId());
    }
}
