package edu.self.eac.lexer.nfa;

/**
 * Created by xuehui on 15/7/26.
 */
public class NfaPatternTracer {
    public NfaPatternTracer() {
        _matchTracer = new int[6][3];
        _initMatchTracer();
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
        _matchTracer[0][0] = 0;
        _matchTracer[0][1] = 0;
        _matchTracer[0][2] = 0;
    }

    private int[][] _matchTracer;
}
