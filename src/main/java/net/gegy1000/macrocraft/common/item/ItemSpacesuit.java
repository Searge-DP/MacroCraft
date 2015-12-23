package net.gegy1000.macrocraft.common.item;

import net.gegy1000.macrocraft.client.model.ModelSpacesuitHelmet;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemSpacesuit extends ItemArmor
{
    private ModelSpacesuitHelmet helmet = new ModelSpacesuitHelmet();

    public ItemSpacesuit(ArmorMaterial material, int armorType)
    {
        super(material, 4, armorType);
    }


    @SideOnly(Side.CLIENT)
    public ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack itemstack, int armorSlot)
    {
        ModelBiped armorModel;

        if (itemstack != null)
        {
            armorModel = armorSlot == 4 ? helmet : null;

            if (armorModel != null)
            {
                armorModel.isSneak = entityLiving.isSneaking();
                armorModel.isRiding = entityLiving.isRiding();
                armorModel.isChild = entityLiving.isChild();
                armorModel.heldItemRight = entityLiving.getEquipmentInSlot(0) != null ? 1 : 0;

                if (entityLiving instanceof EntityPlayer)
                {
                    ItemStack heldItem = entityLiving.getHeldItem();

                    armorModel.aimedBow = ((EntityPlayer) entityLiving).getItemInUseDuration() > 0 && heldItem != null && heldItem.getItemUseAction() == EnumAction.BOW;
                    armorModel.heldItemRight = ((EntityPlayer) entityLiving).getItemInUseDuration() > 0 && heldItem != null && heldItem.getItemUseAction() == EnumAction.BLOCK ? 3 : entityLiving.getEquipmentInSlot(0) != null ? 1 : 0;
                }

                return armorModel;
            }
        }

        return null;
    }

    /**
     * Called by RenderBiped and RenderPlayer to determine the armor texture that
     * should be use for the currently equipped item.
     * This will only be called on instances of ItemArmor.
     *
     * Returning null from this function will use the default value.
     *
     * @param stack ItemStack for the equipped armor
     * @param entity The entity wearing the armor
     * @param slot The slot the armor is in
     * @param type The subtype, can be null or "overlay"
     * @return Path of texture to bind, or null to use default
     */
    public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
    {
        return slot == 1 ? "macrocraft:textures/spacesuit/space_helmet.png" : null;
    }
}
