package org.jianzhao.events;

@FunctionalInterface
public interface EventListener<T> {

    void handle(T parameter);
}
