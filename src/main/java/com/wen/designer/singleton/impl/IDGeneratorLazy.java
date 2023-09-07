package com.wen.designer.singleton.impl;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @program: designer
 * @description: 唯一递增ID号码生成器，串行获取，执行慢
 * @author: wentz
 * @create: 2023-09-05 16:47
 **/
public class IDGeneratorLazy {

    private AtomicLong id = new AtomicLong();

    private static IDGeneratorLazy instance;

    private IDGeneratorLazy(){}

    public static synchronized IDGeneratorLazy getInstance() {
        if (instance == null) {
            instance = new IDGeneratorLazy();
        }
        return instance;
    }

    public long getId() {
        return id.incrementAndGet();
    }


}
