package edu.self.eac.lexer.nfa.cons;

import edu.self.eac.lexer.nfa.edge.NfaEdge;
import edu.self.eac.lexer.nfa.edge.NfaEdgeEmptyValue;
import edu.self.eac.lexer.nfa.state.NfaState;
import edu.self.eac.lexer.nfa.state.NfaStateIdGenerator;
import edu.self.eac.lexer.nfa.state.NfaStateType;

/**
 * Created by xuehui on 15/7/27.
 */
public class NfaOptionalConstruction implements INfaConstruction {
    public NfaOptionalConstruction(INfaConstruction cons, NfaOperatorConstruction optional) {
        _cons = cons;
        _optional = optional;
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
        _initialState = new NfaState(NfaStateIdGenerator.getNewId(), NfaStateType.Initial);

        NfaEdge emptyEdge1 = new NfaEdge(_initialState, _cons.getInitialState(), new NfaEdgeEmptyValue());
        _cons.getInitialState().setType(NfaStateType.Normal);
        _initialState.addOutEdge(emptyEdge1);
        _cons.getInitialState().addInEdge(emptyEdge1);

        _finalState = new NfaState(NfaStateIdGenerator.getNewId(), NfaStateType.Final);

        NfaEdge emptyEdge2 = new NfaEdge(_cons.getFinalState(), _finalState, new NfaEdgeEmptyValue());
        _cons.getFinalState().setType(NfaStateType.Normal);
        _cons.getFinalState().addOutEdge(emptyEdge2);
        _finalState.addInEdge(emptyEdge2);

        NfaEdge emptyEdge3 = new NfaEdge(_initialState, _finalState, new NfaEdgeEmptyValue());
        _initialState.addOutEdge(emptyEdge3);
        _finalState.addInEdge(emptyEdge3);

//        NfaEdge emptyEdge = new NfaEdge(_initialState, _finalState, new NfaEdgeEmptyValue());
//        _initialState.addOutEdge(emptyEdge);
//        _finalState.addInEdge(emptyEdge);
    }

    private INfaConstruction _cons;
    private NfaOperatorConstruction _optional;
    private String _productionName;
    private NfaState _initialState;
    private NfaState _finalState;
}
