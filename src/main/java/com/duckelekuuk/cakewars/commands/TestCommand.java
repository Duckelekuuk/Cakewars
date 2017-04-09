package com.duckelekuuk.cakewars.commands;

import com.duckelekuuk.cakewars.Cakewars;
import com.duckelekuuk.cakewars.match.GamePlayer;
import com.duckelekuuk.cakewars.match.MatchStatus;
import org.bukkit.command.CommandSender;

@CommandInfo(
        description = "This is the default test command",
        usage = "test",
        aliases = {"test"}
)
public class TestCommand extends AbstractCommand {

    public TestCommand(Cakewars plugin) {
        super(plugin);
    }

    @Override
    protected void onCommand(GamePlayer player, CommandSender sender, String[] args) {
        getPlugin().getGameManager().assignTeam(player, getPlugin().getGameManager().getTeam("BLUE"));

        getPlugin().getGameManager().getTeam("BLUE").setColoredNames();

//        getPlugin().getGameManager().getActiveMatch().startGenerators();
        getPlugin().getGameManager().getActiveMatch().setMatchStatus(MatchStatus.END);
    }
}
