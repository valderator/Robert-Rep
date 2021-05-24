#include "Date.h"
#include <iostream>
using namespace std;

Date::Date() {
	day = -1;
	month = -1;
	year = -1;
}

Date::Date(int day, int month, int year) {
	this->day = day;
	this->month = month;
	this->year = year;
}

Date::~Date() {
	day = -1;
	month = -1;
	year = -1;
}

bool Date::isInThePastComparedTo(Date comparedDate) {
	if (comparedDate.isYearInTheFuture(year)) {
		return true;
	}

	if (comparedDate.isYearEqual(year)) {
		if (comparedDate.isMonthInTheFuture(month)) {
			return true;
		}
	}

	if (comparedDate.isMonthEqual(month)) {
		if (comparedDate.isDayInTheFuture(day)) {
			return true;
		}
	}

	return false;
}

bool Date::isInTheFutureComparedTo(Date comparedDate) {
	if (comparedDate.isYearInThePast(year)) {
		return true;
	}

	if (comparedDate.isYearEqual(year)) {
		if (comparedDate.isMonthInThePast(month)) {
			return true;
		}
	}

	if (comparedDate.isMonthEqual(month)) {
		if (comparedDate.isDayInThePast(day)) {
			return true;
		}
	}

	return false;
}

bool Date::areDatesEqual(Date comparedDate)
{
	if (comparedDate.isYearEqual(year)) {
		if (comparedDate.isMonthEqual(month)) {
			if (comparedDate.isDayEqual(day)) {
				return true;
			}
		}
	}
	return false;
}

bool Date::isYearInTheFuture(int comparedYear) {
	if (year > comparedYear) {
		return true;
	}
	return false;
}

bool Date::isMonthInTheFuture(int comparedMonth) {
	if (month > comparedMonth) {
		return true;
	}
	return false;
}

bool Date::isDayInTheFuture(int comparedDay) {
	if (day > comparedDay) {
		return true;
	}
	return false;
}


bool Date::isYearInThePast(int comparedYear) {
	if (year < comparedYear) {
		return true;
	}
	return false;
}

bool Date::isMonthInThePast(int comparedMonth) {
	if (month < comparedMonth) {
		return true;
	}
	return false;
}

bool Date::isDayInThePast(int comparedDay) {
	if (day < comparedDay) {
		return true;
	}
	return false;
}

bool Date::isYearEqual(int comparedYear) {
	if (year == comparedYear) {
		return true;
	}
	return false;
}

bool Date::isMonthEqual(int comparedMonth) {
	if (month == comparedMonth) {
		return true;
	}
	return false;
}

bool Date::isDayEqual(int comparedDay) {
	if (day == comparedDay) {
		return true;
	}
	return false;
}

void Date::displayDate() {
	if (day < 10) {
		cout << " 0" << day << ".";
	}
	else {
		cout << " "<< day << ".";
	}

	if (month < 10) {
		cout << "0" << month << ".";
	}
	else {
		cout << month << ".";
	}
	cout << year << " ";
}

void Date::incrementTime(int days) {
	day = day + days;

	while (day > 31) {
		day = day - 31;
		month++;
	}

	while (month > 12) {
		month = month - 12;
		year++;
	}

}