package qouteall.dimlib.neoforge;

import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.RegisterCommandsEvent;
import net.neoforged.neoforge.event.tick.ServerTickEvent;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import net.neoforged.neoforge.network.registration.HandlerThread;
import net.neoforged.neoforge.network.registration.PayloadRegistrar;
import qouteall.dimlib.DimLib;
import qouteall.dimlib.DimLibNetworking;
import qouteall.dimlib.DimsCommand;
import qouteall.dimlib.ducks.IMinecraftServer;

@EventBusSubscriber(modid = DimLib.MODID)
public class DimLibEvents {
    @SubscribeEvent
    public static void serverTick(ServerTickEvent.Post event) {
        ((IMinecraftServer) event.getServer()).dimlib_processTasks();
    }

    @SubscribeEvent
    public static void registerCommand(RegisterCommandsEvent event) {
        DimsCommand.register(event.getDispatcher());
    }

    @SubscribeEvent
    public static void registerNetworking(RegisterPayloadHandlersEvent event) {
        final PayloadRegistrar registrar = event.registrar("1").executesOn(HandlerThread.MAIN);

        registrar.playToClient(DimLibNetworking.DimSyncPacket.TYPE, DimLibNetworking.DimSyncPacket.CODEC, ((dimSyncPacket, iPayloadContext) -> {
            dimSyncPacket.handle((ClientGamePacketListener) iPayloadContext.listener());
        }));
    }
}
