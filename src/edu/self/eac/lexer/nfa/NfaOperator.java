package edu.self.eac.lexer.nfa;

/**
 * Created by xuehui on 15/7/19.
 */
public class NfaOperator implements INfaNode {
    public NfaOperator(String text) {
        _text = text;
    }

    public NfaNodeType getNodeType() {
        return NfaNodeType.Operator;
    }

    public String getNodeText() {
        return _text;
    }

    private String _text;
}
