import com.github.theholywaffle.teamspeak3.api.event.*;
import net.vortexdata.tsqpf.modules.*;

public class PluginMain extends PluginInterface {

    private CommandManager commandManager = new CommandManager();

    @Override
    public String getName() {
        return "PrivateChannel";
    }

    @Override
    public void onEnable() {
        getLogger().printInfo("PrivateChannel enabled.");
        getContainer().getPluginConfig().setDefault("test", "testValue");
    }

    @Override
    public void onDisable() {
        getLogger().printInfo("PrivateChannel disabled.");
    }

    @Override
    public void onTextMessage(TextMessageEvent textMessageEvent) {
        commandManager.evaluateCommand(textMessageEvent, getAPI());
    }

    @Override
    public void onClientJoin(ClientJoinEvent clientJoinEvent) {
        getAPI().sendPrivateMessage(clientJoinEvent.getClientId(), "Hello");
    }
}