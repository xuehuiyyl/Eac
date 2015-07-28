package edu.self.eac.lexer.nfa.cons;

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

    private INfaConstruction _cons;
    private NfaOperatorConstruction _positive;
    private String _productionName;
}
