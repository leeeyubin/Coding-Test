#include<iostream>
using namespace std;
int main(void)
{
	int n = 0;
	cin >> n;
	int* arr = new int[n];
	int* sort = new int[5];

	for (int i = 0; i < n; i++) {
		cin >> arr[i];
	}

	for (int i = 0; i < n - 1; i++) {
		for (int j = 0; j < n - i - 1; j++) {
			if (arr[j] > arr[j + 1]) {
				int temp = arr[j];
				arr[j] = arr[j + 1];
				arr[j + 1] = temp;
			}
		}
	}

	int left = 0, right = 0;
	int min = 1000000000;

	while (right >= left) {
		if (right >= n)
			break;
		if (arr[right] - arr[left] > 4)
			left++;
		else {
			int a = 5 - (right - left + 1);
			if (min > a)
				min = a;
			right++;
		}
	}

	cout << min << endl;

	return 0;
}