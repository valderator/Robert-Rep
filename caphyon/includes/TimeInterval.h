#pragma once
#include"Time.h"

class TimeInterval {
public:
	TimeInterval() {}
	TimeInterval(Time lowerInterval, Time upperInterval);
	bool	contains(Time currentTime);
	void	swapIntervals();
	bool	areIntervalsWrong();
	void	displayInterval();

private:
	Time	lowerInterval;
	Time	upperInterval;
};

