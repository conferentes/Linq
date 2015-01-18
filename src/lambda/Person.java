/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lambda;

/**
 *
 * @author Eduardo
 */
 public class Person
{
        public String s;
        
        public int i;
        
        public Gender gender = Gender.Male;
        
        public Person(String s, int i, Gender gender)
        {
            this.s = s;
            this.i=i;
            this.gender= gender;
        }
       
 
}
