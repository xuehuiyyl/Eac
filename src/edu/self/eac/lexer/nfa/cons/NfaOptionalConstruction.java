package edu.self.eac.lexer.nfa.cons;

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

    private INfaConstruction _cons;
    private NfaOperatorConstruction _optional;
    private String _productionName;
}
