package edu.self.eac.lexer.nfa;

/**
 * Created by xuehui on 15/7/26.
 */
public class NfaEdgeEmptyValue implements INfaEdgeValue {
    public boolean isMatch(char ch) {
        return true;
    }
}
