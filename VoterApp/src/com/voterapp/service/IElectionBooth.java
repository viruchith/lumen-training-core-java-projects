package com.voterapp.service;

import com.voterapp.exception.InvalidVoterException;
import com.voterapp.exception.UnderAgeException;

public interface IElectionBooth {
boolean checkEligibility(int age,String locality,int voterId) throws InvalidVoterException;
}
