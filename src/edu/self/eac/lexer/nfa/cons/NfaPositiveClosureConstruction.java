package edu.self.eac.lexer.nfa.cons;

import edu.self.eac.lexer.nfa.state.NfaState;

/**
 * Created by xuehui on 15/7/27.
 */
public class NfaPositiveClosureConstruction implements INfaConstruction {
    public NfaPositiveClosureConstruction(INfaConstruction cons, NfaOperatorConstruction positive) {
        _cons = cons;
        _positive = positive;
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
    private NfaOperatorConstruction _positive;
    private String _productionName;
    private NfaState _initialState;
    private NfaState _finalState;
}
