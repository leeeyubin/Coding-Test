#include<iostream>
#include<queue>
#define MAX 601
using namespace std;
int pos[4][2] = { {0, 1}, {1,0}, {0,-1}, {-1,0} };
char maze[MAX][MAX];
int visited[MAX][MAX];
int N, M, res = 0;
void bfs(int x, int y) {

	queue<pair<int, int>> queue;
	visited[x][y] = 1;

	queue.push({ x,y });

	while (!queue.empty()) {
		pair<int, int> current = queue.front();
		queue.pop();

		for (int i = 0; i < 4; i++) {
			int newX = current.first + pos[i][0];
			int newY = current.second + pos[i][1];

			if (newX >= 1 && newY >= 1 && newX <= N && newY <= M && visited[newX][newY] != 1 && maze[newX][newY] != 'X') {
				if (maze[newX][newY] == 'P') res++;
				visited[newX][newY] = 1;
				queue.push({ newX, newY });
			}
		}
	}
}
int main(void)
{
	char target;
	int targetX, targetY;

	cin >> N >> M;

	for (int i = 1; i <= N; i++) {
		for (int j = 1; j <= M; j++) {
			cin >> target;
			if (target == 'I') {
				targetX = i;
				targetY = j;
			}
			maze[i][j] = target;
		}
	}

	bfs(targetX, targetY);

	if (res == 0) cout << "TT";
	else cout << res;

	return 0;
}