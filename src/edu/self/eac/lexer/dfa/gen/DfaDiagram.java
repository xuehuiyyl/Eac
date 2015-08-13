package edu.self.eac.lexer.dfa.gen;

import edu.self.eac.lexer.nfa.state.NfaState;
import edu.self.eac.lexer.nfa.state.NfaStateType;

import java.util.HashSet;
import java.util.Iterator;

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
            if (!_inAlphabet(ch)) return false;

            for (DfaTransTableItem item : _transTable.getItemList()) {
                char ich = item.getInputChar().charAt(0);
                if (_isEqualSet(item.getCurrentStateSet(), currStateSet) && ich == ch) {
                    currStateSet = item.getNextStateSet();
                    break;
                }
            }
        }
        return _isFinalStateSet(currStateSet);
    }

    private boolean _inAlphabet(char ch) {
        for (String str : _alphabet) {
            if (str.charAt(0) == ch) return true;
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

    private boolean _isEqualSet(HashSet<NfaState> set1, HashSet<NfaState> set2) {
        if (set1.size()==set2.size()){
            Iterator<NfaState> iterator1 = set1.iterator();
            int in = 0;
            while(iterator1.hasNext()){
                NfaState state1 = iterator1.next();
                Iterator<NfaState> iterator2 = set2.iterator();
                while(iterator2.hasNext()) {
                    NfaState state2 = iterator2.next();
                    if (state1.getId().equals(state2.getId())){
                        ++in;
                        break;
                    }
                }
            }
            if (set1.size() == in)return true;
        }
        return false;
    }

    private HashSet<NfaState> _initialStateSet;
    private String[] _alphabet;
    private DfaTransTable _transTable;
}
