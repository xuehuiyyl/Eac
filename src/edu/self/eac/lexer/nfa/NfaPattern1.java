package edu.self.eac.lexer.nfa;

import java.util.HashSet;

/**
 * Created by �� on 2015/7/18.
 */
public class NfaPattern1 implements INfaNode {
    public NfaPattern1(String text, NfaPatternType type){
        _text = text;
        _type = type;
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

    public NfaNodeType getNodeType() {
        return NfaNodeType.Pattern;
    }

    public String getNodeText() {
        return _text;
    }

    public NfaPatternType getType() {
        return _type;
    }

    public NfaPattern1 getLeftChildPattern() {
        return _leftChildPattern;
    }

    public void setLeftChildPattern(NfaPattern1 pattern) {
        _leftChildPattern = pattern;
    }

    public NfaPattern1 getRightChildPattern() {
        return _rightChildPattern;
    }

    public void setRightChildPattern(NfaPattern1 pattern) {
        _rightChildPattern = pattern;
    }

    public NfaOperator getOperator() {
        return _operator;
    }

    public void setOperator(NfaOperator operator) {
        _operator = operator;
    }

    private String _text;
    private NfaPatternType _type;
    private NfaPattern1 _leftChildPattern;
    private NfaPattern1 _rightChildPattern;
    private NfaOperator _operator;
    private NfaState _initialState;
    private HashSet<NfaState> _stateSet;
    //private HashSet<NfaAlphabet> _alphabetSet;
    //private HashSet<NfaEdge> _edgeSet;
    //private HashSet<NfaState> _initialStateSet;
    private HashSet<NfaState> _finalStateSet;
}
