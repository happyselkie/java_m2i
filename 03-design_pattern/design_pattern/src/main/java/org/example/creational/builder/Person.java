package org.example.creational.builder;

public class Person {

    private String lastName;
    private String firstName;
    private int age;

    // Créer une personne peu importe les paramètres on peut utiliser le polymorphisme mais s'il y a trop de propriétés ça risque de vite devenir ingérable
    // Un builder permet de construire une personne dans l'ordre qu'on veut

    private Person(Builder builder){
        lastName = builder.lastName;
        firstName = builder.firstName;
        age = builder.age;
    }


    // Un builder est une classe dans la classe qu'on veut builder (on peut aussi la sortir en faisant une nouvelle classe PersonBuilder par exemple)
    public static class Builder{

        private String lastName;
        private String firstName;
        private int age;

        public Builder lastName(String lastName){
            this.lastName = lastName;
            return this;
        }

        public Builder firstName(String firstName){
            this.firstName = firstName;
            return this;
        }

        public Builder age(int age){
            this.age = age;
            return this;
        }

        public Person build(){
            return new Person(this);
        }
    }

    @Override
    public String toString() {
        return "Person{" +
                "lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", age=" + age +
                '}';
    }
}
