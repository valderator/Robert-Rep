#pragma once
#include"TimeInterval.h"

class ExpensiveInterval {
public:
	ExpensiveInterval();
	ExpensiveInterval(TimeInterval expensiveInterval, int price);
	bool	contains(Time time);
	void	displayInterval();
	int		incrementTaxBy15Min(int totalTax);

private:
	TimeInterval expensiveInterval;
	int			 price;
};

