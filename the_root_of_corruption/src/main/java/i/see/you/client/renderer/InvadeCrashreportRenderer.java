
package i.see.you.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import i.see.you.entity.InvadeCrashreportEntity;
import i.see.you.client.model.Modelinvade_crash_report;

public class InvadeCrashreportRenderer extends MobRenderer<InvadeCrashreportEntity, Modelinvade_crash_report<InvadeCrashreportEntity>> {
	public InvadeCrashreportRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelinvade_crash_report<InvadeCrashreportEntity>(context.bakeLayer(Modelinvade_crash_report.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(InvadeCrashreportEntity entity) {
		return ResourceLocation.parse("the_root_of_corruption:textures/entities/64px-missing_texture_windows_je2.png");
	}

	@Override
	protected boolean isShaking(InvadeCrashreportEntity entity) {
		return true;
	}
}
