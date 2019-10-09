package org.jianzhao.events.impl;

import lombok.Data;
import lombok.NonNull;
import org.jianzhao.events.EventListener;

@Data
public class EventListenerWrapper<T> implements EventListener<T> {

    private String type;
    private int times;

    private boolean available = true;
    private EventListener<T> listener;

    public EventListenerWrapper(@NonNull String type,
                                @NonNull EventListener<T> eventListener,
                                int times) {
        this.type = type;
        this.listener = eventListener;
        this.times = times;
    }

    @Override
    public void handle(T parameter) {
        this.listener.handle(parameter);
    }

}
