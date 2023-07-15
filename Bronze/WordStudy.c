#include <stdio.h>
#include <string.h>
int main(void)
{
    char word[1000000];
    int res[26] = { 0 }; 
    scanf("%s", word);

    int max = 0;
    int size = strlen(word);
    int count = 0;

    for (int i = 0; i < size; i++) {
        if (word[i] >= 'a')
            res[word[i] - 'a']++;
        else
            res[word[i] - 'A']++;
    }

    for (int i = 0; i < 26; i++) { 
        if (res[i] >= res[max]) 
            max = i;
    }

    for (int i = 0; i < 26; i++) { 
        if (res[i] == res[max]) 
            count++;
    }

    if (count >= 2)
        printf("?");
    else
        printf("%c", max + 'A'); 

    return 0;
}