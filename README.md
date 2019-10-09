# EventEmitter

[![Release](https://jitpack.io/v/cbdyzj/eventemitter.svg)](https://jitpack.io/#cbdyzj/eventemitter)

EventEmitter for Java

## Sample

```java
package org.jianzhao.events;

import org.jianzhao.events.impl.DefaultEventEmitter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EventEmitterTest {

    @Test
    void test() {
        EventEmitter emitter = new DefaultEventEmitter();
        emitter.on("data", args -> {
            String[] expected = { "0", "1" };
            Assertions.assertArrayEquals(expected, args);
        });
        emitter.emit("0", "1");
    }
}
```
