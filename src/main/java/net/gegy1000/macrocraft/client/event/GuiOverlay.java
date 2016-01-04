package net.gegy1000.macrocraft.client.event;

import net.gegy1000.macrocraft.MacroCraft;
import net.gegy1000.macrocraft.common.item.MacroCraftItems;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.lwjgl.opengl.GL11;

public class GuiOverlay extends Gui
{
    private static final Minecraft mc = Minecraft.getMinecraft();

    @SubscribeEvent
    public void guiOverlay(RenderGameOverlayEvent.Pre event)
    {
        if (!event.isCanceled())
        {
            int width = event.resolution.getScaledWidth();
            int height = event.resolution.getScaledHeight();
            EntityPlayer player = mc.thePlayer;

            if (event.type == RenderGameOverlayEvent.ElementType.HOTBAR)
            {
                GL11.glEnable(GL11.GL_BLEND);
                GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
                GL11.glColor4f(0F, 0F, 0F, 0.15F);

                ItemStack helmet = player.getCurrentArmor(3);

                if (mc.gameSettings.thirdPersonView == 0 && helmet != null && helmet.getItem() == MacroCraftItems.space_helmet)
                {
                    GL11.glDisable(GL11.GL_DEPTH_TEST);
                    GL11.glDepthMask(false);
                    OpenGlHelper.glBlendFunc(770, 771, 1, 0);
                    GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
                    GL11.glDisable(GL11.GL_ALPHA_TEST); // -121.2 degrees TODO battery and light with camera thing also, microphone overlay
                    mc.getTextureManager().bindTexture(new ResourceLocation(MacroCraft.modid, "textures/gui/space_helmet_overlay.png"));
                    Tessellator tessellator = Tessellator.getInstance();
                    WorldRenderer worldRenderer = tessellator.getWorldRenderer();
                    worldRenderer.begin(7, DefaultVertexFormats.POSITION);
                    worldRenderer.pos(0.0D, height, -90.0D).tex(0.0D, 1.0D).endVertex();
                    worldRenderer.pos(width, height, -90.0D).tex(1.0D, 1.0D).endVertex();
                    worldRenderer.pos(width, 0.0D, -90.0D).tex(1.0D, 0.0D).endVertex();
                    worldRenderer.pos(0.0D, 0.0D, -90.0D).tex( 0.0D, 0.0D).endVertex();
                    tessellator.draw();
                    GL11.glDepthMask(true);
                    GL11.glEnable(GL11.GL_DEPTH_TEST);
                    GL11.glEnable(GL11.GL_ALPHA_TEST);
                    GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
                }
            }
            else if (event.type == RenderGameOverlayEvent.ElementType.HEALTH || event.type == RenderGameOverlayEvent.ElementType.FOOD)
            {
                event.setCanceled(true);
            }
        }
    }
}
