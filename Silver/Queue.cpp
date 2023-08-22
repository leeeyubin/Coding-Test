#include<iostream>
#include<queue>
#include<cstring>
using namespace std;
int main(void)
{
	queue<int> queue;
	int N, X;
	int count = 0;
	string order;

	cin >> N;

	for (int i = 0; i < N; i++) {
		cin >> order;
		if (order == "push") {
			cin >> X;
			queue.push(X);
		}
		else if (order == "pop") {
			if (queue.empty()) {
				cout << -1 << endl;
			}
			else {
				int pop = queue.front();
				queue.pop();
				cout << pop << endl;
			}
		}
		else if (order == "size") {
			int size = queue.size();
			cout << size << endl;
		}
		else if (order == "empty") {
			if (queue.empty()) {
				cout << 1 << endl;
			}
			else {
				cout << 0 << endl;
			}
		}
		else if (order == "front") {
			if (queue.empty()) {
				cout << -1 << endl;
			}
			else {
				cout << queue.front() << endl;
			}
		}
		else if (order == "back") {
			if (queue.empty()) {
				cout << -1 << endl;
			}
			else {
				cout << queue.back() << endl;
			}
		}
	}

	return 0;
}