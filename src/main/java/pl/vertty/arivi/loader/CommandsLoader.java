// 
// Decompiled by Procyon v0.5.36
// 

package pl.vertty.arivi.loader;

import pl.vertty.arivi.commands.helper.*;
import pl.vertty.arivi.commands.root.*;
import pl.vertty.arivi.commands.user.*;
import pl.vertty.arivi.guilds.utils.command.CommandManager;
import pl.vertty.arivi.guilds.utils.command.ConsoleCommand;
import pl.vertty.arivi.commands.admin.SkrzydlaCommand;
import pl.vertty.arivi.commands.admin.EntityClearCommand;
import pl.vertty.arivi.commands.admin.MotdCommand;
import pl.vertty.arivi.commands.admin.StatsCommand;
import pl.vertty.arivi.commands.admin.SetSpawnCommand;
import pl.vertty.arivi.commands.headadmin.KickAllCommand;
import pl.vertty.arivi.commands.moderator.ClearItemsCommand;
import pl.vertty.arivi.commands.admin.PerformanceCommand;
import pl.vertty.arivi.commands.admin.GamemodeCommand;
import pl.vertty.arivi.commands.moderator.BroadcastCommand;
import pl.vertty.arivi.commands.moderator.AutoMessageCommand;
import pl.vertty.arivi.commands.admin.GroupCommand;
import pl.vertty.arivi.commands.builder.Command;

public class CommandsLoader
{
    public static void onCommandsLoad() {
        registerCommand(new PomocCommand());
        registerCommand(new VIPCommand());
        registerCommand(new sVIPCommand());
        registerCommand(new SponsorCommand());
        registerCommand(new YTCommand());
        registerCommand(new PingCommand());
        registerCommand(new IgnoreCommand());
        registerCommand(new ReplyCommand());
        registerCommand(new aItemShopCommand());
        registerCommand(new ItemShopCommand());
        registerCommand(new WyslijCommand());
        registerCommand(new SprawdzCommand());
        registerCommand(new WyslijCommand());
        registerCommand(new PrzyznajesieCommand());
        registerCommand(new CzystyCommand());
        registerCommand(new CheaterCommand());
        registerCommand(new StopCommand());;
        registerCommand(new GroupCommand());
        registerCommand(new AutoMessageCommand());
        registerCommand(new BanCommand());
        registerCommand(new BroadcastCommand());
        registerCommand(new ChatCommand());
        registerCommand(new ClearInventoryCommand());
        registerCommand(new FlyCommand());
        registerCommand(new GamemodeCommand());
        registerCommand(new PerformanceCommand());
        registerCommand(new GodCommand());
        registerCommand(new HealCommand());
        registerCommand(new ClearItemsCommand());
        registerCommand(new KickAllCommand());
        registerCommand(new SetSpawnCommand());
        registerCommand(new StatsCommand());
        registerCommand(new TeleportCommand());
        registerCommand(new UnBanCommand());
        registerCommand(new VanishCommand());
        registerCommand(new MotdCommand());
        registerCommand(new HelpopCommand());
        registerCommand(new GraczCommand());
        registerCommand(new SchowekCommand());
        registerCommand(new TellCommand());
        registerCommand(new SpawnCommand());
        registerCommand(new TopkiCommand());
        registerCommand(new EntityClearCommand());
        registerCommand(new SkrzydlaCommand());
//        registerrCommand(new IncognitoCommand());
        registerCommand(new KlatkiCommand());
        registerCommand(new ACCommand());
        registerCommand(new EQCommand());
        registerCommand(new MonetyCommand());
        registerCommand(new UstawieniaCommand());
        registerCommand(new SklepCommand());
    }
    
    public static void registerrCommand(final ConsoleCommand consoleCommand) {
        CommandManager.register(consoleCommand);
    }
    
    public static void registerCommand(final Command command) {
        pl.vertty.arivi.commands.builder.CommandManager.register(command);
    }
}
