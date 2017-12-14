package symtable;
import java.util.*;
import ast.node.*;

import exceptions.InternalException;


public class MethodSTE extends STE{
//Needs: mSignature, mScope
    private String mSignature;
    private Scope mScope;


    // public MethodSTE(){
    //     super();
    //     mSignature = null;
    //     mScope = null;
    // }

    public MethodSTE(String name, String signature, Scope sc){
        super(name);
        mSignature = signature;
        mScope = sc;
    }


    public String getSignature(){
        return mSignature;
    }

    public void setSignature(String sig){
        mSignature = sig;
    }

    public Scope getScope(){
        return mScope;
    }

    public void setScope(Scope sc){
        mScope = sc;
    }



}
