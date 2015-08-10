package edu.self.eac.lexer.dfa.gen;

import edu.self.eac.lexer.nfa.state.NfaState;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Created by xuehui on 15/8/6.
 */
public class DfaTransTable {
    public DfaTransTable() {
        _itemList = new ArrayList<>();
    }

    public boolean addItem(DfaTransTableItem item) {
        return _itemList.add(item);
    }

    public ArrayList<DfaTransTableItem> getItemList() {
        return _itemList;
    }

    public HashSet<NfaState> getNextStateSet(HashSet<NfaState> currentState, String inputChar) {
        for (DfaTransTableItem item : _itemList) {
            if (item.getCurrentStateSet() == currentState && item.getInputChar().equals(inputChar))
                return item.getNextStateSet();
        }
        return null;
    }

    private ArrayList<DfaTransTableItem> _itemList;
}
