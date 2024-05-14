NAME = Program

SRCS = src/java/edu/roma42/printer/app/Program.java \
       src/java/edu/roma42/printer/logic/ImageTerm.java \
	   src/java/edu/roma42/printer/logic/CustomColor.java \

OBJS = $(SRCS:.java=.class)

OBJDIR = target/

all: $(OBJS)

download:
	@mkdir -p lib
	@if [ ! -f "lib/JColor-5.5.1.jar" ]; then \
		curl https://repo1.maven.org/maven2/com/diogonunes/JColor/5.5.1/JColor-5.5.1.jar --output lib/JColor-5.5.1.jar; \
	fi
	@if [ ! -f "lib/jcommander-1.82.jar" ]; then \
		curl https://repo1.maven.org/maven2/com/beust/jcommander/1.82/jcommander-1.82.jar --output lib/jcommander-1.82.jar; \
	fi

%.class: %.java
	@mkdir -p $(OBJDIR)
	@cp -r src/resources target/
	@echo "Compiling $(SRCS)"
	@javac -cp "lib/*" -d $(OBJDIR) $(SRCS)
	@jar -xf lib/JColor-5.5.1.jar com; mv com target; jar -xf lib/jcommander-1.82.jar com; mv com/beust target/com; rm -rf com


run: all
	@echo "Running program without jar\n"
	@java -cp $(OBJDIR) edu.roma42.printer.app.Program --white=white --black=black

run2: all
	@echo "Running program without jar\n"
	@java -cp $(OBJDIR) edu.roma42.printer.app.Program --white=red --black=black

jar: all
	@echo "Creating jar"
	@jar cvfe $(OBJDIR)images-to-chars-printer.jar edu.roma42.printer.app.Program -C . target/resources -C target com -C target edu

runjar: jar
	@echo "Running program with jar (default value)\n"
	@java -jar target/images-to-chars-printer.jar --white=white --black=black

runjar2: jar
	@echo "Running program without jar\n"
	@java -cp $(OBJDIR) edu.roma42.printer.app.Program --white=red --black=black

clean:
	@rm -r $(OBJDIR) lib

.PHONY: all clean