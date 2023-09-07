package com.wen.designer.singleton.lock;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @program: designer
 * @description: 唯一递增ID号码生成器
 * @author: wentz
 * @create: 2023-09-05 16:47
 **/
public class IDGenerator {

    private AtomicLong id = new AtomicLong();

    private static final IDGenerator instance = new IDGenerator();

    private IDGenerator(){}

    public static IDGenerator getInstance() {
        return instance;
    }

    public long getId() {
        return id.incrementAndGet();
    }


}
