import net.vortexdata.tsqpf.modules.*;

import java.util.*;

public class ConfigManager {

    HashMap<String, String> defaultValues;
    PluginConfig config;

    public ConfigManager(PluginConfig config) {
        defaultValues = new HashMap<>();
        defaultValues.put("messageChannelSyntax", "To create a private channel, please use to following command: !channel <password>");
        defaultValues.put("messageChannelCreationSuccess", "Channel created! I'm moving you now...");
        defaultValues.put("messageChannelCreationFailedUnknown", "Sorry, but something went wrong. I'm currently unable to create your channel. Please try again later.");
        defaultValues.put("messageChannelCreationFailedGroup", "Sorry, but it seems like you don't have permissions to create a private channel.");
        defaultValues.put("messageChannelCreationFailedExisting", "Sorry, but something went wrong. Apparently you already have a private channel.");
        defaultValues.put("messageChannelCreationDisabled", "Sorry, but channel creation is currently disabled.");
        defaultValues.put("channelDefaultId", "1");
        defaultValues.put("channelPrivateParentId", "2");
        defaultValues.put("channelPrivateName", "Private Channel");
        defaultValues.put("channelPrivateDescription", "This is a private channel.");
        defaultValues.put("channelPrivateDeleteDelay", "0");
        defaultValues.put("channelPrivateCodecQuality", "6");
        this.config = config;
    }

    public void load() {
        config.readAll();
        Object[] defaultKeys = defaultValues.keySet().toArray();

        for (int i = 0; i < defaultKeys.length; i++) {
            if (config.readValue(defaultKeys[i].toString()) == null || config.readValue(defaultKeys[i].toString()).equals("")) {
                createConfig(defaultKeys);
            }
        }
    }

    private void createConfig(Object[] keys) {

        for (int i = 0; i < keys.length; i++) {
            config.setDefault(keys[i].toString(), defaultValues.get(keys[i].toString()));
        }

        config.saveAll();
    }

    public String getValue(String key) {
        return config.readValue(key);
    }

}
