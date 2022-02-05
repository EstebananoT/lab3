package edu.eci.cvds.tdd.registry;

import java.util.ArrayList;

public class Registry {
    private ArrayList<Person> NeasValidos = new ArrayList<Person>();
    public RegisterResult registerVoter(Person p) {

        // TODO Validate person and return real result.
        if(p.isAlive()){

            if(p.getAge() < 0 || p.getAge() >= 140) {
                return RegisterResult.INVALID_AGE;
            }if (p.getAge() < 18) {
                return RegisterResult.UNDERAGE;
            }if(NeasValidos.isEmpty()){
                NeasValidos.add(p);
                return RegisterResult.VALID;
            }else{
                for(Person person : NeasValidos){
                    if(person.getId() == p.getId()){
                        return RegisterResult.DUPLICATED;
                    }
                }
                NeasValidos.add(p);
                return RegisterResult.VALID;
            }


        }else{
            return RegisterResult.DEAD;
        }

    }
}