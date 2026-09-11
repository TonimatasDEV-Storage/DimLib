package qouteall.dimlib;

import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.server.level.ServerPlayer;
import org.apache.commons.lang3.NotImplementedException;

public class PlatformAPI {
    @ExpectPlatform
    public static void sendPacket(ServerPlayer player, DimLibNetworking.DimSyncPacket packet) {
        throw new NotImplementedException("not implemented");
    }
}
