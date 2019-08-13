import com.github.theholywaffle.teamspeak3.api.event.*;
import net.vortexdata.tsqpf.modules.*;

public class PluginMain extends PluginInterface {

    private CommandManager commandManager;
    private ConfigManager configManager;

    @Override
    public String getName() {
        return "PrivateChannel";
    }

    @Override
    public void onEnable() {

        // Get ConfigManager
        configManager = new ConfigManager(getConfig());
        configManager.load();

        commandManager = new CommandManager(configManager);

        getLogger().printInfo("PrivateChannel loaded.");
    }

    @Override
    public void onDisable() {
        getLogger().printInfo("PrivateChannel disabled.");
    }

    @Override
    public void onTextMessage(TextMessageEvent textMessageEvent) {
        commandManager.evaluateCommand(textMessageEvent, getAPI());
    }
}