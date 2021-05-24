#pragma once

class Date {
public:
	Date();
	Date(int day, int month, int year);
	~Date();

	bool	isInThePastComparedTo(Date comparedDate);
	bool	isInTheFutureComparedTo(Date comparedDate);
	bool	areDatesEqual(Date comparedDate);

	bool	isYearInTheFuture(int comparedYear);
	bool	isMonthInTheFuture(int comparedMonth);
	bool	isDayInTheFuture(int comparedDay);

	bool	isYearEqual(int comparedYear);
	bool	isMonthEqual(int comparedMonth);
	bool	isDayEqual(int comparedDay);

	bool	isYearInThePast(int comparedYear);
	bool	isMonthInThePast(int comparedMonth);
	bool	isDayInThePast(int comparedDay);

	void	displayDate();
	void	incrementTime(int days);

private:
	int		day;
	int		month;
	int		year;
};
