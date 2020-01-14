# PrivateChannel
Let your clients create their own private channel.

## 💡 How does it work?

If a user wants to create their own private channel, they only need to open the TSQPF chat window and type in the command "!channel <PASSWORD>". This will then create a new private channel and move them to it.

## 🚀 Gettings started

Just download the latest release that's compatible with your TSQPF version and copy it into its plugin directory. After you've done that, either reload or restart your framework instance in order to get it loaded and initiated.

## ⚙️ Configuration

Here's a list of all config keys, value datatypes and a description:

KEY | DATATYPE | DESCRIPTION

- **messageChannelCreationFailedGroup** : [String] Tells the user, that he does not have permission to create a private channel.
- **messageChannelCreationSuccess** : [String] Tells the user, that their channel has been created.
- **messageChannelCreationFailedUnknown** : [String] Tells the user, that the channel creation failed for an unknwon reason.
- **messageChannelCreationFailedExisting** : [String] Tells the user, that they already own a private channel.
- **messageChannelCreationDisabled** : [String] Tells the user, that channel creation is currently disabled.
- **channelPrivateDeleteDelay** : [Integer] Delete delay in seconds until the channel gets removed (if empty).
- **channelPrivateCodecQuality** : [Integer] Sets the codec quality 1 to 10, 1 being worst, and 10 being best quality.
- **channelPrivateDescription** : [String] Default description of private channel.
- **messageChannelSyntax** : [String] Tells the user, how to create a private channel.
- **channelDefaultId** : [Integer] Id of your servers lobby channel.
- **channelPrivateParentId** : [Integer] ID of parent channel, which all private channel will be sub-channel of.
- **channelPrivateName** : [String] Default name of a private channel (Pattern: Username + "channelPrivateName").


## 📁 Directory Tree

AntiAFK/<br>
└── plugin.conf<br>

## 📜 Vortexdata Certification

This plugin is developed by VortexdataNET for the Teamspeak Query Plugin Framework. Every release is being tested for any bugs, its performance or security issues. You are free to use, modify or redistribute the plugin.
