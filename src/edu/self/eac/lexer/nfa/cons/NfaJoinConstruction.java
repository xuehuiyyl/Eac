package edu.self.eac.lexer.nfa.cons;

import edu.self.eac.lexer.re.def.ReOpJoin;

/**
 * Created by xuehui on 15/7/27.
 */
public class NfaJoinConstruction implements INfaConstruction {
    public NfaJoinConstruction(INfaConstruction leftCons, ReOpJoin join, INfaConstruction rightCons) {
        _leftCons = leftCons;
        _join = join;
        _rightCons = rightCons;
    }

    private INfaConstruction _leftCons;
    private ReOpJoin _join;
    private INfaConstruction _rightCons;
}
