package edu.self.eac.lexer.nfa;

/**
 * Created by xuehui on 15/7/19.
 */
public interface INfaNode {
    NfaNodeType getType();
    String getText();
}
