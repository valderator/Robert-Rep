#pragma once
#include "Operation.h"

class ExceptionOperation : public Operation {
public:
	ExceptionOperation() {}
	void		run();
	string		getMessage();
	bool		doContinue();
};