package edu.self.eac.lexer.dfa.gen;

import edu.self.eac.lexer.nfa.state.NfaState;
import edu.self.eac.lexer.nfa.state.NfaStateType;

import java.util.HashSet;

/**
 * Created by xuehui on 15/8/6.
 */
public class DfaDiagram {
    public DfaDiagram(HashSet<NfaState> initialStateSet, String[] alphabet, DfaTransTable transTable) {
        _initialStateSet = initialStateSet;
        _alphabet = alphabet;
        _transTable = transTable;
    }

    public boolean match(String str) {
        HashSet<NfaState> currStateSet = _initialStateSet;
        for (int index = 0; index < str.length(); ++index) {
            char ch = str.charAt(index);
            if (_inAlphabet(ch)) return false;

            for (DfaTransTableItem item : _transTable.getItemList()) {
                if (item.getCurrentStateSet() == currStateSet && item.getInputChar().indexOf(0) == ch) {
                    currStateSet = item.getNextStateSet();
                    break;
                }
            }
        }
        return _isFinalStateSet(currStateSet);
    }

    private boolean _inAlphabet(char ch) {
        for (String str : _alphabet) {
            if (str.indexOf(0) == ch) return true;
        }
        return false;
    }

    private boolean _isFinalStateSet(HashSet<NfaState> stateSet) {
        for (NfaState state : stateSet) {
            if (state.getType() == NfaStateType.Final)
                return true;
        }
        return false;
    }

    private HashSet<NfaState> _initialStateSet;
    private String[] _alphabet;
    private DfaTransTable _transTable;
}
