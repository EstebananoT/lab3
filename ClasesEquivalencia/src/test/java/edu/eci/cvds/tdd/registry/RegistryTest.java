package edu.eci.cvds.tdd.registry;

import org.junit.Assert;
import org.junit.Test;

public class RegistryTest {

    private Registry registry = new Registry();

    @Test
    public void validateRegistryResult() {

        Person person = new Person("ElMaquinon",0000000000,18,Gender.MALE,true);

        RegisterResult result = registry.registerVoter(person);

        Assert.assertEquals(RegisterResult.VALID, result);
    }

    // TODO Complete with more test cases
    @Test
    public void validateUnderAge(){
        Person person = new Person("PepitoPerez",1111111111,15,Gender.MALE,true);

        RegisterResult result = registry.registerVoter(person);

        Assert.assertEquals(RegisterResult.UNDERAGE, result);

    }

    @Test
    public void validateInvalidAge(){
        Person person = new Person("Hermeregildo",222222222,-1,Gender.MALE,true);

        RegisterResult result = registry.registerVoter(person);

        Assert.assertEquals(RegisterResult.INVALID_AGE, result);

    }

    @Test
    public void validateIsDead(){
        Person person = new Person("Santiago Bayona",333333333,-1,Gender.MALE,false);

        RegisterResult result = registry.registerVoter(person);

        Assert.assertEquals(RegisterResult.DEAD, result);

    }

    @Test
    public void validateIsDuplicate(){
        Person person1 = new Person("Santiago Bayona",333333333,19,Gender.MALE,true);
        Person person2 = new Person("Juankis Acosta",333333333,25,Gender.MALE,true);
        RegisterResult result1 = registry.registerVoter(person1);
        RegisterResult result2 = registry.registerVoter(person2);

        Assert.assertEquals(RegisterResult.DUPLICATED, result2);

    }

}