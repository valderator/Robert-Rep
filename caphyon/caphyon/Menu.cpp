#include "Menu.h"
#include<iostream>
using namespace std;

Menu::Menu(unordered_map<int, Operation*> operationMap) {
	this->operationMap = operationMap;
}

Menu::~Menu() {
	operationMap.clear();
}

void Menu::run() {

	int operationCode;
	do {
		displayMessages();
		cout << "Your option: ";
		cin >> operationCode;
		cout << "--------------------------------------------\n";
		if (operationMap[operationCode] != nullptr) {
			operationMap[operationCode]->run();
		}
		else {
			operationCode = -1;
			operationMap[operationCode]->run();
		}
	} while (operationMap[operationCode]->doContinue());
}

void Menu::displayMessages() {
	unordered_map<int, Operation*>::iterator it;
	cout << "\n--------------------------------------------\n";
	for (it = operationMap.begin(); it != operationMap.end(); it++) {
		if (it->second != nullptr && it->first != -1) {
			cout << it->second->getMessage() << endl;
		}
	}
}