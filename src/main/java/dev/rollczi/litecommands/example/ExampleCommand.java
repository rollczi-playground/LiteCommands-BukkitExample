package dev.rollczi.litecommands.example;

import dev.rollczi.litecommands.annotations.Arg;
import dev.rollczi.litecommands.annotations.Execute;
import dev.rollczi.litecommands.annotations.Permission;
import dev.rollczi.litecommands.annotations.Required;
import dev.rollczi.litecommands.annotations.Section;
import org.bukkit.entity.Player;

@Section(route = "tp")
@Permission("dev.rollczi.tp")
public class ExampleCommand {

    /**
     * command: /tp <player> (check arg count)
     * permission: dev.rollczi.tp
     * sender check and cast to Player
     * argument <player> check and parse to player
     *
     * @param sender instance of sender (only player command)
     * @param player instance from <player> argument
     */

    @Execute @Required(1)
    public void execute(Player sender, @Arg(0) Player player) {
        sender.teleport(player.getLocation());
        sender.sendMessage("teleported to " + player.getName());
    }

}
