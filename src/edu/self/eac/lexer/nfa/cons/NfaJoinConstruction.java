package edu.self.eac.lexer.nfa.cons;

import edu.self.eac.lexer.nfa.edge.NfaEdge;
import edu.self.eac.lexer.nfa.edge.NfaEdgeEmptyValue;
import edu.self.eac.lexer.nfa.state.NfaState;
import edu.self.eac.lexer.nfa.state.NfaStateType;

/**
 * Created by xuehui on 15/7/27.
 */
public class NfaJoinConstruction implements INfaConstruction {
    public NfaJoinConstruction(INfaConstruction leftCons, NfaOperatorConstruction join, INfaConstruction rightCons) {
        _leftCons = leftCons;
        _join = join;
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
        _initialState = _leftCons.getInitialState();
        _finalState = _rightCons.getFinalState();

        NfaEdge emptyEdge = new NfaEdge(_leftCons.getFinalState(),_rightCons.getInitialState(),new NfaEdgeEmptyValue());
        _leftCons.getFinalState().setType(NfaStateType.Normal);
        _rightCons.getInitialState().setType(NfaStateType.Normal);
        _leftCons.getFinalState().addOutEdge(emptyEdge);
        _rightCons.getInitialState().addInEdge(emptyEdge);
    }

    private INfaConstruction _leftCons;
    private NfaOperatorConstruction _join;
    private INfaConstruction _rightCons;
    private String _productionName;
    private NfaState _initialState;
    private NfaState _finalState;
}
