%{
int linecounter = 1;
%}
%option nounput
%%
[A-Z][a-zA-Z0-9_]*                             			    { return(UPPER_ID); }
[a-z_][a-zA-Z0-9_]*                             			{ return(LOWER_ID); }
[0-9]+                                      				{ return(INTEGER); }
[0-9]*"."[0-9]+                             				{ return(REAL); }
"\""[a-zA-Z0-9_ \t.:;=\!#$%&\(\)/<>\?-]*"\""				{ return(STRING); }
":="                                            			{ return(ASSERT); }
"?="                                            			{ return(PROVE); }
";"                                             			{ return(SEMICOLON); }
","                                             			{ return(COMMA); }
"\."                                            			{ return(DOT); }
"="                                             			{ return(EQUAL); }
"!="                                            			{ return(NOTEQ); }
"<"                                             			{ return(LT); }
">"                                             			{ return(GT); }
"<="                                            			{ return(LE); }
">="                                            			{ return(GE); }
"+"                                             			{ return(ADD); }
"-"                                             			{ return(SUBTRACT); }
"*"                                             			{ return(MULTIPLY); }
"^"                                             			{ return(HAT); }
"/"                                             			{ return(DIVIDE); }
"~"                                             			{ return(IN); }
"!~"                                            			{ return(NOTIN); }
"("                                             			{ return(LPAR); }
")"                                             			{ return(RPAR); }
"{"                                             			{ return(LBRACE); }
"}"                                             			{ return(RBRACE); }
"["                                             			{ return(LBRACKET); }
"]"                                             			{ return(RBRACKET); }
"|"                                             			{ return(VBAR); }
"\n"                                            			{ linecounter++; }
"\r\n"                                          			{ linecounter++; }
"\r"                                            			{ linecounter++; }
" "|"\t"                                        			{ }
"/*"                                            			{ comment(); }
"//".*														{ }
.                                               			{ return(UNKNOWN); }
%%
int yywrap(void) {
	return(1);
}
void comment(void) {
	int boolean, first, second;

	boolean = TRUE;
	first = input();
	while (first != EOF && boolean) {
		second = input();
		if (first == '*' && second == '/') {
			boolean = FALSE;
		} else if (first == '\r' && second == '\n') {
			linecounter++;
			first = input();
		} else {
			if (first == '\r' || first == '\n') {
				linecounter++;
			}
			first = second;
		}
	}
	if (first == EOF) {
		fprintf(stderr, "eof in comment\n");
	}
}
