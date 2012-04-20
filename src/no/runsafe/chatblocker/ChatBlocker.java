package no.runsafe.chatblocker;

import no.runsafe.framework.RunsafePlugin;
import no.runsafe.framework.configuration.IConfigurationDefaults;
import no.runsafe.framework.configuration.IConfigurationFile;

import java.io.InputStream;

public class ChatBlocker extends RunsafePlugin implements IConfigurationFile, IConfigurationDefaults
{
    @Override
    protected void PluginSetup()
    {
        this.addComponent(PlayerEvents.class);
    }

    @Override
    public InputStream getDefaultConfiguration()
    {
        return getResource(Constants.DEFAULT_CONFIGURATION_FILE);
    }

    @Override
    public String getConfigurationPath()
    {
        return Constants.CONFIGURATION_FILE;
    }
}
