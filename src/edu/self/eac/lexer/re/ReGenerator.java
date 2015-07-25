package edu.self.eac.lexer.re;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by xuehui on 15/7/24.
 */
public class ReGenerator {
    public ReDefinition parse(BufferedReader br) throws IOException {
        ReDefinition rdef = new ReDefinition();
        String line;
        while ((line = br.readLine()) != null) {
            if (0 == line.length()) continue;

            IReElement element = parseLine(line);
            if (element instanceof ReAlphaSet) {
                rdef.addAlphaSet((ReAlphaSet)element);
            }
            else if (element instanceof  ReProduction) {
                rdef.addProduction((ReProduction)element);
            }
        }

        return rdef;
    }

    public IReElement parseLine(String line) {
        int index = _findFirstChar(line, 0, ' ');
        String name = line.substring(0, index - 1);
        String redefinition = line.substring(index + 1);

        if (redefinition.startsWith("[") && redefinition.endsWith("]")) {
            return new ReAlphaSet(name, redefinition);
        }

        index = 0;
        ArrayList<IReElement> elementList = new ArrayList<>();

        while (index < redefinition.length()) {
            char peek = redefinition.charAt(index);
            if (peek == '\\') {
                elementList.add(new ReAlpha(redefinition.charAt(index + 1)));
                ++index;
            }
            else if (peek == '{') {
                int rbindex = _findFirstChar(line, index, '}');
                String refname = line.substring(index + 1, rbindex - 1);
                elementList.add(new ReAlphaSetReference(refname));
                index = rbindex + 1;
            }
            else if (peek == '(') {
                elementList.add(new ReOpLeftBracket());
                ++index;
            }
            else if (peek == ')') {
                elementList.add(new ReOpRightBracket());
                ++index;
            }
            else if (peek == '*') {
                elementList.add(new ReOpClosure());
                ++index;
            }
            else if (peek == '¡¤') {
                elementList.add(new ReOpJoin());
                ++index;
            }
            else if (peek == '|') {
                elementList.add(new ReOpSelect());
                ++index;
            }
            else if (Character.isLetterOrDigit(peek)){
                elementList.add(new ReAlpha(peek));
                ++index;
            }
        }

        ReProduction production = new ReProduction(name, redefinition);
        production.setElementList(elementList);

        return production;
    }

    private int _findFirstChar(String s, int startIndex, char target) {
        for (int i = startIndex; i < s.length() - startIndex; ++i)
            if (s.charAt(i) == target) return i;
        return -1;
    }
}
