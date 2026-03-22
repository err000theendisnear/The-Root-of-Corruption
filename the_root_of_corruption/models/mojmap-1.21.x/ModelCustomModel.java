// Made with Blockbench 4.12.3
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

public class ModelCustomModel<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "custommodel"), "main");
	private final ModelPart head;
	private final ModelPart bone;

	public ModelCustomModel(ModelPart root) {
		this.head = root.getChild("head");
		this.bone = root.getChild("bone");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition head = partdefinition.addOrReplaceChild("head",
				CubeListBuilder.create().texOffs(0, 65)
						.addBox(-16.0F, -96.0F, 0.0F, 16.0F, 96.0F, 16.0F, new CubeDeformation(0.0F)).texOffs(0, 0)
						.addBox(-31.0F, -148.0F, -6.0F, 32.0F, 32.0F, 32.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition bone = partdefinition.addOrReplaceChild("bone",
				CubeListBuilder.create().texOffs(129, 0)
						.addBox(-37.0F, -54.0F, -9.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(0.0F)).texOffs(65, 98)
						.addBox(-8.0F, -38.0F, 16.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(0.0F)).texOffs(65, 65)
						.addBox(-15.0F, -38.0F, -17.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 24.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 256, 256);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		bone.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {
		this.head.zRot = (Mth.sin(ageInTicks * 0.6F) * 0.6F);
		this.bone.xRot = (Mth.sin(ageInTicks * 0.6F + 3) * 0.6F);
	}
}