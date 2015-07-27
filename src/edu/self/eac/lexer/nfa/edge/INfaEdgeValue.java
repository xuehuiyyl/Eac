package edu.self.eac.lexer.nfa.edge;

/**
 * Created by xuehui on 15/7/26.
 */
public interface INfaEdgeValue {
    boolean isMatch(char ch);
}
