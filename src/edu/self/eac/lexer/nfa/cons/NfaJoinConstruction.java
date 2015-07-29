package edu.self.eac.lexer.nfa.cons;

/**
 * Created by xuehui on 15/7/27.
 */
public class NfaJoinConstruction implements INfaConstruction {
    public NfaJoinConstruction(INfaConstruction leftCons, NfaOperatorConstruction join, INfaConstruction rightCons) {
        _leftCons = leftCons;
        _join = join;
        _rightCons = rightCons;
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

    private INfaConstruction _leftCons;
    private NfaOperatorConstruction _join;
    private INfaConstruction _rightCons;
    private String _productionName;
}
