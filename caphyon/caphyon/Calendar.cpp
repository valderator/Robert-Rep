#include "Calendar.h"
#include<iostream>
using namespace std;

Calendar::Calendar(Date date, Time time) {
	this->date = date;
	this->time = time;
}

Calendar::~Calendar() {
	date.~Date();
	time.~Time();
}

bool Calendar::isInTheFutureComparedTo(Calendar comparedCalendar) {
	if (comparedCalendar.dateIsInThePastComparedTo(date)) {
		return true;
	}

	if (comparedCalendar.datesAreEqual(date)) {
		if (comparedCalendar.timeIsInThePastComparedTo(time)) {
			return true;
		}
	}

	return false;
}

bool Calendar::isInThePastComparedTo(Calendar comparedCalendar) {
	if (comparedCalendar.dateIsInTheFutureComparedTo(date)) {
		return true;
	}

	if (comparedCalendar.datesAreEqual(date)) {
		if (comparedCalendar.timeIsInTheFutureComparedTo(time)) {
			return true;
		}
	}

	return false;
}

bool Calendar::momentsAreEqual(Calendar comparedCalendar) {
	if (comparedCalendar.datesAreEqual(date)) {
		if (comparedCalendar.timesAreEqual(time)) {
			return true;
		}
	}
	return false;
}

bool Calendar::dateIsInThePastComparedTo(Date comparedDate) {
	if (comparedDate.isInTheFutureComparedTo(date)) {
		return true;
	}
	return false;
}

bool Calendar::timeIsInThePastComparedTo(Time comparedTime) {
	if (comparedTime.isLaterThan(time)) {
		return true;
	}
	return false;
}

bool Calendar::dateIsInTheFutureComparedTo(Date comparedDate) {
	if (comparedDate.isInThePastComparedTo(date)) {
		return true;
	}
	return false;
}

bool Calendar::timeIsInTheFutureComparedTo(Time comparedTime) {
	if (comparedTime.isEarlierThan(time)) {
		return true;
	}
	return false;
}

bool Calendar::datesAreEqual(Date comparedDate) {
	if (comparedDate.areDatesEqual(date)) {
		return true;
	}
	return false;
}

bool Calendar::timesAreEqual(Time comparedTime) {
	if (comparedTime.isTimeEqual(time)) {
		return true;
	}
	return false;
}


void Calendar::displayTimeAndDate() {
	time.displayTime();
	date.displayDate();
}

void Calendar::incrementTime(int minutes) {

	int	daysToPass = time.incrementTime(minutes);

	if (daysToPass > 0) {
		date.incrementTime(daysToPass);
	}

}

bool Calendar::isTimeInInterval(ExpensiveInterval interval) {
	if (interval.contains(time)) {
		return true;
	}
	return false;
}