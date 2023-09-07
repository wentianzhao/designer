package com.wen.designer.factory.simplefactory;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @program: designer
 * @description: 结合单例模式的，简单工厂模式
 * @author: wentz
 * @create: 2023-09-07 11:56
 **/
public class RuleConfigParserFactory {

    private static final ConcurrentHashMap<String, IRuleConfigParser> cachedParsers = new ConcurrentHashMap<>();

    static {
        cachedParsers.put("json", new JsonRuleConfigParser());
        cachedParsers.put("xml", new RuleConfigParser());
        cachedParsers.put("yaml", new RuleConfigParser());
        cachedParsers.put("properties", new RuleConfigParser());
    }

    public static IRuleConfigParser createParser(String configFormat) {
        if (configFormat == null || configFormat.isEmpty()) {
            return null;
        }

        IRuleConfigParser parser = cachedParsers.get(configFormat);
        return parser;

    }

}
