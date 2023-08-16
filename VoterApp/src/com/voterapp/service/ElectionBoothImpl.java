package com.voterapp.service;

import com.voterapp.exception.InvalidVoterException;
import com.voterapp.exception.LocalityNotFoundException;
import com.voterapp.exception.NoVoterIDException;
import com.voterapp.exception.UnderAgeException;

public class ElectionBoothImpl implements IElectionBooth {
	String[]localities= {"Coimbatore","Bangalore","ooty"};
	@Override
	public boolean checkEligibility(int age, String locality, int voterId) throws InvalidVoterException {
		try{
			if(checkAge(age) && checkLocality(locality) && checkVoterId(voterId)) {
			return true;
		}
	}catch(UnderAgeException |LocalityNotFoundException |NoVoterIDException e1){
		System.out.println(e1.getMessage());
	}
	return false;
	}
	
	private boolean checkAge(int age) throws UnderAgeException{
		if(age>=18) {
			return true;
		}
		throw new UnderAgeException("Voter age should be greater than or equal to 18");
	}
	private boolean checkLocality(String locality) throws LocalityNotFoundException{
		for(String cities:localities) {
			if(cities.equals(locality)) {
				return true;
			}
		}
		throw new LocalityNotFoundException(" Your Locality is not found in the given cities");
	}
	private boolean checkVoterId(int voterId) throws NoVoterIDException {
		if(voterId>=1000 && voterId<10000) {
			return true;
		}
		throw new NoVoterIDException("Voter Id not found");
	}
	


}
