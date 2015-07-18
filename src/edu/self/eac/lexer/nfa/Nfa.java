package edu.self.eac.lexer.nfa;

import java.util.HashSet;

/**
 * Created by »Ô on 2015/7/18.
 */
public class Nfa {

    private HashSet<NfaState> _stateSet;
    private HashSet<NfaAlphabet> _alphabetSet;
    private HashSet<NfaEdge> _edgeSet;
    private HashSet<NfaState> _initialStateSet;
    private HashSet<NfaState> _finalStateSet;
}
