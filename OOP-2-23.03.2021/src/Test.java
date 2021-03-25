/**
 *
 * @author NastyaBrilova
 */
public class Test 
{
    public static void main(String[] args) 
    {
        Order order = new Order(1, "chicken", "Katya");
        order.setDateTime("5 march 2021");
        order.setType(Type.RUSHORDER);
        System.out.println(order);
    }
}
