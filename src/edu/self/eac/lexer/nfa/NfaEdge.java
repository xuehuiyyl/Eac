package edu.self.eac.lexer.nfa;

/**
 * Created by »Ô on 2015/7/18.
 * Comments: NFA diagram edge / NFA transit
 */
public class NfaEdge {
    public NfaEdge(NfaState from, NfaState to, NfaAlphabet alphabet){
        _from = from;
        _to = to;
        _alphabet = alphabet;
    }

    public NfaState getFromState(){
        return _from;
    }

    public NfaState getToState(){
        return _to;
    }

    public boolean move(char alpha) {
        return !(_from == null || _to == null || _alphabet == null) && _alphabet.isMember(alpha);
    }

    private NfaState _from;
    private NfaState _to;
    private NfaAlphabet _alphabet;
}
