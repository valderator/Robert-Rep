#pragma once
#include "ParkSpot.h"

class ParkingReservation {
public:
	ParkingReservation() {}
	ParkingReservation(vector<ParkSpot> parkingSpots);
	~ParkingReservation();

	void			  addParkingSpot(ParkSpot parkSpot);
	void			  removeParkingSpot(int index);
	void			  displayThisReservation();
	void			  bookASpotInParkingArea(int index, Calendar currentTime, Driver driver);
	void			  removeABookingFromAParkingArea(int index);
	void			  checkForExpiration(int index, Calendar currentTime);
	int				  findParkingArea(string location);
	int				  findParkingArea(int id);

private:
	vector<ParkSpot>  parkingSpots;
};