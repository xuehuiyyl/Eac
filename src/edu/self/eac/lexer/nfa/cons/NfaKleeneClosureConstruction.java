package edu.self.eac.lexer.nfa.cons;

import edu.self.eac.lexer.re.def.ReOpKleeneClosure;

/**
 * Created by xuehui on 15/7/27.
 */
public class NfaKleeneClosureConstruction implements INfaConstruction {
    public NfaKleeneClosureConstruction(INfaConstruction cons, ReOpKleeneClosure kleene) {
        _cons = cons;
        _kleene = kleene;
    }

    private INfaConstruction _cons;
    private ReOpKleeneClosure _kleene;
}
