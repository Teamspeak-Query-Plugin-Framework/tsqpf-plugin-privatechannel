import com.github.theholywaffle.teamspeak3.*;
import com.github.theholywaffle.teamspeak3.api.*;
import com.github.theholywaffle.teamspeak3.api.event.*;

import java.util.*;

public class CommandManager {

    ConfigManager configManager;

    public CommandManager(ConfigManager configManager) {
        this.configManager = configManager;
    }

    public void evaluateCommand(TextMessageEvent textMessageEvent, TS3Api api) {
        String[] command = textMessageEvent.getMessage().split(" ");

        if (command[0].equals("!channel")) {
            if (command.length >= 2) {

                HashMap<ChannelProperty, String> channelProperties = new HashMap<>();
                channelProperties.put(ChannelProperty.CHANNEL_FLAG_TEMPORARY, "1");
                channelProperties.put(ChannelProperty.CHANNEL_DELETE_DELAY, configManager.getValue("channelPrivateDeleteDelay"));
                channelProperties.put(ChannelProperty.CHANNEL_DESCRIPTION, configManager.getValue("channelPrivateDescription"));
                channelProperties.put(ChannelProperty.CHANNEL_CODEC_QUALITY, configManager.getValue("channelPrivateCodecQuality"));
                channelProperties.put(ChannelProperty.CHANNEL_PASSWORD, command[1]);
                channelProperties.put(ChannelProperty.CPID, configManager.getValue("channelPrivateParentId"));

                try {
                    int newChannelId = api.createChannel(textMessageEvent.getInvokerName() + " " + configManager.getValue("channelPrivateName"), channelProperties);
                    api.sendPrivateMessage(textMessageEvent.getInvokerId(), configManager.getValue("messageChannelCreationSuccess"));
                    api.moveClient(textMessageEvent.getInvokerId(), newChannelId);
                    // Move API back to default channel
                    api.moveClient(api.whoAmI().getId(), 1);
                } catch (Exception e) {
                    api.sendPrivateMessage(textMessageEvent.getInvokerId(), configManager.getValue("messageChannelCreationFailedExisting"));
                }


            } else {
                // Print Syntax Header
                api.sendPrivateMessage(textMessageEvent.getInvokerId(), configManager.getValue("messageChannelSyntax"));
            }
        }
    }

}
