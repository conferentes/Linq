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
import java.util.function.Predicate;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

/**
 *
 * @author Eduardo
 */
public class List<T> extends ArrayList<T>
{
    
    
    public List<T> Where(Predicate<T> predicate)
    {   
        List<T> arr = new List<T>();
        arr.addAll(this.stream().filter( predicate ).collect(Collectors.<T>toList()));
        return arr;
    }
    
    public T FirstOrDefault(Predicate<T> predicate)
    {
        if(this.size()==0) return null;
        java.util.List<T> list =this.stream().filter( predicate ).collect(Collectors.<T>toList());
        if(list.size()==0) return null;
        return list.stream().findFirst().get();
    }
    
    public double Sum(ToDoubleFunction<T> funct)
    {
        if(this.size()==0)return 0;
       return this.stream().mapToDouble(funct).sum();
    }
    
    public int Sum(ToIntFunction<T> funct)
    {
        if(this.size()==0)return 0;
       return this.stream().mapToInt(funct).sum();
    }
    
    public List<T> OrderByDesc(Functional<T> func)
    {
        return OrderBy(func, false);
    }

    public List<T> OrderByAsc(Functional<T> func)
    {
        return OrderBy(func, true);
    }
    
    private List<T> OrderBy(Functional<T> func, boolean Ascending)
    {
        T arr[] = null ;
        arr = (T[])this.toArray();
        if(arr.length==0)return null;
        //if((Comparable<Object>)func.ComparableObject(arr[0])==null)return null;
        
        MyQuickSort m = new MyQuickSort();
        m.sort(arr, func,Ascending);
        List<T> list = new List<T>();
        list.addAll(Arrays.asList(arr));
        return list;
    }

    public Object Max(Functional<T> func)
    {
        Comparable<Object> Aux =(Comparable) func.ComparableObject(this.get(0));
        for(T p : this)
        {
            Comparable<Object> o =(Comparable) func.ComparableObject(p);
            if(Compare(Aux, o) < 0 )
            Aux = o;
        }
        return Aux;
    }
    
    public Object Min(Functional<T> func)
    {
        Comparable<Object> Aux =(Comparable) func.ComparableObject(this.get(0));
        for(T p : this)
        {
            Comparable<Object> o =(Comparable) func.ComparableObject(p);
            if(Compare(Aux, o) > 0 )
            Aux = o;
        }
        return Aux;
    }
    
    public boolean All(Predicate<T> predicate)
    {
        return this.stream().allMatch(predicate);
    }
    
    public boolean Any(Predicate<T> predicate)
    {
        
        return this.stream().anyMatch(predicate);
    }
    
    public List<T> Take(int value)
    {
        List<T> arr = new List<T>();
        arr.addAll(this.stream().limit(value).collect(Collectors.<T>toList()));
        return arr;
    }
    
    public List<T> Skip(int value)
    {
        
        List<T> arr = new List<T>();
        arr.addAll(this.stream().skip(value).collect(Collectors.<T>toList()));
        return arr;
    }
    
    private int Compare(Comparable<Object> o1,Comparable<Object> o2)
    {
        if (o1 == null)
        {
            return (o2 == null) ? 0 : -1;
        }
        if (o2 == null) 
        {
            return 1;
        }
        
        return o1.compareTo(o2);
    }

    
}
