/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import lambda.List;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;
import sun.security.krb5.JavaxSecurityAuthKerberosAccess;




/**
 *
 * @author Eduardo
 */
public class Linq
{
    public static void main(String[] args)
    {
        List<Person> person = new List<Person>();
        person.add(new Person(null, 1, Gender.Male));
        person.add(new Person("Alejandra", 9, Gender.Female));
        person.add(new Person("Eduardo", 2, Gender.Male));
        person.add(new Person("Amira", 8, Gender.Female));
        person.add(new Person("Eduardo", 3, Gender.Male));
        person.add(new Person("Eduardo", 7, Gender.Male));
        person.add(new Person("Daniela", 4, Gender.Female));
        person.add(new Person("Roberto", 6, Gender.Male));
        person.add(new Person("Eduardo", 1, Gender.Male));
        person.add(new Person("Eduardo", 1, Gender.Male));
        person.add(new Person("Alejandra", 9, Gender.Female));
        person.add(new Person(null, 2, Gender.Male));
        person.add(new Person("Amira", 8, Gender.Female));
        person.add(new Person("Eduardo", 3, Gender.Male));
        person.add(new Person("Eduardo", 7, Gender.Male));
        person.add(new Person("Daniela", 4, Gender.Female));
        person.add(new Person("Roberto", 6, Gender.Male));
        person.add(new Person(null, 5, Gender.Male));

        
        
     
        person.OrderByAsc(p-> p.s).forEach(o-> 
        {
            System.out.println(o.s);
        });
        
        System.out.println("--------------");
        System.out.println("--------------");
        System.out.println("--------------");
        System.out.println("--------------");
        
        
        person.OrderByDesc(p-> p.s).forEach(o-> 
        {
            System.out.println(o.s);
        });
        
        System.out.println("--------------");
        System.out.println("--------------");
        System.out.println("--------------");
        System.out.println("--------------");
        
        
        person.Where(o-> o.gender == Gender.Female).OrderByAsc(o->o.s).forEach(o-> 
        {
            System.out.println(o.s);
        });
        
       Person p = person.FirstOrDefault(o-> o.s=="Eduardo");
       
       System.out.println("--------------");
       System.out.println("--------------");
       System.out.println("--------------");
       System.out.println("--------------");
       System.out.println("Take");
       
       person.Take(4).forEach(o-> 
        {
            System.out.println(o.s);
        });
       
       System.out.println("Take");
       System.out.println("--------------");
       System.out.println("--------------");
       System.out.println("--------------");
       System.out.println("--------------");
       
       System.out.println(p== null? "nulo":"bueno" );
       
       Object max = person.Max(o-> o.s);
       
       System.out.println("Max: "+max );
       
       Object min = person.Min(o-> o.s);
       
       System.out.println("Min: "+min );
       
       
    }
    
}
    
     

