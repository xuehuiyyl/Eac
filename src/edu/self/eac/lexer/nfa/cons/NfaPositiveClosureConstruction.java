package edu.self.eac.lexer.nfa.cons;

import edu.self.eac.lexer.nfa.edge.NfaEdge;
import edu.self.eac.lexer.nfa.edge.NfaEdgeEmptyValue;
import edu.self.eac.lexer.nfa.state.NfaState;
import edu.self.eac.lexer.nfa.state.NfaStateIdGenerator;
import edu.self.eac.lexer.nfa.state.NfaStateType;

/**
 * Created by xuehui on 15/7/27.
 */
public class NfaPositiveClosureConstruction implements INfaConstruction {
    public NfaPositiveClosureConstruction(INfaConstruction cons, NfaOperatorConstruction positive) {
        _cons = cons;
        _positive = positive;
        _createDiagram();
    }

    public String getProductionName() {
        return _productionName;
    }

    public void setProductionName(String productionName) {
        _productionName = productionName;
    }

    public INfaConstruction copy() {
        return this.copy();
    }

    public NfaState getInitialState() {
        return _initialState;
    }

    public NfaState getFinalState() {
        return _finalState;
    }

    public void _createDiagram() {
//        _initialState = new NfaState(NfaStateIdGenerator.getNewId(), NfaStateType.Initial);
//        _finalState = new NfaState(NfaStateIdGenerator.getNewId(), NfaStateType.Final);
//
//        NfaEdge emptyEdge1 = new NfaEdge(_initialState,_finalState,new NfaEdgeEmptyValue());
//        _initialState.addOutEdge(emptyEdge1);
//        _finalState.addInEdge(emptyEdge1);
//
//        NfaEdge emptyEdge2 = new NfaEdge(_cons.getFinalState(), _cons.getInitialState(),new NfaEdgeEmptyValue());
//        _cons.getFinalState().setType(NfaStateType.Normal);
//        _cons.getInitialState().setType(NfaStateType.Normal);
//        _cons.getFinalState().addOutEdge(emptyEdge2);
//        _cons.getInitialState().addInEdge(emptyEdge2);
//
//        NfaEdge emptyEdge3 = new NfaEdge(_cons.getFinalState(),_finalState,new NfaEdgeEmptyValue());
//        _cons.getFinalState().addOutEdge(emptyEdge3);
//        _finalState.addInEdge(emptyEdge3);
//
//        NfaEdge emptyEdge4 = new NfaEdge(_initialState, _cons.getInitialState(),new NfaEdgeEmptyValue());
//        _initialState.addOutEdge(emptyEdge4);
//        _cons.getInitialState().addInEdge(emptyEdge4);

        if (_cons.getInitialState() == null)
            _initialState = new NfaState(NfaStateIdGenerator.getNewId(), NfaStateType.Initial);
        else
            _initialState = _cons.getInitialState();

        if (_cons.getFinalState() == null)
            _finalState = new NfaState(NfaStateIdGenerator.getNewId(), NfaStateType.Final);
        else
            _finalState = _cons.getFinalState();

        NfaEdge emptyEdge = new NfaEdge(_finalState, _initialState, new NfaEdgeEmptyValue());
        _finalState.addOutEdge(emptyEdge);
        _initialState.addInEdge(emptyEdge);
    }

    private INfaConstruction _cons;
    private NfaOperatorConstruction _positive;
    private String _productionName;
    private NfaState _initialState;
    private NfaState _finalState;
}
