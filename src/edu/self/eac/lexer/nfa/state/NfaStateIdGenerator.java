package edu.self.eac.lexer.nfa.state;

/**
 * Created by xuehui on 15/7/20.
 */
public class NfaStateIdGenerator {
    public static String getNewId() {
        return String.valueOf(++_id);
    }
    private static int _id = 0;
}
