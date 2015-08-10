package edu.self.eac.lexer.dfa.gen;

import edu.self.eac.lexer.nfa.cons.INfaConstruction;
import edu.self.eac.lexer.nfa.gen.NfaDiagram;
import edu.self.eac.lexer.nfa.gen.NfaGenerator;
import edu.self.eac.lexer.re.def.ReDefinition;
import edu.self.eac.lexer.re.gen.ReGenerator;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by xuehui on 15/8/10.
 */
public class DfaGeneratorTest {

    @Test
    public void testConvert() throws Exception {
        String filePath = "./test/edu/self/eac/lexer/re/gen/re1.txt";
        BufferedReader br = new BufferedReader(new InputStreamReader(
                new FileInputStream(filePath)));

        ReGenerator gen = new ReGenerator();
        ReDefinition redef = gen.parse(br);

        NfaGenerator ngen = new NfaGenerator(redef);
        ArrayList<INfaConstruction> conList = ngen.parse();
        NfaDiagram nfaDiagram = new NfaDiagram(conList, ngen.getAlphabet());

        DfaGenerator dgen = new DfaGenerator(nfaDiagram);
        DfaDiagram dfaDiagram = dgen.convert();

        if (dfaDiagram.match("ab"))
            System.out.print("Match");
        else
            System.out.print("Not match");
    }
}