package org.pdsw.pbt.registry;

import org.junit.Test;
import org.pdsw.pbt.PBTClassifier;

import static org.quicktheories.QuickTheory.qt;

import java.util.Optional;

public class RegistryTest {

    @Test
    public void validateRegistryResult() {
    	Registry registry = new Registry();
    	PBTClassifier pbtClassifier = new PBTClassifier("validateRegistryResult");
    	
        qt()
            .forAll(PersonGenerator.persons())
            .check(voter ->  {
                RegisterResult result = registry.registerVoter(voter);
                
            	if (voter.getName().length() < 10 || voter.getName().length() > 30) {
            		pbtClassifier.collect("Invalid for vote");
            		return result == RegisterResult.INVALID_NAME;
            	}else if (voter.getAge() < 18) {
            		pbtClassifier.collect("Invalid for vote");
            		return result == RegisterResult.UNDERAGE;
            	}else if (voter.getAge() > 110) {
            		pbtClassifier.collect("Invalid for vote");
            		return result == RegisterResult.OVERAGE;
            	}else if (voter.isAlive() == false) {
            		pbtClassifier.collect("Invalid for vote");
            		return result == RegisterResult.DEAD;
            	}else {
            		pbtClassifier.collect("Valid for vote");
            		return result == RegisterResult.VALID;
            	}
            });
        pbtClassifier.results();
    }

	@Test
	public void validateCertificate() {
		Registry registry = new Registry();
		PBTClassifier pbtclassifier = new PBTClassifier("validateCertificate");
		
	        qt()
	            .forAll(PersonGenerator.persons())
	            .check(voter ->  {
	            	
	                RegisterResult result = registry.registerVoter(voter);
	                Optional<String> certificate = registry.generateCertificate(voter);
	            	
	                if (result == RegisterResult.VALID) {
	                	pbtclassifier.collect("Certificate valid");
	                	return certificate.isPresent() == true;
	                }else {
	                	pbtclassifier.collect("Certificate invalid");
	                	return certificate.isPresent() == false;
	                }
	            });
	        pbtclassifier.results();
    }
}