package edu.self.eac.lexer.dfa.gen;

import edu.self.eac.lexer.nfa.state.NfaState;

import java.util.HashSet;

/**
 * Created by xuehui on 15/8/6.
 */
public class DfaTransTableItem {
    public DfaTransTableItem(HashSet<NfaState> currentStateSet, String inputChar, HashSet<NfaState> nextStateSet) {
        _currentStateSet = currentStateSet;
        _inputChar = inputChar;
        _nextStateSet = nextStateSet;
    }

    public HashSet<NfaState> getCurrentStateSet() {
        return _currentStateSet;
    }

    public String getInputChar() {
        return _inputChar;
    }

    public HashSet<NfaState> getNextStateSet() {
        return _nextStateSet;
    }

    private HashSet<NfaState> _currentStateSet;
    private String _inputChar;
    private HashSet<NfaState> _nextStateSet;
}
