#include"../includes/Spot.h"
#include <iostream>
using namespace std;

Spot::Spot() {
	available = true;
}

Spot::Spot(Calendar deadline, Driver driver) {
	this->deadline = deadline;
	this->driver = driver;
	this->available = false;
}

Spot::~Spot() {
	deadline.~Calendar();
	driver.~Driver();
}

bool Spot::isAvailable() {
	if (available == true) {
		return true;
	}
	return false;
}

void Spot::bookTheSpot(Calendar deadline, Driver driver) {
	this->deadline = deadline;
	this->driver = driver;
	available = false;
}

void Spot::unBookTheSpot() {
	deadline.~Calendar();
	driver.~Driver();
	available = true;
}

void Spot::displaySpotDeadline() {
	deadline.displayTimeAndDate();
}

Driver Spot::getDriver() {
	return driver;
}

bool Spot::isAboutToExpireComparedTo(Calendar currentTime, int minutes) {

	if (currentTime.momentsAreEqual(deadline)) {
		return true;
	}
	
	Calendar elapsedTime = currentTime;
	elapsedTime.incrementTime(minutes);

	if (elapsedTime.momentsAreEqual(deadline)) {
		return true;
	}

	return false;
}

bool Spot::isDeadlineInThePastComparedTo(Calendar currentTime) {
	if (currentTime.isInTheFutureComparedTo(deadline)) {
		return true;
	}
	return false;
}

bool Spot::sendExpirationNotification() {

	bool response = driver.sendNotification();
	return response;
}

bool Spot::isDeadlineNow(Calendar currentTime) {
	if (currentTime.momentsAreEqual(deadline)) {
		return true;
	}
	return false;
}