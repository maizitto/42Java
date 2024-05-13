# NAME = Program
# SRCS = $(shell find . -name "*.java")
# OBJDIR = target/
# JAR_NAME = images-to-chars-printer.jar
# OBJS = $(patsubst %.java,$(OBJDIR)%.class,$(SRCS))

# all: $(OBJS)

# $(OBJDIR)%.class: %.java
# 	@mkdir -p $(@D)
# 	@javac -d $(@D) $<

# run: all
# 	@echo "Running program without jar\n"
# 	@java -cp $(OBJDIR) edu.roma42.printer.app.Program 0 1

# $(OBJDIR)$(JAR_NAME): all
# 	@echo "Creating jar"
# 	@jar cvfm $(OBJDIR)/$(JAR_NAME) src/manifest.txt -C $(OBJDIR) .

# runjar: $(OBJDIR)$(JAR_NAME)
# 	@echo "Running program with jar\n"
# 	@java -jar $< 0 1

# clean:
# 	@rm -rf $(OBJDIR) $(JAR_NAME)

# .PHONY: all clean run runjar

NAME = Program

SRCS = src/java/edu/roma42/printer/app/Program.java \
       src/java/edu/roma42/printer/logic/ImageTerm.java \

OBJS = $(SRCS:.java=.class)

OBJDIR = target/

all: $(OBJS)

%.class: %.java
	@javac -d $(OBJDIR) $(SRCS)

run: all
	@echo "Running program without jar\n"
	@java -cp $(OBJDIR) edu.roma42.printer.app.Program 0 1

jar: all
	@echo "Creating jar"
	@jar cvfe $(OBJDIR)images-to-chars-printer.jar edu.roma42.printer.app.Program -C $(OBJDIR) .

runjar: jar
	@echo "Running program with jar\n"
	@java -jar target/images-to-chars-printer.jar 0 1

clean:
	@rm -r $(OBJDIR)

.PHONY: all clean