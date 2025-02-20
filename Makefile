ANT	= env LC_ALL=ja_JP.UTF-8 ant
ARCHIVE	= $(shell basename `pwd`)
PYTHON = env python

.PHONY:	test start

all:
	$(ANT) all

clean:
	$(ANT) clean

test:
	$(ANT) test
	(cd front ; make)
	java -jar vm.jar

junit:
	$(ANT) junit

install:
	$(ANT) install

doc:
	$(ANT) doc

railroad:
	$(PYTHON) ./bin/yacc_to_railroad_diagram.py

zip: clean
	find . -name ".DS_Store" | xargs rm
	(cd ../ ; zip -r ./$(ARCHIVE).zip ./$(ARCHIVE)/)
