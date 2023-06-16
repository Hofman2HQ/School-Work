#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/wait.h>

#define STR_LEN 100

void reverseString(char* str) {
    int len = strlen(str);
    for (int i = 0; i < len / 2; i++) {
        char temp = str[i];
        str[i] = str[len - i - 1];
        str[len - i - 1] = temp;
    }
}

int main() {
    int pipe_client_to_server[2];
    int pipe_server_to_client[2];

    if (pipe(pipe_client_to_server) == -1 || pipe(pipe_server_to_client) == -1) {
        perror("pipe creation failed");
        exit(EXIT_FAILURE);
    }

    pid_t pid = fork();

    if (pid == -1) {
        perror("fork failed");
        exit(EXIT_FAILURE);
    }

    if (pid == 0) { // child process is server

        close(pipe_client_to_server[1]);   // Close write end of pipe that server reads from it
        close(pipe_server_to_client[0]);   // Close read end of pipe that server writes to it

        char request[STR_LEN];
        char response[STR_LEN] = "";

        while (1) {
            read(pipe_client_to_server[0], request, STR_LEN);  //requests from client

            if (strcmp(request, "exit\n") == 0) {
                strcpy(response, "Done");
                write(pipe_server_to_client[1], response, STR_LEN);  //response to client
                break;
            }

            reverseString(request);
            strcpy(response, request);
            write(pipe_server_to_client[1], response, STR_LEN);  //response to client
        }

        close(pipe_client_to_server[0]);
        close(pipe_server_to_client[1]);
        exit(EXIT_SUCCESS);
    }
    else {
        // Parent process represents the client

        close(pipe_client_to_server[0]);   //close write end of pipe that server reads from it
        close(pipe_server_to_client[1]);   //close read end of pipe that server writes to it

        char input[STR_LEN];
        char response[STR_LEN];

        while (1) {
            fgets(input, STR_LEN, stdin);

            write(pipe_client_to_server[1], input, STR_LEN);  //request to server

            if (strcmp(input, "exit\n") == 0) {
                read(pipe_server_to_client[0], response, STR_LEN);  //read response from server
                printf("%s\n", response);
                break;
            }

            read(pipe_server_to_client[0], response, STR_LEN);  //eead response from server
            printf("%s\n", response);
        }

        close(pipe_client_to_server[1]);
        close(pipe_server_to_client[0]);

        
        int status;
        wait(&status); //waiting for the child to finish

        if (WIFEXITED(status)) {
            printf("status: %d\n", WEXITSTATUS(status));
        }
    }

    return 0;
}
