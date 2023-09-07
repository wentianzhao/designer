package com.wen.designer.singleton.impl;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @program: designer
 * @description: 带入参的单例实现
 * @author: wentz
 * @create: 2023-09-05 16:47
 **/
public class SingletonParam {

    private static SingletonParam instance;

    private final int paramA;
    private final int paramB;



    private SingletonParam(int paramA, int paramB){
        this.paramA = paramA;
        this.paramB = paramB;
    }

    public static SingletonParam getInstance(int paramA, int paramB) {
        if (instance != null) {
            throw new RuntimeException("SingletonParam has been created!");
        }
        instance = new SingletonParam(paramA, paramB);
        return instance;
    }

    public static void main(String[] args) {
        SingletonParam instance1 = SingletonParam.getInstance(10, 20);
    }


}
