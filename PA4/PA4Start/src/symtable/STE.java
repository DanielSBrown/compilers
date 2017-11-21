package symtable;
import java.util.*;
import ast.node.*;

import exceptions.InternalException;


public class STE{

  private String mName;

  public STE(String id){
      mName = id;
  }

  public String getName(){
      return mName;
  }

  public void setName(String id){
      mName = id;
  }


}
