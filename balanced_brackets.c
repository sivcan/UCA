
char reverse(char ch) {
    switch(ch) {
        case '}' : return '{';
        case ']' : return '[';
        case ')' : return '(';
    }
    return 0;
}
char arr[1000];
char** braces(int values_size, char** values, int* result_size) {
    int top = 0;
    *result_size = values_size;
    int flag;
    for(int i = 0; i < values_size; i++) {
           flag = 1;
            top = 0;
        for(int j = 0; values[i][j]; j++) {
            if(values[i][j] == '{' || values[i][j] == '(' || values[i][j] == '[') {
                arr[++top] = values[i][j];
            }
            else {
                if(top <= 0 || arr[top] != reverse(values[i][j])) {
                    flag = 0;
                    break;
                }
                else if(top > 0){
                    --top;
                }

            }
        }
        if(top == 0 && flag) {
            strcpy(values[i],"YES");
        }
        else {
            strcpy(values[i], "NO");
        }
      }
    }
    return values;
}
