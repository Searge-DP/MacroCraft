package net.gegy1000.macrocraft.client.model;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelSpacesuitHelmet extends ModelBiped
{
    public ModelRenderer helmetBase;
    public ModelRenderer helmetFrontBottom;
    public ModelRenderer helmetBackBottom;
    public ModelRenderer helmetFrontMiddle;
    public ModelRenderer helmetFrontTop;
    public ModelRenderer helmetFrontMiddleLeft;
    public ModelRenderer helmetFrontMiddleRight;
    public ModelRenderer helmetFrontBottomLeft;
    public ModelRenderer helmetFrontTopLeft;
    public ModelRenderer helmetLeftMiddle;
    public ModelRenderer helmetLeftBottom;
    public ModelRenderer helmetLeftTop;
    public ModelRenderer cameraLeft;
    public ModelRenderer helmetFrontBottomRight;
    public ModelRenderer helmetFrontTopRight;
    public ModelRenderer helmetRightMiddle;
    public ModelRenderer helmetRightBottom;
    public ModelRenderer helmetRightTop;
    public ModelRenderer cameraRight;
    public ModelRenderer helmetBackMiddle;
    public ModelRenderer helmetBackTop;
    public ModelRenderer helmetBackMiddleRight;
    public ModelRenderer helmetBackMiddleLeft;
    public ModelRenderer oxygenPipeTopLeft;
    public ModelRenderer oxygenPipeTopRight;
    public ModelRenderer helmetTop;
    public ModelRenderer helmetBackBottomRight;
    public ModelRenderer helmetBackTopRight;
    public ModelRenderer helmetBackBottomLeft;
    public ModelRenderer helmetBackTopLeft;
    public ModelRenderer oxygenPipeMiddleLeft;
    public ModelRenderer oxygenPipeBottomLeft;
    public ModelRenderer oxygenPipeMiddleRight;
    public ModelRenderer oxygenPipeBottomRight;

    public ModelSpacesuitHelmet()
    {
        this.textureWidth = 64;
        this.textureHeight = 64;

        this.helmetFrontMiddleRight = new ModelRenderer(this, 0, 9);
        this.helmetFrontMiddleRight.setRotationPoint(-2.5F, -2.0F, 0.5F);
        this.helmetFrontMiddleRight.addBox(-6.0F, -3.0F, 0.0F, 6, 6, 1, 0.0F);
        this.setRotateAngle(helmetFrontMiddleRight, 0.0F, 0.7853981633974483F, 0.0F);
        this.helmetFrontBottom = new ModelRenderer(this, 24, 0);
        this.helmetFrontBottom.setRotationPoint(0.0F, 0.0F, -4.5F);
        this.helmetFrontBottom.addBox(-2.5F, -4.0F, 0.0F, 5, 5, 1, 0.0F);
        this.setRotateAngle(helmetFrontBottom, 0.7740535232594852F, 0.0F, 0.0F);
        this.helmetLeftBottom = new ModelRenderer(this, 42, 14);
        this.helmetLeftBottom.setRotationPoint(3.0F, 3.0F, 0.0F);
        this.helmetLeftBottom.addBox(-3.0F, 0.0F, 0.0F, 6, 4, 1, 0.0F);
        this.setRotateAngle(helmetLeftBottom, 0.7853981633974483F, 0.0F, 0.0F);
        this.helmetRightTop = new ModelRenderer(this, 28, 22);
        this.helmetRightTop.setRotationPoint(-3.0F, -3.0F, 0.0F);
        this.helmetRightTop.addBox(-3.0F, -4.0F, 0.0F, 6, 4, 1, 0.0F);
        this.setRotateAngle(helmetRightTop, -0.7853981633974483F, 0.0F, 0.0F);
        this.helmetBackTopRight = new ModelRenderer(this, 0, 35);
        this.helmetBackTopRight.setRotationPoint(3.0F, -3.0F, 0.0F);
        this.helmetBackTopRight.addBox(-3.0F, -4.0F, 0.0F, 6, 4, 1, 0.0F);
        this.setRotateAngle(helmetBackTopRight, -0.7853981633974483F, 0.0F, 0.0F);
        this.helmetFrontMiddleLeft = new ModelRenderer(this, 44, 7);
        this.helmetFrontMiddleLeft.setRotationPoint(2.5F, -2.0F, 0.5F);
        this.helmetFrontMiddleLeft.addBox(0.0F, -3.0F, 0.0F, 6, 6, 1, 0.0F);
        this.setRotateAngle(helmetFrontMiddleLeft, 0.0F, -0.7853981633974483F, 0.0F);
        this.helmetLeftTop = new ModelRenderer(this, 0, 16);
        this.helmetLeftTop.setRotationPoint(3.0F, -3.0F, 0.0F);
        this.helmetLeftTop.addBox(-3.0F, -4.0F, 0.0F, 6, 4, 1, 0.0F);
        this.setRotateAngle(helmetLeftTop, -0.7853981633974483F, 0.0F, 0.0F);
        this.helmetRightMiddle = new ModelRenderer(this, 0, 21);
        this.helmetRightMiddle.setRotationPoint(-6.0F, 0.0F, 0.0F);
        this.helmetRightMiddle.addBox(-6.0F, -3.0F, 0.0F, 6, 6, 1, 0.0F);
        this.setRotateAngle(helmetRightMiddle, 0.0F, 0.7853981633974483F, 0.0F);
        this.helmetBackMiddleRight = new ModelRenderer(this, 26, 27);
        this.helmetBackMiddleRight.setRotationPoint(2.5F, -2.0F, 0.5F);
        this.helmetBackMiddleRight.addBox(0.0F, -3.0F, 0.0F, 6, 6, 1, 0.0F);
        this.setRotateAngle(helmetBackMiddleRight, 0.0F, -0.7853981633974483F, 0.0F);
        this.helmetBackMiddleLeft = new ModelRenderer(this, 0, 28);
        this.helmetBackMiddleLeft.setRotationPoint(-2.5F, -2.0F, 0.5F);
        this.helmetBackMiddleLeft.addBox(-6.0F, -3.0F, 0.0F, 6, 6, 1, 0.0F);
        this.setRotateAngle(helmetBackMiddleLeft, 0.0F, 0.7853981633974483F, 0.0F);
        this.helmetFrontTopRight = new ModelRenderer(this, 42, 19);
        this.helmetFrontTopRight.setRotationPoint(-3.0F, -3.0F, 0.0F);
        this.helmetFrontTopRight.addBox(-3.0F, -4.0F, 0.0F, 6, 4, 1, 0.0F);
        this.setRotateAngle(helmetFrontTopRight, -0.7853981633974483F, 0.0F, 0.0F);
        this.helmetBase = new ModelRenderer(this, 0, 0);
        this.helmetBase.setRotationPoint(0.0F, 0.5F, 0.0F);
        this.helmetBase.addBox(-4.0F, 0.0F, -4.0F, 8, 1, 8, 0.0F);
        this.oxygenPipeMiddleRight = new ModelRenderer(this, 0, 55);
        this.oxygenPipeMiddleRight.setRotationPoint(0.0F, 3.0F, 0.0F);
        this.oxygenPipeMiddleRight.addBox(-0.5F, 0.0F, 0.0F, 1, 4, 1, 0.0F);
        this.setRotateAngle(oxygenPipeMiddleRight, 0.7853981633974483F, 0.0F, 0.0F);
        this.helmetFrontBottomRight = new ModelRenderer(this, 28, 17);
        this.helmetFrontBottomRight.setRotationPoint(-3.0F, 3.0F, 0.0F);
        this.helmetFrontBottomRight.addBox(-3.0F, 0.0F, 0.0F, 6, 4, 1, 0.0F);
        this.setRotateAngle(helmetFrontBottomRight, 0.7853981633974483F, 0.0F, 0.0F);
        this.oxygenPipeBottomLeft = new ModelRenderer(this, 10, 45);
        this.oxygenPipeBottomLeft.setRotationPoint(0.0F, 4.0F, 0.0F);
        this.oxygenPipeBottomLeft.addBox(-0.5F, 0.0F, 0.0F, 1, 6, 1, 0.0F);
        this.setRotateAngle(oxygenPipeBottomLeft, 0.7853981633974483F, 0.0F, 0.0F);
        this.helmetBackBottom = new ModelRenderer(this, 36, 0);
        this.helmetBackBottom.setRotationPoint(0.0F, 0.0F, 4.5F);
        this.helmetBackBottom.addBox(-2.5F, -4.0F, 0.0F, 5, 5, 1, 0.0F);
        this.setRotateAngle(helmetBackBottom, 0.7740535232594852F, 3.141592653589793F, 0.0F);
        this.oxygenPipeTopLeft = new ModelRenderer(this, 0, 45);
        this.oxygenPipeTopLeft.setRotationPoint(-1.0F, -5.0F, 1.3F);
        this.oxygenPipeTopLeft.addBox(-0.5F, 0.0F, 0.0F, 1, 3, 1, 0.0F);
        this.setRotateAngle(oxygenPipeTopLeft, -0.7853981633974483F, 0.0F, 0.0F);
        this.helmetBackTop = new ModelRenderer(this, 14, 26);
        this.helmetBackTop.setRotationPoint(0.0F, -5.0F, 2.0F);
        this.helmetBackTop.addBox(-2.5F, -4.0F, -1.0F, 5, 5, 1, 0.0F);
        this.setRotateAngle(helmetBackTop, -0.7853981633974483F, 0.0F, 0.0F);
        this.helmetBackBottomRight = new ModelRenderer(this, 40, 31);
        this.helmetBackBottomRight.setRotationPoint(3.0F, 3.0F, 0.0F);
        this.helmetBackBottomRight.addBox(-3.0F, 0.0F, 0.0F, 6, 4, 1, 0.0F);
        this.setRotateAngle(helmetBackBottomRight, 0.7853981633974483F, 0.0F, 0.0F);
        this.oxygenPipeMiddleLeft = new ModelRenderer(this, 0, 55);
        this.oxygenPipeMiddleLeft.setRotationPoint(0.0F, 3.0F, 0.0F);
        this.oxygenPipeMiddleLeft.addBox(-0.5F, 0.0F, 0.0F, 1, 4, 1, 0.0F);
        this.setRotateAngle(oxygenPipeMiddleLeft, 0.7853981633974483F, 0.0F, 0.0F);
        this.helmetBackTopLeft = new ModelRenderer(this, 44, 36);
        this.helmetBackTopLeft.setRotationPoint(-3.0F, -3.0F, 0.0F);
        this.helmetBackTopLeft.addBox(-3.0F, -4.0F, 0.0F, 6, 4, 1, 0.0F);
        this.setRotateAngle(helmetBackTopLeft, -0.7853981633974483F, 0.0F, 0.0F);
        this.helmetFrontMiddle = new ModelRenderer(this, 48, 0);
        this.helmetFrontMiddle.setRotationPoint(0.0F, -5.0F, 0.3F);
        this.helmetFrontMiddle.addBox(-2.5F, -5.0F, 0.5F, 5, 6, 1, 0.0F);
        this.setRotateAngle(helmetFrontMiddle, -0.7853981633974483F, 0.0F, 0.0F);
        this.helmetTop = new ModelRenderer(this, 6, 34);
        this.helmetTop.setRotationPoint(0.0F, -4.0F, -1.0F);
        this.helmetTop.addBox(-4.0F, 0.0F, 0.0F, 8, 1, 8, 0.0F);
        this.setRotateAngle(helmetTop, 0.7853981633974483F, 0.0F, 0.0F);
        this.helmetLeftMiddle = new ModelRenderer(this, 14, 14);
        this.helmetLeftMiddle.setRotationPoint(6.0F, 0.0F, 0.0F);
        this.helmetLeftMiddle.addBox(0.0F, -3.0F, 0.0F, 6, 6, 1, 0.0F);
        this.setRotateAngle(helmetLeftMiddle, 0.0F, -0.7853981633974483F, 0.0F);
        this.oxygenPipeTopRight = new ModelRenderer(this, 0, 45);
        this.oxygenPipeTopRight.setRotationPoint(1.0F, -5.0F, 1.3F);
        this.oxygenPipeTopRight.addBox(-0.5F, 0.0F, 0.0F, 1, 3, 1, 0.0F);
        this.setRotateAngle(oxygenPipeTopRight, -0.7853981633974483F, 0.0F, 0.0F);
        this.helmetFrontBottomLeft = new ModelRenderer(this, 14, 9);
        this.helmetFrontBottomLeft.setRotationPoint(3.0F, 3.0F, 0.0F);
        this.helmetFrontBottomLeft.addBox(-3.0F, 0.0F, 0.0F, 6, 4, 1, 0.0F);
        this.setRotateAngle(helmetFrontBottomLeft, 0.7853981633974483F, 0.0F, 0.0F);
        this.helmetFrontTopLeft = new ModelRenderer(this, 28, 12);
        this.helmetFrontTopLeft.setRotationPoint(3.0F, -3.0F, 0.0F);
        this.helmetFrontTopLeft.addBox(-3.0F, -4.0F, 0.0F, 6, 4, 1, 0.0F);
        this.setRotateAngle(helmetFrontTopLeft, -0.7853981633974483F, 0.0F, 0.0F);
        this.cameraLeft = new ModelRenderer(this, 30, 45);
        this.cameraLeft.setRotationPoint(2.0F, -2.0F, 0.0F);
        this.cameraLeft.addBox(-3.0F, -0.5F, -1.0F, 3, 2, 1, 0.0F);
        this.helmetFrontTop = new ModelRenderer(this, 32, 6);
        this.helmetFrontTop.setRotationPoint(0.0F, -5.0F, 2.0F);
        this.helmetFrontTop.addBox(-2.5F, -4.0F, -1.0F, 5, 5, 1, 0.0F);
        this.setRotateAngle(helmetFrontTop, -0.7853981633974483F, 0.0F, 0.0F);
        this.helmetRightBottom = new ModelRenderer(this, 14, 21);
        this.helmetRightBottom.setRotationPoint(-3.0F, 3.0F, 0.0F);
        this.helmetRightBottom.addBox(-3.0F, 0.0F, 0.0F, 6, 4, 1, 0.0F);
        this.setRotateAngle(helmetRightBottom, 0.7853981633974483F, 0.0F, 0.0F);
        this.helmetBackMiddle = new ModelRenderer(this, 42, 24);
        this.helmetBackMiddle.setRotationPoint(0.0F, -5.0F, 0.3F);
        this.helmetBackMiddle.addBox(-2.5F, -5.0F, 0.5F, 5, 6, 1, 0.0F);
        this.setRotateAngle(helmetBackMiddle, -0.7853981633974483F, 0.0F, 0.0F);
        this.oxygenPipeBottomRight = new ModelRenderer(this, 10, 45);
        this.oxygenPipeBottomRight.setRotationPoint(0.0F, 4.0F, 0.0F);
        this.oxygenPipeBottomRight.addBox(-0.5F, 0.0F, 0.0F, 1, 6, 1, 0.0F);
        this.setRotateAngle(oxygenPipeBottomRight, 0.7853981633974483F, 0.0F, 0.0F);
        this.helmetBackBottomLeft = new ModelRenderer(this, 30, 36);
        this.helmetBackBottomLeft.setRotationPoint(-3.0F, 3.0F, 0.0F);
        this.helmetBackBottomLeft.addBox(-3.0F, 0.0F, 0.0F, 6, 4, 1, 0.0F);
        this.setRotateAngle(helmetBackBottomLeft, 0.7853981633974483F, 0.0F, 0.0F);
        this.cameraRight = new ModelRenderer(this, 20, 45);
        this.cameraRight.setRotationPoint(2.0F, -2.0F, 0.0F);
        this.cameraRight.addBox(-3.0F, -0.5F, -1.0F, 3, 2, 1, 0.0F);

        this.bipedHead.addChild(helmetBase);

        this.helmetFrontMiddle.addChild(this.helmetFrontMiddleRight);
        this.helmetBase.addChild(this.helmetFrontBottom);
        this.helmetLeftMiddle.addChild(this.helmetLeftBottom);
        this.helmetRightMiddle.addChild(this.helmetRightTop);
        this.helmetBackMiddleRight.addChild(this.helmetBackTopRight);
        this.helmetFrontMiddle.addChild(this.helmetFrontMiddleLeft);
        this.helmetLeftMiddle.addChild(this.helmetLeftTop);
        this.helmetFrontMiddleRight.addChild(this.helmetRightMiddle);
        this.helmetBackMiddle.addChild(this.helmetBackMiddleRight);
        this.helmetBackMiddle.addChild(this.helmetBackMiddleLeft);
        this.helmetFrontMiddleRight.addChild(this.helmetFrontTopRight);
        this.oxygenPipeTopRight.addChild(this.oxygenPipeMiddleRight);
        this.helmetFrontMiddleRight.addChild(this.helmetFrontBottomRight);
        this.oxygenPipeMiddleLeft.addChild(this.oxygenPipeBottomLeft);
        this.helmetBase.addChild(this.helmetBackBottom);
        this.helmetBackMiddle.addChild(this.oxygenPipeTopLeft);
        this.helmetBackMiddle.addChild(this.helmetBackTop);
        this.helmetBackMiddleRight.addChild(this.helmetBackBottomRight);
        this.oxygenPipeTopLeft.addChild(this.oxygenPipeMiddleLeft);
        this.helmetBackMiddleLeft.addChild(this.helmetBackTopLeft);
        this.helmetFrontBottom.addChild(this.helmetFrontMiddle);
        this.helmetBackTop.addChild(this.helmetTop);
        this.helmetFrontMiddleLeft.addChild(this.helmetLeftMiddle);
        this.helmetBackMiddle.addChild(this.oxygenPipeTopRight);
        this.helmetFrontMiddleLeft.addChild(this.helmetFrontBottomLeft);
        this.helmetFrontMiddleLeft.addChild(this.helmetFrontTopLeft);
        this.helmetLeftTop.addChild(this.cameraLeft);
        this.helmetFrontMiddle.addChild(this.helmetFrontTop);
        this.helmetRightMiddle.addChild(this.helmetRightBottom);
        this.helmetBackBottom.addChild(this.helmetBackMiddle);
        this.oxygenPipeMiddleRight.addChild(this.oxygenPipeBottomRight);
        this.helmetBackMiddleLeft.addChild(this.helmetBackBottomLeft);
        this.helmetRightTop.addChild(this.cameraRight);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
        super.render(entity, f, f1, f2, f3, f4, f5);

    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z)
    {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
