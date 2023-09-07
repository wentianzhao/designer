package com.wen.designer.factory.factorymethod.factory;

import com.wen.designer.factory.factorymethod.RuleConfig;
import com.wen.designer.factory.factorymethod.factory.IRuleConfigParserFactory;
import com.wen.designer.factory.factorymethod.factory.JsonRuleConfigParserFactory;
import com.wen.designer.factory.simplefactory.IRuleConfigParser;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: designer
 * @description: 因为工厂只包含方法，不包含成员变量，完全可以复用。
 * 不需要每次都创建新的工厂类对象，所以可以用简单工厂模式+单例的模式实现。
 * @author: wentz
 * @create: 2023-09-07 11:57
 **/
public class RuleConfigParserFactoryMap implements IRuleConfigParser {
    private static final Map<String, IRuleConfigParserFactory> cachedFactories = new HashMap<>();

    static{
        cachedFactories.put("json", new JsonRuleConfigParserFactory());
        cachedFactories.put("xml", new JsonRuleConfigParserFactory());
        cachedFactories.put("yaml", new JsonRuleConfigParserFactory());
        cachedFactories.put("properties", new JsonRuleConfigParserFactory());
    }

    public static IRuleConfigParserFactory getParserFactory(String type) {
        if (type == null || type.isEmpty()) {
            return null;
        }
        IRuleConfigParserFactory parserFactory = cachedFactories.get(type);
        return parserFactory;
    }

    @Override
    public RuleConfig parse(String text) {
        return null;
    }
}
