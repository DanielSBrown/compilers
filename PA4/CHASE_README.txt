whats up b

The AST Generation is working for most of if not all of the PA4 Grammar. mj.cup might look a bit messy, but I really had to fuck around with the grammar to make it work. Things to look out for: in the exp ::= rule, there is something I commented out that the grammar says we need, but it gives a shift reduce and I have gotten PA4BlueDot.java to work without it. Dunno if thats a good thing, though. Besides that one rule, other places the grammar may not be exactly right would be were you declare more than one other class in a file. For example, PA4BlueDot does just 1, idk what would happen if you did 2. I tried to handle it in the grammar, but idk if it works.


EDIT: 1:33 PM. I think I got that working too. It looks pretty close to the reference AST. I think we're good to go. That was a lot of work holy moly. <3 you chase, the next part is SymbolTable. 
