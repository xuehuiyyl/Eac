package edu.self.eac.lexer.nfa.cons;

/**
 * Created by xuehui on 15/7/27.
 */
public class NfaBracketConstruction implements INfaConstruction {
    public NfaBracketConstruction(NfaOperatorConstruction leftBracket, INfaConstruction cons, NfaOperatorConstruction rightBracket) {
        _leftBracket = leftBracket;
        _cons = cons;
        _rightBracket = rightBracket;
    }

    public String getProductionName() {
        return _productionName;
    }

    public void setProductionName(String productionName) {
        _productionName = productionName;
    }

    private NfaOperatorConstruction _leftBracket;
    private INfaConstruction _cons;
    private NfaOperatorConstruction _rightBracket;
    private String _productionName;
}
