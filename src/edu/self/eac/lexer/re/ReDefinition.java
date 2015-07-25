package edu.self.eac.lexer.re;

import java.util.ArrayList;

/**
 * Created by xuehui on 15/7/23.
 */
public class ReDefinition {
    public ReDefinition(){
        _alphaSetList = new ArrayList<>();
        _productionList = new ArrayList<>();
    }

    public ArrayList<ReAlphaSet> getAlphaSetList() {
        return _alphaSetList;
    }

    public ArrayList<ReProduction> getProductionList() {
        return _productionList;
    }

    public boolean addAlphaSet(ReAlphaSet alphaSet) {
        return _alphaSetList.add(alphaSet);
    }

    public boolean addProduction(ReProduction production) {
        return _productionList.add(production);
    }

    public boolean containsAlphaSet(String name) {
        for (ReAlphaSet alphaSet : _alphaSetList) {
            if (alphaSet.getName() == name)
                return true;
        }
        return false;
    }

    public boolean containsProduction(String name) {
        for (ReProduction production : _productionList){
            if (production.getName() == name)
                return true;
        }
        return false;
    }

    private ArrayList<ReAlphaSet> _alphaSetList;
    private ArrayList<ReProduction> _productionList;
}
