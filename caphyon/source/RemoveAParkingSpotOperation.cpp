#include"../includes/RemoveAParkingSpotOperation.h"

RemoveAParkingSpotOperation::RemoveAParkingSpotOperation(string message, ParkingReservation* parkingReservation) {
	this->message = message;
	this->parkingReservation = parkingReservation;
}

void RemoveAParkingSpotOperation::run() {
	cout << endl;
	parkingReservation->displayThisReservation();

	int index;
	cout << "Enter the index of the parking spot you want to remove: ";
	cin >> index;

	parkingReservation->removeParkingSpot(index);
}

string RemoveAParkingSpotOperation::getMessage() {
	return message;
}

bool RemoveAParkingSpotOperation::doContinue() {
	return true;
}