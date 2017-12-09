package symtable;
import java.util.*;
import ast.node.*;

import exceptions.InternalException;

public class Scope{
  /*
  Scope	Class	for	a	single	scope,	one	for	each
  Scope	will	be	created	and	linked	together	to
  make	a	symbol	table.
  */
  //Figuring out the rest of what happens here from the lecture slides
  //mHashMap *
  //mEnclosing *
  //STElookup(string) *
  //insert(STE) *

  private final HashMap<String, STE> mHashMap = new HashMap<String, STE>();
  private Scope mEnclosing;
  private String name;
  private int offset;
  protected static final Scope G = new Scope();

  public Scope(){
      mEnclosing = null;
      name = "Global";

  }

  public String getName() {
    return this.name;
  }
  public int getOffset() {
    return offset;
  }
  public void setOffset(int i){
  offset = i;
}

  public Scope(Scope enclosing){
      mEnclosing = enclosing;
  }

  public STE STElookup(String id){
      STE ste = null;
      ste = mHashMap.get(id);
      return ste;
  }

  public boolean insert(STE ste){
      //attempts to insert, returns false if ste is already in mHashmap
      STE tempSTE = ste;
      if(STElookup(tempSTE.getName()) == null){
          mHashMap.put(tempSTE.getName(), tempSTE);
          return true;
      }
      return false;

  }


}
