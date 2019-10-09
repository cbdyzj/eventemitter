package org.jianzhao.events;

public interface EventEmitter {

    int ALWAYS = -1;

    EventEmitter addListener(String type, EventListener listener, int times);

    EventEmitter removeListener(String type, EventListener listener);

    boolean emit(String type, Object... args);

    default EventEmitter addListener(String type, EventListener listener) {
        return this.addListener(type, listener, ALWAYS);
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

}
