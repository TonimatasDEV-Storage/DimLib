package qouteall.dimlib;

import eu.midnightdust.lib.config.MidnightConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import qouteall.dimlib.config.DimLibConfig;

public class DimLib {
    public static final Logger LOGGER = LoggerFactory.getLogger(DimLib.class);
    public static final String MODID = "dimlib";

    public static void init() {
        LOGGER.info("DimLib initializing");

        DynamicDimensionsImpl.init();
        DimensionTemplate.init();

        MidnightConfig.init(
                MODID, DimLibConfig.class
        );
    }
}
