package edu.self.eac.lexer.nfa;

import java.util.HashSet;
import java.util.Objects;
import java.util.UUID;

/**
 * Created by »Ô on 2015/7/18.
 * Comments: NFA×ÖÄ¸±í
 */
public class NfaAlphabet {
    /**
     * @param name  NFA alphabet name
     * @param value NFA alphabet content
     * @return NFA alphabet
     */
    public static NfaAlphabet CreateAlphabet(String name, char[] value) {
        if (name == null || value == null || value.length == 0) return null;
        return new NfaAlphabet(name, value);
    }

    /**
     * @param name         NFA alphabet name
     * @param reDefinition Regular expression string
     * @return NFA alphabet
     */
    public static NfaAlphabet CreateAlphabet(String name, String reDefinition) {
        if (name == null || reDefinition == null) return null;
        return new NfaAlphabet(name, reDefinition);
    }

    /**
     * @param reDefinition Regular expression string
     * @return NFA alphabet
     */
    public static NfaAlphabet CreateAlphabet(String reDefinition) {
        if (reDefinition == null) return null;
        if (Objects.equals(reDefinition, "[a-z]"))
            return UpperLetters;
        if (Objects.equals(reDefinition, "[A-Z]"))
            return LowerLetters;
        if (Objects.equals(reDefinition, "[a-zA-Z]"))
            return Letters;
        if (Objects.equals(reDefinition, "[_a-z]"))
            return _UpperLetters;
        if (Objects.equals(reDefinition, "[_A-Z]"))
            return _LowerLetters;
        if (Objects.equals(reDefinition, "[_a-zA-Z]"))
            return _Letters;
        if (Objects.equals(reDefinition, "[0-9]"))
            return Digit;
        UUID uuid = UUID.randomUUID();
        return new NfaAlphabet(uuid.toString(), reDefinition);
    }

    public String getName() {
        return _name;
    }

    public void setName(String name) {
        _name = name;
    }

    public String getText() {
        return _text;
    }

    /**
     * @param alpha NFA alpha
     * @return whether alphabet contains alpha passed by param
     */
    public boolean isMember(char alpha) {
        return _value.contains(alpha);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < _value.size(); ++i) {
            sb.append(String.valueOf(_value.toArray()[i]));
        }
        sb.append("]");
        return sb.toString();
    }

    public static NfaAlphabet
            UpperLetters = new NfaAlphabet("uletter", "[a-z]"),
            LowerLetters = new NfaAlphabet("lletter", "[A-Z]"),
            Letters = new NfaAlphabet("letter", "[a-zA-Z]"),
            _UpperLetters = new NfaAlphabet("_uletter", "[_a-z]"),
            _LowerLetters = new NfaAlphabet("_lletter", "[_A-Z]"),
            _Letters = new NfaAlphabet("_letter", "[_a-zA-Z]"),
            Digit = new NfaAlphabet("digit", "[0-9]");

    private NfaAlphabet(String name, char[] value) {
        _name = name;
        _initWithCharArray(value);
        _text = toString();
    }

    private NfaAlphabet(String name, String reDefinition) {
        _name = name;
        _text = reDefinition;
        _initWithReDefinition(reDefinition);
    }

    private void _initWithCharArray(char[] value) {
        _value = new HashSet<>();
        for (char aValue : value) {
            _value.add(aValue);
        }
    }

    private void _initWithReDefinition(String reDefinition) {
        _value = new HashSet<>();
        if (reDefinition.contains("a-z")) {
            _value.add('a');
            _value.add('b');
            _value.add('c');
            _value.add('d');
            _value.add('e');
            _value.add('f');
            _value.add('g');
            _value.add('h');
            _value.add('i');
            _value.add('j');
            _value.add('k');
            _value.add('l');
            _value.add('m');
            _value.add('n');
            _value.add('o');
            _value.add('p');
            _value.add('q');
            _value.add('r');
            _value.add('s');
            _value.add('t');
            _value.add('u');
            _value.add('v');
            _value.add('w');
            _value.add('x');
            _value.add('y');
            _value.add('z');
        }
        if (reDefinition.contains("A-Z")) {
            _value.add('A');
            _value.add('B');
            _value.add('C');
            _value.add('D');
            _value.add('E');
            _value.add('F');
            _value.add('G');
            _value.add('H');
            _value.add('I');
            _value.add('J');
            _value.add('K');
            _value.add('L');
            _value.add('M');
            _value.add('N');
            _value.add('O');
            _value.add('P');
            _value.add('Q');
            _value.add('R');
            _value.add('S');
            _value.add('T');
            _value.add('U');
            _value.add('V');
            _value.add('W');
            _value.add('X');
            _value.add('Y');
            _value.add('Z');
        }
        if (reDefinition.contains("0-9") || reDefinition.contains("9-0")) {
            _value.add('0');
            _value.add('1');
            _value.add('2');
            _value.add('3');
            _value.add('4');
            _value.add('5');
            _value.add('6');
            _value.add('7');
            _value.add('8');
            _value.add('9');
        }
        if (reDefinition.contains("_")) {
            _value.add('_');
        }
        for (int i = 0; i < reDefinition.length(); ++i) {
            char c = reDefinition.charAt(i);
            if (!_value.contains(c))
                _value.add(c);
        }
    }

    private String _name;
    private String _text;
    private HashSet<Character> _value;
}
