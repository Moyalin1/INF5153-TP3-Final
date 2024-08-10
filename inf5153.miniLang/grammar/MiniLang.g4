/**
 * Define a grammar called Mini Lang
 * 
 */
grammar MiniLang;

/**
 *  Grammaire du mini langage 
 * 
 *  auteur : el hachemi Alikacem 
 */
 
@header {
	package inf5153.miniLang.parser ;	
	
	import inf5153.miniLang.ast.* ; 
}


compileUnit : 
      block 		      #CompUnitBlock
      ; 
   
block : 
      '{' oneStat=statement*  '}' #Statements
      ; 

statement
    : 
      IF '(' cdt=expression ')' THEN blockThen=block (ELSE blockElse=block)?    #statemntIF 
    | WHILE '(' cdt=expression ')' blockWhile = block 		 	#statemntWhile
    | IDENTIFIER '=' expr=expression ';'						#statemntAssign
    | PRINT '(' expr=expression ')' ';' 						#statemntPrint
    | READ '(' STRINGLITERAL ',' IDENTIFIER ')' ';'  			#statemntRead
    ;

expression
    : 
      expr=primary											#primaryExpr
    | prefix = ('+' | '-') expression           			#uniryExpr
    | left=expression bop = ('*' | '/') right=expression    #binaryExprMult 
    | left=expression bop = ('+' | '-') right=expression    #binaryExprAdd  
    | left=expression bop = ('==' | '!=') right=expression  #binaryExprComp 
    ;

primary
    : '(' expression ')' #exprParenth
    | NUMBER             #numberLiteral 
    | STRINGLITERAL 	 #stringLiteral
    | IDENTIFIER         #identifier 
    ;


IF : 'if' ;
THEN : 'then' ;
ELSE : 'else' ; 
WHILE : 'while' ; 
PRINT : 'print' ; 
READ : 'read' ; 
NUMBER :   [0-9]+ ;
IDENTIFIER  :   [a-zA-Z]+;
WS : [ \t\r\n]+ -> skip ; // skip spaces, tabs, newlines

STRINGLITERAL
    : '"' (~ ('"' | '\n'))* '"'
    ;
