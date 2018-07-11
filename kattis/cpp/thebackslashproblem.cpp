#include <iostream>
#include <fstream>
#include <string>
#include <vector>

using namespace std;

string escape(string s) {
	int l = s.length(); string newstr = ""; int last = 0;
	for (int i = 0; i < l; i++)
	{
		if ((s[i] >= '[') && (s[i] <= ']')) {
			newstr += s.substr(last, i - last); last = i;
			newstr.insert(newstr.length(), 1, '\\');
		}
		else if ((s[i] >= '!') && (s[i] <= '*')) {
			newstr += s.substr(last, i - last); last = i;
			newstr.insert(newstr.length(), 1, '\\');
		}
	}
	newstr += s.substr(last, s.length());
	return newstr;
}

int main() {
	string line;
	while (getline(cin, line)) {
		int lvls = atoi(line.c_str());
		string s; getline(cin, s);
		for (int i = 0; i < lvls; i++)
		{
			s = escape(s);
		}
		cout << s << "\n";
	}
}