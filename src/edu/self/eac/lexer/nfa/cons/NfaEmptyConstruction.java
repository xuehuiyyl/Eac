package edu.self.eac.lexer.nfa.cons;

/**
 * Created by xuehui on 15/7/27.
 */
public class NfaEmptyConstruction implements INfaConstruction {
    public String getProductionName() {
        return _productionName;
    }

    public void setProductionName(String productionName) {
        _productionName = productionName;
    }

    private String _productionName;
}
