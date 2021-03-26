/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author NastyaBrilova
 */
package Main;

public class Contact extends Students
{
    protected String Address; 

    public Contact(String Address, int ID, String firstName, String lastName) 
    {
        super(ID, firstName, lastName);
        this.Address = Address;
    }
    
    public Contact( Students student )
    {
        super(student.getId(), student.getFirstName(), student.getLastName() );
    }
    
    public Contact(){};
    
    public String getAddress() 
    {
       return Address;
    }
    
    public void setAddress( String _address )
    {
        this.Address = _address;
    }

    @Override
    public String toString() 
    {
        return "Contact{" + "Id = " + Id + ", firstName=" + FirstName + ", lastName=" + LastName + ", address=" + Address + '}';
    }
    
}
