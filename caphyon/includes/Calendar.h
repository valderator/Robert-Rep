#pragma once
#include"Time.h"
#include"Date.h"
#include"ExpensiveInterval.h"

class Calendar {
public:
	Calendar() {}
	Calendar(Date date, Time time);
	~Calendar();

	bool	isInTheFutureComparedTo(Calendar comparedCalendar);
	bool	isInThePastComparedTo(Calendar comparedCalendar);
	bool	momentsAreEqual(Calendar comparedCalendar);

	bool	dateIsInThePastComparedTo(Date compapredDate);
	bool	timeIsInThePastComparedTo(Time comparedTime);

	bool	dateIsInTheFutureComparedTo(Date comparedDate);
	bool	timeIsInTheFutureComparedTo(Time comparedTime);

	bool	datesAreEqual(Date comparedDate);
	bool	timesAreEqual(Time time);

	void	displayTimeAndDate();
	void	incrementTime(int minutes);
	bool	isTimeInInterval(ExpensiveInterval interval);

private:
	Time	time;
	Date	date;
};

