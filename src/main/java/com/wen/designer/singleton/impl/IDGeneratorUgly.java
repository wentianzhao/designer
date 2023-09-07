package com.wen.designer.singleton.impl;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @program: designer
 * @description: 饿汉模式，先生成，线程安全，但不支持延迟加载
 * @author: wentz
 * @create: 2023-09-05 16:47
 **/
public class IDGeneratorUgly {

    private AtomicLong id = new AtomicLong();

    private static final IDGeneratorUgly instance = new IDGeneratorUgly();

    private IDGeneratorUgly(){}

    public static IDGeneratorUgly getInstance() {
        return instance;
    }

    public long getId() {
        return id.incrementAndGet();
    }


}
