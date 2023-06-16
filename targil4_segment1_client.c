#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>

#define SERVER_CLIENT_FIFO "a_fifo"
#define STR_LEN 100

int main() {
    char input[STR_LEN];

    while (strcmp("exit", input) != 0) { //a loop that checks if 'exit' was entered
        int fdw;
        fgets(input, STR_LEN, stdin);
        fflush(stdin);
        if ((fdw = open(SERVER_CLIENT_FIFO, O_WRONLY)) == -1) {
            perror("cannot open fifo file for writing");
            exit(EXIT_FAILURE);
        }

        write(fdw, input, strlen(input) + 1);
        close(fdw); //closing after writing

        if (strcmp(input, "exit") == 0) {
            break;
        }

        int fdr;
        if ((fdr = open(SERVER_CLIENT_FIFO, O_RDONLY)) == -1) {
            perror("cannot open fifo file for reading");
            exit(EXIT_FAILURE);
        }

        char response[STR_LEN];
        read(fdr, response, STR_LEN); //reading the response
        printf("%s\n", response);

        close(fdr); //closing after reading
    }

    exit(0);
}





