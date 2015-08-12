package edu.self.eac.lexer.nfa.state;

import edu.self.eac.lexer.nfa.edge.NfaEdge;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Created by �� on 2015/7/18.
 * Comments: NFA state
 */
public class NfaState {
    public NfaState(String id, NfaStateType type) {
        _id = id;
        _type = type;
        _inEdgeSet = new ArrayList<>();
        _outEdgeSet = new ArrayList<>();
    }

    public boolean addInEdge(NfaEdge edge) {
        if (_inEdgeSet.contains(edge)) return false;
        return _inEdgeSet.add(edge);
    }

    public boolean addOutEdge(NfaEdge edge) {
        if (_outEdgeSet.contains(edge)) return false;
        return _outEdgeSet.add(edge);
    }

    public String getId(){
        return _id;
    }

    public ArrayList<NfaEdge> getInEdgeList() {
        return _inEdgeSet;
    }

    public ArrayList<NfaEdge> getOutEdgeList() {
        return _outEdgeSet;
    }

    public NfaStateType getType() {
        return _type;
    }

    public void setType(NfaStateType type) {
        _type = type;
    }

    private String _id;
    private NfaStateType _type;
    private ArrayList<NfaEdge> _inEdgeSet;
    private ArrayList<NfaEdge> _outEdgeSet;
}
