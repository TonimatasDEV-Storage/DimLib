package qouteall.dimlib.fabric;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;
import qouteall.dimlib.DimLib;
import qouteall.dimlib.DimLibNetworking;
import qouteall.dimlib.DimsCommand;
import qouteall.dimlib.ducks.IMinecraftServer;

public class DimLibEntry implements ModInitializer {
	@Override
	public void onInitialize() {
		DimLib.init();

		PayloadTypeRegistry.clientboundPlay().register(DimLibNetworking.DimSyncPacket.TYPE, DimLibNetworking.DimSyncPacket.CODEC);
		
		CommandRegistrationCallback.EVENT.register((dispatcher, _, _) -> DimsCommand.register(dispatcher));
		
		ServerTickEvents.END_SERVER_TICK.register(server -> ((IMinecraftServer) server).dimlib_processTasks());
	}
}