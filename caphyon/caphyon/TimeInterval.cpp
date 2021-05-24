#include "TimeInterval.h"
#include<iostream>
using namespace std;

TimeInterval::TimeInterval(Time lowerInterval, Time upperInterval) {
	this->lowerInterval = lowerInterval;
	this->upperInterval = upperInterval;
}

bool TimeInterval::contains(Time currentTime) {
	if (currentTime.isLaterThan(lowerInterval) || currentTime.isTimeEqual(lowerInterval)) {
		if (currentTime.isEarlierThan(upperInterval) || currentTime.isTimeEqual(upperInterval)) {
			return true;
		}
	}
	return false;
}

void TimeInterval::displayInterval() {
	lowerInterval.displayTime();
	cout << "-";
	upperInterval.displayTime();
}

void TimeInterval::swapIntervals() {
	Time aux;
	aux = upperInterval;
	upperInterval = lowerInterval;
	lowerInterval = aux;
}

bool TimeInterval::areIntervalsWrong() {
	if (lowerInterval.isLaterThan(upperInterval) || upperInterval.isEarlierThan(lowerInterval)) {
		return true;
	}
	return false;
}