package net.vortexdata.tsqpf_plugin_privatechannel;

import com.github.theholywaffle.teamspeak3.TS3Api;
import com.github.theholywaffle.teamspeak3.api.ChannelProperty;
import com.github.theholywaffle.teamspeak3.api.event.TextMessageEvent;
import net.vortexdata.tsqpf.listeners.ChatCommandInterface;

import java.util.HashMap;

public class ChannelCommand implements ChatCommandInterface {

    TS3Api api;
    ConfigManager configManager;

    public ChannelCommand(TS3Api api, ConfigManager configManager) {
        this.api = api;
        this.configManager = configManager;
    }

    @Override
    public void gotCalled(TextMessageEvent textMessageEvent) {
        String[] command = textMessageEvent.getMessage().split(" ");

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
                api.moveClient(api.whoAmI().getId(), Integer.parseInt(configManager.getValue("channelDefaultId")));
            } catch (Exception e) {
                api.sendPrivateMessage(textMessageEvent.getInvokerId(), configManager.getValue("messageChannelCreationFailedExisting"));
            }


        } else {
            // Print Syntax Header
            api.sendPrivateMessage(textMessageEvent.getInvokerId(), configManager.getValue("messageChannelSyntax"));
        }

    }

}
