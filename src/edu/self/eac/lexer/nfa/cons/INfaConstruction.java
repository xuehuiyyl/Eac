package edu.self.eac.lexer.nfa.cons;

import edu.self.eac.lexer.nfa.state.NfaState;

/**
 * Created by xuehui on 15/7/27.
 */
public interface INfaConstruction {
    String getProductionName();
    void setProductionName(String productionName);
    INfaConstruction copy();
    NfaState getInitialState();
    NfaState getFinalState();
}
