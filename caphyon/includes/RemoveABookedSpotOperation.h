#pragma once
#include"Operation.h"
#include"ParkingReservation.h"

class RemoveABookedSpotOperation : public Operation {
public:
	RemoveABookedSpotOperation(string message, ParkingReservation* parkingReservation);
	void		run();
	string		getMessage();
	bool		doContinue();
private:
	ParkingReservation* parkingReservation;
};

