import com.github.theholywaffle.teamspeak3.api.event.*;
import net.vortexdata.tsqpf.listeners.ChatCommandInterface;
import net.vortexdata.tsqpf.modules.*;

public class PluginMain extends PluginInterface {

    private ConfigManager configManager;

    @Override
    public String getName() {
        return "PrivateChannel";
    }

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

    @Override
    protected void registerChatCommand(ChatCommandInterface cmd, String txt) {
        super.registerChatCommand(cmd, txt);
    }

}