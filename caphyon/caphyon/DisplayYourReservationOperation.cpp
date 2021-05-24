#include "DisplayYourReservationOperation.h"

DisplayYourReservationOperation::DisplayYourReservationOperation(string message, ParkingReservation *parkingReservation) {
	this->message = message;
	this->parkingReservation = parkingReservation;
}

void DisplayYourReservationOperation::run() {
	cout << endl;
	parkingReservation->displayThisReservation();
}

string DisplayYourReservationOperation::getMessage() {
	return message;
}

bool DisplayYourReservationOperation::doContinue() {
	return true;
}