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
        super("test");
        mType = null;
        mBase = null;
        mOffset = 0;
    }

    // public VarSTE(String name){
    //     super(name);
    //     mType = null;
    //     mBase = null;
    //     mOffset = 0;
    // }
    //
    public VarSTE(String name, String base, int off){
        super(name);
        mType = null;
        mBase = base;
        mOffset = off;

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
