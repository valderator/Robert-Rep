#include"../includes/CheckExpirationOperation.h"
#include"../includes/ParkSpot.h"
#include <iostream>
using namespace std;

CheckExpirationOperation::CheckExpirationOperation(string message, ParkingReservation* parkingReservation) {
	this->message = message;
	this->parkingReservation = parkingReservation;
}

void CheckExpirationOperation::run() {

	int hour, minute, day, month, year;
	cout << "\nEnter the current moment in time.\n";

	cout << "\nDay (1-31): ";
	cin >> day;
	if (day > 31 || day < 1) {
		cout << "\nEnter a valid day.\n";
		return;
	}

	cout << "Month (1-12): ";
	cin >> month;
	if (month > 12 || month < 1) {
		cout << "\nEnter a valid month.\n";
		return;
	}

	cout << "Year (0-/): ";
	cin >> year;
	if (year < 0) {
		cout << "\nEnter a valid year.\n";
		return;
	}

	cout << "Hour (0-23): ";
	cin >> hour;
	if (hour > 23 || hour < 0) {
		cout << "\nEnter a valid hour.\n";
		return;
	}

	cout << "Minute (0-59): ";
	cin >> minute;
	if (minute > 59 || minute < 0) {
		cout << "\nEnter a valid minute.\n";
		return;
	}

	cout << endl;
	parkingReservation->displayThisReservation();

	Time currentTime(hour, minute);
	Date currentDate(day, month, year);
	Calendar currentMomentInTime(currentDate, currentTime);

	int index;
	cout << "\nEnter the index of the parking area you want to check: ";;
	cin >> index;

	parkingReservation->checkForExpiration(index, currentMomentInTime);

}

string CheckExpirationOperation::getMessage() {
	return message;
}

bool CheckExpirationOperation::doContinue() {
	return true;
}