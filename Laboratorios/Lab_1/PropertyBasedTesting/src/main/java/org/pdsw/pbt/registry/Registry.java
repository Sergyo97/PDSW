package org.pdsw.pbt.registry;

import java.util.Optional;

public class Registry {
    public RegisterResult registerVoter(Person p) {
    	if (p.getName().length() < 10 || p.getName().length() > 30) {
    		return RegisterResult.INVALID_NAME;
    	}else if (p.getAge() < 18) {
    		return RegisterResult.UNDERAGE;
    	}else if (p.getAge() > 110) {
    		return RegisterResult.OVERAGE;
    	}else if (p.isAlive() == false) {
    		return RegisterResult.DEAD;
    	}else {
    		return RegisterResult.VALID;
    	}
    }

    public Optional<String> generateCertificate(Person person) {

        return Optional.empty();
    }
}