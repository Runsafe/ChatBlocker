package no.runsafe.chatblocker;

import no.runsafe.framework.configuration.IConfiguration;
import no.runsafe.framework.event.IConfigurationChanged;
import no.runsafe.framework.event.player.IPlayerChatEvent;
import no.runsafe.framework.server.event.player.RunsafePlayerChatEvent;
import no.runsafe.framework.server.player.RunsafePlayer;

public class PlayerEvents implements IPlayerChatEvent, IConfigurationChanged
{
	@Override
	public void OnPlayerChatEvent(RunsafePlayerChatEvent runsafePlayerChatEvent)
	{
		if (suppress)
		{
			RunsafePlayer thePlayer = runsafePlayerChatEvent.getPlayer();

			if (thePlayer != null)
				if (!thePlayer.hasPermission("chatblocker.suppressionexempt"))
					runsafePlayerChatEvent.setCancelled(true);
		}
	}

	@Override
	public void OnConfigurationChanged(IConfiguration configuration)
	{
		suppress = configuration.getConfigValueAsBoolean("suppressChat");
	}

	private boolean suppress;
}
