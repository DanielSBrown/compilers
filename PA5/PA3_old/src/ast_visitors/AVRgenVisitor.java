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


   public void visitAndExp(AndExp node)
   {
     String label0 = "ML_" + labelCounter;
     String label1 = "ML_" + labelCounter++;
     String label2 = "ML_" + labelCounter++;
     String label3 = "ML_" + labelCounter++;
     String label4 = "ML_" + labelCounter++;

     out.println("\tldi \tr22, " + "1" +   //first part without the branches
                "\n\tpush \tr22\n" +
                "\tpop \tr24\n" +
                "\tpush \tr24\n" +
                "\tldi \tr25, 0\n" +
                "\tcp \tr24, r25\n" +
                "\tbreq   "+label4 + "\n" +
                "\tjmp  " + label3+ "\n"
     );
     out.println(label4 + ":\n" +          //label4
                "\tpop \tr24" +
                "\n\tldi \tr22, 1" +
                "\n\tpush \tr22\n"+
                "\tpop \tr24\n"+
                "\tpush \tr24\n"
     );
     out.println(label3 + ":\n" +        //label3
                "\tpop \tr24\n" +
                "\tldi \tr25, 0\n\n" +
                "\tcp \tr24, r25\n"+
                "\tbrne  " + label1 +
                "\n\tjmp  " + label0 + "\n"
     );

     out.println(label1 + ":\n" +     //label1
                "\tjmp   " + label2 + "\n"
     );
     out.println(label0 + ":\n" +     //label0
                "#Done\n"
     );
     out.println(label2 + ":\n"    //label 2

     );

   }

   public void outPlusExp(PlusExp node)
   {
     out.println("\tpop \tr18\n" +
                "\tpop \tr19\n\n" +
                "\tpop \tr24\n" +
                "\tpop \tr25\n\n"
     );
     out.println("\tadd \tr24, r18\n" +
                "\tadc \tr25, r19\n\n" +
                "\tpush \tr25\n" +
                "\tpush \tr24\n\n"
     );
   }
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

public void outIntegerExp(IntLiteral node) {
  out.write("\n\tldi\tr24, lo8("+node.getIntValue()+")\n" +
              "\n\tldi\tr25, hi8("+node.getIntValue()+")\n\n"+
              "\n\tpush\tr25\n\n" +
              "\n\tpush\tr24\n\n"
  );


}

   public void outByteCast(ByteCast node) {
     out.println("\tpop \tr24\n" +
                 "\tpop \tr25\n" +
                 "\tpush \tr24\n\n"
     );

    }


/*
Start PA3 Grammar Typechecking
*/


    public void outMeggyDelay(MeggyDelay node) {

      out.println("\n\tpop \tr24" +
                "\n\tpop \tr25\n" +
                "\tcall   _Z8delay_msj\n"
      );
    }
    //
    public void visitIfStatement(IfStatement node) { //@Chase
        out.println("# If Statement");

    }

    public void visitWhileStatement(WhileStatement node) {  //@Chase
      out.println("# While Statement");
    }

    public void visitEqualExp(EqualExp node) {   //@Chase
      out.println("# Checking Equals");
    }

    public void outMulExp(MulExp node) {

      out.println("#mult starting\n" +
                "\tpop \tr18\n" +
                "\tpop \tr22\n" +
                "\tmov \tr24, r18\n" +
                "\tmov \tr26, r22\n" +
                "\tmuls \tr24, r26\n" +
                "\tpush \tr1\n" +
                "\tpush \tr0\n" +
                "\teor \tr0, r0\n" +
                "\teor \tr1, r1\n"
      );
    }

    public void visitMinusExp(MinusExp node) {
      out.println("#sub\n" +
                "\tsub \tr24, r18\n" +
                "\tsbc \tr25, r19\n" +
                "\n\tpush \tr25" +
                "\n\tpush \tr24"
      );
    }

    public void outNegExp(NegExp node) {
        out.println("\t#negation\n" +
                  "\tpop \tr24\n" +
                  "\tpop \tr25\n" +
                  "\tldi \tr22, 0\n" +
                  "\tldi \tr23, 0\n" +
                  "\tsub \tr22, r24\n" +
                  "\tsbc \tr23, r25\n" +
                  "\tpush \tr23\n" +
                  "\tpush \tr22\n"
        );
    }

    public void outMeggyGetPixel(MeggyGetPixel node) {
        out.println("\t#GetPixel\n" +
                  "\tpop \tr22\n" +
                  "\tpop \tr24\n" +
                  "\tcall  \t_Z6ReadPxhh\n" +
                  "\tpush \tr24\n"
        );
    }

    public void outMeggyCheckButton(MeggyCheckButton node) {
      String label = "ML_"+labelCounter++;
      out.println("\t#CheckButton\n" +
                  "\tcall    _Z16CheckButtonsDownv\n" +
                  "\tlds \tr24, Button_Up\n" +       //LOOK HERE CHASE, IDK HOW TO GET WHICH BUTTON
                  "\ttst \tr24\n" +
                  "\tbreq" + label + "\n"
      );

    }

    public void outNotExp(NotExp node) {
      out.println("\t#NotExp\n" +
                "\tpop \tr24\n" +
                "\tldi  \tr22, 1\n" +
                "\teor \tr24, r22\n" +
                "\tpush \tr24\n"
      );
    }
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
