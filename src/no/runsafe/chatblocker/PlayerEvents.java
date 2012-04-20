package no.runsafe.chatblocker;

import no.runsafe.framework.configuration.IConfiguration;
import no.runsafe.framework.event.player.IPlayerChatEvent;
import no.runsafe.framework.server.event.player.RunsafePlayerChatEvent;
import no.runsafe.framework.server.player.RunsafePlayer;

public class PlayerEvents implements IPlayerChatEvent
{
    public PlayerEvents(IConfiguration config)
    {
        this.config = config;
    }

    @Override
    public void OnPlayerChatEvent(RunsafePlayerChatEvent runsafePlayerChatEvent)
    {
        if (this.config.getConfigValueAsBoolean("suppressChat"))
        {
            RunsafePlayer thePlayer = runsafePlayerChatEvent.getPlayer();

            if (thePlayer != null)
                if (!thePlayer.hasPermission("chatblocker.suppressionexempt"))
                    runsafePlayerChatEvent.setCancelled(true);
        }
    }

    private IConfiguration config;
}
