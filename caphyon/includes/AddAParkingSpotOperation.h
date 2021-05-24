#pragma once
#include "Operation.h"
#include "ParkingReservation.h"

class AddAParkingSpotOperation : public Operation {
public:
	AddAParkingSpotOperation(string message, ParkingReservation* parkingReservation);
	void		run();
	string		getMessage();
	bool		doContinue();
private:
	ParkingReservation* parkingReservation;
};