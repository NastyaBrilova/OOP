/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author NastyaBrilova
 */
public class Contact 
{
    public int Id;
    private String FirstName;
    private String LastName;
    private String Address;
    
    public String getFirstName() 
   {
       return FirstName;
   }
    
    public void setFirstName(String firstName) 
   {
       this.FirstName = firstName;
   }

    public String getLastName() 
   {
       return LastName;
   }
    public void setLastName(String lastName) 
   {
       this.LastName = lastName;
   }

    public String getAddress() 
   {
       return Address;
   }
    
    public void setAddress(String address) 
   {
       this.Address = address;
   }

    public Contact(String firstName, String lastName, String address)
   { 
    FirstName = firstName;
    LastName = lastName;
    Address = address;
   } 

    @Override
    public String toString() 
    {
        return "Contact{" + "Id = " + Id + ", firstName = " + FirstName + ", lastName = " + LastName + ", address = " + Address + '}';
    }
}
