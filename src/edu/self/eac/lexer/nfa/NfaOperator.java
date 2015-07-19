package edu.self.eac.lexer.nfa;

/**
 * Created by xuehui on 15/7/19.
 */
public class NfaOperator implements INfaNode {
    public NfaOperator(String text) {
        _text = text;
    }

    public NfaNodeType getType() {
        return NfaNodeType.Operator;
    }

    public String getText() {
        return _text;
    }

    private String _text;
}
