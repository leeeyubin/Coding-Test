#include<iostream>
#include<queue>
using namespace std;
int main(void)
{
	int testCase, N, M, weight;
	cin >> testCase;
	int* answer = new int[testCase];

	for (int i = 0; i < testCase; i++) {
		int count = 0;
		priority_queue<int> pq;
		queue<pair<int, int>> q;
		cin >> N >> M;
		for (int j = 0; j < N; j++) {
			cin >> weight;
			pq.push(weight);
			q.push({ j, weight });
		}
		while (!q.empty()) {
			int f = q.front().first;
			int s = q.front().second;
			q.pop();
			if (pq.top() == s) {
				pq.pop();
				count++;
				if (f == M) {
					answer[i] = count;
					break;
				}
			}
			else {
				q.push({ f, s });
			}
		}
	}

	for (int i = 0; i < testCase; i++) {
		cout << answer[i] << endl;
	}

	delete[]answer;

	return 0;
}