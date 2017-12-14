package symtable;
import java.util.*;
import ast.node.*;

import exceptions.InternalException;

public class ClassSTE extends STE{

    private Scope mScope;
    private boolean mMain;

    //must be able to identify if class is main for correct type checking
    public ClassSTE(String name, boolean main, Scope sc){
		super(name);
        mMain = main;
        mScope = sc;
    }

    public Scope getScope(){
        return mScope;
    }

    public void setScope(Scope sc){
        mScope = sc;
    }

    public void setMain(boolean isMain){
        mMain = isMain;
    }

    public boolean getMain(){
        return mMain;
    }




}
