package symtable;
import java.util.*;
import ast.node.*;
import java.io.PrintWriter;
import java.io.PrintStream;

import exceptions.InternalException;

/**
 * SymTable
 * ....
 * The symbol table also keeps a mapping of expression nodes to
 * types because that information is needed elsewhere especially
 * when looking up method call information.
 *
 * @author mstrout
 * WB: Simplified to only expression types
 */
public class SymTable {
    private final HashMap<Node,Type> mExpType = new HashMap<Node,Type>();
    private String SymName;
    private Scope mGlobalScope = Scope.G;
    private Stack<Scope> mScopeStack = new Stack<Scope>();


    public SymTable() {
      mScopeStack.push(mGlobalScope); //kek no idea
      System.out.println(mGlobalScope.getName());
      SymName = "Global";
      System.out.println(mScopeStack.isEmpty());
      //write this
    }

    public SymTable(Scope globalScope){
        mGlobalScope = globalScope;
    }


    /** Lookup a symbol in this symbol table.
 * Starts looking in innermost scope and then
 * look in enclosing scopes.
 * Returns null if the symbol is not found.
 */
    public STE lookup(String sym) {
    /* WRITE ME */
        STE ste = null;
        Stack<Scope> t = (Stack<Scope>) mScopeStack.clone();
        while(mScopeStack.isEmpty() != true){
            ste = lookupInnermost(sym);
            if(ste != null){
                return ste;
            }
            mScopeStack.pop(); //@Danny: currently destroys stack on lookup // @Chase: yeah it does
        }
        mScopeStack = t;
        return ste;
    }


    // Lookup a symbol in innermost scope only.
     // return null if the symbol is not found
     //
    public STE lookupInnermost(String sym) {
    //    STE ste = null;
        Scope currentScope = mScopeStack.peek();
        // if(currentScope == null){
        //     return null;
        // }
      //NEED SCOPE CLASS @class
        return currentScope.STElookup(sym);
        //return ste;
    }


    /** When inserting an STE will just insert
     * it into the scope at the top of the scope stack.
     */

    public void insert(STE ste) {
        Scope currentScope = mScopeStack.peek();
        boolean success = false;
        success = currentScope.insert(ste);
        if(success == false){
            System.out.println("*** Failed to insert STE ***");
        }


        //NEED STE CLASS @class
        /* WRITE ME */
    }


    /**
     * Lookup the given method scope and make it the innermost
     * scope.  That is, make it the top of the scope stack.
     */

    public void pushScope(String id) {
        STE ste = lookup(id);
        MethodSTE mste = null;
        mste = (MethodSTE)ste; //@Danny I tried to cast as a methodSTE to try to get access to getScope();
        mScopeStack.push(mste.getScope());
    }


    public void popScope() {
        mScopeStack.pop();
    }

    public void outputDot(PrintStream printer){
      	@SuppressWarnings("unchecked")
  		Stack<Scope> tempScopeStack = (Stack<Scope>) mScopeStack.clone();
  		printer.println("digraph SymTable {\n"+
  			"\tgraph [rankdir=\"LR\"];\n"+
  			"\tnode [shape=record];");
  		mGlobalScope.outputDot(printer);
  		while(!tempScopeStack.isEmpty()){
  			tempScopeStack.peek().outputDot(printer);
  			tempScopeStack.pop();
  		}
  		printer.println("}");
  	}

    public Scope viewScope(){
        return mScopeStack.peek();
    }


    public void setExpType(Node exp, Type t)
    {
    	this.mExpType.put(exp, t);
    }


    public Type getExpType(Node exp)
    {
    	return this.mExpType.get(exp);
    }



/*
 */

}
