package edu.self.eac.lexer.re;

/**
 * Created by xuehui on 15/7/24.
 */
public class ReGenerator {
    public ReDefinition parse() {
        return null;
    }

    public IReElement parseLine(String line) {
        int index = _findFirstChar(line, 0, ' ');
        String name = line.substring(0, index - 1);
        String redefinition = line.substring(index + 1);

        return null;
    }

    private int _findFirstChar(String s, int startIndex, char target) {
        for (int i = startIndex; i < s.length() - startIndex; ++i)
            if (s.charAt(i) == target) return i;
        return -1;
    }
}
