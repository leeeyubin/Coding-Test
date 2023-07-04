#include <iostream>
#include<string>
#include<unordered_set>
using namespace std;
int main(void)
{
	string str;
	getline(cin, str);
	unordered_set<string> set;
	for (int i = 0; i < str.length(); i++) {
		for (int j = i + 1; j <= str.length(); j++) {
			set.insert(str.substr(i, j - i));
		}
	}
	cout << set.size();
	return 0;
}