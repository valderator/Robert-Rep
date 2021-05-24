#include<iostream>
#include <unordered_map>
#include "ParkingReservation.h"
#include "Menu.h"
#include "ExitOperation.h"
#include "AddAParkingSpotOperation.h"
#include "RemoveAParkingSpotOperation.h"
#include "DisplayYourReservationOperation.h"
#include "BookASpotOperation.h"
#include "CheckExpirationOperation.h"
#include "RemoveABookedSpotOperation.h"
#include "ExceptionOperation.h"

#include"Time.h"
#include"TimeInterval.h"
#include"Date.h"
#include"Calendar.h"

using namespace std;

int main() {

	Time lower(12, 0);
	Time upper(13, 0);
	TimeInterval timeInterval(lower, upper);
	int price = 160;
	ExpensiveInterval expensiveInterval(timeInterval, price);
	vector<ExpensiveInterval> expensiveIntervals;
	expensiveIntervals.push_back(expensiveInterval);

	ParkSpot orangeParkingSpot(1, 10, 40, 60, "Central");

	ParkSpot purpleParkingSpot(2, 20, 60, 180, "Residential");

	ParkSpot blueParkingSpot(3, 30, 80, 1440, "Busy", expensiveIntervals);

	ParkingReservation* park = new ParkingReservation;
	//park->addParkingSpot(orangeParkingSpot);
	//park->addParkingSpot(purpleParkingSpot);
	//park->addParkingSpot(blueParkingSpot);
	

	unordered_map<int, Operation*> operationMap;
	operationMap[0] = new ExitOperation("Press '0' to exit.");
	operationMap[1] = new AddAParkingSpotOperation("Press '1' to add a new parking spot.", park);
	operationMap[2] = new RemoveAParkingSpotOperation("Press '2' to remove a parking spot.", park);
	operationMap[3] = new DisplayYourReservationOperation("Press '3' to display your parking reservation.", park);
	operationMap[4] = new BookASpotOperation("Press '4' to book a spot in a parking area.", park);
	operationMap[5] = new CheckExpirationOperation("Press '5' to check the expiration time for a spot.", park);
	operationMap[6] = new RemoveABookedSpotOperation("Press '6' to remove a booking from a spot.", park);
	operationMap[-1] = new ExceptionOperation();
	Menu menu(operationMap);
	menu.run();

	cout << endl;
	return 0;
}
