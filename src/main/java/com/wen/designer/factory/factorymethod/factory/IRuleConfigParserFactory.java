package com.wen.designer.factory.factorymethod.factory;

import com.wen.designer.factory.simplefactory.IRuleConfigParser;

/**
 * 通过接口实现，也就是多态实现，implements
 */
public interface IRuleConfigParserFactory {

    IRuleConfigParser createParser();
}
