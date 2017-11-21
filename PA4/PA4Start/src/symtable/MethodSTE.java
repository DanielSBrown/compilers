package symtable;
import java.util.*;
import ast.node.*;

import exceptions.InternalException;


public class MethodSTE extends STE{
//Needs: mSignature, mScope
    private String mSignature;
    private Scope mScope;


    public MethodSTE(){
        mSignature = null;
        mScope = null;
    }

    public MethodSTE(String sig, Scope sc){
        mSignature = sig;
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
