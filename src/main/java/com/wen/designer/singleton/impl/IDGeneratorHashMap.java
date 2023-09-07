package com.wen.designer.singleton.impl;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @program: designer
 * @description: 实现单例模式的线程内唯一（默认是进程唯一的）
 * @author: wentz
 * @create: 2023-09-05 16:47
 **/
public class IDGeneratorHashMap {

    private AtomicLong id = new AtomicLong();

    private static final ConcurrentHashMap<Long, IDGeneratorHashMap> instance = new ConcurrentHashMap<>();

    private IDGeneratorHashMap(){}

    public static IDGeneratorHashMap getInstance() {
        long currentThreadId = Thread.currentThread().getId();
        instance.put(currentThreadId, new IDGeneratorHashMap());
        return instance.get(currentThreadId);
    }

    public long getId() {
        return id.incrementAndGet();
    }


}
