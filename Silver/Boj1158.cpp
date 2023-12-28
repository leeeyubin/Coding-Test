#include<iostream>
#include<queue>
#include<vector>
using namespace std;
int main()
{
	int N, K;
	cin >> N >> K;

	queue<int> q;
	vector<int> v;

	for (int i = 0; i < N; i++) {
		q.push(i + 1);
	}

	while (!q.empty()) {
		for (int i = 0; i < K - 1; i++) {
			int front = q.front();
			q.pop();
			q.push(front);
		}
		int res = q.front();
		q.pop();
		v.push_back(res);
	}

	cout << "<";
	for (int i = 0; i < v.size(); i++) {
		cout << v[i];
		if (i != v.size() - 1) {
			cout << ", ";
		}
	}
	cout << ">";

	return 0;
}
