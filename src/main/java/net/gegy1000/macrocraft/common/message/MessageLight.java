package net.gegy1000.macrocraft.common.message;

import io.netty.buffer.ByteBuf;
import net.gegy1000.macrocraft.common.event.CommonEventHandler;
import net.ilexiconn.llibrary.common.message.AbstractMessage;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;

public class MessageLight extends AbstractMessage<MessageLight> implements IMessage
{
    private boolean shining;

    public MessageLight() {}

    public MessageLight(boolean shining)
    {
        this.shining = shining;
    }

    @Override
    public void handleClientMessage(MessageLight message, EntityPlayer player)
    {

    }

    @Override
    public void handleServerMessage(MessageLight message, EntityPlayer player)
    {
        if (message.shining)
        {
            if (!CommonEventHandler.playersShining.contains(player))
            {
                CommonEventHandler.playersShining.add(player);
            }
        }
        else
        {
            CommonEventHandler.playersShining.remove(player);
        }
    }

    @Override
    public void fromBytes(ByteBuf buf)
    {
        shining = buf.readBoolean();
    }

    @Override
    public void toBytes(ByteBuf buf)
    {
        buf.writeBoolean(shining);
    }
}
