package org.jianzhao.events.impl;

import lombok.NonNull;
import org.jianzhao.events.EventEmitter;
import org.jianzhao.events.EventListener;

import java.util.LinkedHashMap;
import java.util.Map;

public class DefaultEventEmitter implements EventEmitter {

    private Map<String, Map<EventListener, EventListenerWrapper>> listeners = new LinkedHashMap<>();

    @Override
    public EventEmitter addListener(@NonNull String type, @NonNull EventListener listener, int times) {
        EventListenerWrapper wrapper = new EventListenerWrapper(type, listener, times);
        Map<EventListener, EventListenerWrapper> typedListeners = this.listeners.computeIfAbsent(type, k -> new LinkedHashMap<>());
        typedListeners.put(listener, wrapper);
        return this;
    }

    @Override
    public EventEmitter removeListener(@NonNull String type, @NonNull EventListener listener) {
        Map<EventListener, EventListenerWrapper> typedListeners = this.listeners.get(type);
        if (typedListeners != null) {
            typedListeners.remove(listener);
        }
        return this;
    }

    @Override
    public boolean emit(String type, Object... args) {
        Map<EventListener, EventListenerWrapper> typedListeners = this.listeners.get(type);
        for (EventListenerWrapper listener : typedListeners.values()) {
            if (listener.getTimes() == 0) {
                listener.setAvailable(false);
            }
            if (!listener.isAvailable()) {
                continue;
            }
            listener.handle(args);
            if (listener.getTimes() != EventEmitter.ALWAYS) {
                listener.setTimes(listener.getTimes() - 1);
            }
        }
        return true;
    }
}
