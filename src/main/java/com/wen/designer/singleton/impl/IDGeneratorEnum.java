package com.wen.designer.singleton.impl;

import java.util.concurrent.atomic.AtomicLong;

public enum IDGeneratorEnum {

    INSTANCE;

    private AtomicLong id = new AtomicLong();

    public long getId() {
        return id.incrementAndGet();
    }
}
