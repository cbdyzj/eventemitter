package org.jianzhao.events;

import org.jianzhao.events.impl.DefaultEventEmitter;
import org.junit.jupiter.api.Test;

class EventEmitterTest {
    @Test
    void test() {

        EventEmitter emitter = new DefaultEventEmitter();
        EventListener listener = args -> {
            System.out.println("hello listener");
        };
        emitter.on("hello", listener);
    }
}
