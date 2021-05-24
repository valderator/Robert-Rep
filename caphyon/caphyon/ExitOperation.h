#pragma once
#include "Operation.h"

class ExitOperation : public Operation {
public:
	ExitOperation(string message);
	void		run();
	string		getMessage();
	bool		doContinue();
};