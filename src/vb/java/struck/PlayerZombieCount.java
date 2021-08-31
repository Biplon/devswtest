package vb.java.struck;

import java.util.UUID;

public class PlayerZombieCount
{
    private final UUID player;

    private int count;

    public UUID getPlayer()
    {
        return player;
    }

    public int getCount()
    {
        return count;
    }

    public void setCount(int count)
    {
        this.count = count;
    }

    public void addCount(int count)
    {
        this.count += count;
    }

    public void removeCount(int count)
    {
        this.count -= count;
    }

    public PlayerZombieCount(UUID player, int count)
    {
        this.player = player;
        this.count = count;
    }
}
