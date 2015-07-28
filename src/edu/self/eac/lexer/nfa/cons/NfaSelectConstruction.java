package edu.self.eac.lexer.nfa.cons;

/**
 * Created by xuehui on 15/7/27.
 */
public class NfaSelectConstruction implements INfaConstruction {
    public NfaSelectConstruction(INfaConstruction leftCons, NfaOperatorConstruction select, INfaConstruction rightCons) {
        _leftCons = leftCons;
        _select = select;
        _rightCons = rightCons;
    }

    public String getProductionName() {
        return _productionName;
    }

    public void setProductionName(String productionName) {
        _productionName = productionName;
    }

    private INfaConstruction _leftCons;
    private NfaOperatorConstruction _select;
    private INfaConstruction _rightCons;
    private String _productionName;
}
