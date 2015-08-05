package edu.self.eac.lexer.nfa.cons;

import edu.self.eac.lexer.nfa.state.NfaState;

/**
 * Created by xuehui on 15/7/27.
 */
public class NfaOptionalConstruction implements INfaConstruction {
    public NfaOptionalConstruction(INfaConstruction cons, NfaOperatorConstruction optional) {
        _cons = cons;
        _optional = optional;
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
        
    }

    private INfaConstruction _cons;
    private NfaOperatorConstruction _optional;
    private String _productionName;
    private NfaState _initialState;
    private NfaState _finalState;
}
