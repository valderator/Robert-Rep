#include "BookASpotOperation.h"
#include "ParkSpot.h"

BookASpotOperation::BookASpotOperation(string message, ParkingReservation* parkingReservation) {
	this->message = message;
	this->parkingReservation = parkingReservation;
}

void BookASpotOperation::run() {
	int index, hour, minute, day, month, year;

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

	cout << "Enter the index of the parking area where you want to book a spot: ";
	cin >> index;

	Time currentTime(hour, minute);
	Date currentDate(day, month, year);
	Calendar currentMomentInTime(currentDate, currentTime);
	Driver driver;
	
	parkingReservation->bookASpotInParkingArea(index, currentMomentInTime, driver);
}

string BookASpotOperation::getMessage() {
	return message;
}

bool BookASpotOperation::doContinue() {
	return true;
}