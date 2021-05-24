#pragma once
#include <string>
using namespace std;

class Operation {
public:
	virtual			~Operation() {}
	virtual void	run() = 0;
	virtual string	getMessage() = 0;
	virtual bool	doContinue() = 0;
protected:
	string			message;
};