package ast_visitors;

/**
 * CheckTypes
 *
 * This AST visitor traverses a MiniJava Abstract Syntax Tree and checks
 * for a number of type errors.  If a type error is found a SymanticException
 * is thrown
 *
 * CHANGES to make next year (2012)
 *  - make the error messages between *, +, and - consistent <= ??
 *
 * Bring down the symtab code so that it only does get and set Type
 *  for expressions
 */

import ast.node.*;
import ast.visitor.DepthFirstVisitor;
import java.util.*;

import symtable.SymTable;
import symtable.Type;
import exceptions.InternalException;
import exceptions.SemanticException;

public class CheckTypes extends DepthFirstVisitor
{

   private SymTable mCurrentST;

   public CheckTypes(SymTable st) {
     if(st==null) {
          throw new InternalException("unexpected null argument");
      }
      mCurrentST = st;
   }

   //========================= Overriding the visitor interface

   public void defaultOut(Node node) {
       System.err.println("Node not implemented in CheckTypes, " + node.getClass());
   }

   public void outAndExp(AndExp node)
   {
     if(this.mCurrentST.getExpType(node.getLExp()) != Type.BOOL) {
       throw new SemanticException(
         "Invalid left operand type for operator &&",
         node.getLExp().getLine(), node.getLExp().getPos());
     }

     if(this.mCurrentST.getExpType(node.getRExp()) != Type.BOOL) {
       throw new SemanticException(
         "Invalid right operand type for operator &&",
         node.getRExp().getLine(), node.getRExp().getPos());
     }

     this.mCurrentST.setExpType(node, Type.BOOL);
   }

   public void outPlusExp(PlusExp node)
   {
       Type lexpType = this.mCurrentST.getExpType(node.getLExp());
       Type rexpType = this.mCurrentST.getExpType(node.getRExp());
       if ((lexpType==Type.INT  || lexpType==Type.BYTE) &&
           (rexpType==Type.INT  || rexpType==Type.BYTE)
          ){
           this.mCurrentST.setExpType(node, Type.INT);
       } else {
           throw new SemanticException(
                   "Operands to + operator must be INT or BYTE",
                   node.getLExp().getLine(),
                   node.getLExp().getPos());
       }

   }
/*
Start PA2 Grammar Typechecking
*/
   public void outMeggySetPixel(MeggySetPixel node) {
     Type xexpType = this.mCurrentST.getExpType(node.getXExp());
     Type yexpType = this.mCurrentST.getExpType(node.getYExp());
     Type cexpType = this.mCurrentST.getExpType(node.getColor());
     System.out.println(xexpType);
     System.out.println(yexpType);
     System.out.println(cexpType);

     if (xexpType==Type.BYTE && yexpType==Type.BYTE && cexpType==Type.COLOR) {
       this.mCurrentST.setExpType(node, Type.VOID);
     }
     else {
       throw new SemanticException(
              "Operands for MeggySetPixel must be BYTE, BYTE, COLOR",
                    node.getXExp().getLine(),
                    node.getXExp().getPos());
     }

   }

   public void outByteCast(ByteCast node) {
     Type expType = this.mCurrentST.getExpType(node.getExp());
     if (expType==Type.INT) {
       this.mCurrentST.setExpType(node, Type.BYTE);
     }
     else {
       throw new SemanticException(
              "Operands for ByteCast must be INT",
                    node.getExp().getLine(),
                    node.getExp().getPos());
     }
   }

/*
Start PA3 Grammar Typechecking
*/
    public void outMeggyDelay(MeggyDelay node) {
      Type expType = this.mCurrentST.getExpType(node.getExp());
      if (expType==Type.INT || expType==Type.BYTE) {
        this.mCurrentST.setExpType(node, Type.VOID);
      }
      else {
        throw new SemanticException(
               "Operands for MeggyDelay must be INT or BYTE",
                     node.getExp().getLine(),
                     node.getExp().getPos());
      }
    }

    public void outIfStatement(IfStatement node) { //CHECK THIS
      Type expType = this.mCurrentST.getExpType(node.getExp());
      if (expType!=Type.BOOL) {
        throw new SemanticException(
               "Operands for IfStatement must be BOOL",
                     node.getExp().getLine(),
                     node.getExp().getPos());
                   }
    //  this.mCurrentST.setExpType(node, Type.BOOL);
    }

    public void outWhileStatement(WhileStatement node) {  //Here too
      Type expType = this.mCurrentST.getExpType(node.getExp());
      if (expType!=Type.BOOL) {
        throw new SemanticException(
               "Operands for while must be BOOL",
                     node.getExp().getLine(),
                     node.getExp().getPos());
                    }
      this.mCurrentST.setExpType(node, Type.BOOL);
    }

    public void outEqualExp(EqualExp node) {   //HERE too....
      Type lexpType = this.mCurrentST.getExpType(node.getLExp());
      Type rexpType = this.mCurrentST.getExpType(node.getRExp());
      if ((lexpType==Type.BOOL && rexpType==Type.BOOL) || ((lexpType==Type.BYTE || lexpType==Type.INT) && (rexpType==Type.BYTE || rexpType==Type.INT)) || ((lexpType==Type.COLOR && rexpType==Type.COLOR))){
        this.mCurrentST.setExpType(node, Type.BOOL);
      }
      else {
        throw new SemanticException(
               "Operands for equals operation must be BOOL, INT, or BYTE",
                     node.getLExp().getLine(),
                     node.getLExp().getPos());
      }
    }

    public void outLtExp(LtExp node) {
      Type lexpType = this.mCurrentST.getExpType(node.getLExp());
      Type rexpType = this.mCurrentST.getExpType(node.getRExp());

      if ((lexpType==Type.INT  || lexpType==Type.BYTE) &&
          (rexpType==Type.INT  || rexpType==Type.BYTE)
         ){
          this.mCurrentST.setExpType(node, Type.BOOL);
      } else {
          throw new SemanticException(
                  "Operands to < operator must be INT or BYTE",
                  node.getLExp().getLine(),
                  node.getLExp().getPos());
      }

    }

    public void outMulExp(MulExp node) {
      Type lexpType = this.mCurrentST.getExpType(node.getLExp());
      Type rexpType = this.mCurrentST.getExpType(node.getRExp());

      if ((lexpType==Type.INT  || lexpType==Type.BYTE) &&
          (rexpType==Type.INT  || rexpType==Type.BYTE)
         ){
          this.mCurrentST.setExpType(node, Type.INT);
      } else {
          throw new SemanticException(
                  "Operands to * operator must be INT or BYTE",
                  node.getLExp().getLine(),
                  node.getLExp().getPos());
      }

    }

    public void outMinusExp(MinusExp node) {
      Type lexpType = this.mCurrentST.getExpType(node.getLExp());
      Type rexpType = this.mCurrentST.getExpType(node.getRExp());

      if ((lexpType==Type.INT  || lexpType==Type.BYTE) &&
          (rexpType==Type.INT  || rexpType==Type.BYTE)
         ){
          this.mCurrentST.setExpType(node, Type.INT);
      } else {
          throw new SemanticException(
                  "Operands to - operator must be INT or BYTE",
                  node.getLExp().getLine(),
                  node.getLExp().getPos());
      }

    }

    public void outNegExp(NegExp node) {
      Type expType = this.mCurrentST.getExpType(node.getExp());
      if (expType==Type.INT || expType==Type.BYTE) {
        this.mCurrentST.setExpType(node, Type.INT);
      }
      else {
        throw new SemanticException(
               "Operands for Negation must be INT or BOOL",
                     node.getExp().getLine(),
                     node.getExp().getPos());
      }
    }

    public void outMeggyGetPixel(MeggyGetPixel node) {
      Type xexpType = this.mCurrentST.getExpType(node.getXExp());
      Type yexpType = this.mCurrentST.getExpType(node.getYExp());

      if (xexpType==Type.BYTE && yexpType==Type.BYTE) {
        this.mCurrentST.setExpType(node, Type.COLOR); //Does it return color..?
      }
      else {
        throw new SemanticException(
               "Operands for MeggyGetPixel must be BYTE",
                     node.getXExp().getLine(),
                     node.getXExp().getPos());
      }
    }

    public void outMeggyCheckButton(MeggyCheckButton node) {
      Type expType = this.mCurrentST.getExpType(node.getExp());

      if (expType==Type.BUTTON ) {
        this.mCurrentST.setExpType(node, Type.BOOL);
      }
      else {
        throw new SemanticException(
               "Operands for MeggyCheckButton must be BUTTON",
                     node.getExp().getLine(),
                     node.getExp().getPos());
      }
    }

    public void outNotExp(NotExp node) {
      Type expType = this.mCurrentST.getExpType(node.getExp());
      if (expType==Type.BOOL) {
        this.mCurrentST.setExpType(node, Type.BOOL);
      }
      else {
        throw new SemanticException(
               "Operands for '!' must be BYTE",
                     node.getExp().getLine(),
                     node.getExp().getPos());
      }
    }

    public void outTrueExp(TrueLiteral node){
      if (node.getLexeme() == "true") {
      }
      else {
        throw new SemanticException(
            "Operand must for True Literal must be 'true'",
            node.getLine(),
            node.getPos()
        );
      }
    }

    public void outFalseExp(FalseLiteral node){
      if (node.getLexeme() == "false") {
      }
      else {
        throw new SemanticException(
            "Operand must for False literal must be 'false'",
            node.getLine(),
            node.getPos()
        );
      }
    }

    public void outProgram(Program node) {

    }
    public void outMainClass(MainClass node) {

    }
    public void outBlockStatement(BlockStatement node) {

    }
    public void outButtonExp(ButtonLiteral node) {

    }
    public void outColorExp(ColorLiteral node) {

    }
    public void outIntegerExp(IntLiteral node) {
    }


/* PA4 BOIIIIIIIII */
    public void outByteType(ByteType node) {
//nada
    }

    public void outVoidType(VoidType node) {
//nada
    }

    public void outNewExp(NewExp node) {
 //nada
    }
    public void outCallStatement(CallStatement node) {
    }
    public void outFormal(Formal node) {
      mCurrentST.setExpType(node, null); //Look here;

    }
    public void outIdLiteral(IdLiteral node) {
          //might need something here
    }


}
