#include<iostream>
using namespace std;
int main(void)
{
	int N;
	cin >> N;
	int count = 0;

	while (N % 5 != 0 && N >= 0) {
		N -= 3;
		count++;
	}

	if (N < 0) {
		cout << -1;
	}
	else {
		count = count + N / 5;
		cout << count;
	}

	return 0;
}