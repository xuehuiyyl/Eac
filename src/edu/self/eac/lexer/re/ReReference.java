package edu.self.eac.lexer.re;

/**
 * Created by �� on 2015/7/25.
 */
public class ReReference implements IReElement {
    public ReReference(String name) {
        _name = name;
    }

    public String getName() {
        return _name;
    }

    private String _name;
}
