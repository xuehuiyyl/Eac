package edu.self.eac.lexer.nfa.gen;

import edu.self.eac.lexer.nfa.cons.*;
import edu.self.eac.lexer.re.def.*;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by �� on 2015/7/18.
 * Comments: NFA generator
 */
public class NfaGenerator {
    public NfaGenerator(ReDefinition redefinition) {
        _redefinition = redefinition;
        _stack = new Stack<>();
        _constructionList = new ArrayList<>();
    }

    public ArrayList<INfaConstruction> parse() {
        _alphaSetList = _redefinition.getAlphaSetList();
        _productionList = _redefinition.getProductionList();
        _constructionList.clear();

        for (ReProduction production : _productionList) {
            INfaConstruction cons = _parseProduction(production);
            _constructionList.add(cons);
        }

        return _constructionList;
    }



    private INfaConstruction _parseProduction(ReProduction production) {
        _stack.clear();
        _currentReProduction = production;
        ArrayList<IReElement> elementList = production.getElementList();
        INfaConstruction construction;
        for (int index = 0; index < elementList.size(); ++index) {
            IReElement element = elementList.get(index);
            _currentReElementIndex = index;
            if (element instanceof ReAlpha) {
                construction = new NfaAlphabetConstruction((ReAlpha) element);
                _stack.push(construction);
                _match();
            } else if (element instanceof ReAlphaSet) {
                construction = new NfaAlphabetConstruction((ReAlphaSet) element);
                _stack.push(construction);
                _match();
            } else if (element instanceof ReReference) {
                ReAlphaSet alphaSet = null;
                for (ReAlphaSet as : _alphaSetList) {
                    if (as.getName().equals(element.getName())) {
                        alphaSet = as;
                        break;
                    }
                }
                if (alphaSet != null) {
                    construction = new NfaAlphabetConstruction(alphaSet);
                    _stack.push(construction);
                    _match();
                    continue;
                }

                for (INfaConstruction cons : _constructionList) {
                    if (cons.getProductionName().equals(element.getName())) {
                        construction = cons.copy();
                        _stack.push(construction);
                        _match();
                        continue;
                    }
                }
            } else if (element instanceof ReOpLeftBracket) {
                construction = new NfaOperatorConstruction((ReOpLeftBracket) element);
                _stack.push(construction);
                _match();
            } else if (element instanceof ReOpRightBracket) {
                construction = new NfaOperatorConstruction((ReOpRightBracket) element);
                _stack.push(construction);
                _match();
            } else if (element instanceof ReOpKleeneClosure) {
                construction = new NfaOperatorConstruction((ReOpKleeneClosure) element);
                _stack.push(construction);
                _match();
            } else if (element instanceof ReOpPositiveClosure) {
                construction = new NfaOperatorConstruction((ReOpPositiveClosure) element);
                _stack.push(construction);
                _match();
            } else if (element instanceof ReOpOptional) {
                construction = new NfaOperatorConstruction((ReOpOptional) element);
                _stack.push(construction);
                _match();
            } else if (element instanceof ReOpJoin) {
                construction = new NfaOperatorConstruction((ReOpJoin) element);
                _stack.push(construction);
                _match();
            } else if (element instanceof ReOpSelect) {
                construction = new NfaOperatorConstruction((ReOpSelect) element);
                _stack.push(construction);
                _match();
            }
        }

        if (_stack.size() == 1)
            return _stack.pop();
        else
            throw new Error("产生式：" + production.getName() + "定义错误。");
    }

    private void _match() {
        if (_stack.size() < 2) return;

        boolean matchSuccess = false;
        while(true) {
            matchSuccess = false;
            INfaConstruction peek = _stack.elementAt(_stack.size() - 1);

            if (_stack.size() < 2) return;
            INfaConstruction next = _stack.elementAt(_stack.size() - 2);

            if (peek instanceof NfaOperatorConstruction) {
                if (next instanceof NfaOperatorConstruction) {
                    //throw new Error("相邻的操作符：" + ((NfaOperatorConstruction) next).getReOperator().getName() + ((NfaOperatorConstruction) peek).getReOperator().getName());
                    return;
                }

                ReOperator operator = ((NfaOperatorConstruction) peek).getReOperator();
                if (operator instanceof ReOpRightBracket) {
                    if (_stack.size() < 3) {
                        throw new Error("语法错误，无法匹配的右括号')'");
                    }

                    INfaConstruction last = _stack.elementAt(_stack.size() - 3);
                    if (!(last instanceof NfaOperatorConstruction)) return;
                    if (!(((NfaOperatorConstruction) last).getReOperator() instanceof ReOpLeftBracket)) return;

                    INfaConstruction cons = new NfaBracketConstruction((NfaOperatorConstruction)last,next,(NfaOperatorConstruction)peek);
                    _stack.pop();
                    _stack.pop();
                    _stack.pop();
                    _stack.push(cons);
                    matchSuccess = true;
                }
                else if (operator instanceof ReOpOptional) {
                    INfaConstruction cons = new NfaOptionalConstruction(next,(NfaOperatorConstruction)peek);
                    _stack.pop();
                    _stack.pop();
                    _stack.push(cons);
                    matchSuccess = true;
                }
                else if (operator instanceof ReOpPositiveClosure) {
                    INfaConstruction cons = new NfaPositiveClosureConstruction(next,(NfaOperatorConstruction)peek);
                    _stack.pop();
                    _stack.pop();
                    _stack.push(cons);
                    matchSuccess = true;
                }
                else if (operator instanceof ReOpKleeneClosure) {
                    INfaConstruction cons = new NfaKleeneClosureConstruction(next, (NfaOperatorConstruction)peek);
                    _stack.pop();
                    _stack.pop();
                    _stack.push(cons);
                    matchSuccess = true;
                }
            }
            else {
                if (next instanceof NfaOperatorConstruction) {
                    INfaConstruction last = _stack.elementAt(_stack.size() - 3);
                    if (last instanceof NfaOperatorConstruction) return;
                    if (((NfaOperatorConstruction) next).getReOperator() instanceof ReOpJoin) {
                        if (_currentReElementIndex < _currentReProduction.getElementList().size() - 1) {
                            IReElement lookahead = _currentReProduction.getElementList().get(_currentReElementIndex + 1);
                            if (lookahead instanceof ReOpKleeneClosure || lookahead instanceof ReOpPositiveClosure || lookahead instanceof ReOpOptional)
                                break;
                        }
                        INfaConstruction cons = new NfaJoinConstruction(last, (NfaOperatorConstruction) next, peek);
                        _stack.pop();
                        _stack.pop();
                        _stack.pop();
                        _stack.push(cons);
                        matchSuccess = true;
                    } else if (((NfaOperatorConstruction) next).getReOperator() instanceof ReOpSelect) {
                        if (_currentReElementIndex < _currentReProduction.getElementList().size() - 1) {
                            IReElement lookahead = _currentReProduction.getElementList().get(_currentReElementIndex + 1);
                            if (lookahead instanceof ReOpKleeneClosure || lookahead instanceof ReOpPositiveClosure || lookahead instanceof ReOpOptional)
                                break;
                        }
                        INfaConstruction cons = new NfaSelectConstruction(last, (NfaOperatorConstruction) next, peek);
                        _stack.pop();
                        _stack.pop();
                        _stack.pop();
                        _stack.push(cons);
                        matchSuccess = true;
                    }
                } else {
                    if (_currentReElementIndex < _currentReProduction.getElementList().size() - 1) {
                        IReElement lookahead = _currentReProduction.getElementList().get(_currentReElementIndex + 1);
                        if (lookahead instanceof ReOpKleeneClosure || lookahead instanceof ReOpPositiveClosure || lookahead instanceof ReOpOptional)
                            break;
                    }

                    INfaConstruction cons = new NfaJoinConstruction(next, new NfaOperatorConstruction(new ReOpJoin()), peek);
                    _stack.pop();
                    _stack.pop();
                    _stack.push(cons);
                    matchSuccess = true;
                }
            }
            if (!matchSuccess) break;
        }
    }

    private Stack<INfaConstruction> _stack;
    private ReDefinition _redefinition;
    private ArrayList<ReAlphaSet> _alphaSetList;
    private ArrayList<ReProduction> _productionList;
    private ArrayList<INfaConstruction> _constructionList;
    private int _currentReElementIndex;
    private ReProduction _currentReProduction;
}
