package edu.eci.cvds.tdd.registry;

import org.junit.Assert;
import org.junit.Test;

public class RegistryTest {
    private Registry registry = new Registry();

    @Test
    public void validateValidAndUniquePerson() {
        Person person = new Person("John Sanchez", 123456, 30, Gender.MALE, true);
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.VALID, result);
    }

    @Test
    public void validateUnderagePerson() {
        Person person = new Person("Cristina Sanchez", 789012, 15, Gender.FEMALE, true);
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.UNDERAGE, result); // Cambiado de VALID a UNDERAGE
    }

    @Test
    public void validateDeadPerson() {
        Person person = new Person("Juan Sierra", 345678, 40, Gender.MALE, false);
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.DEAD, result); // Cambiado de VALID a DEAD
    }

    @Test
    public void validateDuplicateId() {
        Person person1 = new Person("Maria Perea", 456789, 25, Gender.FEMALE, true);
        registry.registerVoter(person1);
        // Intentar registrar la misma persona nuevamente
        Person person2 = new Person("Maria Perea", 456789, 25, Gender.FEMALE, true);
        RegisterResult result = registry.registerVoter(person2);
        Assert.assertEquals(RegisterResult.DUPLICATED, result);
    }

    @Test
    public void validateIncompletePersonData() {
        Person person = new Person(); // Crear una persona sin datos
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.INVALID, result);
    }
}
