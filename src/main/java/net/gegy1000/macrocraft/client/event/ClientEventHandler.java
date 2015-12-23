package net.gegy1000.macrocraft.client.event;

import net.gegy1000.macrocraft.MacroCraft;
import net.gegy1000.macrocraft.common.item.MacroCraftItems;
import net.gegy1000.macrocraft.common.key.MacroCraftKeyBindings;
import net.gegy1000.macrocraft.common.message.MessageLight;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class ClientEventHandler
{
    private Minecraft mc = Minecraft.getMinecraft();

    private boolean lightKeyDownPrev;

    @SubscribeEvent
    public void onTick(TickEvent.ClientTickEvent event)
    {
        if (mc.thePlayer != null)
        {
            ItemStack helmet = mc.thePlayer.getCurrentArmor(3);

            boolean lightKeyDown = MacroCraftKeyBindings.light.isKeyDown() && helmet != null && helmet.getItem() == MacroCraftItems.space_helmet;

            if (lightKeyDown != lightKeyDownPrev)
            {
                MacroCraft.networkManager.wrapper.sendToServer(new MessageLight(lightKeyDown));
            }

            lightKeyDownPrev = lightKeyDown;
        }
    }
}
