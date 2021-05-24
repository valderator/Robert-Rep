#pragma once
#include <unordered_map>
#include "Operation.h"
using namespace std;

class Menu {
public:
	Menu() {};
	Menu(unordered_map<int, Operation*> operationMap);
	~Menu();
	void		run();

private:
	void		displayMessages();
	unordered_map<int, Operation*> operationMap;
};