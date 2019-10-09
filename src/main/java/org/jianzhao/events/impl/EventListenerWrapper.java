package org.jianzhao.events.impl;

import lombok.Data;
import lombok.NonNull;
import org.jianzhao.events.EventListener;

@Data
public class EventListenerWrapper implements EventListener {

    private String type;
    private int times;

    private boolean available = true;
    private EventListener listener;

    public EventListenerWrapper(@NonNull String type,
                                @NonNull EventListener eventListener,
                                int times) {
        this.type = type;
        this.listener = eventListener;
        this.times = times;
    }

    @Override
    public void handle(Object... args) {
        this.listener.handle(args);
    }

}
