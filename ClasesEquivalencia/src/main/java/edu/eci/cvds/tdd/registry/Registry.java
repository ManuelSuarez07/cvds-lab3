package edu.eci.cvds.tdd.registry;

import java.util.HashMap;

public class Registry {
    private HashMap<Integer, Person> registeredVoters;

    public Registry() {
        registeredVoters = new HashMap<>();
    }

    /**
     * Registra a un votante en el sistema.
     *
     * @param p la persona a registrar.
     * @return el resultado del registro.
     */
    public RegisterResult registerVoter(Person p) {
        if (p == null) {
            return RegisterResult.INVALID;
        }

        if (registeredVoters.containsKey(p.getId())) {
            return RegisterResult.DUPLICATED;
        }

        if (p.getAge() < 18 || !p.isAlive() || p.getName() == null || p.getName().isEmpty()) {
            return RegisterResult.INVALID;
        }

        registeredVoters.put(p.getId(), p);
        return RegisterResult.VALID;
    }
}
