#include <stdio.h>
#include <stdlib.h>
#include <limits.h>
int main(void)
{
	int N;
	int min = INT_MAX, max = INT_MIN;

	scanf_s("%d", &N);
	int* arr = (int*)malloc(sizeof(int) * N);

	for (int i = 0; i < N; i++) {
		scanf_s("%d", &arr[i]);
		if (arr[i] >= max)
			max = arr[i];
		if (arr[i] <= min)
			min = arr[i];
	}

	printf("%d %d", min, max);

	free(arr);
	return 0;
}