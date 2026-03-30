// Made with Blockbench 4.12.6
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

public class ModelUndefined<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "custommodel"), "main");
	private final ModelPart bone;
	private final ModelPart bone2;

	public ModelUndefined(ModelPart root) {
		this.bone = root.getChild("bone");
		this.bone2 = root.getChild("bone2");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition bone = partdefinition.addOrReplaceChild("bone", CubeListBuilder.create().texOffs(0, 0)
				.addBox(-111.0F, -37.0F, -53.0F, 16.0F, 16.0F, 144.0F, new CubeDeformation(0.0F)).texOffs(0, 160)
				.addBox(17.0F, -37.0F, -53.0F, 16.0F, 16.0F, 128.0F, new CubeDeformation(0.0F)).texOffs(288, 288)
				.addBox(-95.0F, -37.0F, -53.0F, 128.0F, 16.0F, 16.0F, new CubeDeformation(0.0F)).texOffs(0, 304)
				.addBox(-95.0F, -37.0F, 75.0F, 128.0F, 16.0F, 16.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-33.0F, 45.0F, 53.0F));

		PartDefinition bone2 = partdefinition.addOrReplaceChild("bone2", CubeListBuilder.create().texOffs(288, 160)
				.addBox(-101.0F, -40.0F, 38.0F, 64.0F, 64.0F, 64.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 24.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 1024, 1024);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		bone.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		bone2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {
	}
}