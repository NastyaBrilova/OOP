package Test;
import java.util.*;
import java.io.IOException;
import java.io.*;
import Main.Students;
import Main.Contact;
import Main.Order;
import Main.Delivery;
public class Test 
{
    static Scanner scanner = new Scanner(System.in, "windows-1251");
    public static void menuPrint() 
    {
        System.out.println("*^*^*^*^*^*^*^*^*^*^*^*^*^*МЕНЮ*^*^*^*^*^*^*^*^*^*^*^*^*^*");
        System.out.println("1 - > Заповнити анкету студента (запис анкети у файл)");
        System.out.println("2 - > Вивести записані анкети студентів на екран");
        System.out.println("3 - > Вивести дані з файлу на екран. Введіть ім'я файла: ");
        System.out.println("4 - > Сортувати дані ");
        System.out.println("5 - > Вийти з програми");
        System.out.println(" ");
        System.out.println("Введіть потрібний вам пункт, щоб виконати команду:");
    }
    public static void printList(ArrayList<?> list)
    {
        for (int i = 0; i < list.size(); i++) 
        {
             System.out.println( list.get(i) );
             System.out.println( "^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^" );
        }
    }
    public static void sortCollections( )
    {
        System.out.println(" ");
        System.out.println("Варіанти сортування ");
        System.out.println("1 - > По імені кур'єра в зворотному порядку заповнення");
        System.out.println("2 - > По імені студента за алфавітом ");
        System.out.println("3 - > По адресі");
        System.out.println(" ");
        System.out.print("Оберіть бажаний варіант сортування: " );
        int _sortOption = Integer.parseInt(scanner.nextLine());
        System.out.println(" ");
        switch  ( _sortOption )
        {
            case 1 -> {
                OrderList.sort( Comparator.comparing( Order::getCourier).reversed() );
                System.out.println("Після сортування: " ); 
                System.out.println( "^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^" );
                printList( OrderList );
            }
            case 2 -> {
                StudentsList.sort( Comparator.comparing( Students::getFirstName ) );
                System.out.println("Після сортуваня: " ); 
                System.out.println( "^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^" );
                printList( StudentsList );
            }
            case 3 -> { 
                ContactList.sort( Comparator.comparing( Contact::getAddress ) );
                System.out.println("Після сортування: " ); 
                System.out.println( "^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^" );
                printList( ContactList );
            }
            default -> System.out.println("За таким номером немвє сортування!");   
        }
    }
    public static void menuChoice(int numMenu) 
    {
        switch (numMenu) 
        {
            case 1 -> {
                Input(); SetInFile();
            }
            case 2 -> Output(); 
            case 3 -> GetFromFile( scanner.nextLine() );
            case 4 -> {
                if ( OrderList.isEmpty() || ContactList.isEmpty() || StudentsList.isEmpty() )
                    System.out.println("Заповніть для початку дані!"); 
                else
                    sortCollections( );
            }
            case 5 -> {
            	SetInFile();
            	System.exit(0);
            }
            default -> System.out.println("Даний пункт не існує!");
        }
    }
     static Students student = new Students();
     static Contact contact = new Contact();
     static Order order = new Order();
     static Delivery delivery = new Delivery();
     static ArrayList<Students> StudentsList = new ArrayList<Students>();
     static ArrayList<Contact> ContactList = new ArrayList<Contact>();
     static ArrayList<Order> OrderList = new ArrayList<Order>();
    public static void Input()
    {
        System.out.println( " " );
        System.out.println( "Введіть дані студента: ID, Ім'я, Фамілію: " );
        student = new Students( Integer.parseInt( scanner.nextLine() ), scanner.nextLine(), scanner.nextLine());
        StudentsList.add(0, student);
        System.out.println( "Дані студента записані ♥" );
        System.out.println( " " );
        System.out.println( "Введіть адресу студента:" );
        contact = new Contact( student, scanner.nextLine() );
        ContactList.add(0, contact);
        System.out.println( "Дана адреса записана ♥" );
        System.out.println( " " );
        System.out.println( "Введіть ім'я кур'єра та дату доставки:" );
        order = new Order( contact, scanner.nextLine(), scanner.nextLine() );
        OrderList.add(0, order);
        System.out.println( "Дані про кур'єра та дату записано ♥" );
        delivery = new Delivery ( order, 1 );  
        System.out.println( " " );
        }
    public static void Output()
    {  
        if (OrderList.isEmpty() )
            System.out.println("Заполните данные для начала!");
            System.out.println( " " );
        for (int i = 0; i < OrderList.size(); i++) 
        {
            System.out.println( " " );
            System.out.println( "^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^" );
            System.out.println(StudentsList.get(i));
            System.out.println(ContactList.get(i));
            System.out.println(OrderList.get(i));
            System.out.println( "^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^" );
            System.out.println( " " );
        }
    }
    public static void main(String[] args) 
    {
        while (true) 
        {
        	menuPrint();
            menuChoice(Integer.parseInt(scanner.nextLine()));
        }
    }
    public static void SetInFile() 
    {
    try (FileWriter writer = new FileWriter("output.txt", true))
    {
            writer.append("\n");
            writer.write( Integer.toString(student.getId() ) );
            writer.append("\n");
            writer.write(student.getFirstName());
            writer.append("\n");
            writer.write(student.getLastName());
            writer.append("\n");
            writer.write(order.getCourier());
            writer.append("\n");
            writer.write(contact.getAddress());
            writer.append("\n");
            writer.write(order.getDateTime());
            writer.append("\n");
    }  
        catch (IOException ex)
        {
        System.out.println("Помилка" + ex);
        }     
    }
    public static void GetFromFile( String _pathToFile )
    {
        try 
        {
            File myObj = new File(_pathToFile);
            try (Scanner myReader = new Scanner(myObj)) 
            {
                System.out.println( " " );
                System.out.println("Дані з файлу ♥");
                System.out.println( " " );
                while (myReader.hasNextLine()) 
                {
                	String line = myReader.nextLine();
                	if (line.isEmpty())
                		continue;
                    System.out.println("ID студента: " + Integer.parseInt( line ) );
                    System.out.println("Ім'я студента: " + myReader.nextLine() );
                    System.out.println("Фамілія студента: " + myReader.nextLine() );
                    System.out.println("Адреса студента: " + myReader.nextLine() );
                    System.out.println("Ім'я кур'єра: " + myReader.nextLine() );
                    System.out.println("Дата доставки: " + myReader.nextLine() );
                    System.out.println( " " );
                }
            }
        } 
        catch (FileNotFoundException e) 
        {
        System.out.println("Сталася помилка!!!");
        e.printStackTrace();
        }
    }
}
