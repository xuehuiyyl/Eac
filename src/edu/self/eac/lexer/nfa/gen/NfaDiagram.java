package edu.self.eac.lexer.nfa.gen;

import edu.self.eac.lexer.nfa.cons.INfaConstruction;
import edu.self.eac.lexer.nfa.edge.NfaEdge;
import edu.self.eac.lexer.nfa.edge.NfaEdgeEmptyValue;
import edu.self.eac.lexer.nfa.state.NfaState;
import edu.self.eac.lexer.nfa.state.NfaStateIdGenerator;
import edu.self.eac.lexer.nfa.state.NfaStateType;

import java.util.ArrayList;

/**
 * Created by xuehui on 15/8/6.
 */
public class NfaDiagram {
    public NfaDiagram(ArrayList<INfaConstruction> consList) {
        _consList = consList;
        _createDiagram();
    }

    public NfaState getInitialState() {
        return _initialState;
    }

    public NfaState getFinalState() {
        return _finalState;
    }

    private void _createDiagram() {
        _initialState = new NfaState(NfaStateIdGenerator.getNewId(), NfaStateType.Initial);
        _finalState = new NfaState(NfaStateIdGenerator.getNewId(), NfaStateType.Final);

        for (INfaConstruction cons : _consList) {
            NfaEdge emptyEdge1 = new NfaEdge(_initialState, cons.getInitialState(), new NfaEdgeEmptyValue());
            cons.getInitialState().setType(NfaStateType.Normal);
            _initialState.addOutEdge(emptyEdge1);
            cons.getInitialState().addInEdge(emptyEdge1);

            NfaEdge emptyEdge2 = new NfaEdge(cons.getFinalState(),_finalState, new NfaEdgeEmptyValue());
            cons.getFinalState().setType(NfaStateType.Normal);
            cons.getFinalState().addOutEdge(emptyEdge2);
            _finalState.addInEdge(emptyEdge2);
        }
    }

    private NfaState _initialState;
    private NfaState _finalState;
    private ArrayList<INfaConstruction> _consList;
}
