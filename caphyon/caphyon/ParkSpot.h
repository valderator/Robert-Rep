#pragma once
#include<iostream>
#include<vector>
#include"Driver.h"
#include"Calendar.h"
#include"Time.h"
#include"TimeInterval.h"
#include"ExpensiveInterval.h"
#include"Spot.h"
using namespace std;

class ParkSpot {
public:
	ParkSpot(int id, int size, int normalPrice, int maxTime, string location, vector<ExpensiveInterval> expensiveIntervals);
	ParkSpot(int id, int size, int normalPrice, int maxTime, string location);
	~ParkSpot();

	void			book(Calendar currentTime, Driver driver);
	void			removeABookedSpot(int index);
	void			printParkingAreaDetails();
	void			checkForExpiration(int index, Calendar currentTime);
	bool			find(string location);
	bool			find(int id);

private:
	int						  id;
	int						  size;
	string					  location;
	int						  maxTime;
	int						  normalPrice;
	vector<ExpensiveInterval> expensiveIntervals;
	vector<Spot>			  spots;

	int				checkingForSpots();
	bool			isAvailable(int index);
	void			printParkingIntervals();
	int				computeTax(Calendar currentTime, int time);
	void			bookTheSpot(Calendar currentTime, Driver driver, int spot);
};