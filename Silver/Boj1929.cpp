#include<iostream>
#include<stack>
using namespace std;
int main(void)
{
	int K, sum=0;
	cin >> K;
	stack<int> s;

	for (int i = 0; i < K; i++) {
		int temp;
		cin >> temp;

		if (temp == 0) {
			s.pop();
		}
		else {
			s.push(temp);
		}
	}

	while (!s.empty()) {
		sum += s.top();
		s.pop();
	}

	cout << sum;

	return 0;
}