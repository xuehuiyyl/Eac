package edu.self.eac.lexer.dfa.gen;

import edu.self.eac.lexer.nfa.edge.NfaEdge;
import edu.self.eac.lexer.nfa.edge.NfaEdgeEmptyValue;
import edu.self.eac.lexer.nfa.gen.NfaDiagram;
import edu.self.eac.lexer.nfa.state.NfaState;

import java.util.HashSet;
import java.util.Stack;

/**
 * Created by xuehui on 15/8/6.
 */
public class DfaGenerator {
    public DfaGenerator(NfaDiagram nfaDiagram) {
        _nfaDiagram = nfaDiagram;
        _alphabet = (String[])_nfaDiagram.getAlphabet().values().toArray();
    }

    public DfaDiagram convert() {
        _transTable = new DfaTransTable();

        HashSet<NfaState> n0 = new HashSet<>();
        n0.add(_nfaDiagram.getInitialState());

        HashSet<NfaState> q0 = _calcEmptyClosureSet(n0);

        HashSet<HashSet<NfaState>> Q = new HashSet<>();
        Q.add(q0);

        HashSet<HashSet<NfaState>> workList = new HashSet<>();
        workList.add(q0);

        while (workList.size() > 0) {
            HashSet<NfaState> q = (HashSet<NfaState>) workList.toArray()[0];
            for (String c : _alphabet) {
                HashSet<NfaState> t = _calcEmptyClosureSet(_calcDeltaSet(q, c));
                //更新转换表
                _transTable.addItem(new DfaTransTableItem(q, c, t));

                if (!Q.contains(t)) {
                    Q.add(t);
                    workList.add(t);
                }
            }
        }

        return null;
    }

    private HashSet<NfaState> _calcEmptyClosureSet(HashSet<NfaState> nfaStateSet) {
        Stack<NfaState> stack = new Stack<>();
        for (NfaState state : nfaStateSet) {
            stack.push(state);
        }

        HashSet<NfaState> ret = new HashSet<>();
        for (Object state : nfaStateSet.toArray()) {
            ret.add((NfaState)state);
        }

        while (stack.size() > 0) {
            NfaState peek = stack.pop();
            for (NfaEdge edge : peek.getOutEdgeList()) {
                if (edge.getValue() instanceof NfaEdgeEmptyValue && !ret.contains(edge.getToState())) {
                    ret.add(edge.getToState());
                    stack.push(edge.getToState());
                }
            }
        }

        return ret;
    }

    private HashSet<NfaState> _calcDeltaSet(HashSet<NfaState> q, String c) {
        return null;
    }

    private NfaDiagram _nfaDiagram;
    private String[] _alphabet;
    private DfaTransTable _transTable;
}
