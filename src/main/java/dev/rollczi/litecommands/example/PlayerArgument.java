package dev.rollczi.litecommands.example;

import dev.rollczi.litecommands.inject.SingleArgumentHandler;
import dev.rollczi.litecommands.valid.ValidationCommandException;
import dev.rollczi.litecommands.valid.ValidationInfo;
import org.bukkit.Bukkit;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;

import java.util.List;

public class PlayerArgument implements SingleArgumentHandler<Player> {

    @Override
    public Player parse(String argument) throws ValidationCommandException {
        Player player = Bukkit.getPlayer(argument);

        if (player == null) {
            throw new ValidationCommandException(ValidationInfo.CUSTOM, "&cPlayer is offline!");
        }

        return player;
    }

    @Override
    public List<String> tabulation(String command, String[] args) {
        return Bukkit.getOnlinePlayers().stream()
                .map(HumanEntity::getName)
                .toList();
    }

}
