package me.StevenLawson.essentials;

import com.earth2me.essentials.User;
import java.util.logging.Level;
import java.util.logging.Logger;
import me.StevenLawson.TotalFreedomMod.TFM_AdminList;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class ES_Utils
{
	private static final Logger logger = Bukkit.getLogger();

	private ES_Utils()
	{
		throw new AssertionError();
	}

	public static void bcastMsg(String message)
	{
		logger.info(message);

		for (Player player : Bukkit.getOnlinePlayers())
		{
			player.sendMessage(message);
		}
	}

	public static boolean isSuperadmin(CommandSender sender)
	{
		try
		{
			if (Bukkit.getServer().getPluginManager().isPluginEnabled("TotalFreedomMod"))
			{
				return TFM_AdminList.isSuperAdmin(sender);
			}
		}
		catch (Exception ex)
		{
		}

		return false;
	}

	public static CommandSender getSender(User user)
	{
		final CommandSender sender = Bukkit.getConsoleSender();

		final Player player = Bukkit.getPlayer(user.getName());
		if (player != null)
		{
			return player;
		}

		return sender;
	}

	public static void log(Level level, String message)
	{
		logger.log(level, message);
	}
}
