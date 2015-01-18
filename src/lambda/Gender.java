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
public enum Gender 
{
    Male(1),
    Female(2);
    
    private final int value;

    private Gender(int value) {
        this.value = value;
    }
    
    static Gender fromValue(int value) 
    {  
        for (Gender my: Gender.values())
        {  
            if (my.value == value) 
            {  
                return my;  
            }  
        }
        return null;  
    } 
}
