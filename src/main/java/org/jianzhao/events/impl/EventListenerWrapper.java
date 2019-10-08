package org.jianzhao.events.impl;

import org.jianzhao.events.EventListener;

public class EventListenerWrapper implements EventListener {

    int id;
    private String type;
    private EventListener delegate;
    private int times;
    private boolean available = true;

    public EventListenerWrapper(String type,
                                EventListener eventListener,
                                int times) {
        this.id = eventListener.hashCode();
        this.type = type;
        this.delegate = eventListener;
        this.times = times;
    }

    @Override
    public void handle(Object... args) {
        this.delegate.handle(args);
    }

}
