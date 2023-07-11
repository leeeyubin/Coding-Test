#include<iostream>
#include<queue>
using namespace std;
int bfs(int N, int K)
{
	queue<int> queue;
	bool visited[100001] = {false};
	int time[100001] ={0};
	queue.push(N);
	visited[N] = true;

	while (!queue.empty()) {
		int temp = queue.front();
		queue.pop();
		if (temp == K)
			return time[temp];
		int pos[3] = { temp + 1, temp - 1,temp * 2 };
		for (int node : pos) {
			if (node < 0 || node >= 100001)
				continue;
			if (!visited[node]) {
				visited[node] = true;
				time[node] = time[temp] + 1;
				queue.push(node);
			}
		}
	}
	return -1;
}
int main(void)
{
	int N, K;
	cin >> N >> K;
	cout << bfs(N, K);

	return 0;
}