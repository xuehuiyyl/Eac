package edu.self.eac.lexer.nfa.cons;

import edu.self.eac.lexer.re.def.ReOpOptional;

/**
 * Created by xuehui on 15/7/27.
 */
public class NfaOptionalConstruction implements INfaConstruction {
    public NfaOptionalConstruction(INfaConstruction cons, ReOpOptional optional) {
        _cons = cons;
        _optional = optional;
    }

    private INfaConstruction _cons;
    private ReOpOptional _optional;
}
