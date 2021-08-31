package vb.java.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import vb.java.manager.PlayerZombieCountManager;

public class OnPlayerQuit implements Listener
{
    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event)
    {
        PlayerZombieCountManager.getInstance().unloadPlayer(event.getPlayer().getUniqueId());
    }
}
