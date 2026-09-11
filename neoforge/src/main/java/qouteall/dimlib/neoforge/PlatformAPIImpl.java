package qouteall.dimlib.neoforge;

import net.minecraft.server.level.ServerPlayer;
import net.neoforged.neoforge.network.PacketDistributor;
import qouteall.dimlib.DimLibNetworking;

public class PlatformAPIImpl {
    public static void sendPacket(ServerPlayer player, DimLibNetworking.DimSyncPacket packet) {
        PacketDistributor.sendToPlayer(player, packet);
    }
}
