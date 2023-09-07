package com.wen.designer.singleton.impl;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @program: designer
 * @description: 内部静态类
 * @author: wentz
 * @create: 2023-09-05 16:47
 **/
public class IDGeneratorStatic {

    private AtomicLong id = new AtomicLong();
    private IDGeneratorStatic(){}

    private static class SingletonHolder {
        private static final IDGeneratorStatic instance = new IDGeneratorStatic();
    }

    public static IDGeneratorStatic getInstance() {
        return SingletonHolder.instance;
    }

    public long getId() {
        return id.incrementAndGet();
    }


}
