#include "Driver.h"
#include <iostream>
using namespace std;

bool Driver::sendNotification() {
	char choice;
	cout << "\nYour parking time is about to end, do you want to extend its duration?";
	cout << "\nBy picking anything besides 'y' or 'n', the notification will be ignored.";
	cout << "\nEnter your choice(y/n): ";
	cin >> choice;

	if (choice == 'y' || choice == 'Y') {
		return true;
	}
	else if (choice == 'n' || choice == 'N') {
		return false;
	}
	else {
		return false;
	}
}