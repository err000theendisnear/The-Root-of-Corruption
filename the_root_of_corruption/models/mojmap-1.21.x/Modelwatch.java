// Made with Blockbench 4.12.3
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

public class Modelwatch<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "watch"), "main");
	private final ModelPart bone;
	private final ModelPart bb_main;

	public Modelwatch(ModelPart root) {
		this.bone = root.getChild("bone");
		this.bb_main = root.getChild("bb_main");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition bone = partdefinition.addOrReplaceChild("bone", CubeListBuilder.create().texOffs(0, 0)
				.addBox(-48.0F, -344.0F, -48.0F, 96.0F, 96.0F, 96.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition bb_main = partdefinition.addOrReplaceChild("bb_main", CubeListBuilder.create().texOffs(0, 193)
				.addBox(-48.0F, -16.0F, -48.0F, 96.0F, 16.0F, 96.0F, new CubeDeformation(0.0F)).texOffs(0, 467)
				.addBox(-16.0F, -180.0F, -16.0F, 32.0F, 164.0F, 32.0F, new CubeDeformation(0.0F)).texOffs(0, 306)
				.addBox(-64.0F, -64.0F, -64.0F, 32.0F, 32.0F, 128.0F, new CubeDeformation(0.0F)).texOffs(321, 306)
				.addBox(32.0F, -64.0F, -64.0F, 32.0F, 32.0F, 128.0F, new CubeDeformation(0.0F)).texOffs(385, 0)
				.addBox(-64.0F, -64.0F, 64.0F, 128.0F, 32.0F, 32.0F, new CubeDeformation(0.0F)).texOffs(385, 65)
				.addBox(-64.0F, -64.0F, -96.0F, 128.0F, 32.0F, 32.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 24.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 1024, 1024);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		bone.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		bb_main.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {
	}
}