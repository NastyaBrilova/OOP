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

public class Order extends Contact
{

    protected String Courier;
    public String DateTime;
    private OrderType type;    
    
    public Order(String Address, int ID, String firstName, String lastName, String Courier, String DateTime) 
    {
        super(Address, ID, firstName, lastName);
        this.Courier = Courier;
        this.DateTime = DateTime;
    }
    
    public Order(){};
    
    public Order ( Contact _contact )
    {
        super( _contact.getAddress(), _contact.getId(), _contact.getFirstName(), _contact.getLastName() );
    }
    
    public String getCourier() 
    {
        return  Courier;
    }

    public void setCourier(String courier) 
    {
        this.Courier = courier;
    }

    
    public String getDateTime() 
    {
        return DateTime;
    }

    public void setDateTime(String dateTime) 
    {
        this.DateTime = dateTime;
    }

    public OrderType getType() 
    {
        return type;
    }

    public void setType(OrderType type) 
    {
        this.type = type;    
    }

    @Override
    public String toString() 
    {
        return "Order{" + "Courier=" + Courier + ", DateTime=" + DateTime + '}';
    }

public enum OrderType
{
RUSHORDER,
REGULARORDER;
}
}