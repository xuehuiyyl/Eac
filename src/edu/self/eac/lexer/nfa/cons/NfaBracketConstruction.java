package edu.self.eac.lexer.nfa.cons;

import edu.self.eac.lexer.re.def.ReOpLeftBracket;
import edu.self.eac.lexer.re.def.ReOpRightBracket;

/**
 * Created by xuehui on 15/7/27.
 */
public class NfaBracketConstruction implements INfaConstruction {
    public NfaBracketConstruction(ReOpLeftBracket leftBracket, INfaConstruction cons, ReOpRightBracket rightBracket) {
        _leftBracket = leftBracket;
        _cons = cons;
        _rightBracket = rightBracket;
    }

    private ReOpLeftBracket _leftBracket;
    private INfaConstruction _cons;
    private ReOpRightBracket _rightBracket;
}
