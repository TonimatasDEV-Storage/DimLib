package qouteall.dimlib.neoforge;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import qouteall.dimlib.DimLib;

@Mod(DimLib.MODID)
public class DimLibNeoForge {
    public DimLibNeoForge(IEventBus eventBus) {
        DimLib.init();
    }
}