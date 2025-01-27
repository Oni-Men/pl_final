#include "defs.h"

void indent(int level);

int main(void) {
	linecounter = 1;
	yyparse();

	return(EXIT_SUCCESS);
}

void indent(int level) {
	int count;
	for (count = 0; count < level; count++) {
		printf("    ");
	}
}

Cell *cons(Cell *car, Cell *cdr) {
	Cell *pointer;

	pointer = (Cell *)malloc(sizeof(Cell));
	pointer->kind = CONS;
	pointer->head = car;
	pointer->tail = cdr;
	return(pointer);
}

Cell *node(char *car, Cell *cdr) {
	Cell *pointer;

	pointer = (Cell *)malloc(sizeof(Cell));
	pointer->kind = NODE;
	pointer->head = (Cell *)strdup(car);
	pointer->tail = cdr;
	return(pointer);
}

Cell *leaf(char *car, char *cdr) {
	Cell *pointer;

	pointer = (Cell *)malloc(sizeof(Cell));
	pointer->kind = LEAF;
	pointer->head = (Cell *)strdup(car);
	pointer->tail = (Cell *)strdup(cdr);

	return(pointer);
}

Cell *append(Cell *list, Cell *element) {
	Cell *pointer = list;
	while ((pointer->tail) != NULL){
		pointer = pointer->tail;
	}
	pointer->tail = cons(element, NULL);

	return list;
}

void tree(Cell *pointer) {
	visit(pointer, 1);
	printf("\n\n");
	fflush(stdout);
}

void visit(Cell *pointer, int level) {
	if (pointer == NULL) {
		return;
	}

	if (pointer->kind == CONS) {
		printf("\n");
		indent(level);
		visit(pointer->head, level + 1);
		if (pointer->tail != NULL && pointer->tail->kind == CONS) {
			visit_tail(pointer->tail, level + 1);	
		} else {
			visit(pointer->tail, level + 1);
		}
	}
	if (pointer->kind == NODE) {
		printf("\n");
		indent(level);
		printf("(");
		printf("%s ", (char *)pointer->head);
		if (pointer->tail != NULL && pointer->tail->kind == CONS) {
			visit_tail(pointer->tail, level + 1);
		} else {
			visit(pointer->tail, level + 1);
		}
		printf(")");
	}
	if (pointer->kind == LEAF) {
		printf("(");
		printf("%s ", (char *)pointer->head);
		printf("%s", (char *)pointer->tail);
		printf(")");
	}
	return;
}

void visit_tail(Cell *pointer, int level)
{
	if (pointer->head == NULL) {
		printf("()");
		return;
	}
	visit(pointer->head, level);
	if (pointer->tail != NULL) {
		if (pointer->tail->kind == CONS) {
			printf(" ");
			visit_tail(pointer->tail, level);
		} else {
			printf(" ");
			visit(pointer->tail, level);
		}
	}
}
