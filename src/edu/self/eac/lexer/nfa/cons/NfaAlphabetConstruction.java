package edu.self.eac.lexer.nfa.cons;

import edu.self.eac.lexer.re.def.ReAlpha;
import edu.self.eac.lexer.re.def.ReAlphaSet;
import edu.self.eac.lexer.util.SetRelationType;

import java.util.Hashtable;

/**
 * Created by xuehui on 15/7/27.
 */
public class NfaAlphabetConstruction implements INfaConstruction {
    public NfaAlphabetConstruction(ReAlpha alpha) {
        _alphaSet = new Hashtable<>();
        _alphaSet.put(alpha.getName(), alpha.getName());
        _alphaSetRel = SetRelationType.In;
    }

    public NfaAlphabetConstruction(ReAlphaSet alphaSet) {
        _alphaSet = new Hashtable<>();
        _alphaSet = alphaSet.getValue();
        _alphaSetRel = alphaSet.getSetRel();
    }

    public Hashtable<String, String> getValue() {
        return _alphaSet;
    }

    public SetRelationType getSetRelation() {
        return _alphaSetRel;
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

    private Hashtable<String, String> _alphaSet;
    private SetRelationType _alphaSetRel;
    private String _productionName;
}
