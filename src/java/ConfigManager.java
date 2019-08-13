import net.vortexdata.tsqpf.modules.*;

import java.util.*;

public class ConfigManager {

    PluginConfig config;

    public ConfigManager(PluginConfig config) {
        config.setDefault("messageChannelSyntax", "To create a private channel, please use '!channel <password>'");
        config.setDefault("messageChannelCreationSuccess", "Channel created! I'm moving you now...");
        config.setDefault("messageChannelCreationFailedUnknown", "Sorry, but something went wrong. I'm currently unable to create your channel. Please try again later.");
        config.setDefault("messageChannelCreationFailedGroup", "Sorry, but it seems like you don't have permissions to create a private channel.");
        config.setDefault("messageChannelCreationFailedExisting", "Sorry, but something went wrong. Apparently you already have a private channel.");
        config.setDefault("messageChannelCreationDisabled", "Sorry, but channel creation is currently disabled.");
        config.setDefault("channelDefaultId", "1");
        config.setDefault("channelPrivateParentId", "2");
        config.setDefault("channelPrivateName", "Private Channel");
        config.setDefault("channelPrivateDescription", "This is a private channel.");
        config.setDefault("channelPrivateDeleteDelay", "0");
        config.setDefault("channelPrivateCodecQuality", "6");
        this.config = config;
        config.saveAll();
    }

    public void load() {
        config.readAll();
    }

    public String getValue(String key) {
        return config.readValue(key);
    }

}
