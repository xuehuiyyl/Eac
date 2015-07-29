package edu.self.eac.lexer.nfa.cons;

import edu.self.eac.lexer.re.def.ReOperator;

/**
 * Created by xuehui on 15/7/27.
 */
public class NfaOperatorConstruction implements INfaConstruction {
    public NfaOperatorConstruction(ReOperator operator) {
        _operator = operator;
    }

    public ReOperator getReOperator() {
        return _operator;
    }

    public String getProductionName() {
        return null;
    }

    public void setProductionName(String name) {
        return;
    }

    public INfaConstruction copy() {
        return this.copy();
    }

    private ReOperator _operator;
}
