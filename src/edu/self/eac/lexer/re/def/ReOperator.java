package edu.self.eac.lexer.re.def;

import edu.self.eac.lexer.re.def.IReElement;

/**
 * Created by xuehui on 15/7/23.
 * 正则表达式定义构成元素——运算符
 */
public class ReOperator implements IReElement {
    public ReOperator(String operator) {
        _operator = operator;
    }

    public String getName() {
        return String.valueOf(_operator);
    }

    public boolean equals(String operator) {
        return _operator.equals(operator);
    }

    private String _operator;
}
