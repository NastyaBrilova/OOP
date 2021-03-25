/**
 *
 * @author NastyaBrilova
 */
public class Contact extends Students
{
    protected String Address; 

    public Contact(String Address, int ID, String firstName, String lastName) 
    {
        super(ID, firstName, lastName);
        this.Address = Address;
    }
    
    public String getAddress() 
    {
       return Address;
    }
    public void setAddress(String address) 
    {
       this.Address = address;
    }    
    
    @Override
    public String toString() 
    {
        return "Contact{" + "Id = " + Id + ", firstName = " + FirstName + ", lastName = " + LastName + ", address = " + Address + '}';
    }
}
