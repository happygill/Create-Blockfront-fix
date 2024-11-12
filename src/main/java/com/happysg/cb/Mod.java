package com.happysg.cb;

import com.mojang.logging.LogUtils;
import org.slf4j.Logger;


@net.minecraftforge.fml.common.Mod(Mod.MODID)
public class Mod {
    public static final String MODID = "create_blockfront_fix";
    private static final Logger LOGGER = LogUtils.getLogger();

    public Mod() {
        LOGGER.info("Hello from Create BlockFront Fix!");
    }

}
