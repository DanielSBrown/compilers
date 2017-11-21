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
  //mHashMap
  //mEnclosing
  //STElookup(string)
  //insert(STE)

  private final HashMap<String, STE> mHashMap = new HashMap<String, STE>();
  private Scope mEnclosing;



  public STE STElookup(String id){
      STE ste = null;

      return ste;
  }


}
