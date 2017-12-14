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

   public void visitLtExp(LtExp node) {
     String label0=  "MJ_L" + labelCounter++;
     String label1=  "MJ_L" + labelCounter++;
     String label2=  "MJ_L" + labelCounter++;

     node.getLExp().accept(this);
     node.getRExp().accept(this);


     out.println("\t# lt expression" +
                "\n\tpop \tr18" +
                "\n\tpop \tr24\n" +
                "\tcp r24, r18\n" +
                "\tbrlt "+ label1 + "\n" +
                "\n\n" + "#Load false" + "\n" + label0 + ":" +
                "\n\tldi \tr24, 0\n" +
                "\tjmp " + label2 + "\n\n# load true" +
                "\n" + label1 + ":" + "\n" +
                "\tldi \tr24, 1\n" +
                "\n# push results of lt" +
                "\n" + label2 + ":\n" +
                "\tpush \tr24\n"
     );

   }

   public void visitMeggyToneStart(MeggyToneStart node) {
      // Might need to add accepting the second param. dunno
      node.getToneExp().accept(this);
      node.getDurationExp().accept(this);


      out.println("\t#MEGGY.STARTTONE" +
                  "\n\tpop \tr22\n" +
                  "\tpop \tr23" +
                  "\n\tpop \tr24" +
                  "\n\tpop \tr24" +
                  "\n\tcall \t_Z10Tone_Startjj"
      );

   }


   public void visitAndExp(AndExp node)
   {
     String label0 = "MJ_L" + labelCounter++;
     String label1 = "MJ_L" + labelCounter++;
     String label2 = "MJ_L" + labelCounter++;
     String label3 = "MJ_L" + labelCounter++;
     String label4 = "MJ_L" + labelCounter++;

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
        String label0 = "MJ_L" + labelCounter++;  //ML 0
        String label1 = "MJ_L" + labelCounter++; // ML 1
        String label2 = "MJ_L" + labelCounter++; // ML 2

        out.println("# If Statement\n");
        node.getExp().accept(this);
        out.println("" +
                    "# Load condition and branch iff false \n # load a one byte exp off stack\n" +
                    "\tpop \tr24\n" +
                    "\t#Load zero into reg\n" +
                    "\tldi \tr25, 0" +
                    "\n\n #use cp to set SREG\n" +
                    "\tcp \tr24, r25\n" +
                    "\t#WANT breq to some" + label0 + "\n" +
                    "\tbrne \t" + label1 +
                    "\n\tjmp \t" + label0 +
                    "\n\n\n#Then label for if\n" +
                    label1 + ":\n\n\n"
                    );
        node.getThenStatement().accept(this);
        out.println("\n\tjmp \t" + label2);
        out.println("\n\n\t# else label for if"
                    + label0 + ":\n"
        );
        out.println("\n"+ label0 + ":\n");
        if (node.getElseStatement() != null) {
          node.getElseStatement().accept(this);
        }
        out.println("\n" + label2 + ":\n\n");


    }



    public void visitWhileStatement(WhileStatement node) {  //@Chase
      out.println("# While Statement");
      String label0 = "MJ_L" + labelCounter++;
      String label1 = "MJ_L" + labelCounter++; // label1
      String label2 = "MJ_L" + labelCounter++; // Label 2

      out.println("\n" + label0 + ":\n"
      );
      node.getExp().accept(this);
      out.println("\n \t# if not (condition) WHILE" +
                  "\n\tpop \t r24" +
                  "\n\tldi \t r25, 0\n" +
                  "\tcp \tr24, r25\n" +
                  "\t# WANT breq "+ label2 +
                  "\n\tbrne \t"+ label1 + "\n" +
                  "\tjmp \t"+ label2 + "\n" +
                  "\n\n" + label1 + ":\n"
      );
      node.getStatement().accept(this);
      out.println("\n \tjmp \t" + label0 + "\n");
      out.println("\n \t# end of while\n" + label2 + ":\n");

    }

    public void visitEqualExp(EqualExp node) {   //@Chase
      String label1 = "MJ_L" + labelCounter++;
      String label2 = "MJ_L" + labelCounter++;
      String label3 = "MJ_L" + labelCounter++;
      node.getLExp().accept(this);
      node.getRExp().accept(this);
      out.println("# Checking Equals\n" +
                  "\tpop \tr18\n" +
                  "\n"+
                  "\tpop \tr24\n" +
                  "\tcp \tr24, r18" +
                  "\n\tbreq " + label2 +
                  "\n\n\n \t\t #result is false\n" +
                  label1 + ":\n" +
                  "\tldi \tr24, 0\n" +
                  "\tjmp \t" + label3 +
                  "\n\n\t# Result is true\n" +
                   label2 + ":\n" +
                  "\tldi \tr24, 1" +
                  "\n" + label3 + ":\n" +
                  "\t # Push one byte expression onto stack\n" +
                  "\tpush \tr24"
                  );
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
    public void outToneExp(ToneLiteral node) {
      out.println("\tldi \tr25, hi8("+ node.getIntValue() + ")\n" +
                  "\tldi \tr24, lo8(" + node.getIntValue() + ")\n" +
                  "\tpush \tr25\n" +
                  "\tpush \tr24\n"
      );
    }

   public void outAssignStatement(AssignStatement node) {
     VarSTE temp = (VarSTE) this.st.lookup(node.getId());  // should get STE for the left side of equation
     //System.out.println(temp.getBase());
     //System.out.println(temp);
     System.out.println("temps size is " + temp.getType().getAVRTypeSize());
     String oneortwo = "";
     if (temp.getType().getAVRTypeSize() == 2) {
       oneortwo = "\n\tpop r25\n";
     }
     out.println("# assign statement\n" +
                "\tpop \tr24\n" +
                oneortwo +
                "\n\tstd " + temp.getBase() + " + " + temp.getOffset() + ", r24\n"
     );
   }

   public void outNewExp(NewExp node) {
     //do stuff
   }
   public void outCallExp(CallExp node) {
     //do more stuff
   }
   public void outIdLiteral(IdLiteral node) {
     //do stuff
   }
   public void outByteType(ByteType node) {
     //this
   }
   public void outVarDecl(VarDecl node) {

   }
   public void outMethodDecl(MethodDecl node) {

   }
   public void outTopClassDecl(TopClassDecl node) {
     
   }





}
