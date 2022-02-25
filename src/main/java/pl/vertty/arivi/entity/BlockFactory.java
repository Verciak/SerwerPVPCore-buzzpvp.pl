package pl.vertty.arivi.entity;

import cn.nukkit.Server;
import cn.nukkit.block.Block;
import cn.nukkit.block.BlockUnknown;
import pl.vertty.arivi.Main;

import java.lang.reflect.Constructor;

public final class BlockFactory {
    public static void registerBlock(int id, Class<? extends Block> block) {
        try {
            Block.list[id] = block;
            Block blockInstance = block.newInstance();
            try {
                try {
                    Constructor<? extends Block> constructor = block.getDeclaredConstructor(new Class[] { int.class });
                    constructor.setAccessible(true);
                    for (int data = 0; data < 16; data++) {
                        Block.fullList[id << 4 | data] = constructor
                                .newInstance(new Object[] { Integer.valueOf(data) });
                    }
                    Block.hasMeta[id] = true;
                } catch (NoSuchMethodException ignored) {
                    for (int data = 0; data < 16; data++)
                        Block.fullList[id << 4 | data] = blockInstance;
                }
            } catch (Exception e) {
                Server.getInstance().getLogger()
                        .error("[Block] Failed to register block (ID: " + id + "): " + block.getSimpleName(), e);
                for (int data = 0; data < 16; data++)
                    Block.fullList[id << 4 | data] = (Block)new BlockUnknown(id, Integer.valueOf(data));
                return;
            }
            Block.solid[id] = blockInstance.isSolid();
            Block.transparent[id] = blockInstance.isTransparent();
            Block.hardness[id] = blockInstance.getHardness();
            Block.light[id] = blockInstance.getLightLevel();
            if (blockInstance.isSolid()) {
                if (blockInstance.isTransparent()) {
                    if (!(blockInstance instanceof cn.nukkit.block.BlockLiquid) && !(blockInstance instanceof cn.nukkit.block.BlockIce)) {
                        Block.lightFilter[id] = 1;
                    } else {
                        Block.lightFilter[id] = 2;
                    }
                } else {
                    Block.lightFilter[id] = 15;
                }
            } else {
                Block.lightFilter[id] = 1;
            }
            for (int i = 0; i < 15; i++)
                Block.fullList[id << 4 | i] = blockInstance;
        } catch (Exception e) {
            Main.getPlugin().getLogger().error("[Block] Failed to register block (ID: " + id + "): ", e);
        }
    }
}

