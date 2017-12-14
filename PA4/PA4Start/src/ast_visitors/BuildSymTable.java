/**
 * This ast walker generates dot output for the AST.
 *
 * 6/06 - Modified from Brian Richard's ParserTest.Java.
 *        Michelle Strout
 */
package ast_visitors;

import java.io.PrintWriter;
import java.util.*;
import symtable.*;
import ast.visitor.DepthFirstVisitor;
import ast.node.*;
import exceptions.SemanticException;


/**
 * We extend the DepthFirstAdapter.
 * Visitors invoke a defaultCase method on each node they visit.
 * We override this method so that it
 * prints out dot info about a node.
 */
public class BuildSymTable extends DepthFirstVisitor {

   private SymTable s;

   /** Constructor takes a PrintWriter, and stores in instance var. */
   public BuildSymTable() {
      s = new SymTable();
   }


   /** Upon entering each node in AST, check of this node is the root
   to generate start of .dot file, output the dot output for the node.
   */
   public void defaultIn(Node node) {
      Type tempType = null;
      if (node instanceof TrueLiteral) {
        tempType = Type.BOOL;
        s.setExpType(node, tempType);
      }
      else if (node instanceof FalseLiteral) {
        tempType = Type.BOOL;
        s.setExpType(node, tempType);
      }
      else if (node instanceof ByteType) {
        tempType = Type.BYTE;
        s.setExpType(node, tempType);
      }
      else if (node instanceof IntLiteral) {
        tempType = Type.INT;
        s.setExpType(node, tempType);
      }
      else if (node instanceof ColorLiteral) {
        tempType = Type.COLOR;
        s.setExpType(node, tempType);
      }
      else if (node instanceof ButtonLiteral) {
        tempType = Type.BUTTON;
        s.setExpType(node, tempType);
      }
      else if (node instanceof ToneLiteral) {
        tempType = Type.TONE;
        s.setExpType(node, tempType);
      }


   }

//slides 16,17,18
   public void inMethodDecl(MethodDecl node){
        //lookup method name in current sym table to see if there are dups
        String signature = "(";
        String name = node.getName();

        //signature generation?
        LinkedList<Formal> paramlist = node.getFormals();
        for(Formal p : paramlist){
            signature += p.getType() + ", ";
        }
        signature += ") returns " + node.getType();
        System.out.println("inMethodDecl signature = " + signature);

        if(s.lookup(name) == null){
            //Create func signature object of some kind
            //@Danny trying to figure this out
            System.out.println("Method " + name + "not found creating new MethodSTE");
            //Create a methodSTE
            MethodSTE ste = new MethodSTE(name,  signature, s.viewScope());
            //Insert the STE into the symtable with symtable.insert
            s.insert(ste);
            System.out.println("MethodSTE " + name + "inserted into symtable s");

        }
        else{
          throw new SemanticException(
          "Name " + node.getName() + "() already exists\n",node.getLine(),node.getPos()
          );
            //Duplicate method name exists
            //throw an Error
        }
        s.pushScope(name);
        System.out.println("Scope" + name + " pushed in inMethodDecl");

      //  outMethodDecl(node);
        //set current offset in visitor to 1? @Danny
   }

   public void outMethodDecl(MethodDecl node){
     s.popScope();
     System.out.println("Popped scope, outMethodDecl");
       //store number of bytes needed for param as size of the method ?
   }

   public void inTopClassDecl(TopClassDecl node){
       String name = node.getName();
       boolean isMain = false;
       if(name == "main"){
           isMain = true;
       }
       Scope currScope = s.viewScope();
       if(s.lookup(name) == null){
           System.out.println("class not found, creating ClassSTE for insert");
           ClassSTE myClass = new ClassSTE(name, isMain, currScope);
           s.insert(myClass);

       }else{
           throw new SemanticException(
           "Name " + node.getName() + "() already exists\n",node.getLine(),node.getPos()
           );
       }
       s.pushScope(name);
 
   }

   public void outTopClassDecl(TopClassDecl node){
       System.out.println("outTopClassDecl");
       s.popScope();
   }

   public void outClassType(ClassType node) {
       System.out.println("outClassType");
   }

   public void outThisExp(ThisLiteral node) {
       System.out.println("outThisExp");
   }

   public void outIdExp(IdLiteral node) {
       System.out.println("outIdExp");
   }

   public void outNewExp(NewExp node) {
       System.out.println("outNewExp");

   }



   public void outVarDecl(VarDecl node) {
     Type t = s.getExpType(node.getType());
     System.out.println("t is:" + t);
     Scope current = s.viewScope();
     VarSTE myvar = new VarSTE(node.getName(),t, "base1", current.getOffset());
     System.out.println("Created myvar VarSTE");
     s.insert(myvar);
     System.out.println("inserted myvar in outVarDecl");

   }

   public void outFormal(MethodDecl node){
       //i think this needs to be similar to inMethodDecl() but for VarSTE creation
       //create VarSTE with current method offset ?
       //increment visitor-maintained offset based on the type of the formal variable
       //call s.insert()
       LinkedList<VarDecl> paramlist = node.getVarDecls();

       for(VarDecl p : paramlist){
           String name = p.getName();
           if(s.lookup(name) == null){
               System.out.println(name + "not found, creating VARSTE");
               //Create func signature object of some kind
               //@Danny trying to figure this out
               String base = "Y";
               int tSize = 1;
               //Type t = node.getType();
                //getAVRTypeSize()
               //Create a methodSTE
               VarSTE ste = new VarSTE(name, base, tSize);
               //Insert the STE into the symtable with symtable.insert
               s.insert(ste);
               System.out.println("VarSTE Name: " + name + "Base: " + base + "tSize: " + tSize + " inserted!");
           }
           else{
             throw new SemanticException(
             "Name " + node.getName() + "() already exists\n",node.getLine(),node.getPos()
             );
               //Duplicate method name exists
               //throw an Error
           }

       }
      // s.pushScope(name);
   }

   public SymTable getSymTable() {
     return s;
   }



}
