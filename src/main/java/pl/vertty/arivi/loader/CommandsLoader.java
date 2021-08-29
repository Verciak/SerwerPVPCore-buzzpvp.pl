// 
// Decompiled by Procyon v0.5.36
// 

package pl.vertty.arivi.loader;

import pl.vertty.arivi.commands.user.*;
import pl.vertty.arivi.guilds.utils.command.CommandManager;
import pl.vertty.arivi.guilds.commands.GuildGlobalCommand;
import pl.vertty.arivi.guilds.commands.user.IncognitoCommand;
import pl.vertty.arivi.guilds.commands.GuildAdminCommand;
import pl.vertty.arivi.guilds.utils.command.ConsoleCommand;
import pl.vertty.arivi.guilds.commands.GuildCommand;
import pl.vertty.arivi.commands.admin.SkrzydlaCommand;
import pl.vertty.arivi.commands.admin.EntityClearCommand;
import pl.vertty.arivi.commands.admin.MotdCommand;
import pl.vertty.arivi.commands.helper.VanishCommand;
import pl.vertty.arivi.commands.helper.UnBanCommand;
import pl.vertty.arivi.commands.helper.TeleportCommand;
import pl.vertty.arivi.commands.admin.StatsCommand;
import pl.vertty.arivi.commands.admin.SetWarpCommand;
import pl.vertty.arivi.commands.admin.SetSpawnCommand;
import pl.vertty.arivi.commands.moderator.OpenCommand;
import pl.vertty.arivi.commands.admin.KickCommand;
import pl.vertty.arivi.commands.headadmin.KickAllCommand;
import pl.vertty.arivi.commands.moderator.ClearItemsCommand;
import pl.vertty.arivi.commands.helper.HealCommand;
import pl.vertty.arivi.commands.helper.GodCommand;
import pl.vertty.arivi.commands.admin.PerformanceCommand;
import pl.vertty.arivi.commands.admin.GamemodeCommand;
import pl.vertty.arivi.commands.helper.FlyCommand;
import pl.vertty.arivi.commands.moderator.DelWarpCommand;
import pl.vertty.arivi.commands.helper.ClearInventoryCommand;
import pl.vertty.arivi.commands.helper.ChatCommand;
import pl.vertty.arivi.commands.moderator.BroadcastCommand;
import pl.vertty.arivi.commands.helper.BanCommand;
import pl.vertty.arivi.commands.moderator.AutoMessageCommand;
import pl.vertty.arivi.commands.admin.GroupCommand;
import pl.vertty.arivi.commands.root.CaseCommand;
import pl.vertty.arivi.commands.root.PandoraCommand;
import pl.vertty.arivi.commands.helper.CheaterCommand;
import pl.vertty.arivi.commands.helper.CzystyCommand;
import pl.vertty.arivi.commands.helper.SprawdzCommand;
import pl.vertty.arivi.commands.root.aItemShopCommand;
import pl.vertty.arivi.commands.admin.BackupCommand;
import pl.vertty.arivi.commands.builder.Command;

public class CommandsLoader
{
    public static void onCommandsLoad() {
        registerCommand(new PingCommand());
        registerCommand(new IgnoreCommand());
        registerCommand(new WorkbenchCommand());
        registerCommand(new EnderchestCommand());
        registerCommand(new PlecakCommand());
        registerCommand(new ReplyCommand());
        registerCommand(new BackupCommand());
        registerCommand(new aItemShopCommand());
        registerCommand(new ItemShopCommand());
        registerCommand(new WyslijCommand());
        registerCommand(new SprawdzCommand());
        registerCommand(new WyslijCommand());
        registerCommand(new PrzyznajesieCommand());
        registerCommand(new CzystyCommand());
        registerCommand(new CheaterCommand());
        registerCommand(new PandoraCommand());
        registerCommand(new TestCommand());
        registerCommand(new CaseCommand());
        registerCommand(new DelHomeCommand());
        registerCommand(new DropCommand());
        registerCommand(new GroupCommand());
        registerCommand(new AutoMessageCommand());
        registerCommand(new BanCommand());
        registerCommand(new BroadcastCommand());
        registerCommand(new ChatCommand());
        registerCommand(new ClearInventoryCommand());
        registerCommand(new DelWarpCommand());
        registerCommand(new FlyCommand());
        registerCommand(new GamemodeCommand());
        registerCommand(new PerformanceCommand());
        registerCommand(new GodCommand());
        registerCommand(new HealCommand());
        registerCommand(new ClearItemsCommand());
        registerCommand(new KickAllCommand());
        registerCommand(new KickCommand());
        registerCommand(new OpenCommand());
        registerCommand(new SetSpawnCommand());
        registerCommand(new SetWarpCommand());
        registerCommand(new StatsCommand());
        registerCommand(new TeleportCommand());
        registerCommand(new UnBanCommand());
        registerCommand(new VanishCommand());
        registerCommand(new MotdCommand());
        registerCommand(new CobblexCommand());
        registerCommand(new HelpopCommand());
        registerCommand(new HomeCommand());
        registerCommand(new OchronaCommand());
        registerCommand(new GraczCommand());
        registerCommand(new RepairCommand());
        registerCommand(new SchowekCommand());
        registerCommand(new TellCommand());
        registerCommand(new KitsCommand());
        registerCommand(new SetHomeCommand());
        registerCommand(new SmietnikCommand());
        registerCommand(new SpawnCommand());
        registerCommand(new TopkiCommand());
        registerCommand(new TpacceptCommand());
        registerCommand(new TpaCommand());
        registerCommand(new TpdenyCommmand());
        registerCommand(new WarpCommand());
        registerCommand(new OsiagnieciaCommand());
        registerCommand(new EntityClearCommand());
        registerCommand(new EfektyCommand());
        registerCommand(new SkrzydlaCommand());
        registerCommand(new CraftingiCommand());
        registerrCommand(new GuildCommand());
        registerrCommand(new GuildAdminCommand());
        registerrCommand(new IncognitoCommand());
        registerrCommand(new GuildGlobalCommand());
    }
    
    public static void registerrCommand(final ConsoleCommand consoleCommand) {
        CommandManager.register(consoleCommand);
    }
    
    public static void registerCommand(final Command command) {
        pl.vertty.arivi.commands.builder.CommandManager.register(command);
    }
}