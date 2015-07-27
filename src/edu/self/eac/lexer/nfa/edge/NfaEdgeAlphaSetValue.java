package edu.self.eac.lexer.nfa.edge;

import edu.self.eac.lexer.re.def.ReAlpha;
import edu.self.eac.lexer.re.def.ReAlphaSet;
import edu.self.eac.lexer.util.SetRelationType;

import java.util.Hashtable;

/**
 * Created by xuehui on 15/7/26.
 */
public class NfaEdgeAlphaSetValue implements INfaEdgeValue {
    public NfaEdgeAlphaSetValue(ReAlpha alpha) {
        _alphaSet = new Hashtable<>();
        _alphaSet.put(alpha.getName(), alpha.getName());
        _alphaSetRel = SetRelationType.In;
    }

    public NfaEdgeAlphaSetValue(ReAlphaSet alphaSet) {
        _alphaSet = new Hashtable<>();
        _alphaSet = alphaSet.getValue();
        _alphaSetRel = alphaSet.getSetRel();
    }

    public boolean isMatch(char ch) {
        return _alphaSet.contains(String.valueOf(ch));
    }

    private Hashtable<String, String> _alphaSet;
    private SetRelationType _alphaSetRel;
}
