package edu.self.eac.lexer.nfa.cons;

import edu.self.eac.lexer.nfa.edge.NfaEdge;
import edu.self.eac.lexer.nfa.edge.NfaEdgeEmptyValue;
import edu.self.eac.lexer.nfa.state.NfaState;
import edu.self.eac.lexer.nfa.state.NfaStateIdGenerator;
import edu.self.eac.lexer.nfa.state.NfaStateType;

/**
 * Created by xuehui on 15/7/27.
 */
public class NfaSelectConstruction implements INfaConstruction {
    public NfaSelectConstruction(INfaConstruction leftCons, NfaOperatorConstruction select, INfaConstruction rightCons) {
        _leftCons = leftCons;
        _select = select;
        _rightCons = rightCons;
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

        NfaEdge emptyEdge1 = new NfaEdge(_initialState, _leftCons.getInitialState(), new NfaEdgeEmptyValue());
        _leftCons.getInitialState().setType(NfaStateType.Normal);
        _initialState.addOutEdge(emptyEdge1);
        _leftCons.getInitialState().addInEdge(emptyEdge1);

        NfaEdge emptyEdge2 = new NfaEdge(_initialState, _rightCons.getInitialState(), new NfaEdgeEmptyValue());
        _rightCons.getInitialState().setType(NfaStateType.Normal);
        _initialState.addOutEdge(emptyEdge2);
        _rightCons.getInitialState().addInEdge(emptyEdge2);

        _finalState = new NfaState(NfaStateIdGenerator.getNewId(), NfaStateType.Final);

        NfaEdge emptyEdge3 = new NfaEdge(_leftCons.getFinalState(), _finalState, new NfaEdgeEmptyValue());
        _leftCons.getFinalState().setType(NfaStateType.Normal);
        _leftCons.getFinalState().addOutEdge(emptyEdge3);
        _finalState.addInEdge(emptyEdge3);

        NfaEdge emptyEdge4 = new NfaEdge(_rightCons.getFinalState(), _finalState, new NfaEdgeEmptyValue());
        _rightCons.getFinalState().setType(NfaStateType.Normal);
        _rightCons.getFinalState().addOutEdge(emptyEdge4);
        _finalState.addInEdge(emptyEdge4);
    }

    private INfaConstruction _leftCons;
    private NfaOperatorConstruction _select;
    private INfaConstruction _rightCons;
    private String _productionName;
    private NfaState _initialState;
    private NfaState _finalState;
}
