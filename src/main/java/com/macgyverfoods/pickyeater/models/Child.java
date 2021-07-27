package com.macgyverfoods.pickyeater.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.*;

@Entity
public class Child {

    @Id
    @GeneratedValue
    private Long id;

    private String firstName;
    private String lastName;
    private String age;

    @ManyToMany
    private Set<Preference> preferences;

    @ManyToMany
    private Collection<Allergy> allergies;

    @ManyToOne
    private Parent parent;

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAge() {
        return age;
    }

    public Parent getParent() {
        return parent;
    }

    public Collection<Allergy> getAllergies() {
        return allergies;
    }

    public Collection<Preference> getPreferences() {
        return preferences;
    }

    public void addPreference(Preference preferenceToAdd) {
        preferences.add(preferenceToAdd);
    }

    public void removePreference(Preference preferenceToRemove) {
        preferences.remove(preferenceToRemove);
    }

    public Child(String firstName, String lastName, String age, Allergy...allergies) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.allergies = new ArrayList<>(Arrays.asList(allergies));
        this.preferences = new HashSet<>();
    }

    public Child() {}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Child child = (Child) o;
        return Objects.equals(id, child.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
