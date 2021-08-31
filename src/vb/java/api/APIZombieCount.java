package vb.java.api;

import vb.java.manager.PlayerZombieCountManager;
import vb.java.struck.PlayerZombieCount;

import java.util.UUID;

public class APIZombieCount
{
    private static APIZombieCount instance;

    public static APIZombieCount getInstance()
    {
        return instance;
    }

    public APIZombieCount()
    {
        instance = this;
    }

    public PlayerZombieCount getZombies(UUID player)
    {
       return PlayerZombieCountManager.getInstance().getPlayer(player);
    }

    public void addZombies(UUID player, int count)
    {
        PlayerZombieCountManager.getInstance().addCount(player, count);
    }

    public void setZombies(UUID player, int count)
    {
        PlayerZombieCountManager.getInstance().setCount(player, count);
    }

    public void removeZombies(UUID player, int count)
    {
        PlayerZombieCountManager.getInstance().removeCount(player, count);
    }
}
