package edu.self.eac.lexer.re;

import java.util.ArrayList;

/**
 * Created by xuehui on 15/7/23.
 * 正则表达式定义构成元素——产生式
 */
public class ReProduction implements IReElement {
    public ReProduction(String name, String redefinition) {
        _name = name;
        _redefinition = redefinition;
        _elementList = new ArrayList<>();
    }

    public String getName() {
        return _name;
    }

    public ArrayList<IReElement> getElementList() {
        return _elementList;
    }

    public void setElementList(ArrayList<IReElement> list) {
        _elementList = list;
    }

    private String _name;
    private String _redefinition;
    private ArrayList<IReElement> _elementList;
}
