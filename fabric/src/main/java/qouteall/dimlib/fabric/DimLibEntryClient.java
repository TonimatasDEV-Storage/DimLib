package qouteall.dimlib.fabric;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import qouteall.dimlib.DimLibNetworking;

public class DimLibEntryClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ClientPlayNetworking.registerGlobalReceiver(
                DimLibNetworking.DimSyncPacket.TYPE,
                (p, c) -> {
                    // it's now handled in client thread, not networking thread
                    p.handle(c.client().getConnection());
                }
        );
    }
}
