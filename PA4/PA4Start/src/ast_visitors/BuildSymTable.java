/**
 * This ast walker generates dot output for the AST.
 *
 * 6/06 - Modified from Brian Richard's ParserTest.Java.
 *        Michelle Strout
 */
package ast_visitors;

import java.io.PrintWriter;
import java.util.Stack;
import symtable.*;
import ast.visitor.DepthFirstVisitor;
import ast.node.*;

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


   public void inMethodDecl(MethodDecl node){
        //lookup method name in current sym table to see if there are dups
        String signature = null;
        String name = node.getName();
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

   }

   public SymTable getSymTable() {
     return s;
   }



}
