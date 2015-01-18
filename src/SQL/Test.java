/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SQL;


import java.util.List;


/**
 *
 * @author Eduardo
 */
public class Test 
{
    public static void main(String[] args) {
        try 
        {
            List<Categoria> lista = SqlHelper.List("select * from categoria", Categoria.class, null);
            Categoria c = SqlHelper.Find("select * from categoria where Descripcion = ?", Categoria.class, "Computo");
            for(Categoria cat : lista)
            {
                System.out.println(cat.getId()+"...."+cat.getDescripcion());
            }
            System.out.println(c.getId()+"...."+c.getDescripcion());
        } 
        catch (Exception ex) 
        {
            System.out.println(ex.getMessage());
        }
            
    }
}
