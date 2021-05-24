#pragma once
#include"Calendar.h"
#include"Driver.h"

class Spot {
public:
	Spot();
	Spot(Calendar deadline, Driver driver);
	~Spot();
	bool	isAvailable();
	void	bookTheSpot(Calendar deadline, Driver driver);
	void	unBookTheSpot();

	Driver	getDriver();
	void	displaySpotDeadline();

	bool	isAboutToExpireComparedTo(Calendar currentTime, int minutes);
	bool	isDeadlineInThePastComparedTo(Calendar currentTime);
	bool	isDeadlineNow(Calendar currentTime);
	bool	sendExpirationNotification();

private:
	bool	 available;
	Calendar deadline;
	Driver	 driver;
};