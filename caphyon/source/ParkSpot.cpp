#include"../includes/ParkSpot.h"

ParkSpot::ParkSpot(int id, int size, int normalPrice, int maxTime, string location, vector<ExpensiveInterval> expensiveIntervals) {
	this->id = id;
	this->size = size;
	this->normalPrice = normalPrice;
	this->maxTime = maxTime;
	this->location = location;
	this->expensiveIntervals = expensiveIntervals;

	Spot emptySpot;
	for (int i = 0; i < size; i++) {
		spots.push_back(emptySpot);
	}
}

ParkSpot::ParkSpot(int id, int size, int normalPrice, int maxTime, string location) {
	this->id = id;
	this->size = size;
	this->normalPrice = normalPrice;
	this->maxTime = maxTime;
	this->location = location;
	
	Spot emptySpot;
	for (int i = 0; i < size; i++) {
		spots.push_back(emptySpot);
	}
}

ParkSpot::~ParkSpot() {
	spots.clear();
	expensiveIntervals.clear();
}

bool ParkSpot::isAvailable(int index) {
	if (spots[index].isAvailable()) {
		return true;
	}
	return false;
}

int ParkSpot::checkingForSpots() {
	for (int spot = 0; spot < spots.size(); spot++) {
		if (isAvailable(spot)) {
			return spot;
		}
	}

	cout<<"\nThere are no empty spots in this zone.\n";
	return -1;
}

void ParkSpot::printParkingIntervals() {
	cout << "\nAvailable parking time: \n";
	for (int i = 15, j = 1; i <= maxTime; i = i + 15, j++) {
		if (i / 60 != 0) {
			cout << j << ". " << i / 60 << "h";
			if (i % 60 != 0) {
				cout << ":" << i % 60;
			}
		}
		else {
			cout << j << ". " << i % 60 << "min";
		}

		if (i + 15 <= maxTime) {
			if (j % 4 == 0) {
				cout << endl;
			}
			else {
				cout << ", ";
			}
		}
	}
	cout << endl;
}

void ParkSpot::printParkingAreaDetails() {

	cout << "\tZone ID-" << id << " is located at the "<< location << " area and has the hourly price of " 
		 << normalPrice << " coins/hour.\n";
	
	if (expensiveIntervals.size() != 0) {
		cout << "\tExcept between: ";
		for (int i = 0; i < expensiveIntervals.size(); i++) {
			cout << "\n\t- ";
			expensiveIntervals[i].displayInterval();
		}
		cout << endl;
	}

	cout << "\tIt has the capacity of " << size << " spots and the maximum parking time is " 
	     << maxTime / 60 << "h and " << maxTime % 60 << " minutes.\n";
}

int ParkSpot::computeTax(Calendar currentTime, int time) {

	int totalTax = 0;
	int previousTax = 0;

	Calendar deadline = currentTime;
	Calendar justAboutToExpire = currentTime;
	Calendar elapsedTime = currentTime;

	deadline.incrementTime(time);
	justAboutToExpire.incrementTime(time - 14);

	while (deadline.isInTheFutureComparedTo(elapsedTime) && justAboutToExpire.isInTheFutureComparedTo(elapsedTime)) {
		elapsedTime.incrementTime(15);
		if (expensiveIntervals.size() != 0) {
			for (int i = 0; i < expensiveIntervals.size(); i++) {
				if (elapsedTime.isTimeInInterval(expensiveIntervals[i])) {
					totalTax = expensiveIntervals[i].incrementTaxBy15Min(totalTax);
					break;
				}
			}
			if (previousTax == totalTax) {
				totalTax = totalTax + normalPrice / 4;
			}
		}
		else {
			totalTax = totalTax + normalPrice / 4;
		}
		previousTax = totalTax;
	}

	return totalTax;
}

void ParkSpot::bookTheSpot(Calendar currentTime, Driver driver, int spot) {

	cout << "\n--------------------------------------------\n";
	cout << "\nThe current time is ";
	currentTime.displayTimeAndDate();
	cout << endl << endl;

	printParkingAreaDetails();

	cout << "\nThe parking spot no." << spot + 1 << " is available.\n";

	printParkingIntervals();

	int time, index;
	cout << "Choose your desired parking time (index): ";
	cin >> index;
	time = index * 15;

	if (time > maxTime || time <= 0) {
		cout << "\nChoose a valid index.\n";
		cout << "\n--------------------------------------------\n";
		return;
	}

	cout << "\nYou chose to book for " << time / 60 << "h and " << time % 60 << " minutes.\n";

	int totalTax = computeTax(currentTime, time);
	//unit testing 

	cout << "You will have to pay " << totalTax << " coins in total.\n";

	char choice;
	cout << "\nDo you want to book this spot?(y/n): ";
	cin >> choice;

	if (choice == 'y' || choice == 'Y') {

		Calendar deadline = currentTime;
		deadline.incrementTime(time);
		spots[spot].bookTheSpot(deadline, driver);

		cout << "\nParking spot no." << spot + 1 << " is now yours from ";
		currentTime.displayTimeAndDate();
		cout << "to ";
		deadline.displayTimeAndDate();
		cout << endl;
	}
	else if (choice == 'n' || choice == 'N') {
		cout << "We are sorry to hear that, farewell.\n";
	}
	else {
		cout << "Choose a valid option.\n";
	}

	cout << "\n--------------------------------------------\n";
}

void ParkSpot::book(Calendar currentTime, Driver driver) {

	int spot = checkingForSpots();

	if (spot > -1) {

		bookTheSpot(currentTime, driver, spot);
	}
}

void ParkSpot::checkForExpiration(int index, Calendar currentTime) {

	if (index <= 0 || index > spots.size()) {
		cout << "\nChoose a valid index for the spot.\n";
		return;
	}

	if (spots[index - 1].isAvailable()) {
		cout << "\nThis spot has not been booked yet.\n";
		return;
	}

	Calendar deadline = currentTime;
	bool response = false;

	if (spots[index-1].isDeadlineNow(currentTime)) {
		response = spots[index - 1].sendExpirationNotification();
		if (response == true) {
			bookTheSpot(currentTime, spots[index - 1].getDriver(), index - 1);
			return;
		}
		else {
			cout << "\nYour spot will expire as told at ";
			spots[index - 1].displaySpotDeadline();
			cout << "\nYou can extend your booking later if you decide to, but not later than your expiration time.\n";
			return;
		}
	}

	if (spots[index - 1].isDeadlineInThePastComparedTo(currentTime)) {
		cout << "\nThe current time is ";
		currentTime.displayTimeAndDate();
		cout << "\nThis parking spot time has expired at ";
		spots[index - 1].displaySpotDeadline();
		cout << endl;

		char choice;
		cout << "\nDo you want to remove the booking from this spot?(y/n): ";
		cin >> choice;

		if (choice == 'y' || choice == 'Y') {
			cout << "\nThis booking has been succesfully removed.\n";
			spots[index - 1].unBookTheSpot();
		}
		else if (choice == 'n' || choice == 'N') {
			cout << "Alright then, as you wish.\n";
		}
		else {
			cout << "Choose a valid option.\n";
		}
		return;
	}

	for (int minutes = 10; minutes >= 0; minutes--) {

		if (spots[index - 1].isAboutToExpireComparedTo(deadline, minutes)) {
			response = spots[index - 1].sendExpirationNotification();
			if (response == true) {
				bookTheSpot(currentTime, spots[index - 1].getDriver(), index - 1);
				return;
			}
			else {
				cout << "\nYour spot will expire as told at ";
				spots[index - 1].displaySpotDeadline();
				cout << "\nYou can extend your booking later if you decide to, but not later than your expiration time.\n";
				return;
			}
		}

		deadline.incrementTime(1);
	}

	cout << "\nThe current time is ";
	currentTime.displayTimeAndDate();
	cout << "\nThis parking spot time will expire at ";
	spots[index - 1].displaySpotDeadline();
	cout << endl;
}

void ParkSpot::removeABookedSpot(int index) {

	if (index <= 0 || index > spots.size()) {
		cout << "\nChoose a valid index for the spot.\n";
		return;
	}

	if (spots[index - 1].isAvailable()) {
		cout << "\nThis spot's has not been booked yet.\n";
		return;
	}

	cout << "\nThis parking spot expiration date is ";
	spots[index - 1].displaySpotDeadline();

	char choice;
	cout << "\nDo you want to remove the booking from this spot?(y/n): ";
	cin >> choice;

	if (choice == 'y' || choice == 'Y') {
		cout << "\nThis booking has been succesfully removed.\n";
		spots[index - 1].unBookTheSpot();
	}
	else if (choice == 'n' || choice == 'N') {
		cout << "Alright then, as you wish.\n";
	}
	else {
		cout << "Choose a valid option.\n";
	}
}

bool ParkSpot::find(string location) {
	if (this->location == location) {
		return true;
	}
	return false;
}

bool ParkSpot::find(int id) {
	if (this->id == id) {
		return true;
	}
	return false;
}