package com.wen.designer.factory.factorymethod.factory;

import com.wen.designer.factory.factorymethod.factory.IRuleConfigParserFactory;
import com.wen.designer.factory.simplefactory.IRuleConfigParser;
import com.wen.designer.factory.simplefactory.JsonRuleConfigParser;

/**
 * @program: designer
 * @description: Yaml解析
 * @author: wentz
 * @create: 2023-09-07 12:01
 **/
public class YamlRuleConfigParserFactory implements IRuleConfigParserFactory {
    @Override
    public IRuleConfigParser createParser() {
        return new JsonRuleConfigParser();
    }
}
