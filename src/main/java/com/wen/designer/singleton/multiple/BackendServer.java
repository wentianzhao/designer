package com.wen.designer.singleton.multiple;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @program: designer
 * @description: 多例模式(限制最多3个)
 * @author: wentz
 * @create: 2023-09-06 15:48
 **/
public class BackendServer {

    private long serverNo;
    private String serverAddress;

    private static final int SERVER_COUNT = 3;

    private static final Map<Long, BackendServer> serverInstance = new HashMap<>();

    static {
        serverInstance.put(1L, new BackendServer(1L, ""));
        serverInstance.put(2L, new BackendServer(2L, ""));
        serverInstance.put(3L, new BackendServer(3L, ""));
    }


    private BackendServer(long serverNo, String serverAddress) {
        this.serverNo = serverNo;
        this.serverAddress = serverAddress;
    }

    public static BackendServer getServerInstance(long serverNo) {
        return serverInstance.get(serverNo);
    }

    public static BackendServer getRandomInstance() {
        Random random = new Random();
        int key = random.nextInt(SERVER_COUNT) + 1;
        return serverInstance.get(key);
    }

}
