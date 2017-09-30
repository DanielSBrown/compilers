
//----------------------------------------------------
// The following code was generated by CUP v0.11a beta 20060608
// Sat Sep 30 00:41:30 EDT 2017
//----------------------------------------------------

package mjparser;

import java_cup.runtime.*;
import java.util.*;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.File;
import java.io.FileNotFoundException;

/** CUP v0.11a beta 20060608 generated parser.
  * @version Sat Sep 30 00:41:30 EDT 2017
  */
public class mj extends java_cup.runtime.lr_parser {

  /** Default constructor. */
  public mj() {super();}

  /** Constructor which sets the default scanner. */
  public mj(java_cup.runtime.Scanner s) {super(s);}

  /** Constructor which sets the default scanner. */
  public mj(java_cup.runtime.Scanner s, java_cup.runtime.SymbolFactory sf) {super(s,sf);}

  /** Production table. */
  protected static final short _production_table[][] = 
    unpackFromStrings(new String[] {
    "\000\014\000\002\002\004\000\002\002\006\000\002\007" +
    "\002\000\002\010\002\000\002\011\002\000\002\006\026" +
    "\000\002\004\013\000\002\003\006\000\002\003\003\000" +
    "\002\003\003\000\002\005\003\000\002\005\004" });

  /** Access to production table. */
  public short[][] production_table() {return _production_table;}

  /** Parse-action table. */
  protected static final short[][] _action_table = 
    unpackFromStrings(new String[] {
    "\000\054\000\004\017\005\001\002\000\004\002\056\001" +
    "\002\000\004\046\006\001\002\000\004\044\007\001\002" +
    "\000\004\037\010\001\002\000\004\061\012\001\002\000" +
    "\004\002\000\001\002\000\004\011\uffff\001\002\000\004" +
    "\011\014\001\002\000\004\032\015\001\002\000\004\034" +
    "\016\001\002\000\004\036\017\001\002\000\004\016\020" +
    "\001\002\000\004\007\021\001\002\000\004\035\022\001" +
    "\002\000\004\041\023\001\002\000\004\042\024\001\002" +
    "\000\004\061\025\001\002\000\004\010\026\001\002\000" +
    "\004\011\027\001\002\000\004\052\ufffe\001\002\000\004" +
    "\052\033\001\002\000\006\012\053\052\033\001\002\000" +
    "\006\012\ufff7\052\ufff7\001\002\000\004\007\034\001\002" +
    "\000\010\007\037\060\036\064\035\001\002\000\006\010" +
    "\ufff8\027\ufff8\001\002\000\006\010\ufff9\027\ufff9\001\002" +
    "\000\004\015\047\001\002\000\004\027\041\001\002\000" +
    "\010\007\037\060\036\064\035\001\002\000\004\027\043" +
    "\001\002\000\010\007\037\060\036\064\035\001\002\000" +
    "\004\010\045\001\002\000\004\044\046\001\002\000\006" +
    "\012\ufffb\052\ufffb\001\002\000\004\010\050\001\002\000" +
    "\010\007\037\060\036\064\035\001\002\000\006\010\ufffa" +
    "\027\ufffa\001\002\000\006\012\ufff6\052\ufff6\001\002\000" +
    "\004\012\ufffd\001\002\000\004\012\055\001\002\000\004" +
    "\002\ufffc\001\002\000\004\002\001\001\002" });

  /** Access to parse-action table. */
  public short[][] action_table() {return _action_table;}

  /** <code>reduce_goto</code> table. */
  protected static final short[][] _reduce_table = 
    unpackFromStrings(new String[] {
    "\000\054\000\004\002\003\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\004\006\010\001\001" +
    "\000\002\001\001\000\002\001\001\000\004\007\012\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\004\010" +
    "\027\001\001\000\006\004\031\005\030\001\001\000\004" +
    "\004\051\001\001\000\002\001\001\000\002\001\001\000" +
    "\004\003\037\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\004\003\041\001" +
    "\001\000\002\001\001\000\004\003\043\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\004\003\050\001\001\000\002\001\001\000\002" +
    "\001\001\000\004\011\053\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001" });

  /** Access to <code>reduce_goto</code> table. */
  public short[][] reduce_table() {return _reduce_table;}

  /** Instance of action encapsulation class. */
  protected CUP$mj$actions action_obj;

  /** Action encapsulation object initializer. */
  protected void init_actions()
    {
      action_obj = new CUP$mj$actions(this);
    }

  /** Invoke a user supplied parse action. */
  public java_cup.runtime.Symbol do_action(
    int                        act_num,
    java_cup.runtime.lr_parser parser,
    java.util.Stack            stack,
    int                        top)
    throws java.lang.Exception
  {
    /* call code in generated class */
    return action_obj.CUP$mj$do_action(act_num, parser, stack, top);
  }

  /** Indicates start state. */
  public int start_state() {return 0;}
  /** Indicates start production. */
  public int start_production() {return 0;}

  /** <code>EOF</code> Symbol index. */
  public int EOF_sym() {return 0;}

  /** <code>error</code> Symbol index. */
  public int error_sym() {return 1;}




    public PrintWriter out;

    public String programName;

    public void unrecovered_syntax_error(Symbol cur_SymbolValue) {
        report_fatal_error("Fatal syntax error", cur_SymbolValue);
    }

    public void report_fatal_error(String message, Object info) {
        report_error(message, info);
        done_parsing();
        Symbol SymbolValue = (Symbol)info;
        mjparser.SymbolValue tok = (mjparser.SymbolValue)SymbolValue.value;
        throw new mjparser.ParseException("Fatal parsing error",
                                          tok.line, tok.pos);
    }

    public void report_error(String message, Object info) {
        Symbol SymbolValue = (Symbol)info;
        mjparser.SymbolValue tok = (mjparser.SymbolValue)SymbolValue.value;
        System.err.println("[" + tok.line + "," + tok.pos + "] "
                               + message + " at " + tok.toString() );
    }


}

/** Cup generated class to encapsulate user supplied action code.*/
class CUP$mj$actions {
  private final mj parser;

  /** Constructor */
  CUP$mj$actions(mj parser) {
    this.parser = parser;
  }

  /** Method with the actual generated action code. */
  public final java_cup.runtime.Symbol CUP$mj$do_action(
    int                        CUP$mj$act_num,
    java_cup.runtime.lr_parser CUP$mj$parser,
    java.util.Stack            CUP$mj$stack,
    int                        CUP$mj$top)
    throws java.lang.Exception
    {
      /* Symbol object for return from actions */
      java_cup.runtime.Symbol CUP$mj$result;

      /* select the action based on the action number */
      switch (CUP$mj$act_num)
        {
          /*. . . . . . . . . . . . . . . . . . . .*/
          case 11: // statement_list ::= statement_list statement 
            {
              Object RESULT =null;
		int sleft = ((java_cup.runtime.Symbol)CUP$mj$stack.peek()).left;
		int sright = ((java_cup.runtime.Symbol)CUP$mj$stack.peek()).right;
		Object s = (Object)((java_cup.runtime.Symbol) CUP$mj$stack.peek()).value;

              CUP$mj$result = parser.getSymbolFactory().newSymbol("statement_list",3, ((java_cup.runtime.Symbol)CUP$mj$stack.elementAt(CUP$mj$top-1)), ((java_cup.runtime.Symbol)CUP$mj$stack.peek()), RESULT);
            }
          return CUP$mj$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 10: // statement_list ::= statement 
            {
              Object RESULT =null;
		int sleft = ((java_cup.runtime.Symbol)CUP$mj$stack.peek()).left;
		int sright = ((java_cup.runtime.Symbol)CUP$mj$stack.peek()).right;
		Object s = (Object)((java_cup.runtime.Symbol) CUP$mj$stack.peek()).value;

              CUP$mj$result = parser.getSymbolFactory().newSymbol("statement_list",3, ((java_cup.runtime.Symbol)CUP$mj$stack.peek()), ((java_cup.runtime.Symbol)CUP$mj$stack.peek()), RESULT);
            }
          return CUP$mj$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 9: // exp ::= COLOR_LITERAL 
            {
              Integer RESULT =null;
		int colorleft = ((java_cup.runtime.Symbol)CUP$mj$stack.peek()).left;
		int colorright = ((java_cup.runtime.Symbol)CUP$mj$stack.peek()).right;
		SymbolValue color = (SymbolValue)((java_cup.runtime.Symbol) CUP$mj$stack.peek()).value;
		 RESULT = color.value; 
              CUP$mj$result = parser.getSymbolFactory().newSymbol("exp",1, ((java_cup.runtime.Symbol)CUP$mj$stack.peek()), ((java_cup.runtime.Symbol)CUP$mj$stack.peek()), RESULT);
            }
          return CUP$mj$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 8: // exp ::= INT_LITERAL 
            {
              Integer RESULT =null;
		int ileft = ((java_cup.runtime.Symbol)CUP$mj$stack.peek()).left;
		int iright = ((java_cup.runtime.Symbol)CUP$mj$stack.peek()).right;
		SymbolValue i = (SymbolValue)((java_cup.runtime.Symbol) CUP$mj$stack.peek()).value;
		 RESULT = i.value; 
              CUP$mj$result = parser.getSymbolFactory().newSymbol("exp",1, ((java_cup.runtime.Symbol)CUP$mj$stack.peek()), ((java_cup.runtime.Symbol)CUP$mj$stack.peek()), RESULT);
            }
          return CUP$mj$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 7: // exp ::= LPAREN BYTE RPAREN exp 
            {
              Integer RESULT =null;
		int eleft = ((java_cup.runtime.Symbol)CUP$mj$stack.peek()).left;
		int eright = ((java_cup.runtime.Symbol)CUP$mj$stack.peek()).right;
		Integer e = (Integer)((java_cup.runtime.Symbol) CUP$mj$stack.peek()).value;
		 RESULT = e; 
              CUP$mj$result = parser.getSymbolFactory().newSymbol("exp",1, ((java_cup.runtime.Symbol)CUP$mj$stack.elementAt(CUP$mj$top-3)), ((java_cup.runtime.Symbol)CUP$mj$stack.peek()), RESULT);
            }
          return CUP$mj$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 6: // statement ::= MEGGYSETPIXEL LPAREN exp COMMA exp COMMA exp RPAREN SEMI 
            {
              Object RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$mj$stack.elementAt(CUP$mj$top-6)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$mj$stack.elementAt(CUP$mj$top-6)).right;
		Integer a = (Integer)((java_cup.runtime.Symbol) CUP$mj$stack.elementAt(CUP$mj$top-6)).value;
		int bleft = ((java_cup.runtime.Symbol)CUP$mj$stack.elementAt(CUP$mj$top-4)).left;
		int bright = ((java_cup.runtime.Symbol)CUP$mj$stack.elementAt(CUP$mj$top-4)).right;
		Integer b = (Integer)((java_cup.runtime.Symbol) CUP$mj$stack.elementAt(CUP$mj$top-4)).value;
		int colorleft = ((java_cup.runtime.Symbol)CUP$mj$stack.elementAt(CUP$mj$top-2)).left;
		int colorright = ((java_cup.runtime.Symbol)CUP$mj$stack.elementAt(CUP$mj$top-2)).right;
		Integer color = (Integer)((java_cup.runtime.Symbol) CUP$mj$stack.elementAt(CUP$mj$top-2)).value;
		
          //code assembly printing here
          //parser.out.print("# testflush");
          parser.out.print("\n");
          //@Danny: a and b are not correctly referencing the int value
          //that I tried to set in expression, below this
          parser.out.println("\tldi\t" + "r24,lo8(" + a + ")");
          parser.out.println("\tldi\t" + "r25,hi8(" + a + ")");
          parser.out.println("\tpush\t" + "r25");
          parser.out.println("\tpush\t" + "r24");
          parser.out.print("\n");

          parser.out.println("# casting int1 to byte");
          parser.out.println("\tpop\t" + "r24");
          parser.out.println("\tpop\t" + "r25");
          parser.out.println("\tpush\t" + "r24");
          parser.out.print("\n");

          parser.out.println("\tldi\t" + "r24,lo8(" + b + ")");
          parser.out.println("\tldi\t" + "r25,hi8(" + b + ")");
          parser.out.println("\tpush\t" + "r25");
          parser.out.println("\tpush\t" + "r24");
          parser.out.print("\n");

          parser.out.println("# casting int2 to byte");
          parser.out.println("\tpop\t" + "r24");
          parser.out.println("\tpop\t" + "r25");
          parser.out.println("\tpush\t" + "r24");
          parser.out.print("\n");

          parser.out.println("# color expression meggy.color.COLOR");
          parser.out.println("\tldi\t" + "r22," + color);
          parser.out.println("# Push color expression onto stack");
          parser.out.println("\tpush\t" + "r22");
          parser.out.print("\n");

          parser.out.println("### Meggy.SetPixel(a,b,color) call");
          parser.out.println("# load a one byte expression off stack");
          parser.out.println("\tpop\t" + "r20");
          parser.out.println("\tpop\t" + "r22");
          parser.out.println("\tpop\t" + "r24");
          parser.out.println("\tcall\t" + "_Z6DrawPxhhh");
          parser.out.println("\tcall\t" + "_Z12DisplaySlatev");
          parser.out.print("\n");

        
              CUP$mj$result = parser.getSymbolFactory().newSymbol("statement",2, ((java_cup.runtime.Symbol)CUP$mj$stack.elementAt(CUP$mj$top-8)), ((java_cup.runtime.Symbol)CUP$mj$stack.peek()), RESULT);
            }
          return CUP$mj$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 5: // main_class ::= CLASS ID NT$0 LBRACE PUBLIC STATIC VOID MAIN LPAREN STRING LBRACKET RBRACKET ID RPAREN LBRACE NT$1 statement_list RBRACE NT$2 RBRACE 
            {
              Object RESULT =null;
              // propagate RESULT from NT$2
                RESULT = (Object) ((java_cup.runtime.Symbol) CUP$mj$stack.elementAt(CUP$mj$top-1)).value;
		int nameleft = ((java_cup.runtime.Symbol)CUP$mj$stack.elementAt(CUP$mj$top-18)).left;
		int nameright = ((java_cup.runtime.Symbol)CUP$mj$stack.elementAt(CUP$mj$top-18)).right;
		SymbolValue name = (SymbolValue)((java_cup.runtime.Symbol) CUP$mj$stack.elementAt(CUP$mj$top-18)).value;
		int paramleft = ((java_cup.runtime.Symbol)CUP$mj$stack.elementAt(CUP$mj$top-7)).left;
		int paramright = ((java_cup.runtime.Symbol)CUP$mj$stack.elementAt(CUP$mj$top-7)).right;
		SymbolValue param = (SymbolValue)((java_cup.runtime.Symbol) CUP$mj$stack.elementAt(CUP$mj$top-7)).value;
		int listleft = ((java_cup.runtime.Symbol)CUP$mj$stack.elementAt(CUP$mj$top-3)).left;
		int listright = ((java_cup.runtime.Symbol)CUP$mj$stack.elementAt(CUP$mj$top-3)).right;
		Object list = (Object)((java_cup.runtime.Symbol) CUP$mj$stack.elementAt(CUP$mj$top-3)).value;
		
            //Epilogue
            System.out.println("Generate epilogue using avrF.rtl.s");
            InputStream mainEpilogue=null;
            BufferedReader reader=null;
          //  parser.out.println("This is a test");
            try {
                // The syntax for loading a text resource file
                // from a jar file here:
                // http://www.rgagnon.com/javadetails/java-0077.html
                mainEpilogue
                    = this.getClass().getClassLoader().getResourceAsStream(
                        "avrF.rtl.s");
                reader = new BufferedReader(new
                    InputStreamReader(mainEpilogue));

                String line = null;
                while ((line = reader.readLine()) != null) {
                  parser.out.println(line);
                }
            } catch ( Exception e2) {
                e2.printStackTrace();
            }
            finally{
                try{
                    if(mainEpilogue!=null) mainEpilogue.close();
                    if(reader!=null) reader.close();
                }
                catch (IOException e) {
                   e.printStackTrace();
                }
            }

            parser.out.flush();
          
              CUP$mj$result = parser.getSymbolFactory().newSymbol("main_class",4, ((java_cup.runtime.Symbol)CUP$mj$stack.elementAt(CUP$mj$top-19)), ((java_cup.runtime.Symbol)CUP$mj$stack.peek()), RESULT);
            }
          return CUP$mj$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 4: // NT$2 ::= 
            {
              Object RESULT =(Object) ((java_cup.runtime.Symbol) CUP$mj$stack.elementAt(CUP$mj$top-2)).value;
		int nameleft = ((java_cup.runtime.Symbol)CUP$mj$stack.elementAt(CUP$mj$top-16)).left;
		int nameright = ((java_cup.runtime.Symbol)CUP$mj$stack.elementAt(CUP$mj$top-16)).right;
		SymbolValue name = (SymbolValue)((java_cup.runtime.Symbol) CUP$mj$stack.elementAt(CUP$mj$top-16)).value;
		int paramleft = ((java_cup.runtime.Symbol)CUP$mj$stack.elementAt(CUP$mj$top-5)).left;
		int paramright = ((java_cup.runtime.Symbol)CUP$mj$stack.elementAt(CUP$mj$top-5)).right;
		SymbolValue param = (SymbolValue)((java_cup.runtime.Symbol) CUP$mj$stack.elementAt(CUP$mj$top-5)).value;
		int listleft = ((java_cup.runtime.Symbol)CUP$mj$stack.elementAt(CUP$mj$top-1)).left;
		int listright = ((java_cup.runtime.Symbol)CUP$mj$stack.elementAt(CUP$mj$top-1)).right;
		Object list = (Object)((java_cup.runtime.Symbol) CUP$mj$stack.elementAt(CUP$mj$top-1)).value;

            //currently prints null, commenting out to not ruin assembly file
          //parser.out.println(list);
          
              CUP$mj$result = parser.getSymbolFactory().newSymbol("NT$2",7, ((java_cup.runtime.Symbol)CUP$mj$stack.peek()), ((java_cup.runtime.Symbol)CUP$mj$stack.peek()), RESULT);
            }
          return CUP$mj$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 3: // NT$1 ::= 
            {
              Object RESULT =(Object) ((java_cup.runtime.Symbol) CUP$mj$stack.elementAt(CUP$mj$top-12)).value;
		int nameleft = ((java_cup.runtime.Symbol)CUP$mj$stack.elementAt(CUP$mj$top-13)).left;
		int nameright = ((java_cup.runtime.Symbol)CUP$mj$stack.elementAt(CUP$mj$top-13)).right;
		SymbolValue name = (SymbolValue)((java_cup.runtime.Symbol) CUP$mj$stack.elementAt(CUP$mj$top-13)).value;
		int paramleft = ((java_cup.runtime.Symbol)CUP$mj$stack.elementAt(CUP$mj$top-2)).left;
		int paramright = ((java_cup.runtime.Symbol)CUP$mj$stack.elementAt(CUP$mj$top-2)).right;
		SymbolValue param = (SymbolValue)((java_cup.runtime.Symbol) CUP$mj$stack.elementAt(CUP$mj$top-2)).value;

            System.out.println("Generate prolog using avrH.rtl.s");
            InputStream mainPrologue=null;
            BufferedReader reader=null;
          //  parser.out.println("This is a test");
            try {
                // The syntax for loading a text resource file
                // from a jar file here:
                // http://www.rgagnon.com/javadetails/java-0077.html
                mainPrologue
                    = this.getClass().getClassLoader().getResourceAsStream(
                        "avrH.rtl.s");
                reader = new BufferedReader(new
                    InputStreamReader(mainPrologue));

                String line = null;
                while ((line = reader.readLine()) != null) {
                  parser.out.println(line);
                }
            } catch ( Exception e2) {
                e2.printStackTrace();
            }
            finally{
                try{
                    if(mainPrologue!=null) mainPrologue.close();
                    if(reader!=null) reader.close();
                }
                catch (IOException e) {
                   e.printStackTrace();
                }
            }

          
              CUP$mj$result = parser.getSymbolFactory().newSymbol("NT$1",6, ((java_cup.runtime.Symbol)CUP$mj$stack.peek()), ((java_cup.runtime.Symbol)CUP$mj$stack.peek()), RESULT);
            }
          return CUP$mj$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 2: // NT$0 ::= 
            {
              Object RESULT =null;
		int nameleft = ((java_cup.runtime.Symbol)CUP$mj$stack.peek()).left;
		int nameright = ((java_cup.runtime.Symbol)CUP$mj$stack.peek()).right;
		SymbolValue name = (SymbolValue)((java_cup.runtime.Symbol) CUP$mj$stack.peek()).value;
 java.io.PrintStream sout
                    = new java.io.PrintStream(
                        new java.io.FileOutputStream(name.lexeme+".java.s"));
                parser.out = new PrintWriter(sout);
                // Check filename is class name, if not exit with error message

              if (!(name.lexeme+".java").equals(parser.programName)){
                	System.out.println(parser.programName);
                	parser.report_fatal_error("Program/Class Name Mismatch",name);
                	System.exit(1);
                }

                //System.exit(0);
            
              CUP$mj$result = parser.getSymbolFactory().newSymbol("NT$0",5, ((java_cup.runtime.Symbol)CUP$mj$stack.peek()), ((java_cup.runtime.Symbol)CUP$mj$stack.peek()), RESULT);
            }
          return CUP$mj$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 1: // program ::= IMPORT MEGGY SEMI main_class 
            {
              Object RESULT =null;

              CUP$mj$result = parser.getSymbolFactory().newSymbol("program",0, ((java_cup.runtime.Symbol)CUP$mj$stack.elementAt(CUP$mj$top-3)), ((java_cup.runtime.Symbol)CUP$mj$stack.peek()), RESULT);
            }
          return CUP$mj$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 0: // $START ::= program EOF 
            {
              Object RESULT =null;
		int start_valleft = ((java_cup.runtime.Symbol)CUP$mj$stack.elementAt(CUP$mj$top-1)).left;
		int start_valright = ((java_cup.runtime.Symbol)CUP$mj$stack.elementAt(CUP$mj$top-1)).right;
		Object start_val = (Object)((java_cup.runtime.Symbol) CUP$mj$stack.elementAt(CUP$mj$top-1)).value;
		RESULT = start_val;
              CUP$mj$result = parser.getSymbolFactory().newSymbol("$START",0, ((java_cup.runtime.Symbol)CUP$mj$stack.elementAt(CUP$mj$top-1)), ((java_cup.runtime.Symbol)CUP$mj$stack.peek()), RESULT);
            }
          /* ACCEPT */
          CUP$mj$parser.done_parsing();
          return CUP$mj$result;

          /* . . . . . .*/
          default:
            throw new Exception(
               "Invalid action number found in internal parse table");

        }
    }
}

