package pl.vertty.arivi.entity;

import cn.nukkit.Player;
import cn.nukkit.block.Block;
import cn.nukkit.block.BlockFire;
import cn.nukkit.block.BlockLiquid;
import cn.nukkit.block.BlockSand;
import cn.nukkit.level.format.FullChunk;
import cn.nukkit.math.BlockFace;
import cn.nukkit.math.Vector3;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FixedSand extends BlockSand
{
    public int onUpdate(final int type) {
        if (type == 1) {
            final BlockFace face;
            final FullChunk chunk;
            final Block down;
            Vector3 position;
            Vector3 blockup;
            int j;
            ArrayList<Block> bo;
            ArrayList<Block> bn;
            Block block;
            int i;
            Vector3 pp;
            Block id;
            Vector3 bp;
            Block b;
            Player[] players;
                face = BlockFace.DOWN;
                chunk = this.getChunk();
                down = this.getBlock(chunk, this.getFloorX() + face.getXOffset(), this.getFloorY() + face.getYOffset(), this.getFloorZ() + face.getZOffset());
                if (this.canFall(chunk, (Vector3)down.getLocation()) && this.getFloorY() >= 0) {
                    chunk.setBlockId(this.getFloorX() & 0xF, this.getFloorY(), this.getFloorZ() & 0xF, 0);
                    for (position = (Vector3)this.down(); this.canFall(chunk, position) && position.getY() > 0.0; position = position.down()) {}
                    blockup = position.up();
                    chunk.setBlockId(blockup.getFloorX() & 0xF, blockup.getFloorY(), blockup.getFloorZ() & 0xF, this.getId());
                    j = 1;
                    bo = new ArrayList<Block>(Collections.singletonList(Block.get(0, this.level, this.getFloorX(), this.getFloorY(), this.getFloorZ())));
                    bn = new ArrayList<Block>();
                    block = Block.get(this.getId());
                    block.setLevel(this.level);
                    block.setComponents(blockup.getX(), blockup.getY(), blockup.getZ());
                    bn.add(block);
                    for (i = 0; i <= 256.0 - this.getY(); ++i) {
                        pp = new Vector3(this.getX(), this.getY() + i, this.getZ());
                        id = this.getBlock(chunk, this.getFloorX(), this.getFloorY() + i, this.getFloorZ());
                        if (id.getId() != 0) {
                            if (id.getId() == 13 || id.getId() == 12 || id.getId() == 145) {
                                bo.add(Block.get(0, this.level, pp.getFloorX(), pp.getFloorY(), pp.getFloorZ()));
                                chunk.setBlockId(pp.getFloorX() & 0xF, pp.getFloorY(), pp.getFloorZ() & 0xF, 0);
                                bp = new Vector3((double)position.up().getFloorX(), (double)(position.up().getFloorY() + j), (double)position.up().getFloorZ());
                                chunk.setBlockId(bp.getFloorX() & 0xF, bp.getFloorY(), bp.getFloorZ() & 0xF, id.getId());
                                b = Block.get(id.getId());
                                b.setComponents(bp.getX(), bp.getY(), bp.getZ()).setLevel(this.level);
                                bn.add(b);
                                ++j;
                            }
                            else {
                                break;
                            }
                        }
                    }
                    players = (Player[])this.level.getChunkPlayers(chunk.getX(), chunk.getZ()).values().toArray(new Player[0]);
                    this.level.sendBlocks(players, (Vector3[])bo.toArray((Vector3[])new Block[0]));
                    this.level.sendBlocks(players, (Vector3[])bn.toArray((Vector3[])new Block[0]));
                }
        }
        return type;
    }

    public boolean canFall(final FullChunk chunk, final Vector3 blockposition) {
        final Block block = this.getBlock(chunk, blockposition.getFloorX(), blockposition.getFloorY(), blockposition.getFloorZ());
        return block.getId() == 0 || block instanceof BlockLiquid || block instanceof BlockFire;
    }

    public Block getBlock(final FullChunk chunk, final int x, final int y, final int z) {
        int fullState;
        if (y >= 0 && y < 256) {
            final int cx = x >> 4;
            final int cz = z >> 4;
            if (chunk != null) {
                fullState = chunk.getFullBlock(x & 0xF, y, z & 0xF);
            }
            else {
                fullState = 0;
            }
        }
        else {
            fullState = 0;
        }
        final Block block = Block.fullList[fullState & 0xFFF].clone();
        block.x = x;
        block.y = y;
        block.z = z;
        block.level = this.level;
        return block;
    }
}
