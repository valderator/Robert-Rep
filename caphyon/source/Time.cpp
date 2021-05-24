#include"../includes/Time.h"
#include<iostream>
using namespace std;

Time::Time() {
	hour = -1;
	minute = -1;
}

Time::Time(int hour, int minute) {
	this->hour = hour;
	this->minute = minute;
}

Time::~Time() {
	hour = -1;
	minute = -1;
}

bool Time::isLaterThan(Time comparedTime) {

	if (comparedTime.hourIsLesserThan(hour)) {
		return true;
	}

	if (comparedTime.hourIsEqual(hour)) {
		if (comparedTime.minuteIsLesserThan(minute)) {
			return true;
		}
	}

	return false;
}

bool Time::isEarlierThan(Time comparedTime) {

	if (comparedTime.hourIsGreaterThan(hour)) {
		return true;
	}

	if (comparedTime.hourIsEqual(hour)) {
		if (comparedTime.minuteIsGreaterThan(minute)) {
			return true;
		}
	}

	return false;
}

bool Time::isTimeEqual(Time comparedTime) {
	if (comparedTime.hourIsEqual(hour)) {
		if (comparedTime.minuteIsEqual(minute)) {
			return true;
		}
	}
	return false;
}

bool Time::hourIsGreaterThan(int comparedHour) {
	if (hour > comparedHour) {
		return true;
	}
	return false;
}

bool Time::minuteIsGreaterThan(int comparedMinute) {
	if (minute > comparedMinute) {
		return true;
	}
	return false;
}

bool Time::hourIsLesserThan(int comparedHour) {
	if (hour < comparedHour) {
		return true;
	}
	return false;
}

bool Time::minuteIsLesserThan(int comparedMinute) {
	if (minute < comparedMinute) {
		return true;
	}
	return false;
}

bool Time::hourIsEqual(int comparedHour) {
	if (hour == comparedHour) {
		return true;
	}
	return false;
}

bool Time::minuteIsEqual(int comparedMinute) {
	if (minute == comparedMinute) {
		return true;
	}
	return false;
}

void Time::displayTime() {
	if (hour < 10) {
		cout << "0" << hour << ":";
	}
	else {
		cout << hour << ":";
	}

	if (minute < 10) {
		cout << "0" << minute;
	}
	else {
		cout << minute;
	}
}

int Time::incrementTime(int minutes) {

	int daysToPass = 0;

	minute = minute + minutes % 60;

	if (minute > 59) {
		minute = minute - 60;
		hour++;
	}

	hour = hour + minutes / 60;

	while (hour > 23) {
		hour = hour - 24;
		daysToPass++;
	}

	return daysToPass;
}