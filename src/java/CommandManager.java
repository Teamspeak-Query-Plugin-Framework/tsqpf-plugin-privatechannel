import com.github.theholywaffle.teamspeak3.*;
import com.github.theholywaffle.teamspeak3.api.*;
import com.github.theholywaffle.teamspeak3.api.event.*;

import java.util.*;

public class CommandManager {

    public void evaluateCommand(TextMessageEvent textMessageEvent, TS3Api api) {
        String[] command = textMessageEvent.getMessage().split(" ");

        if (command[0].equals("!channel")) {
            if (command.length >= 2) {

                // Update -> Add channel description

                HashMap<ChannelProperty, String> channelProperties = new HashMap<>();
                channelProperties.put(ChannelProperty.CHANNEL_FLAG_TEMPORARY, "1");
                channelProperties.put(ChannelProperty.CHANNEL_DELETE_DELAY, "0");
                channelProperties.put(ChannelProperty.CHANNEL_DESCRIPTION, "This is a private channel. You need to ask the channels owner for the password.");
                channelProperties.put(ChannelProperty.CHANNEL_CODEC_QUALITY, "6");
                channelProperties.put(ChannelProperty.CHANNEL_PASSWORD, command[1]);
                channelProperties.put(ChannelProperty.CPID, "1");

                int newChannelId = api.createChannel(textMessageEvent.getInvokerName() + "'s Private Channel", channelProperties);
                api.sendPrivateMessage(textMessageEvent.getInvokerId(), "Private channel created. Moving you now...");
                api.moveClient(textMessageEvent.getInvokerId(), newChannelId);
                api.moveClient(api.whoAmI().getId(), 1);

            } else {
                // Print Syntax Header
                api.sendPrivateMessage(textMessageEvent.getInvokerId(), "Incorrect syntax: !channel <password>");
            }
        }
    }

}
