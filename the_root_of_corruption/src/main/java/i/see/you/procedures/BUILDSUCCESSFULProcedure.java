package i.see.you.procedures;

import net.minecraft.world.level.LevelAccessor;

import i.see.you.TheRootOfCorruptionMod;

public class BUILDSUCCESSFULProcedure {
	public static void execute(LevelAccessor world) {
		AlertWindowsProcedure.execute("> Task :jarJar NO-SOURCE", "Executing Gradle task: build");
		TheRootOfCorruptionMod.queueServerWork(20, () -> {
			AlertWindowsProcedure.execute("> Task :processTestResources NO-SOURCE", "Executing Gradle task: build");
			TheRootOfCorruptionMod.queueServerWork(20, () -> {
				AlertWindowsProcedure.execute("> Task :createArtifactManifest UP-TO-DATE", "Executing Gradle task: build");
				TheRootOfCorruptionMod.queueServerWork(20, () -> {
					AlertWindowsProcedure.execute("> Task :createMinecraftArtifacts UP-TO-DATE", "Executing Gradle task: build");
					TheRootOfCorruptionMod.queueServerWork(20, () -> {
						AlertWindowsProcedure.execute("> Task :processResources UP-TO-DATE", "Executing Gradle task: build");
						TheRootOfCorruptionMod.queueServerWork(20, () -> {
							AlertWindowsProcedure.execute("> Task :compileJava UP-TO-DATE", "Executing Gradle task: build");
							TheRootOfCorruptionMod.queueServerWork(20, () -> {
								AlertWindowsProcedure.execute("> Task :classes UP-TO-DATE", "Executing Gradle task: build");
								TheRootOfCorruptionMod.queueServerWork(20, () -> {
									AlertWindowsProcedure.execute("> Task :compileTestJava NO-SOURCE", "Executing Gradle task: build");
									TheRootOfCorruptionMod.queueServerWork(20, () -> {
										AlertWindowsProcedure.execute("> Task :testClasses UP-TO-DATE", "Executing Gradle task: build");
										TheRootOfCorruptionMod.queueServerWork(20, () -> {
											AlertWindowsProcedure.execute("> Task :test NO-SOURCE", "Executing Gradle task: build");
											TheRootOfCorruptionMod.queueServerWork(20, () -> {
												AlertWindowsProcedure.execute("> Task :check UP-TO-DATE", "Executing Gradle task: build");
												TheRootOfCorruptionMod.queueServerWork(20, () -> {
													AlertWindowsProcedure.execute("> Task :jar", "Executing Gradle task: build");
													TheRootOfCorruptionMod.queueServerWork(20, () -> {
														AlertWindowsProcedure.execute("> Task :assemble", "Executing Gradle task: build");
														TheRootOfCorruptionMod.queueServerWork(20, () -> {
															AlertWindowsProcedure.execute("> Task :build", "Executing Gradle task: build");
															TheRootOfCorruptionMod.queueServerWork(50, () -> {
																AlertWindowsProcedure.execute("BUILD SUCCESSFUL", "Executing Gradle task: build");
															});
														});
													});
												});
											});
										});
									});
								});
							});
						});
					});
				});
			});
		});
	}
}
