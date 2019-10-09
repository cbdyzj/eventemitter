# EventEmitter

[![Release](https://jitpack.io/v/cbdyzj/eventemitter.svg)](https://jitpack.io/#cbdyzj/eventemitter)

EventEmitter for Java

## Sample

```java
package org.jianzhao.events;

import lombok.experimental.Delegate;
import org.jianzhao.events.impl.DefaultEventEmitter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TestEventSource implements EventEmitter {

    @Delegate
    private EventEmitter delegateEventEmitter = new DefaultEventEmitter();

    public void source(Object... data) {
        this.emit("data", data);
    }
}

public class EventEmitterTest {

    @Test
    void test() {
        TestEventSource testEventSource = new TestEventSource();
        testEventSource.on("data", args -> {
            String[] expected = { "0", "1" };
            Assertions.assertArrayEquals(expected, args);
        });
        testEventSource.source("0", "1");
    }
}
```
