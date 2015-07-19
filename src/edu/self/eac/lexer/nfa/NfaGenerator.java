package edu.self.eac.lexer.nfa;

import java.util.HashSet;
import java.util.Stack;

/**
 * Created by �� on 2015/7/18.
 * Comments: NFA generator
 */
public class NfaGenerator {
    public NfaGenerator() {
        _alphabetSet = new HashSet<>();
        _patternSet = new HashSet<>();
        _matchTable = new int[4][3];
        _matchStack = new Stack<>();
    }

    public NfaPattern parse(String filepath){
        return null;
    }

    public NfaPattern parseLine(String reDifinition) {
        if (reDifinition == null || reDifinition.trim().isEmpty()) return null;
        int firstBlankIndex;
        for (int i = 0; i < reDifinition.length(); ++i){
            if (reDifinition.charAt(i) != ' ')
                continue;
            firstBlankIndex = i;
            break;
        }
        String name = reDifinition.substring(0, firstBlankIndex - 1);
        String body = reDifinition.substring(firstBlankIndex + 1);
        if (name.isEmpty() || body.isEmpty()) return null;


        return null;
    }

    public NfaPattern combinate(HashSet<NfaPattern> patternSet){
        return null;
    }

    private boolean match(INfaNode node){
        if (node.getType() == NfaNodeType.Pattern) {

        }
        else if(node.getType() == NfaNodeType.Operator) {
            String text = node.getText();
            if (text.equals("(") && _matchTable[3][0] == 0) {
                _matchTable[3][0] == 1;
                return false;
            }
            else if(text.equals(")") && _matchTable[3][0] == 1 && _matchTable[3][1] == 1 && _matchTable[3][2] == 0) {
                _matchTable[3][2] == 1;
                return true;
            }
            else if ((text.equals("*") || text.equals("+") || text.equals("?")) && _matchTable[2][0] == 1) {
                _matchTable[2][1] = 1;
                return true;
            }
            else if (text.equals("|") && _matchTable[0][0] == 1 && _matchTable[0][1] == 0 && _matchTable == [0][2]) {
                _matchTable[0][1] = 1;
                return true;
            }
        }
    }

    private void _initMatchTable() {
        _matchTable[0][0] = 0;
        _matchTable[0][1] = 0;
        _matchTable[0][2] = 0;
        _matchTable[1][0] = 0;
        _matchTable[1][1] = 0;
        _matchTable[1][2] = -1;
        _matchTable[2][0] = 0;
        _matchTable[2][1] = 0;
        _matchTable[2][2] = -1;
        _matchTable[3][0] = 0;
        _matchTable[3][1] = 0;
        _matchTable[3][2] = 0;
    }

    private HashSet<NfaAlphabet> _alphabetSet;
    private HashSet<NfaPattern> _patternSet;
    private int[][] _matchTable;
    private Stack<INfaNode> _matchStack;
}
