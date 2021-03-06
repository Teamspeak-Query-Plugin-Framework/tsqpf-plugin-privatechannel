package net.vortexdata.tsqpf_plugin_privatechannel;

import net.vortexdata.tsqpf.plugins.*;

public class PrivateChannel extends TeamspeakPlugin {

    private ConfigManager configManager;

    @Override
    public void onEnable() {

        // Load the plugins config
        configManager = new ConfigManager(getConfig());
        configManager.load();

        // Register channel command
        registerChatCommand(new ChannelCommand(getAPI(), configManager), "!channel");

        // Inform user that the plugin has been loaded.
        getLogger().printInfo("PrivateChannel loaded.");
    }

    @Override
    public void onDisable() {
        getLogger().printInfo("PrivateChannel disabled.");
    }

}