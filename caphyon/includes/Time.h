#pragma once

class Time {
public:
	Time();
	Time(int hour, int minute);
	~Time();

	bool	isLaterThan(Time comparedTime);
	bool	isEarlierThan(Time comparedTime);
	bool	isTimeEqual(Time comparedTime);

	bool	hourIsGreaterThan(int comparedHour);
	bool	minuteIsGreaterThan(int comparedMinute);

	bool	hourIsLesserThan(int comparedHour);
	bool	minuteIsLesserThan(int comparedMinute);

	bool	hourIsEqual(int comparedHour);
	bool	minuteIsEqual(int comparedMinute);

	void	displayTime();
	int		incrementTime(int minutes);

private:
	int		hour;
	int		minute;
};