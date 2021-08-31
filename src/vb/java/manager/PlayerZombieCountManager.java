package vb.java.manager;

import vb.java.ZombieCount;
import vb.java.struck.PlayerZombieCount;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class PlayerZombieCountManager
{
    private static PlayerZombieCountManager instance;

    private final List<PlayerZombieCount> playerZombieCountList = new ArrayList<>();

    public static PlayerZombieCountManager getInstance()
    {
        return instance;
    }

    File configFile;

    public PlayerZombieCountManager()
    {
        instance = this;
        loadFile();
    }

    private void loadFile()
    {
        configFile = new File("plugins" + File.separator + ZombieCount.getInstance().getName() + File.separator + "config.yml");
        if (!configFile.exists())
        {
            ZombieCount.getInstance().getLogger().info("Creating config ...");
            ZombieCount.getInstance().saveDefaultConfig();
        }
        try
        {
            ZombieCount.getInstance().getConfig().load(configFile);
        }
        catch (Exception e)
        {
            ZombieCount.getInstance().getLogger().severe("Could not load the config! Error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void loadPlayer(UUID player)
    {
        if (playerExist(player))
        {
            playerZombieCountList.add(getPlayerData(player));
        }
        else
        {
            playerZombieCountList.add(createPlayerData(player));
        }
    }

    public void unloadPlayer(UUID player)
    {
        PlayerZombieCount pzc = getPlayer(player);
        if (pzc !=null)
        {
            savePlayerData(player);
            playerZombieCountList.remove(pzc);
        }
    }

    private boolean playerExist(UUID player)
    {
        return ZombieCount.getInstance().getConfig().isConfigurationSection("player."+ player);
    }

    private PlayerZombieCount getPlayerData(UUID player)
    {
        return new PlayerZombieCount(player,ZombieCount.getInstance().getConfig().getInt("player."+ player +".count"));
    }

    private void savePlayerData(UUID player)
    {
        ZombieCount.getInstance().getConfig().set("player."+ player +".count",getPlayer(player).getCount());
        try
        {
            ZombieCount.getInstance().getConfig().save(configFile);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    private PlayerZombieCount createPlayerData(UUID player)
    {
        ZombieCount.getInstance().getConfig().createSection("player."+ player +".count");
        ZombieCount.getInstance().getConfig().set("player."+ player +".count", 0);
        try
        {
            ZombieCount.getInstance().getConfig().save(configFile);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return new PlayerZombieCount(player,0);
    }

    public void addCount(UUID player, int count)
    {
        PlayerZombieCount pzc = getPlayer(player);
        if (pzc !=null)
        {
            pzc.addCount(count);
        }
    }

    public void removeCount(UUID player, int count)
    {
        PlayerZombieCount pzc = getPlayer(player);
        if (pzc !=null)
        {
            pzc.removeCount(count);
        }
    }

    public void setCount(UUID player, int count)
    {
        PlayerZombieCount pzc = getPlayer(player);
        if (pzc !=null)
        {
            pzc.setCount(count);
        }
    }

    public PlayerZombieCount getPlayer(UUID player)
    {
        for (PlayerZombieCount pzc : playerZombieCountList)
        {
            if (player.equals(pzc.getPlayer()))
            {
                return pzc;
            }
        }
        return null;
    }
}
