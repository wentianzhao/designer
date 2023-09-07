package com.wen.designer.factory.simplefactory;

import com.wen.designer.factory.factorymethod.RuleConfig;

public interface IRuleConfigParser {

    RuleConfig parse(String text);
}
