package com.example.androidakademija.examples.classes;

import java.io.Serializable;

public class JavaClassesExamples {

    static class Person implements Serializable {
        private final String firstName;
        private final String lastName;
        private final String dateOfBirth;
        private final Long oib;

        public Person(String firstName, String lastName, String dateOfBirth, Long oib) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.dateOfBirth = dateOfBirth;
            this.oib = oib;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public String getDateOfBirth() {
            return dateOfBirth;
        }

        public Long getOib() {
            return oib;
        }
    }

    static class University {
        private final int id;
        private final String name;

        public University(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }
    }

    static class Student extends Person {
        private final Long jmbag;
        private final University university;

        public Student(String firstName, String lastName, String dateOfBirth, Long oib, Long jmbag, University university) {
            super(firstName, lastName, dateOfBirth, oib);
            this.jmbag = jmbag;
            this.university = university;
        }

        public University getUniversity() {
            return university;
        }

        public Long getJmbag() {
            return jmbag;
        }

        public String getDetails() {
            return getFirstName() + " " + getLastName() + ", " + getJmbag();
        }
    }

    public static void main(String[] args) {
        University fer = new University(123, "FER");
        Student studentA = new Student("Pero", "Peric", "12.04.1998.", 123456789123L, 1655238435L, fer);
        Student studentB = new Student("Ivana", "Horvat", "02.12.1999.", 987654987654L, 1564654335L, fer);
        System.out.println(studentA.getDetails());
        System.out.println(studentB.getDetails());
    }
}
