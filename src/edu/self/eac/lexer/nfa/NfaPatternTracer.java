package edu.self.eac.lexer.nfa;

import edu.self.eac.lexer.nfa.INfaNode;
import edu.self.eac.lexer.nfa.NfaPatternType;
import edu.self.eac.lexer.nfa.cons.INfaConstruction;
import edu.self.eac.lexer.nfa.cons.NfaAlphabetConstruction;
import edu.self.eac.lexer.nfa.cons.NfaOperatorConstruction;
import edu.self.eac.lexer.re.def.*;

/**
 * Created by xuehui on 15/7/26.
 */
public class NfaPatternTracer {
    public NfaPatternTracer() {
        _matchTracer = new int[6][3];
        _initMatchTracer();
    }

    public void trace(INfaConstruction con) {
        if (con instanceof NfaOperatorConstruction) {
            ReOperator op = ((NfaOperatorConstruction) con).getReOperator();
            if (op instanceof ReOpLeftBracket) {
                ++_matchTracer[0][0];
            }
            else if (op instanceof ReOpRightBracket) {
                if (_matchTracer[0][0] == _matchTracer[0][1] && _matchTracer[0][1] == _matchTracer[0][2] + 1) {
                    ++_matchTracer[0][2];
                }
                else {
                    throw new Error("括号匹配错误。");
                }
            }
            else if (op instanceof ReOpKleeneClosure) {
                if (_matchTracer[1][0] == _matchTracer[1][1] + 1) {
                    ++_matchTracer[1][1];
                }
                else {
                    throw new Error("克林闭包匹配错误。");
                }
            }
            else if (op instanceof ReOpPositiveClosure) {
                if (_matchTracer[2][0] == _matchTracer[2][1] + 1) {
                    ++_matchTracer[2][1];
                }
                else {
                    throw new Error("正闭包匹配错误。");
                }
            }
            else if (op instanceof ReOpOptional) {
                if (_matchTracer[3][0] == _matchTracer[3][1] + 1) {
                    ++_matchTracer[3][1];
                }
                else  {
                    throw new Error("可选操作符匹配错误。");
                }
            }
            else if (op instanceof ReOpJoin) {
                if (_matchTracer[4][0] == _matchTracer[4][1] + 1 && _matchTracer[4][1] == _matchTracer[4][2]) {
                    ++_matchTracer[4][1];
                }
                else {
                    throw new Error("连接操作符匹配错误。");
                }
            }
            else if (op instanceof ReOpSelect) {
                if (_matchTracer[5][0] == _matchTracer[5][1] + 1 && _matchTracer[5][1] == _matchTracer[5][2]) {
                    ++_matchTracer[5][1];
                }
                else {
                    throw new Error("选择操作符匹配错误。");
                }
            }
        }
        else {

        }
    }

    public NfaPatternType match() {

    }

    public INfaConstruction reduce(NfaPatternType type) {

    }

    private void _initMatchTracer() {
        //(Σ) bracket
        _matchTracer[0][0] = 0;
        _matchTracer[0][1] = 0;
        _matchTracer[0][2] = 0;
        //Σ* kleene closure
        _matchTracer[1][0] = 0;
        _matchTracer[1][1] = 0;
        _matchTracer[1][2] = -1;
        //Σ+ positive closure
        _matchTracer[2][0] = 0;
        _matchTracer[2][1] = 0;
        _matchTracer[2][2] = -1;
        //Σ? optional
        _matchTracer[3][0] = 0;
        _matchTracer[3][1] = 0;
        _matchTracer[3][2] = -1;
        //ΣΣ or Σ·Σ join
        _matchTracer[4][0] = 0;
        _matchTracer[4][1] = 0;
        _matchTracer[4][2] = 0;
        //Σ|Σ select
        _matchTracer[5][0] = 0;
        _matchTracer[5][1] = 0;
        _matchTracer[5][2] = 0;
    }

    private int[][] _matchTracer;
}
