package org.deneb.tp2.ejercicio3.employee;
// Fig. 10.4: Employee.java
// Employee abstract superclass.

import java.time.LocalDate;

public abstract class Employee
{
   private String firstName;
   private String lastName;
   private String socialSecurityNumber;
   private LocalDate birthDate;
   static public float additional;

   public LocalDate getBirthDate() {
      return birthDate;
   }

   // three-argument constructor
   public Employee(String first, String last, String ssn)
   {
      firstName = first;
      lastName = last;
      socialSecurityNumber = ssn;
   } // end three-argument Employee constructor


   // five-argument constructor
   public Employee( String first, String last, String ssn, LocalDate cumple)
   {
      firstName = first;
      lastName = last;
      socialSecurityNumber = ssn;
      this.birthDate = cumple;
   } // end five-argument Employee constructor



   public double salary(LocalDate date) {
      if (date.getMonth() == birthDate.getMonth()) {
         return earnings() + additional;
      }
      return earnings();
   }
   // set first name
   public void setFirstName( String first )
   {
      firstName = first;
   } // end method setFirstName

   // return first name
   public String getFirstName()
   {
      return firstName;
   } // end method getFirstName

   // set last name
   public void setLastName( String last )
   {
      lastName = last;
   } // end method setLastName

   // return last name
   public String getLastName()
   {
      return lastName;
   } // end method getLastName

   // set social security number
   public void setSocialSecurityNumber( String ssn )
   {
      socialSecurityNumber = ssn; // should validate
   } // end method setSocialSecurityNumber

   // return social security number
   public String getSocialSecurityNumber()
   {
      return socialSecurityNumber;
   } // end method getSocialSecurityNumber

   // return String representation of Employee object
   public String toString()
   {
      return String.format( "%s %s\nsocial security number: %s", 
         getFirstName(), getLastName(), getSocialSecurityNumber() );
   } // end method toString

   // abstract method overridden by subclasses
   public abstract double earnings(); // no implementation here
} // end abstract class Employee


