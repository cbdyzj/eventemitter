package org.jianzhao.events;

import org.jianzhao.events.impl.DefaultEventEmitter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EventEmitterTest {

    @Test
    void test() {
        EventEmitter emitter = new DefaultEventEmitter();
        emitter.on("data", data -> {
            Assertions.assertEquals(17, data);
        });
        emitter.emit("data", 17);
    }
}
