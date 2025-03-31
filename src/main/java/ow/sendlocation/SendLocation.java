package ow.sendlocation;

import org.bukkit.plugin.java.JavaPlugin;

public final class SendLocation extends JavaPlugin {

    @Override
    public void onEnable() {
        System.out.println("OwSendLocation has started.");
        getCommand("sc").setExecutor(new PlayerLocation());
    }

    @Override
    public void onDisable() {
        System.out.println("OwSendLocation has stopped.");
    }
}
