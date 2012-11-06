package no.runsafe.chatblocker;

import no.runsafe.framework.RunsafeConfigurablePlugin;
import no.runsafe.framework.RunsafePlugin;
import no.runsafe.framework.configuration.IConfigurationFile;

import java.io.InputStream;

public class Plugin extends RunsafeConfigurablePlugin
{
	@Override
	protected void PluginSetup()
	{
		this.addComponent(PlayerEvents.class);
	}
}
