package symtable;
import java.util.*;
import ast.node.*;

import exceptions.InternalException;

public class VarSTE extends STE{
//Needs: mType, mBase, mOffset
    private Type mType;
    private String mBase;
    private int mOffset;

    public VarSTE(){
        mType = null;
        mBase = null;
        mOffset = -1;
    }

    public VarSTE(String name, Type t, String base, int off){
        super(name);
        mType = t;
        mBase = base;
        mOffset = off;
    }


    public Type getType(){
        return mType;
    }

    public void setType(Type t){
        mType = t;
    }

    public String getBase(){
        return mBase;
    }

    public void setBase(String id){
        mBase = id;
    }

    public int getOffset(){
        return mOffset;
    }

    public void setOffset(int off){
        mOffset = off;
    }

}
