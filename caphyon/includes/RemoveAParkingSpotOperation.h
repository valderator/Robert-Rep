#pragma once
#include "Operation.h"
#include "ParkingReservation.h"

class RemoveAParkingSpotOperation : public Operation {
public:
	RemoveAParkingSpotOperation(string message, ParkingReservation* parkingReservation);
	void		run();
	string		getMessage();
	bool		doContinue();
private:
	ParkingReservation* parkingReservation;
};