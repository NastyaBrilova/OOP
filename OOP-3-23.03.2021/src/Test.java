/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author NastyaBrilova
 */
public class Test 
{
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        Students student = new Students (1, "Emelenko", "Katya", 19, "Designer");
        student.discipline = "OOP";
        student.mark = 5;
        student.NameTeacher = "Sergey Vasilenko";
        System.out.println(student);
    }
}
