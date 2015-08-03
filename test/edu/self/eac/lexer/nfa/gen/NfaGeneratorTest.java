package edu.self.eac.lexer.nfa.gen;

import edu.self.eac.lexer.nfa.cons.INfaConstruction;
import edu.self.eac.lexer.re.def.ReDefinition;
import edu.self.eac.lexer.re.def.ReProduction;
import edu.self.eac.lexer.re.gen.ReGenerator;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by xuehui on 15/8/2.
 */
public class NfaGeneratorTest {

    @Test
    public void testParse() throws Exception {
        String filePath = "./test/edu/self/eac/lexer/re/gen/re.txt";
        BufferedReader br = new BufferedReader(new InputStreamReader(
                new FileInputStream(filePath)));

        ReGenerator gen = new ReGenerator();
        ReDefinition redef = gen.parse(br);

        NfaGenerator ngen = new NfaGenerator(redef);
        ArrayList<INfaConstruction> conList = ngen.parse();
        System.out.println();
    }
}