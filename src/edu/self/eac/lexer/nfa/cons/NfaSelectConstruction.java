package edu.self.eac.lexer.nfa.cons;

import edu.self.eac.lexer.re.def.ReOpSelect;

/**
 * Created by xuehui on 15/7/27.
 */
public class NfaSelectConstruction implements INfaConstruction {
    public NfaSelectConstruction(INfaConstruction leftCons, ReOpSelect select, INfaConstruction rightCons) {
        _leftCons = leftCons;
        _select = select;
        _rightCons = rightCons;
    }

    private INfaConstruction _leftCons;
    private ReOpSelect _select;
    private INfaConstruction _rightCons;
}
