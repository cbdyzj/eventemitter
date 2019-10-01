package org.jianzhao.events;

import org.jianzhao.events.impl.EventEmitterImpl;

import java.lang.reflect.Proxy;

public interface EventEmitter {

    default EventEmitter addListener(String type, EventListener listener, int times) {
        // Implementation required
        return this;
    }

    default EventEmitter addListener(String type, EventListener listener) {
        return this.addListener(type, listener, -1);
    }

    default EventEmitter removeListener(String type, EventListener listener) {
        // Implementation required
        return this;
    }

    default boolean emit(String type, Object... args) {
        // Implementation required
        return true;
    }

    default EventEmitter on(String type, EventListener listener) {
        return this.addListener(type, listener);
    }

    default EventEmitter once(String type, EventListener listener) {
        return this.addListener(type, listener, 1);
    }

    default EventEmitter off(String type, EventListener listener) {
        return this.removeListener(type, listener);
    }

    @SuppressWarnings("unchecked")
    static <T extends EventEmitter> T mixin(T eventEmitter) {
        Class<EventEmitter> clazz = EventEmitter.class;
        EventEmitter impl = new EventEmitterImpl();
        return (T) Proxy.newProxyInstance(clazz.getClassLoader(), new Class[]{clazz}, (proxy, method, args) -> {
            switch (method.getName()) {
                case "emit":
                case "removeListener":
                case "addListener":
                    return method.invoke(impl, args);
                default:
                    return method.invoke(eventEmitter, args);
            }
        });
    }
}
