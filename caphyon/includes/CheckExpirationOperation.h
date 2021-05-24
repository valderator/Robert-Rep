#pragma once
#include"Operation.h"
#include"ParkingReservation.h"

class CheckExpirationOperation : public Operation {
public:
	CheckExpirationOperation(string message, ParkingReservation* parkingReservation);
	void		 run();
	string		 getMessage();
	bool		 doContinue();
private:
	ParkingReservation* parkingReservation;
};

