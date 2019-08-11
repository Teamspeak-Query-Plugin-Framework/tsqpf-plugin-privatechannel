import net.vortexdata.tsqpf.modules.*;

public class PluginMain extends PluginInterface {


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

}
