package edu.self.eac.lexer.nfa.cons;

import edu.self.eac.lexer.nfa.edge.NfaEdge;
import edu.self.eac.lexer.nfa.edge.NfaEdgeAlphaSetValue;
import edu.self.eac.lexer.nfa.state.NfaState;
import edu.self.eac.lexer.nfa.state.NfaStateIdGenerator;
import edu.self.eac.lexer.nfa.state.NfaStateType;
import edu.self.eac.lexer.re.def.IReElement;
import edu.self.eac.lexer.re.def.ReAlpha;
import edu.self.eac.lexer.re.def.ReAlphaSet;
import edu.self.eac.lexer.util.SetRelationType;

import java.util.Hashtable;

/**
 * Created by xuehui on 15/7/27.
 */
public class NfaAlphabetConstruction implements INfaConstruction {
    public NfaAlphabetConstruction(ReAlpha alpha) {
        _alphabet = alpha;
        _alphaSet = new Hashtable<>();
        _alphaSet.put(alpha.getName(), alpha.getName());
        _alphaSetRel = SetRelationType.In;
        _createDiagram();
    }

    public NfaAlphabetConstruction(ReAlphaSet alphaSet) {
        _alphabet = alphaSet;
        _alphaSet = new Hashtable<>();
        _alphaSet = alphaSet.getValue();
        _alphaSetRel = alphaSet.getSetRel();
        _createDiagram();
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

    public NfaState getInitialState() {
        return _initialState;
    }

    public NfaState getFinalState() {
        return _finalState;
    }

    private void _createDiagram() {
        _initialState = new NfaState(NfaStateIdGenerator.getNewId(), NfaStateType.Initial);
        _finalState = new NfaState(NfaStateIdGenerator.getNewId(), NfaStateType.Final);

        NfaEdge edge = null;
        if (_alphabet instanceof ReAlpha)
            edge = new NfaEdge(_initialState, _finalState, new NfaEdgeAlphaSetValue((ReAlpha) _alphabet));
        if (_alphabet instanceof ReAlphaSet)
            edge = new NfaEdge(_initialState, _finalState, new NfaEdgeAlphaSetValue((ReAlphaSet) _alphabet));

        if (edge != null) {
            _initialState.addOutEdge(edge);
            _finalState.addInEdge(edge);
        }
    }

    private Hashtable<String, String> _alphaSet;
    private SetRelationType _alphaSetRel;
    private String _productionName;
    private IReElement _alphabet;
    private NfaState _initialState;
    private NfaState _finalState;
}
