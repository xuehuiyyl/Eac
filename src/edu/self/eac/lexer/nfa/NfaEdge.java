package edu.self.eac.lexer.nfa;

/**
 * Created by �� on 2015/7/18.
 * Comments: NFA diagram edge / NFA transit
 */
public class NfaEdge {
    public NfaEdge(NfaState from, NfaState to, INfaEdgeValue value){
        _from = from;
        _to = to;
        _value = value;
    }

    public NfaState getFromState(){
        return _from;
    }

    public NfaState getToState(){
        return _to;
    }

    public boolean move(char alpha) {
        return !(_from == null || _to == null || _value == null) && _value.isMatch(alpha);
    }

    private NfaState _from;
    private NfaState _to;
    private INfaEdgeValue _value;
}
