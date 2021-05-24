#include"../includes/ParkingReservation.h"

ParkingReservation::ParkingReservation(vector<ParkSpot> parkingSpots) {
	this->parkingSpots = parkingSpots;
}

ParkingReservation::~ParkingReservation() {
	parkingSpots.clear();
}

void ParkingReservation::addParkingSpot(ParkSpot parkSpot) {
	parkingSpots.push_back(parkSpot);
	cout << "\nParking spot added succesfully.\n";
}

void ParkingReservation::removeParkingSpot(int index) {

	if (index <= 0 || index > parkingSpots.size()) {
		cout << "\nChoose a valid index.\n";
		return;
	}

	parkingSpots.erase(parkingSpots.begin() + index - 1);
	cout << "\nParking spot removed succesfully.\n";
}

void ParkingReservation::displayThisReservation() {

	if (parkingSpots.size() == 0) {
		cout << "This reservation is empty.\n";
		return;
	}

	for (int i = 0; i < parkingSpots.size(); i++) {
		cout <<" "<< i + 1 << ". -> ";
		parkingSpots[i].printParkingAreaDetails();
		cout << endl;
	}
}

void ParkingReservation::bookASpotInParkingArea(int index, Calendar currentTime, Driver driver) {

	if (index <= 0 || index > parkingSpots.size()) {
		cout << "\nChoose a valid index.\n";
		return;
	}

	parkingSpots[index - 1].book(currentTime, driver);
}

int ParkingReservation::findParkingArea(string location) {

	for (int i = 0; i < parkingSpots.size(); i++) {
		if (parkingSpots[i].find(location) == true) {
			return i + 1;
		}
	}
	return -1;
}

int ParkingReservation::findParkingArea(int id) {

	for (int i = 0; i < parkingSpots.size(); i++) {
		if (parkingSpots[i].find(id) == true) {
			return i + 1;
		}
	}
	return -1;
}

void ParkingReservation::checkForExpiration(int index, Calendar currentTime) {
	if (index <= 0 || index > parkingSpots.size()) {
		cout << "\nChoose a valid index for the parking area.\n";
		return;
	}

	int spot;
	cout << "\nEnter the index of the parking spot you want to check: ";
	cin >> spot;
	parkingSpots[index - 1].checkForExpiration(spot, currentTime);
}

void ParkingReservation::removeABookingFromAParkingArea(int index) {
	if (index <= 0 || index > parkingSpots.size()) {
		cout << "\nChoose a valid index for the parking area.\n";
		return;
	}

	int spot;
	cout << "\nEnter the index of the parking spot you want: ";
	cin >> spot;
	parkingSpots[index - 1].removeABookedSpot(spot);
}