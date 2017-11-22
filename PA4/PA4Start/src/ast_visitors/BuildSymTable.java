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
        String signature = "( ";
        String name = node.getName();

        //signature generation?
        LinkedList<Formal> paramlist = node.getFormals();
        for(Formal p : paramlist){
            signature += p.getType() + " ";
        }
        signature += " ) returns " + node.getType();

        if(s.lookup(name) == null){
            //Create func signature object of some kind
            //@Danny trying to figure this out

            //Create a methodSTE
            MethodSTE ste = new MethodSTE(name,  signature, s.viewScope());
            //Insert the STE into the symtable with symtable.insert
            s.insert(ste);
        }
        else{
          throw new SemanticException(
          "Name " + node.getName() + "() already exists\n",node.getLine(),node.getPos()
          );
            //Duplicate method name exists
            //throw an Error
        }
        s.pushScope(name);
        //set current offset in visitor to 1? @Danny
   }

   public void outMethodDecl(MethodDecl node){
       //store number of bytes needed for param as size of the method ?


   }

   public void outFormal(){
       //i think this needs to be similar to inMethodDecl() but for VarSTE creation
       //create VarSTE with current method offset ?
       //increment visitor-maintained offset based on the type of the formal variable
       //call s.insert()

   }

   public SymTable getSymTable() {
     return s;
   }



}
