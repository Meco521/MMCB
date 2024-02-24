package me.meco.core;

import dev.mmcb.api.event.handler.EventManager;
import dev.mmcb.api.event.component.EventTarget;
import me.meco.core.events.TickEvent;

public class Core {
    public static Core instance = new Core();

    public void init() {
        EventManager.register(this);
    }

    @EventTarget
    private void onTick(TickEvent event) {

    }
}
