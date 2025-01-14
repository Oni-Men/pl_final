ANT	= env LC_ALL=ja_JP.UTF-8 ant
ARCHIVE	= $(shell basename `pwd`)

.PHONY:	test

all:
	$(ANT) all

clean:
	$(ANT) clean

test:
	$(ANT) test

junit:
	$(ANT) junit

install:
	$(ANT) install

doc:
	$(ANT) doc

zip: clean
	find . -name ".DS_Store" | xargs rm
	(cd ../ ; zip -r ./$(ARCHIVE).zip ./$(ARCHIVE)/)
