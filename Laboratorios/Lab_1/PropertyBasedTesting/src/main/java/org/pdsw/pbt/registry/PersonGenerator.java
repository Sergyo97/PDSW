package org.pdsw.pbt.registry;

import org.quicktheories.core.*;
import org.quicktheories.generators.*;

import static org.quicktheories.generators.SourceDSL.*;

public class PersonGenerator {
	
	public static Gen<Person> persons() {
		return ids().zip(name(), age(), genders(), living(), (id, name ,age, gender, alive) 
				-> new Person(name, id, age, gender, alive));
	}
	
	public static Gen<String> name(){
		return strings().basicLatinAlphabet().ofLengthBetween(10, 30);	
	}
	
	public static Gen<Integer> ids(){
		return integers().allPositive();
	}
	
	public static Gen<Integer> age(){
		return integers().from(0).upToAndIncluding(110);
	}
	
	private static Gen<Gender> genders(){
		return Generate.enumValues(Gender.class);
	}
	
	private static Gen<Boolean> living(){
		return booleans().all();
	} 
	
	
}
