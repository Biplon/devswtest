package vb.java.befehle;


import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import vb.java.manager.PlayerZombieCountManager;


public class ZombieCountBefehl implements CommandExecutor
{
    @Override
    public boolean onCommand(@SuppressWarnings("NullableProblems") CommandSender commandSender, @SuppressWarnings("NullableProblems") Command command, @SuppressWarnings("NullableProblems") String s, @SuppressWarnings("NullableProblems") String[] args)
    {
        Player player = (Player) commandSender;

        player.sendMessage("Zombies: "+ PlayerZombieCountManager.getInstance().getPlayer(player.getUniqueId()).getCount());

        return true;
    }
}