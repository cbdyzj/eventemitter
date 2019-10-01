package org.jianzhao.events;

@FunctionalInterface
public interface EventListener {

    void handle(Object... args);
}
