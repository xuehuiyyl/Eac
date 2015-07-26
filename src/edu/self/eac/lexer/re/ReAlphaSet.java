package edu.self.eac.lexer.re;

import edu.self.eac.lexer.util.SetRelationType;

import java.util.Hashtable;

/**
 * Created by xuehui on 15/7/23.
 * 正则表达式定义构成元素——字母集
 */
public class ReAlphaSet implements IReElement {
    public ReAlphaSet(String name, String redefinition) {
        _name = name;
        _redefinition = redefinition;
        _initAlphaSet();
    }

    public String getName() {
        return _name;
    }

    public Hashtable<String, String> getValue() {
        return _alphaSet;
    }

    public SetRelationType getSetRel() {
        return _alphaSetRel;
    }

    public boolean contains(String key) {
        return _alphaSet.containsKey(key);
    }

    private void _initAlphaSet() {
        if (!_redefinition.startsWith("[") || !_redefinition.endsWith("]")) {
            throw new Error("字符集：" + _name + "的定义必须以'['开头并且以']'结尾。");
        }

        if (_redefinition.charAt(1) == '^') {
            _alphaSetRel = SetRelationType.NotIn;
        }
        else  {
            _alphaSetRel = SetRelationType.In;
        }

        _alphaSet = new Hashtable<>();

        switch (_redefinition) {
            case "[0-9]":
            case "[9-0]":
            case "[^0-9]":
            case "[^9-0]":
                _alphaSet.put("0", "0");
                _alphaSet.put("1", "1");
                _alphaSet.put("2", "2");
                _alphaSet.put("3", "3");
                _alphaSet.put("4", "4");
                _alphaSet.put("5", "5");
                _alphaSet.put("6", "6");
                _alphaSet.put("7", "7");
                _alphaSet.put("8", "8");
                _alphaSet.put("9", "9");
                break;
            case "[a-z]":
            case "[^a-z]":
                _alphaSet.put("a", "a");
                _alphaSet.put("b", "b");
                _alphaSet.put("c", "c");
                _alphaSet.put("d", "d");
                _alphaSet.put("e", "e");
                _alphaSet.put("f", "f");
                _alphaSet.put("g", "g");
                _alphaSet.put("h", "h");
                _alphaSet.put("i", "i");
                _alphaSet.put("j", "j");
                _alphaSet.put("k", "k");
                _alphaSet.put("l", "l");
                _alphaSet.put("m", "m");
                _alphaSet.put("n", "n");
                _alphaSet.put("o", "o");
                _alphaSet.put("p", "p");
                _alphaSet.put("q", "q");
                _alphaSet.put("r", "r");
                _alphaSet.put("s", "s");
                _alphaSet.put("t", "t");
                _alphaSet.put("u", "u");
                _alphaSet.put("v", "v");
                _alphaSet.put("w", "w");
                _alphaSet.put("x", "x");
                _alphaSet.put("y", "y");
                _alphaSet.put("z", "z");
                break;
            case "[A-Z]":
            case "[^A-Z]":
                _alphaSet.put("A", "A");
                _alphaSet.put("B", "B");
                _alphaSet.put("C", "C");
                _alphaSet.put("D", "D");
                _alphaSet.put("E", "E");
                _alphaSet.put("F", "F");
                _alphaSet.put("G", "G");
                _alphaSet.put("H", "H");
                _alphaSet.put("I", "I");
                _alphaSet.put("J", "J");
                _alphaSet.put("K", "K");
                _alphaSet.put("L", "L");
                _alphaSet.put("M", "M");
                _alphaSet.put("N", "N");
                _alphaSet.put("O", "O");
                _alphaSet.put("P", "P");
                _alphaSet.put("Q", "Q");
                _alphaSet.put("R", "R");
                _alphaSet.put("S", "S");
                _alphaSet.put("T", "T");
                _alphaSet.put("U", "U");
                _alphaSet.put("V", "V");
                _alphaSet.put("W", "W");
                _alphaSet.put("X", "X");
                _alphaSet.put("Y", "Y");
                _alphaSet.put("Z", "Z");
                break;
            case "[a-zA-Z]":
            case "[A-Za-z]":
            case "[^a-zA-Z]":
            case "[^A-Za-z]":
                _alphaSet.put("a", "a");
                _alphaSet.put("b", "b");
                _alphaSet.put("c", "c");
                _alphaSet.put("d", "d");
                _alphaSet.put("e", "e");
                _alphaSet.put("f", "f");
                _alphaSet.put("g", "g");
                _alphaSet.put("h", "h");
                _alphaSet.put("i", "i");
                _alphaSet.put("j", "j");
                _alphaSet.put("k", "k");
                _alphaSet.put("l", "l");
                _alphaSet.put("m", "m");
                _alphaSet.put("n", "n");
                _alphaSet.put("o", "o");
                _alphaSet.put("p", "p");
                _alphaSet.put("q", "q");
                _alphaSet.put("r", "r");
                _alphaSet.put("s", "s");
                _alphaSet.put("t", "t");
                _alphaSet.put("u", "u");
                _alphaSet.put("v", "v");
                _alphaSet.put("w", "w");
                _alphaSet.put("x", "x");
                _alphaSet.put("y", "y");
                _alphaSet.put("z", "z");
                _alphaSet.put("A", "A");
                _alphaSet.put("B", "B");
                _alphaSet.put("C", "C");
                _alphaSet.put("D", "D");
                _alphaSet.put("E", "E");
                _alphaSet.put("F", "F");
                _alphaSet.put("G", "G");
                _alphaSet.put("H", "H");
                _alphaSet.put("I", "I");
                _alphaSet.put("J", "J");
                _alphaSet.put("K", "K");
                _alphaSet.put("L", "L");
                _alphaSet.put("M", "M");
                _alphaSet.put("N", "N");
                _alphaSet.put("O", "O");
                _alphaSet.put("P", "P");
                _alphaSet.put("Q", "Q");
                _alphaSet.put("R", "R");
                _alphaSet.put("S", "S");
                _alphaSet.put("T", "T");
                _alphaSet.put("U", "U");
                _alphaSet.put("V", "V");
                _alphaSet.put("W", "W");
                _alphaSet.put("X", "X");
                _alphaSet.put("Y", "Y");
                _alphaSet.put("Z", "Z");
                break;
            default:
                int start = _alphaSetRel == SetRelationType.In ? 1 : 2;
                for (int i = start; i < _redefinition.length() - 1; ++i) {
                    _alphaSet.put(String.valueOf(_redefinition.charAt(i)), String.valueOf(_redefinition.charAt(i)));
                }
                break;
        }
    }

    private String _name;
    private String _redefinition;
    private Hashtable<String, String> _alphaSet;
    private SetRelationType _alphaSetRel;
}
