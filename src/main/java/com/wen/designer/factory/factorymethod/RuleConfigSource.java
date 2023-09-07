package com.wen.designer.factory.factorymethod;

import com.wen.designer.factory.factorymethod.factory.IRuleConfigParserFactory;
import com.wen.designer.factory.factorymethod.factory.RuleConfigParserFactoryMap;
import com.wen.designer.factory.simplefactory.IRuleConfigParser;

import java.util.InvalidPropertiesFormatException;

/**
 * @program: designer
 * @description:
 * @author: wentz
 * @create: 2023-09-07 13:59
 **/
public class RuleConfigSource {

    public RuleConfig load(String ruleConfigFilePath) throws InvalidPropertiesFormatException {

        String ruleConfigFileExtension = getFileExtension(ruleConfigFilePath);

        //从工厂Map中获取当前需要的工厂
        IRuleConfigParserFactory parserFactory = RuleConfigParserFactoryMap.getParserFactory(ruleConfigFileExtension);

        if (parserFactory == null) {
            throw new InvalidPropertiesFormatException("Rule config file format is not support.");
        }

        //获取当前需要的解析类，比如json解析类
        IRuleConfigParser parser = parserFactory.createParser();


        //RuleConfig是解析出来的配置信息
        String configText = "";
        RuleConfig ruleConfig = parser.parse(configText);
        return ruleConfig;
    }

    private String getFileExtension(String filePath) {
        //获取文件后缀名字
        return "json";
    }

    /**
     * 除了设置不同的解析类，还设置了不同解析类的工厂，工厂之上还有个总的单例Map，用来获取工厂
     */
}
