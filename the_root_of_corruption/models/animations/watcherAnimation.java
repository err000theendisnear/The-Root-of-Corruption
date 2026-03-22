// Save this class in your mod and generate all required imports

/**
 * Made with Blockbench 4.12.3 Exported for Minecraft version 1.19 or later with
 * Mojang mappings
 * 
 * @author Author
 */
public class watcherAnimation {
	public static final AnimationDefinition animation = AnimationDefinition.Builder.withLength(0.75F)
			.addAnimation("bone",
					new AnimationChannel(AnimationChannel.Targets.ROTATION,
							new Keyframe(0.0F, KeyframeAnimations.degreeVec(90.0F, 0.0F, 0.0F),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.75F, KeyframeAnimations.degreeVec(-74.8987F, 0.0F, -5.0733F),
									AnimationChannel.Interpolations.LINEAR)))
			.build();
}