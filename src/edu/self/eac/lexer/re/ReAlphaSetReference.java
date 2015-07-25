package edu.self.eac.lexer.re;

/**
 * Created by »Ô on 2015/7/25.
 */
public class ReAlphaSetReference implements IReElement {
    public ReAlphaSetReference(String name) {
        _name = name;
    }

    public String getName() {
        return _name;
    }

    private String _name;
}
