#pragma once
#include "Operation.h"
#include "ParkingReservation.h"

class DisplayYourReservationOperation : public Operation {
public:
	DisplayYourReservationOperation(string message, ParkingReservation* parkingReservation);
	void		run();
	string		getMessage();
	bool		doContinue();
private:
	ParkingReservation* parkingReservation;
};