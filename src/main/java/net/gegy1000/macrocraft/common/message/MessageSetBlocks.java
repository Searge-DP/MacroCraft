package net.gegy1000.macrocraft.common.message;

import io.netty.buffer.ByteBuf;
import net.gegy1000.macrocraft.common.entity.EntitySpaceship;
import net.gegy1000.macrocraft.common.entity.SpaceshipBlockContainer;
import net.ilexiconn.llibrary.common.message.AbstractMessage;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.BlockPos;

import java.util.HashMap;
import java.util.Map;

public class MessageSetBlocks extends AbstractMessage<MessageSetBlocks>
{
    private Map<BlockPos, SpaceshipBlockContainer> blocks = new HashMap<BlockPos, SpaceshipBlockContainer>();
    private int entityId;

    public MessageSetBlocks() {}

    public MessageSetBlocks(EntitySpaceship spaceship)
    {
        this.blocks = spaceship.getBlocks();
        this.entityId = spaceship.getEntityId();
    }

    @Override
    public void handleClientMessage(MessageSetBlocks message, EntityPlayer player)
    {
        handleMessage(player);
    }

    @Override
    public void handleServerMessage(MessageSetBlocks message, EntityPlayer player)
    {
        handleMessage(player);
    }

    private void handleMessage(EntityPlayer player)
    {
        Entity entity = player.worldObj.getEntityByID(entityId);

        if (entity instanceof EntitySpaceship)
        {
            EntitySpaceship spaceship = (EntitySpaceship) entity;

            spaceship.setBlocks(blocks);
        }
    }

    @Override
    public void fromBytes(ByteBuf buf)
    {
        int count = buf.readInt();

        entityId = buf.readInt();

        for (int i = 0; i < count; i++)
        {
            BlockPos pos = BlockPos.fromLong(buf.readLong());
            SpaceshipBlockContainer container = new SpaceshipBlockContainer(null);
            container.fromBytes(buf);

            blocks.put(pos, container);
        }
    }

    @Override
    public void toBytes(ByteBuf buf)
    {
        buf.writeInt(blocks.size());
        buf.writeInt(entityId);

        for (Map.Entry<BlockPos, SpaceshipBlockContainer> entry : blocks.entrySet())
        {
            buf.writeLong(entry.getKey().toLong());
            entry.getValue().toBytes(buf);
        }
    }
}
