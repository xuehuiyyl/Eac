package edu.self.eac.lexer.nfa.cons;

import edu.self.eac.lexer.nfa.edge.NfaEdge;
import edu.self.eac.lexer.nfa.edge.NfaEdgeEmptyValue;
import edu.self.eac.lexer.nfa.state.NfaState;
import edu.self.eac.lexer.nfa.state.NfaStateIdGenerator;
import edu.self.eac.lexer.nfa.state.NfaStateType;

/**
 * Created by xuehui on 15/7/27.
 */
public class NfaEmptyConstruction implements INfaConstruction {
    public NfaEmptyConstruction() {
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
        _finalState = new NfaState(NfaStateIdGenerator.getNewId(), NfaStateType.Final);

        NfaEdge emptyEdge = new NfaEdge(_initialState, _finalState,new NfaEdgeEmptyValue());
        _initialState.addOutEdge(emptyEdge);
        _finalState.addInEdge(emptyEdge);
    }

    private String _productionName;
    private NfaState _initialState;
    private NfaState _finalState;
}
