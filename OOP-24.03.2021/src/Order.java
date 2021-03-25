/**
 *
 * @author NastyaBrilova
 */
public class Order extends Contact
{
    protected String Courier;
    public String DateTime;
    private Type type;    
    
    public Order(String Address, int ID, String firstName, String lastName, String Courier, String DateTime) 
    {
        super(Address, ID, firstName, lastName);
        this.Courier = Courier;
        this.DateTime = DateTime;
    }

    Order(int ID, String Address, String firstName, String lastName, String Courier, String DateTime)
    {
        super(Address, ID, firstName, lastName);
        this.Courier = Courier; 
        this.DateTime = DateTime;
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

    public Type getType() 
    {
        return type;
    }

    public void setType(Type type) 
    {
        this.type = type;
    }

    @Override
    public String toString() 
    {
        return super.toString() + " DateTime = " + DateTime + ", Courier = " + Courier ;
    }
    
public enum Type
{
RUSHORDER,
REGULARORDER;
}
}

