NAME = Program

SRCS = src/java/edu.roma42.printer/app/Program.java \
       src/java/edu.roma42.printer/logic/ImageTerm.java \

OBJS = $(SRCS:.java=.class)

OBJDIR = target/

all: $(OBJS)

%.class: %.java
	@javac -d $(OBJDIR) $(SRCS)

run:
	@java -cp target edu.roma42.printer.app.Program 0 1 it.bmp

clean:
	rm -r $(OBJDIR)\edu

.PHONY: all clean