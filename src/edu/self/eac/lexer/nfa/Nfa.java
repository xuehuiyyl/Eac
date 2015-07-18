package edu.self.eac.lexer.nfa;

import java.util.HashSet;
import java.util.Hashtable;

/**
 * Created by �� on 2015/7/18.
 */
public class Nfa {
    public Nfa(){
        _stateSet = new HashSet<>();
        _finalStateSet = new HashSet<>();
    }

    public boolean addState(NfaState state){
        if (state == null) return false;
        if (_initialState != null && state.getType() == NfaStateType.Initial)
            return false;
        if (_initialState == null && state.getType() == NfaStateType.Initial)
            _initialState = state;
        if (state.getType() == NfaStateType.Final)
            _finalStateSet.add(state);
        _stateSet.add(state);
        return true;
    }

    public NfaState getInitialState() {
        return _initialState;
    }

    public HashSet<NfaState> getFinalStateSet() {
        return _finalStateSet;
    }

    public HashSet<NfaState> getStateSet() {
        return _stateSet;
    }

    private NfaState _initialState;
    private HashSet<NfaState> _stateSet;
    //private HashSet<NfaAlphabet> _alphabetSet;
    //private HashSet<NfaEdge> _edgeSet;
    //private HashSet<NfaState> _initialStateSet;
    private HashSet<NfaState> _finalStateSet;
}
