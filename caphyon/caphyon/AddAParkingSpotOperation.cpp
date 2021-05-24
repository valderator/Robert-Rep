#include "AddAParkingSpotOperation.h"
#include "ParkSpot.h"
#include <iostream>
using namespace std;

AddAParkingSpotOperation::AddAParkingSpotOperation(string message, ParkingReservation* parkingReservation) {
	this->message = message;
	this->parkingReservation = parkingReservation;
}

void AddAParkingSpotOperation::run() {

	int ID, size, normalPrice, maxTime, expensivePrice;
	string location;
	vector<ExpensiveInterval> expensiveIntervals;

	cout << "\nChoose the ID of the parking spot: ";
	cin >> ID;
	if (parkingReservation->findParkingArea(ID) != -1) {
		cout << "\nThere already exists a parking spot with this ID.\n";
		return;
	}
	cout << "Choose the maximum capacity of the parking spot: ";
	cin >> size;
	cout << "Enter the location of the parking spot (text): ";
	cin >> location;
	cout << "Enter the normal hourly price of the parking spot: ";
	cin >> normalPrice;
	cout << "Choose the maximum time you can park here (minutes): ";
	cin >> maxTime;

	char choice;
	cout << "Do you want to have a more expensive time interval for this parking spot?(y/n): ";
	cin >> choice;

	if (choice == 'y' || choice == 'Y') {
		while (choice == 'y' || choice == 'Y') {

			int lowerHour, lowerMinute, upperHour, upperMinute;
			cout << "\nEnter the expensive time interval.\n";

			cout << "\nLower bound hour (0-23): ";
			cin >> lowerHour;
			if (lowerHour > 23 || lowerHour < 0) {
				cout << "\nEnter a valid hour.\n";
				return;
			}

			cout << "Lower bound minute (0-59): ";
			cin >> lowerMinute;
			if (lowerMinute > 59 || lowerMinute < 0) {
				cout << "\nEnter a valid hour.\n";
				return;
			}
			Time lowerBound(lowerHour, lowerMinute);

			cout << "Upper bound hour (0-23): ";
			cin >> upperHour;
			if (upperHour > 23 || upperHour < 0) {
				cout << "\nEnter a valid hour.\n";
				return;
			}

			cout << "Upper bound minute (0-59): ";
			cin >> upperMinute;
			if (upperMinute > 59 || upperMinute < 0) {
				cout << "\nEnter a valid hour.\n";
				return;
			}
			Time upperBound(upperHour, upperMinute);
			TimeInterval timeInterval(lowerBound, upperBound);

			if (timeInterval.areIntervalsWrong()) {
				timeInterval.swapIntervals();
			}

			cout << "\nEnter the price for the expensive time interval: ";
			cin >> expensivePrice;

			ExpensiveInterval expensiveInterval(timeInterval, expensivePrice);
			expensiveIntervals.push_back(expensiveInterval);

			cout << "Do you want to add another expensive interval?(y/n): ";
			cin >> choice;
		}

		ParkSpot newParkSpot(ID, size, normalPrice, maxTime, location, expensiveIntervals);
		parkingReservation->addParkingSpot(newParkSpot);
	}
	else if (choice == 'n' || choice == 'N') {
		cout << "\nAll right, this parking spot won't have an expensive interval.\n";
		ParkSpot newParkSpot(ID, size, normalPrice, maxTime, location);
		parkingReservation->addParkingSpot(newParkSpot);
	}
	else {
		cout << "Choose a valid option.\n";
	}
}

string AddAParkingSpotOperation::getMessage() {
	return message;
}

bool AddAParkingSpotOperation::doContinue() {
	return true;
}
