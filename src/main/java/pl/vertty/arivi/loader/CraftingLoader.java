// 
// Decompiled by Procyon v0.5.36
// 

package pl.vertty.arivi.loader;

import pl.vertty.arivi.utils.ChatUtil;
import cn.nukkit.inventory.Recipe;
import java.util.List;
import java.util.Map;
import cn.nukkit.inventory.ShapedRecipe;
import java.util.Collections;
import cn.nukkit.Server;
import java.util.HashMap;
import cn.nukkit.item.Item;

public class CraftingLoader
{
    public static void onCraftingLoad() {
        onKox();
        onStoniarka();
    }
    
    public static void onKox() {
        final Item applae = Item.get(466);
        final String[] shapeaaaaa = { "GGG", "GAG", "GGG" };
        final Map<Character, Item> ingredientsewa = new HashMap<Character, Item>();
        ingredientsewa.put('G', Item.get(41));
        ingredientsewa.put('A', Item.get(260));
        Server.getInstance().getCraftingManager().registerRecipe((Recipe)new ShapedRecipe(applae, shapeaaaaa, (Map)ingredientsewa, (List)Collections.emptyList()));
        Server.getInstance().getCraftingManager().rebuildPacket();
    }
    
    public static void onStoniarka() {
        final Item applae = Item.get(121);
        applae.setCustomName(ChatUtil.fixColor("&9Stoniarka"));
        applae.setLore(new String[] { ChatUtil.fixColor("&8>> &7Postaw na ziemi!"), ChatUtil.fixColor("&8>> &7nad blokiem pojawi sie stone!") });
        final String[] shapeaaaaa = { "GGG", "GAG", "GGG" };
        final Map<Character, Item> ingredientsewa = new HashMap<Character, Item>();
        ingredientsewa.put('G', Item.get(1));
        ingredientsewa.put('A', Item.get(264));
        Server.getInstance().getCraftingManager().registerRecipe((Recipe)new ShapedRecipe(applae, shapeaaaaa, (Map)ingredientsewa, (List)Collections.emptyList()));
        Server.getInstance().getCraftingManager().rebuildPacket();
    }
}
