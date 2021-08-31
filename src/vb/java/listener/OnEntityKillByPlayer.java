package vb.java.listener;

import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import vb.java.manager.PlayerZombieCountManager;

public class OnEntityKillByPlayer implements Listener
{
    @EventHandler
    public void onEntityKillByPlayer(EntityDeathEvent event)
    {
        if (event.getEntity().getType() == EntityType.ZOMBIE)
        {
            if (event.getEntity().getKiller() != null)
            {
                PlayerZombieCountManager.getInstance().addCount(event.getEntity().getKiller().getUniqueId(),1);
            }
        }
    }
}
