#include"../includes/ExceptionOperation.h"
#include<iostream>
using namespace std;

void ExceptionOperation::run() {
	cout << "\nChoose a valid option.\n";
}

string ExceptionOperation::getMessage() {
	return "";
}

bool ExceptionOperation::doContinue() {
	return true;
}