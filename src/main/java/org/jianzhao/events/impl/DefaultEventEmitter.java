package org.jianzhao.events.impl;

import org.jianzhao.events.EventEmitter;
import org.jianzhao.events.EventListener;

public class DefaultEventEmitter implements EventEmitter {


    @Override
    public EventEmitter addListener(String type, EventListener listener, int times) {
        EventListenerWrapper wrapper = new EventListenerWrapper(type, listener, times);
        return this;
    }

    @Override
    public EventEmitter removeListener(String type, EventListener listener) {

        return this;
    }

    @Override
    public boolean emit(String type, Object... args) {
        System.out.println("EventEmitterImpl#emit");
        return true;
    }
}
