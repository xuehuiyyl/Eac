package edu.self.eac.lexer.nfa.cons;

import edu.self.eac.lexer.nfa.edge.NfaEdge;
import edu.self.eac.lexer.nfa.edge.NfaEdgeAlphaSetValue;
import edu.self.eac.lexer.nfa.edge.NfaEdgeEmptyValue;
import edu.self.eac.lexer.nfa.state.NfaState;
import edu.self.eac.lexer.nfa.state.NfaStateIdGenerator;
import edu.self.eac.lexer.nfa.state.NfaStateType;
import edu.self.eac.lexer.re.def.ReAlpha;

/**
 * Created by xuehui on 15/7/27.
 */
public class NfaBracketConstruction implements INfaConstruction {
    public NfaBracketConstruction(NfaOperatorConstruction leftBracket, INfaConstruction cons, NfaOperatorConstruction rightBracket) {
        _leftBracket = leftBracket;
        _cons = cons;
        _rightBracket = rightBracket;
        _createDiagram();
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

    public void _createDiagram() {
        _initialState = new NfaState(NfaStateIdGenerator.getNewId(), NfaStateType.Initial);
        NfaState midState1 = new NfaState(NfaStateIdGenerator.getNewId(), NfaStateType.Normal);

        NfaEdge leftBracketEdge = new NfaEdge(_initialState, midState1,new NfaEdgeAlphaSetValue(new ReAlpha('(')));
        _initialState.addOutEdge(leftBracketEdge);
        midState1.addInEdge(leftBracketEdge);

        NfaEdge emptyEdge1 = new NfaEdge(midState1, _cons.getInitialState(),new NfaEdgeEmptyValue());
        _cons.getInitialState().setType(NfaStateType.Normal);
        midState1.addOutEdge(emptyEdge1);
        _cons.getInitialState().addInEdge(emptyEdge1);

        NfaState midState2 = new NfaState(NfaStateIdGenerator.getNewId(), NfaStateType.Normal);

        NfaEdge emptyEdge2 = new NfaEdge(_cons.getFinalState(),midState2,new NfaEdgeEmptyValue());
        _cons.getFinalState().setType(NfaStateType.Normal);
        _cons.getFinalState().addOutEdge(emptyEdge2);
        midState2.addInEdge(emptyEdge2);

        _finalState = new NfaState(NfaStateIdGenerator.getNewId(), NfaStateType.Final);

        NfaEdge rightBracketEdge = new NfaEdge(midState2,_finalState,new NfaEdgeAlphaSetValue(new ReAlpha(')')));
        midState2.addOutEdge(rightBracketEdge);
        _finalState.addInEdge(rightBracketEdge);
    }

    private NfaOperatorConstruction _leftBracket;
    private INfaConstruction _cons;
    private NfaOperatorConstruction _rightBracket;
    private String _productionName;
    private NfaState _initialState;
    private NfaState _finalState;

}
