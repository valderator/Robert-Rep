#include"../includes/RemoveABookedSpotOperation.h"

RemoveABookedSpotOperation::RemoveABookedSpotOperation(string message, ParkingReservation* parkingReservation) {
	this->message = message;
	this->parkingReservation = parkingReservation;
}

void RemoveABookedSpotOperation::run() {

	int index;
	cout << "\nEnter the index of the parking area you want: ";
	cin >> index;

	parkingReservation->removeABookingFromAParkingArea(index);
}

string RemoveABookedSpotOperation::getMessage() {
	return message;
}

bool RemoveABookedSpotOperation::doContinue() {
	return true;
}