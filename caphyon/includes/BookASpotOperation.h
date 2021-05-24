#pragma once
#include "Operation.h"
#include "ParkingReservation.h"

class BookASpotOperation : public Operation {
public:
	BookASpotOperation(string message, ParkingReservation* parkingReservation);
	void		run();
	string		getMessage();
	bool		doContinue();
private:
	ParkingReservation* parkingReservation;
};