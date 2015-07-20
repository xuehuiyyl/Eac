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

        int firstBlankIndex = 0;
        for (int i = 0; i < reDifinition.length(); ++i){
            if (reDifinition.charAt(i) != ' ')
                continue;
            firstBlankIndex = i;
            break;
        }
        String name = reDifinition.substring(0, firstBlankIndex - 1);
        String body = reDifinition.substring(firstBlankIndex + 1);
        if (name.isEmpty() || body.isEmpty()) return null;

        _matchStack.clear();
        _initMatchTable();

        int index = 0;
        int length = body.length();
        boolean inbracket = false;
        char c = body.charAt(index);
        while (index < length) {
            if (Character.isLetter(c)) {

            }
            else if (Character.isDigit(c)) {

            }
            else if (c == '(') {

            }
            else if (c == ')') {

            }
            else if (c == '*' || c == '+' || c == '?') {

            }
            else if (c == '|') {

            }
            else if (c == '\\') {

            }
            else if (c == '[') {

            }
            else if (c == '{') {

            }
        }

        return null;
    }

    public NfaPattern combinate(HashSet<NfaPattern> patternSet){
        return null;
    }

    private void match(INfaNode node){
        if (node.getNodeType() == NfaNodeType.Pattern) {//要改！！！，入栈+1，出栈匹配成功后改行各-1
            if (_matchTable[3][0] == _matchTable[3][1] + 1 && _matchTable[3][1] == _matchTable[3][2])
                _matchTable[3][1] += 1;
            if (_matchTable[2][0] == 0 && _matchTable[2][1] == 0)
                _matchTable[2][0] = 1;
            if (_matchTable[1][0] == 0 && _matchTable[1][1] == 0)
                _matchTable[1][0] = 1;
            if (_matchTable[1][0] == 1 && _matchTable[1][1] == 0)
                _matchTable[1][1] = 1;
            if (_matchTable[0][0] == 0 && _matchTable[0][1] == 0 && _matchTable[0][2] == 0)
                _matchTable[0][0] = 1;
            if (_matchTable[0][0] == 1 && _matchTable[0][1] == 1 && _matchTable[0][2] == 0)
                _matchTable[0][2] = 1;
        }
        else if(node.getNodeType() == NfaNodeType.Operator) {
            String text = node.getNodeText();
            if (text.equals("(") && _matchTable[3][0] == 0) {
                _matchTable[3][0] = 1;
            }
            else if(text.equals(")") && _matchTable[3][0] == 1 && _matchTable[3][1] == 1 && _matchTable[3][2] == 0) {
                _matchTable[3][2] = 1;
            }
            else if ((text.equals("*") || text.equals("+") || text.equals("?")) && _matchTable[2][0] == 1) {
                _matchTable[2][1] = 1;
            }
            else if (text.equals("|") && _matchTable[0][0] == 1 && _matchTable[0][1] == 0 && _matchTable[0][2] == 0) {
                _matchTable[0][1] = 1;
            }
        }
    }

    private NfaPatternType getPatternType() {
        if (_matchTable[3][0] == 1 && _matchTable[3][1] == 1 && _matchTable[3][2] == 1) return NfaPatternType.Bracket;
        else if (_matchTable[2][0] == 1 && _matchTable[2][1] == 1) return NfaPatternType.Closure;
        else if (_matchTable[1][0] == 1 && _matchTable[1][1] == 1) return NfaPatternType.Join;
        else if (_matchTable[0][0] == 1 && _matchTable[0][1] == 1 && _matchTable[0][2] == 1) return NfaPatternType.Select;
        else return NfaPatternType.Alpha;
    }

    private void _initMatchTable() {
        //Σ|Σ select
        _matchTable[0][0] = 0;
        _matchTable[0][1] = 0;
        _matchTable[0][2] = 0;
        //ΣΣ or Σ·Σ join
        _matchTable[1][0] = 0;
        _matchTable[1][1] = 0;
        _matchTable[1][2] = -1;
        //Σ* or Σ? or Σ+ closure
        _matchTable[2][0] = 0;
        _matchTable[2][1] = 0;
        _matchTable[2][2] = -1;
        //(Σ) bracket
        _matchTable[3][0] = 0;
        _matchTable[3][1] = 0;
        _matchTable[3][2] = 0;
    }

    private HashSet<NfaAlphabet> _alphabetSet;
    private HashSet<NfaPattern> _patternSet;
    private int[][] _matchTable;
    private Stack<INfaNode> _matchStack;
}
