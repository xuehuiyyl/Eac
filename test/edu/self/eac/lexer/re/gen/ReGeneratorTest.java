package edu.self.eac.lexer.re.gen;

import edu.self.eac.lexer.re.def.IReElement;
import edu.self.eac.lexer.re.def.ReAlphaSet;
import edu.self.eac.lexer.re.def.ReProduction;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Hashtable;

import static org.junit.Assert.*;

/**
 * Created by xuehui on 15/7/31.
 */
public class ReGeneratorTest {

    @Test
    public void testParse() throws Exception {

    }

    @Test
    public void testParseLine() throws Exception {
        ReGenerator gen = new ReGenerator();
        IReElement element = gen.parseLine("letter [a-z]");
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
            System.out.println("RE字母集："+name);
            for (IReElement item : _elementList) {
                System.out.println(item.getName());
            }
        }
    }
}