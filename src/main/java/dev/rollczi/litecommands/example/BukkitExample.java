package dev.rollczi.litecommands.example;

import dev.rollczi.litecommands.LiteCommands;
import dev.rollczi.litecommands.bukkit.LiteBukkitFactory;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public final class BukkitExample extends JavaPlugin {

    private LiteCommands liteCommands;

    @Override
    public void onEnable() {
        liteCommands = LiteBukkitFactory.builder(this.getServer(), "my-example-plugin")
                .argument(Player.class, new PlayerArgument())
                .bind(Player.class, new PlayerSenderBind())
                .command(ExampleCommand.class)
                .register();
    }

    @Override
    public void onDisable() {
        this.liteCommands.getPlatformManager().unregisterCommands();
    }
}
