package edu.self.eac.lexer.nfa.cons;

/**
 * Created by xuehui on 15/7/27.
 */
public class NfaKleeneClosureConstruction implements INfaConstruction {
    public NfaKleeneClosureConstruction(INfaConstruction cons, NfaOperatorConstruction kleene) {
        _cons = cons;
        _kleene = kleene;
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

    private INfaConstruction _cons;
    private NfaOperatorConstruction _kleene;
    private String _productionName;
}
