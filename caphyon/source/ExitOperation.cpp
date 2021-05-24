#include"../includes/ExitOperation.h"
#include<iostream>
using namespace std;

ExitOperation::ExitOperation(string message) {
	this->message = message;
}

void ExitOperation::run() {
	cout << "\nExited succesfully.\n";
}

string ExitOperation::getMessage() {
	return message;
}

bool ExitOperation::doContinue() {
	return false;
}