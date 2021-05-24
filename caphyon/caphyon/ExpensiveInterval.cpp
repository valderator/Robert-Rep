#include "ExpensiveInterval.h"
#include<iostream>
using namespace std;

ExpensiveInterval::ExpensiveInterval() {
	price = 0;
}

ExpensiveInterval::ExpensiveInterval(TimeInterval expensiveInterval, int price) {
	this->expensiveInterval = expensiveInterval;
	this->price = price;
}

bool ExpensiveInterval::contains(Time time) {
	if (expensiveInterval.contains(time)) {
		return true;
	}
	return false;
}

void ExpensiveInterval::displayInterval() {
	expensiveInterval.displayInterval();
	cout << " having a price of " << price << " coins/hour.";
}

int ExpensiveInterval::incrementTaxBy15Min(int totalTax) {
	return totalTax + price / 4;
}