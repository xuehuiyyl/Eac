package edu.self.eac.lexer.dfa.gen;

import edu.self.eac.lexer.nfa.edge.NfaEdge;
import edu.self.eac.lexer.nfa.edge.NfaEdgeAlphaSetValue;
import edu.self.eac.lexer.nfa.edge.NfaEdgeEmptyValue;
import edu.self.eac.lexer.nfa.gen.NfaDiagram;
import edu.self.eac.lexer.nfa.state.NfaState;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Stack;

/**
 * Created by xuehui on 15/8/6.
 */
public class DfaGenerator {
    public DfaGenerator(NfaDiagram nfaDiagram) {
        _nfaDiagram = nfaDiagram;

        _alphabet = new String[_nfaDiagram.getAlphabet().size()];
        Object[] valArray = _nfaDiagram.getAlphabet().values().toArray();
        for (int index = 0; index < _alphabet.length; ++index)
            _alphabet[index] = valArray[index].toString();
        //{_nfaDiagram.getAlphabet().values().toArray(String[])};
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
            HashSet<NfaState> q = (HashSet<NfaState>) workList.toArray()[workList.size() - 1];
            workList.remove(q);

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

        return new DfaDiagram(q0, _alphabet, _transTable);
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
        HashSet<NfaState> ret = new HashSet<>();
        for (NfaState state : q) {
            ArrayList<NfaEdge> outEdgeList = state.getOutEdgeList();
            for (NfaEdge edge : outEdgeList) {
                if (edge.getValue() instanceof NfaEdgeEmptyValue) continue;
                NfaEdgeAlphaSetValue value = (NfaEdgeAlphaSetValue) edge.getValue();
                if (value.isMatch(c.charAt(0)))
                    ret.add(edge.getToState());
            }
        }
        return ret;
    }

    private NfaDiagram _nfaDiagram;
    private String[] _alphabet;
    private DfaTransTable _transTable;
}
