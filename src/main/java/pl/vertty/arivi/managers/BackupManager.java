// 
// Decompiled by Procyon v0.5.36
// 

package pl.vertty.arivi.managers;

import java.sql.ResultSet;
import java.sql.SQLException;
import pl.vertty.arivi.guilds.utils.Logger;
import pl.vertty.arivi.Main;
import pl.vertty.arivi.inventory.InventoryMenuHandler;
import pl.vertty.arivi.utils.exception.SkinChangeException;
import java.util.Arrays;
import cn.nukkit.command.CommandSender;
import pl.vertty.arivi.inventory.item.ItemClick;
import pl.vertty.arivi.inventory.item.ItemData;
import pl.vertty.arivi.utils.ChatUtil;
import pl.vertty.arivi.guilds.utils.DataUtil;
import cn.nukkit.item.Item;
import java.util.concurrent.atomic.AtomicInteger;
import pl.vertty.arivi.inventory.InventoryCategory;
import pl.vertty.arivi.inventory.InventoryMenu;
import java.util.Iterator;
import java.util.stream.Collector;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import cn.nukkit.Player;
import cn.nukkit.inventory.PlayerInventory;
import pl.vertty.arivi.objects.Backup;
import java.util.ArrayList;

public class BackupManager
{
    static ArrayList<Backup> backups;
    
    public static void createBackup(final String name, final String killer, final int ping, final PlayerInventory inventory, final int points) {
        final Backup backup = new Backup(name, killer, ping, inventory, points);
        BackupManager.backups.add(backup);
    }
    
    public static ArrayList<Backup> getPlayerBackups(final Player p) {
        ArrayList<Backup> result = new ArrayList<>();
        for (Backup backup : BackupManager.backups) {
            if (backup.getName().equalsIgnoreCase(p.getName())) {
                result.add(backup);
            }
        }
        return result;
    }
    
    public static Backup findTimeToBackup(final long time, final String name) {
        for (final Backup backup : BackupManager.backups) {
            if (backup.getTime() == time && backup.getName().equalsIgnoreCase(name)) {
                return backup;
            }
        }
        return null;
    }
    
    public static void openInventory(final Player p, final Player destiny) {
        final InventoryMenu menu = new InventoryMenu();
        final InventoryCategory category = new InventoryCategory();
        final AtomicInteger slot = new AtomicInteger();
        getPlayerBackups(p).forEach(backup -> {
            Item item = new Item(397, 1, 1);
            item.setCustomName(ChatUtil.fixColor("&7Data zgonu: &9" + DataUtil.getDate(backup.getTime())));
            item.setLore(ChatUtil.fixColor(new String[] { "&7Nick: &9" + backup.getName(), "&7Zabojca: &9" + backup.getKiller(), "&7ID: &9" + backup.getTime(), "&7Ping: &9" + backup.getPing(), "&7Stracone Punkty: &9" + backup.getPoints() }));
            category.addElement(slot.getAndIncrement(), ItemData.fromItem(item), new ItemClick() {
                
                @Override
                public void onClick(final Player player, final Item item) throws SkinChangeException {
                    if (p == null) {
                        ChatUtil.sendMessage(player, "&4Blad: &cGracz jest offline!");
                        return;
                    }
                    final String name = Arrays.stream(item.getLore()).iterator().next().substring(10);
                    final Backup backupp = BackupManager.findTimeToBackup(backup.getTime(), name);
                    if (backupp == null) {
                        return;
                    }
                    backupp.restore(p);
                    ChatUtil.sendMessage(player, "&aPrzywrocono ekwipunek gracza");
                    BackupManager.deleteBackup(backupp);
                }
            });
        });
        menu.setDoubleChest();
        menu.setMainCategory(category);
        menu.addCategory("BackupGUI" + p.getName(), category);
        menu.setName(ChatUtil.fixColor("&9Backup"));
        menu.setOnlyRead(true);
        menu.show(destiny);
        InventoryMenuHandler.registerNewMenu("BackupGUI" + p.getName(), menu);
    }
    
    public static void loadBackups() {
        try {
            final ResultSet rs = Main.getStore().query("SELECT * FROM `{P}backups`");
            while (rs.next()) {
                final Backup backup = new Backup(rs);
                BackupManager.backups.add(backup);
            }
            rs.close();
            Logger.info("Loaded " + BackupManager.backups.size() + " backups");
        }
        catch (SQLException var2) {
            Logger.info("Can not load backups Error " + var2.getMessage());
            var2.printStackTrace();
        }
    }
    
    public static void deleteBackup(final Backup backup) {
        BackupManager.backups.remove(backup);
        Main.getStore().update(false, String.valueOf(new StringBuilder().append("DELETE FROM `{P}backups` WHERE `name` = '").append(backup.getName()).append("'")));
    }
    
    static {
        BackupManager.backups = new ArrayList<Backup>();
    }
}
