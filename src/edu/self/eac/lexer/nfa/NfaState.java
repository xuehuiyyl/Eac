package edu.self.eac.lexer.nfa;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Created by �� on 2015/7/18.
 * Comments: NFA state
 */
public class NfaState {
    public NfaState(String id, NfaStateType type){
        _id = id;
        _type = type;
        _inEdges = new HashSet<>();
        _outEdges = new ArrayList<>();
    }

    public boolean addInEdge(NfaEdge edge){
        if (_inEdges.contains(edge))return false;
        return _inEdges.add(edge);
    }

    public boolean addOutEdge(NfaEdge edge){
        if(_outEdges.contains(edge)) return false;
        return _outEdges.add(edge);
    }

    public NfaStateType getType() {
        return _type;
    }

    private String _id;
    private NfaStateType _type;
    private HashSet<NfaEdge> _inEdges;
    private ArrayList<NfaEdge> _outEdges;
}
