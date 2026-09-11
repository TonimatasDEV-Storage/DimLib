package qouteall.dimlib.fabric;

import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.server.level.ServerPlayer;
import qouteall.dimlib.DimLibNetworking;

public class PlatformAPIImpl {
    public static void sendPacket(ServerPlayer player, DimLibNetworking.DimSyncPacket packet) {
        ServerPlayNetworking.send(player, packet);
    }
}
