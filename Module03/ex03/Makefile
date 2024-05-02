NAME	= Program

SRC		= $(wildcard *java)
CC		= javac
RM		= rm -f
EXEC	= java

$(NAME):
		@$(CC) -Xlint:-deprecation $(SRC)

all: $(NAME)

launch: $(NAME)
		@$(EXEC) $(NAME)

clean:
		@$(shell $(RM) *class)

fclean: clean

re: fclean all

.PHONY: all launch clean fclean re