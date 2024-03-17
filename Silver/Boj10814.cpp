#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;
bool compare(pair<int, string> x, pair<int, string> y) {
	return x.first < y.first;
}
int main(void)
{

	int N;
	vector<pair<int, string>> v;

	cin >> N;
	for (int i = 0; i < N; i++) {
		int age;
		string name;
		cin >> age >> name;
		v.push_back(make_pair(age, name));
	}

	stable_sort(v.begin(), v.end(), compare);

	for (auto& i : v) {
		cout << i.first << " " << i.second << "\n";
	}

	return 0;
}