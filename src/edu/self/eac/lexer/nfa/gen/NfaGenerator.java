package edu.self.eac.lexer.nfa.gen;

import edu.self.eac.lexer.nfa.cons.INfaConstruction;
import edu.self.eac.lexer.nfa.cons.NfaAlphabetConstruction;
import edu.self.eac.lexer.re.def.*;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by �� on 2015/7/18.
 * Comments: NFA generator
 */
public class NfaGenerator {
    public NfaGenerator(ReDefinition redefinition) {
//        _alphabetSet = new HashSet<>();
//        _patternSet = new HashSet<>();
//        _matchTable = new int[4][3];
//        _matchStack = new Stack<>();
        _redefinition = redefinition;
        _stack = new Stack<>();
        _constructionList = new ArrayList<>();
    }

    public INfaConstruction parse() {
        _alphaSetList = _redefinition.getAlphaSetList();
        _productionList = _redefinition.getProductionList();

        return null;
    }

    public INfaConstruction parseProduction(ReProduction production) {
        _stack.clear();
        ArrayList<IReElement> elementList = production.getElementList();
        INfaConstruction construction;
        for (IReElement element : elementList) {
            if (element instanceof ReAlpha) {
                construction = new NfaAlphabetConstruction((ReAlpha)element);
            }
            else if (element instanceof ReReference) {

            }
            else if (element instanceof ReOpLeftBracket) {

            }
            else if (element instanceof ReOpRightBracket) {

            }
            else if (element instanceof ReOpKleeneClosure) {

            }
            else if (element instanceof ReOpPositiveClosure) {

            }
            else if (element instanceof ReOpOptional) {

            }
            else if (element instanceof ReOpJoin) {

            }
            else if (element instanceof ReOpSelect) {

            }
        }
        return null;
    }

    private INfaConstruction _match() {
        return null;
    }

    private Stack<INfaConstruction> _stack;
    private ReDefinition _redefinition;
    private ArrayList<ReAlphaSet> _alphaSetList;
    private ArrayList<ReProduction> _productionList;
    private ArrayList<INfaConstruction> _constructionList;

//    public NfaPattern1 parse(String filepath) {
//        return null;
//    }
//
//    public INfaNode parseLine(String reDifinition) {
//        if (reDifinition == null || reDifinition.trim().isEmpty()) return null;
//
//        int firstBlankIndex = 0;
//        for (int i = 0; i < reDifinition.length(); ++i) {
//            if (reDifinition.charAt(i) != ' ')
//                continue;
//            firstBlankIndex = i;
//            break;
//        }
//        String name = reDifinition.substring(0, firstBlankIndex - 1);
//        String body = reDifinition.substring(firstBlankIndex + 1);
//        if (name.isEmpty() || body.isEmpty()) return null;
//
//        if (body.charAt(0) == '[') {
//            NfaAlphabet alphabet = _parseAlphabet(name, body);
//            _alphabetSet.add(alphabet);
//            return alphabet;
//        }
//
//        _matchStack.clear();
//        _initMatchTable();
//
//        int index = 0;
//        int length = body.length();
//        boolean inbracket = false;
//        char c = body.charAt(index);
//        INfaNode node = null;
//        while (index < length) {
//            if (Character.isLetterOrDigit(c)) {
//                node = new NfaPattern1(String.valueOf(c), NfaPatternType.Alpha);
//                _matchStack.push(node);
//                _mark(node);
//                ++index;
//                if (index < length - 1) {
//                    char next = body.charAt(index + 1);
//                    if (next == '*' || next == '+' || next == '?') {
//                        continue;
//                    }
//                }
//            } else if (c == '(') {
//                node = new NfaOperator(String.valueOf(c));
//                _matchStack.push(node);
//                _mark(node);
//                ++index;
//            } else if (c == ')') {
//                node = new NfaOperator(String.valueOf(c));
//                _matchStack.push(node);
//                _mark(node);
//                ++index;
//            } else if (c == '*' || c == '+' || c == '?') {
//                node = new NfaOperator(String.valueOf(c));
//                _matchStack.push(node);
//                _mark(node);
//                ++index;
//            } else if (c == '|') {
//                node = new NfaOperator(String.valueOf(c));
//                _matchStack.push(node);
//                _mark(node);
//                ++index;
//            } else if (c == '\\') {
//                ++index;
//                c = body.charAt(index);
//                node = new NfaPattern1(String.valueOf(c), NfaPatternType.Alpha);
//                _matchStack.push(node);
//                _mark(node);
//                ++index;
//            } else if (c == '[') {
//                int end = _findFirstChar(body, index, ']');
//                node = new NfaPattern1(body.substring(index, end), NfaPatternType.Alpha);
//                _matchStack.push(node);
//                _mark(node);
//                index = end;
//                if (index < length - 1){
//                    char next = body.charAt(index + 1);
//                    if (next == '*' || next == '+' || next == '?'){
//                        continue;
//                    }
//                }
//
//            } else if (c == '{') {
//                int end = _findFirstChar(body, index, '}');
//                node = new NfaPattern1(body.substring(index, end), NfaPatternType.Alpha);
//                _matchStack.push(node);
//                _mark(node);
//                index = end;
//                if (index < length - 1){
//                    char next = body.charAt(index + 1);
//                    if (next == '*' || next == '+' || next == '?'){
//                        continue;
//                    }
//                }
//            }
//            NfaPatternType type = _match();
//            if (type != NfaPatternType.Alpha)
//                _matchStack.push(_reduce(type));
//        }
//
//        return _matchStack.pop();
//    }
//
//    public NfaPattern1 combinate(HashSet<NfaPattern1> patternSet) {
//        return null;
//    }
//
//    private int _findFirstChar(String s, int startIndex, char target) {
//        for (int i = startIndex; i < s.length() - startIndex; ++i)
//            if (s.charAt(i) == target) return i;
//        return -1;
//    }
//
//    private void _mark(INfaNode node) {
//        if (node.getNodeType() == NfaNodeType.Pattern) {
//            if (_matchTable[3][0] == _matchTable[3][1] + 1 && _matchTable[3][1] == _matchTable[3][2])
//                _matchTable[3][1] += 1;
//            if (_matchTable[2][0] == _matchTable[2][1])
//                _matchTable[2][0] += 1;
//            if (_matchTable[1][0] == _matchTable[1][1])
//                _matchTable[1][0] += 1;
//            if (_matchTable[1][0] == _matchTable[1][1] + 1)
//                _matchTable[1][1] += 1;
//            if (_matchTable[0][0] == _matchTable[0][1] && _matchTable[0][1] == _matchTable[0][2])
//                _matchTable[0][0] += 1;
//            if (_matchTable[0][0] == _matchTable[0][1] && _matchTable[0][1] == _matchTable[0][2] + 1)
//                _matchTable[0][2] += 1;
//        } else if (node.getNodeType() == NfaNodeType.Operator) {
//            String text = node.getNodeText();
//            if (text.equals("(")) {
//                _matchTable[3][0] += 1;
//            } else if (text.equals(")") && _matchTable[3][0] == _matchTable[3][1] && _matchTable[3][1] == _matchTable[3][2] + 1) {
//                _matchTable[3][2] += 1;
//            } else if ((text.equals("*") || text.equals("+") || text.equals("?")) && _matchTable[2][0] > 0) {
//                _matchTable[2][1] += 1;
//            } else if (text.equals("|") && _matchTable[0][0] == _matchTable[0][1] + 1 && _matchTable[0][1] == _matchTable[0][2]) {
//                _matchTable[0][1] += 1;
//            }
//        }
//    }
//
//    private NfaPattern1 _reduce(NfaPatternType type) {
//        NfaPattern1 pattern = null;
//        if (type == NfaPatternType.Bracket) {
//            _matchStack.pop();
//            INfaNode tmp = _matchStack.pop();
//            pattern = new NfaPattern1("(" + tmp.getNodeText() + ")", NfaPatternType.Alpha);
//            pattern.setLeftChildPattern((NfaPattern1)tmp);
//            pattern.setOperator(new NfaOperator("()"));
//            --_matchTable[3][0];
//            --_matchTable[3][1];
//            --_matchTable[3][2];
//            _matchStack.pop();
//        } else if (type == NfaPatternType.Closure) {
//            INfaNode tmpOp = _matchStack.pop();
//            INfaNode tmpAl = _matchStack.pop();
//            pattern = new NfaPattern1(tmpAl.getNodeText() + tmpOp.getNodeText(), NfaPatternType.Alpha);
//            pattern.setLeftChildPattern((NfaPattern1) tmpAl);
//            pattern.setOperator((NfaOperator) tmpOp);
//            --_matchTable[2][0];
//            --_matchTable[2][1];
//        } else if (type == NfaPatternType.Join) {
//            INfaNode tmpRal = _matchStack.pop();
//            INfaNode tmpLal = _matchStack.pop();
//            pattern = new NfaPattern1(tmpLal.getNodeText() + tmpRal.getNodeText(), NfaPatternType.Alpha);
//            pattern.setLeftChildPattern((NfaPattern1) tmpLal);
//            pattern.setRightChildPattern((NfaPattern1) tmpRal);
//            pattern.setOperator(new NfaOperator("·"));
//            --_matchTable[1][0];
//            --_matchTable[1][1];
//        } else if (type == NfaPatternType.Select) {
//            INfaNode tmpRal = _matchStack.pop();
//            INfaNode tmpOp = _matchStack.pop();
//            INfaNode tmpLal = _matchStack.pop();
//            pattern = new NfaPattern1(tmpLal.getNodeText() + tmpOp.getNodeText() + tmpRal.getNodeText(), NfaPatternType.Alpha);
//            pattern.setLeftChildPattern((NfaPattern1) tmpLal);
//            pattern.setRightChildPattern((NfaPattern1) tmpRal);
//            pattern.setOperator((NfaOperator) tmpOp);
//            --_matchTable[0][0];
//            --_matchTable[0][1];
//            --_matchTable[0][2];
//        }
//
//        return pattern;
//    }
//
//    private NfaPatternType _match() {
//        if (_matchTable[3][0] > 0 && _matchTable[3][0] == _matchTable[3][1] && _matchTable[3][1] == _matchTable[3][2]) return NfaPatternType.Bracket;
//        else if (_matchTable[2][0] > 0 && _matchTable[2][0] == _matchTable[2][1]) return NfaPatternType.Closure;
//        else if (_matchTable[1][0] > 0 && _matchTable[1][0] == _matchTable[1][1]) return NfaPatternType.Join;
//        else if (_matchTable[0][0] > 0 && _matchTable[0][0] == _matchTable[0][1] && _matchTable[0][1] == _matchTable[0][2]) return NfaPatternType.Select;
//        else return NfaPatternType.Alpha;
//    }
//
//    private NfaAlphabet _parseAlphabet(String name, String text) {
//        return NfaAlphabet.CreateAlphabet(name, text);
//    }
//
//    private void _initMatchTable() {
//        //Σ|Σ select
//        _matchTable[0][0] = 0;
//        _matchTable[0][1] = 0;
//        _matchTable[0][2] = 0;
//        //ΣΣ or Σ·Σ join
//        _matchTable[1][0] = 0;
//        _matchTable[1][1] = 0;
//        _matchTable[1][2] = -1;
//        //Σ* or Σ? or Σ+ closure
//        _matchTable[2][0] = 0;
//        _matchTable[2][1] = 0;
//        _matchTable[2][2] = -1;
//        //(Σ) bracket
//        _matchTable[3][0] = 0;
//        _matchTable[3][1] = 0;
//        _matchTable[3][2] = 0;
//    }

//    private HashSet<NfaAlphabet> _alphabetSet;
//    private HashSet<NfaPattern1> _patternSet;
//    private int[][] _matchTable;
//    private Stack<INfaNode> _matchStack;
}
