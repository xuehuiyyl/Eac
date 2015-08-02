package edu.self.eac.lexer.re.gen;

import edu.self.eac.lexer.re.def.IReElement;
import edu.self.eac.lexer.re.def.ReAlphaSet;
import edu.self.eac.lexer.re.def.ReDefinition;
import edu.self.eac.lexer.re.def.ReProduction;
import org.junit.Test;

import java.util.ArrayList;
import java.io.*;

import static org.junit.Assert.*;

/**
 * Created by xuehui on 15/7/31.
 */
public class ReGeneratorTest {

    @Test
    public void testParse() throws Exception {
        String filePath = "./test/edu/self/eac/lexer/re/gen/re.txt";
        BufferedReader br = new BufferedReader(new InputStreamReader(
                new FileInputStream(filePath)));

        ReGenerator gen = new ReGenerator();
        ReDefinition redef = gen.parse(br);

        ArrayList<ReAlphaSet> alphaSetList = redef.getAlphaSetList();
        for (ReAlphaSet element : alphaSetList) {
            String name = element.getName();
            System.out.println("RE字母集："+name);
            Object[] value = element.getValue().values().toArray();
            for (int i = 0; i < value.length; ++i) {
                System.out.println(value[i]);
            }
            System.out.println();
        }

        ArrayList<ReProduction> productionList = redef.getProductionList();
        for (ReProduction element : productionList) {
            String name = element.getName();
            ArrayList<IReElement> _elementList = element.getElementList();
            System.out.println("RE产生式："+name);
            for (IReElement item : _elementList) {
                System.out.println(item.getName());
            }
            System.out.println();
        }
    }

    @Test
    public void testParseLine() throws Exception {
        ReGenerator gen = new ReGenerator();
        IReElement element = gen.parseLine("pro {letter}[0-9]a(b|c)*");
//        IReElement element = gen.parseLine("letter [a-zA-Z]");
        if (element instanceof ReAlphaSet) {
            String name = element.getName();
            System.out.println("RE字母集："+name);
            Object[] value = ((ReAlphaSet) element).getValue().values().toArray();
            for (int i = 0; i < value.length; ++i) {
                System.out.println(value[i]);
            }
            System.out.println();
        }
        else if (element instanceof ReProduction) {
            String name = element.getName();
            ArrayList<IReElement> _elementList = ((ReProduction) element).getElementList();
            System.out.println("RE产生式："+name);
            for (IReElement item : _elementList) {
                System.out.println(item.getName());
            }
        }
    }
}