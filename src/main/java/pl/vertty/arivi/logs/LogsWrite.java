// 
// Decompiled by Procyon v0.5.36
// 

package pl.vertty.arivi.logs;

import pl.vertty.arivi.Main;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class LogsWrite
{
    public static void logToFileInv(final String message) {
        try {
            final File dataFolder = Main.getPlugin().getDataFolder();
            if (!dataFolder.exists()) {
                dataFolder.mkdir();
            }
            final File saveTo = new File(Main.getPlugin().getDataFolder(), "data_inv.txt");
            if (!saveTo.exists()) {
                saveTo.createNewFile();
            }
            final FileWriter fw = new FileWriter(saveTo, true);
            final PrintWriter pw = new PrintWriter(fw);
            pw.println(message);
            pw.flush();
            pw.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void logToFileBreak(final String message) {
        try {
            final File dataFolder = Main.getPlugin().getDataFolder();
            if (!dataFolder.exists()) {
                dataFolder.mkdir();
            }
            final File saveTo = new File(Main.getPlugin().getDataFolder(), "data_break.txt");
            if (!saveTo.exists()) {
                saveTo.createNewFile();
            }
            final FileWriter fw = new FileWriter(saveTo, true);
            final PrintWriter pw = new PrintWriter(fw);
            pw.println(message);
            pw.flush();
            pw.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void logToFilePlace(final String message) {
        try {
            final File dataFolder = Main.getPlugin().getDataFolder();
            if (!dataFolder.exists()) {
                dataFolder.mkdir();
            }
            final File saveTo = new File(Main.getPlugin().getDataFolder(), "data_place.txt");
            if (!saveTo.exists()) {
                saveTo.createNewFile();
            }
            final FileWriter fw = new FileWriter(saveTo, true);
            final PrintWriter pw = new PrintWriter(fw);
            pw.println(message);
            pw.flush();
            pw.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void logToFileCommands(final String message) {
        try {
            final File dataFolder = Main.getPlugin().getDataFolder();
            if (!dataFolder.exists()) {
                dataFolder.mkdir();
            }
            final File saveTo = new File(Main.getPlugin().getDataFolder(), "data_commands.txt");
            if (!saveTo.exists()) {
                saveTo.createNewFile();
            }
            final FileWriter fw = new FileWriter(saveTo, true);
            final PrintWriter pw = new PrintWriter(fw);
            pw.println(message);
            pw.flush();
            pw.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
