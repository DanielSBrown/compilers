/**
 * This ast walker generates dot output for the AST.
 *
 * 6/06 - Modified from Brian Richard's ParserTest.Java.
 *        Michelle Strout
 */

 package ast_visitors;

 import java.util.Scanner;
 import java.io.IOException;
 import java.io.InputStream;
 import java.io.InputStreamReader;
 import java.io.PrintWriter;
 import java.io.File;
 import java.io.FileNotFoundException;
 import java.util.List;
 import java.util.ListIterator;

 import exceptions.SemanticException;

 import label.Label;

 import symtable.*;
 import ast.visitor.DepthFirstVisitor;
 import ast.node.*;

/**
 * We extend the DepthFirstAdapter.
 * Visitors invoke a defaultCase method on each node they visit.
 * We override this method so that it
 * prints out dot info about a node.
 */
public class AVRgenVisitor extends DepthFirstVisitor {
   private PrintWriter out;
   private SymTable st;
   private int labelCounter;

   /** Constructor takes a PrintWriter, and stores in instance var. */
   public AVRgenVisitor(PrintWriter out, SymTable st) {
     this.st = st;
      this.out = out;
      labelCounter = 0;
   }

   public void defaultOut(Node node) {
       System.err.println("Node not implemented in AVRgenVisitor, " + node.getClass());
   }

  //  public void outAndExp(AndExp node)
  //  {
   //
  //  }
  //  public void inAndExp(AndExp node)
  //  {
   //
  //  }
  //  public void visitAndExp(AndExp node)
  //  {
  //   // inAndExp(node);
  //   // int a = labelCounter++;
  //   // int b = labelCounter++;
  //   // if(node.getLExp() != null)
  //   //   node.getLExp().accept(this);
  //   //
  //   // out.println("    pop    r24\n"           //PRINT THE AND IN ASSEMBLY
  //   // + "     pop     r25\n"
  //   // + " \n");
  //  }

  //  public void outPlusExp(PlusExp node)
  //  {
   //
  //  }
/*
Start PA2 Grammar Typechecking
*/
   public void outMeggySetPixel(MeggySetPixel node) {
     out.println("\tpop r20\n" +
                "\tpop r22\n" +
                "\tpop r24\n" +
                "\tcall \t_Z6DrawPxhhh\n" +
                "\tcall \t_Z12DisplaySlatev\n"
     );

   }

  //  public void inByteCast(ByteCast node) {
  //    out.println("#work you");
  //  }
  //  public void outByteCast(ByteCast node) {
   //
  //  }
   public void visitByteCast(ByteCast node) {
     out.println("\tpop \tr24\n" +
                 "\tpop \tr25\n" +
                 "\tpush \tr24\n\n"
     );
   }

/*
Start PA3 Grammar Typechecking
*/

public void outIntegerExp(IntLiteral node) {
  out.write("\n\tldi\tr24, lo8("+node.getIntValue()+")\n" +
              "\n\tldi\tr24, hi8("+node.getIntValue()+")\n\n"+
              "\n\tpush\tr25\n\n" +
              "\n\tpush\tr24\n\n"
  );
}
    // public void outMeggyDelay(MeggyDelay node) {
    //
    // }
    //
    // public void outIfStatement(IfStatement node) { //CHECK THIS
    // }
    //
    // public void outWhileStatement(WhileStatement node) {  //Here too
    //
    // }
    //
    // public void outEqualExp(EqualExp node) {   //HERE too....
    //
    // }
    //
    // public void outMulExp(MulExp node) {
    //
    // }
    //
    // public void outMinusExp(MinusExp node) {
    //
    // }
    //
    // public void outNegExp(NegExp node) {
    //
    // }
    //
    // public void outMeggyGetPixel(MeggyGetPixel node) {
    //
    // }
    //
    // public void outMeggyCheckButton(MeggyCheckButton node) {
    //
    //
    // }
    //
    // public void outNotExp(NotExp node) {
    //
    // }
    public void inProgram(Program node)  {
      try {
        File f = new File("src/ast_visitors/avrH.rtl.s");
        Scanner input = new Scanner(f);
        while (input.hasNextLine()) {
          out.println(input.nextLine());
        }
      }
      catch (FileNotFoundException e){
        System.out.println("File not found");
      }
    }
    public void outProgram(Program node) {
      try {
        File f = new File("src/ast_visitors/avrF.rtl.s");
        Scanner input = new Scanner(f);
        while (input.hasNextLine()) {
          String temp = input.nextLine();
          System.out.println(temp);
          out.println(temp);
        }
      }
      catch (FileNotFoundException e) {
        System.out.println("File not found");
      }

      out.flush();
    }
    public void outMainClass(MainClass node) {
        //nothign
        //nothing
    }
    public void outBlockStatement(BlockStatement node) {
        //nothing
        //nothing
    }
    public void outButtonExp(ButtonLiteral node) {

    }
    public void outColorExp(ColorLiteral node) {
      out.println("\tldi \tr22, "+ node.getIntValue() + "\n" +
                  "\tpush \tr22"
      );
    }





}
