/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SQL;

import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SqlHelper 
{
    
    static String bd = "zerdax";
    static String login = "root";
    static String password = "x7654321";
    static String url = "jdbc:mysql://localhost/"+bd+"?connectTimeout=5000";

    private static Connection cn=null;
    
    private static Connection Conexion() throws ClassNotFoundException, SQLException
    {
        if(cn!= null && !cn.isClosed()) return cn;
        
        Class.forName("org.gjt.mm.mysql.Driver");
        cn = DriverManager.getConnection(url,login,password);
        return cn;
    }
    
    private static PreparedStatement Commando(String Query) throws ClassNotFoundException, SQLException
    {
         PreparedStatement st = null;
         st = Conexion().prepareStatement(Query);
        return st;
    }
    
    public static int ExecuteNonQuery(String query,Object... parametros)throws ClassNotFoundException, SQLException
    {
        
            PreparedStatement st = Commando(query);
            int i = 1;
            for (Object parameter : parametros) 
            {
                st.setObject(i,parameter);
                i++;
            }
            return st.executeUpdate();
        
        
    }
    
    private static ResultSet ExecuteQuery(String query,Object... parametros)throws ClassNotFoundException, SQLException
    {
        ResultSet rs=null;
        PreparedStatement st = Commando(query);
        int i = 1;
        if(parametros != null)
        {
            for (Object parameter : parametros) 
            {
                st.setObject(i,parameter);
                i++;
            }
        }
        rs= st.executeQuery();
        return rs;
    }
    
    public static<T> List<T> List(String query,Class<T> t,Object... parametros) throws IntrospectionException, ClassNotFoundException, SQLException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException, InstantiationException
    {
        List<T> lista = new ArrayList<>();
        ResultSet rs = ExecuteQuery(query,parametros);
        
        List<String> PropNames = GetPropNames(t);
        
        
        while(rs.next())
        {
            T obj = ToObject(rs, t,PropNames);
            lista.add(obj);
        }
        rs.close();
        return lista;
    }

    public static<T> T Find(String query,Class<T> t,Object... parametros) throws ClassNotFoundException, SQLException, IntrospectionException, InstantiationException, NoSuchFieldException, IllegalAccessException
    {
        ResultSet rs = ExecuteQuery(query,parametros);
        if(rs.next())
        {
            return ToObject(rs, t);
           
        }
        rs.close();
        return null;
    }
    
    private static<T> T ToObject(ResultSet rs, Class<T> t ) throws IntrospectionException, InstantiationException, NoSuchFieldException, IllegalAccessException, SQLException
    {   
        T obj = t.newInstance();    
        for(String name : GetPropNames(t))
        {
            Field prop = t.getDeclaredField(name);
            prop.setAccessible(true);
            prop.set(obj, rs.getObject(name)); 
        }
        return obj;
    }
    
    private static<T> T ToObject(ResultSet rs, Class<T> t,List<String> PropNames ) throws IntrospectionException, InstantiationException, NoSuchFieldException, IllegalAccessException, SQLException
    {   
        T obj = t.newInstance();    
        for(String name : PropNames)
        {
            Field prop = t.getDeclaredField(name);
            prop.setAccessible(true);
            prop.set(obj, rs.getObject(name)); 
        }
        return obj;
    }
    
    private static<T> List<String> GetPropNames(Class<T> t) throws IntrospectionException
    {
        PropertyDescriptor[] propertyDescriptors =  Introspector.getBeanInfo(t).getPropertyDescriptors();
        List<String> propertyNames = new ArrayList<>();
        
        for (PropertyDescriptor propertyDescriptor : propertyDescriptors)
        {
            if(propertyDescriptor.getName().equals("class"))continue;
            propertyNames.add(propertyDescriptor.getName());
        }
        return propertyNames;
    }
}
