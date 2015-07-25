package edu.self.eac.lexer.re;

/**
 * Created by xuehui on 15/7/23.
 * 正则表达式定义构成元素——字母
 */
public class ReAlpha implements IReElement {
    public ReAlpha(char alpha) {
        _alpha = alpha;
    }

    public String getName() {
        return String.valueOf(_alpha);
    }

    public boolean equals(char alpha) {
        return _alpha == alpha;
    }

    public boolean isLetter() {
        return Character.isLetter(_alpha);
    }

    public boolean isDigit() {
        return Character.isDigit(_alpha);
    }

    public boolean isLetterOrDigit() {
        return Character.isLetterOrDigit(_alpha);
    }

    private char _alpha;
}
