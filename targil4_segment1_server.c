#include <stdio.h>
#include <stdlib.h>
#include <errno.h>
#include <string.h>
#include <fcntl.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <unistd.h>
#include <pthread.h>

#define SERVER_CLIENT_FIFO "a_fifo"
#define STR_LEN 100

pthread_t th;
FILE* fdr;
FILE* fdw;

char* revstr(const char* str1) { //Using a secondary function to perform the reverse to the string
    size_t len = strlen(str1);
    char* reversed_str = malloc(len + 1);  // Allocate memory for reversed string

    if (reversed_str == NULL) {
        perror("failed to allocate memory");
        exit(EXIT_FAILURE);
    }

    for (size_t i = 0; i < len; i++) {
        reversed_str[i] = str1[len - i - 1];
    }
    reversed_str[len] = '\0';  // Null-terminate the reversed string

    return reversed_str;
}

void* reversed(void* arg) { //Function to get the argument from pthread_create
    if (!(fdw = fopen(SERVER_CLIENT_FIFO, "w"))) {
        perror("cannot open fifo file for w");
        exit(EXIT_FAILURE);
    }

    char input[STR_LEN];
    strcpy(input, (char*)arg);
    if (strcmp(input, "exit\n") != 0) {
        int len = strlen(input);
        if (input[len - 1] == '\n') {
            input[len - 1] = '\0';
        }

        char* reversed_str = revstr(input);
        fputs(reversed_str, fdw);
        fflush(fdw);

        free(reversed_str);  // Free the memory allocated for reversed string
    }
    else {
        fputs("Done", fdw);
        fflush(fdw);
    }

    fclose(fdw);
    pthread_exit(NULL);
}

int main() {
    char exits[STR_LEN];

    if (mkfifo(SERVER_CLIENT_FIFO, S_IFIFO | 0667) == -1 && errno != EEXIST) { //creating the FIFO pipe for both client and server
        perror("cannot create fifo file"); 
        exit(EXIT_FAILURE); //this code from FIFO example from moodle
    }

    while (strcmp("exit\n", exits) != 0) { //checks if exit is in the string
        if (!(fdr = fopen(SERVER_CLIENT_FIFO, "r"))) {
            perror("cannot open fifo file for r");
            exit(EXIT_FAILURE); //same as in example for fopen
        }

        fgets(exits, STR_LEN, fdr);
        fclose(fdr);

        pthread_create(&th, NULL, reversed, (void*)exits);
        pthread_join(th, NULL);
    }

    unlink(SERVER_CLIENT_FIFO);
    exit(0);
}
