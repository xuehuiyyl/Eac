package edu.self.eac.lexer.nfa.cons;

import edu.self.eac.lexer.re.def.ReOpPositiveClosure;

/**
 * Created by xuehui on 15/7/27.
 */
public class NfaPositiveClosureConstruction implements INfaConstruction {
    public NfaPositiveClosureConstruction(INfaConstruction cons, ReOpPositiveClosure positive) {
        _cons = cons;
        _positive = positive;
    }

    private INfaConstruction _cons;
    private ReOpPositiveClosure _positive;
}
