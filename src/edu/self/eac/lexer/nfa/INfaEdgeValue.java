package edu.self.eac.lexer.nfa;

/**
 * Created by xuehui on 15/7/26.
 */
public interface INfaEdgeValue {
    boolean isMatch(char ch);
}
