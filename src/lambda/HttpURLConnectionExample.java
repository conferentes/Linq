/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lambda;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DateFormat;
import java.util.Date;


 
import javax.net.ssl.HttpsURLConnection;


 
public class HttpURLConnectionExample {
 
	private final String USER_AGENT = "Mozilla/5.0";
 
	public static void main(String[] args) throws Exception {
 
		HttpURLConnectionExample http = new HttpURLConnectionExample();
 
		System.out.println("Testing 1 - Send Http GET request");
                //http.sendGet();
                
                
                
                
                
                
                
                GsonBuilder builder = new GsonBuilder(); 
                
                // Register an adapter to manage the date types as long values 
                builder.registerTypeAdapter(Date.class, new JsonDateDeserializer() );

                Gson gson = builder.create();

                
                
                
                
                
		//System.out.println("\nTesting 2 - Send Http POST request");
		//http.sendPost();
 
	}
 
	// HTTP GET request
	private String sendGet() throws Exception 
        {
            String url = "http://localhost:41184/OrdenDeTrabajo/GetEquipo?";
 
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
 
            // optional default is GET
            con.setRequestMethod("GET");
            con.setDoOutput(true);
            //add request header
            con.setRequestProperty("User-Agent", USER_AGENT);
                
            OutputStream os =  con.getOutputStream();
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os,"UTF-8"));
            
            writer.write("Codigo=AW01");
            writer.flush();
            writer.close();
            
            os.close();
 
            int responseCode = con.getResponseCode();
            System.out.println("\nSending 'GET' request to URL : " + url);
            System.out.println("Response Code : " + responseCode);
 
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
 
            while ((inputLine = in.readLine()) != null) 
            {
            	response.append(inputLine);
            }
            in.close();
 
            //print result
            System.out.println(response.toString());
            return response.toString();
 
	}
 
	// HTTP POST request
	private void sendPost() throws Exception {
 
		String url = "https://selfsolve.apple.com/wcResults.do";
		URL obj = new URL(url);
		HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();
 
		//add reuqest header
		con.setRequestMethod("POST");
		con.setRequestProperty("User-Agent", USER_AGENT);
		con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
 
		String urlParameters = "sn=C02G8416DRJM&cn=&locale=&caller=&num=12345";
 
		// Send post request
		con.setDoOutput(true);
		DataOutputStream wr = new DataOutputStream(con.getOutputStream());
		wr.writeBytes(urlParameters);
		wr.flush();
		wr.close();
 
		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'POST' request to URL : " + url);
		System.out.println("Post parameters : " + urlParameters);
		System.out.println("Response Code : " + responseCode);
 
		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();
 
		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
 
		//print result
		System.out.println(response.toString());
 
	}
    private class Equipo extends Dbe
    {
        private String Codigo;
       
        private String NumeroDeSerie;
        
        private Dbe EquipoTipo;

        private String Modelo;

        private Dbe Marca;

        private Dbe Localizacion;
        
        public String getCodigo() {
            return Codigo;
        }

        public void setCodigo(String Codigo) {
            this.Codigo = Codigo;
        }

        /**
         * @return the NumeroDeSerie
         */
        public String getNumeroDeSerie() {
            return NumeroDeSerie;
        }

        /**
         * @param NumeroDeSerie the NumeroDeSerie to set
         */
        public void setNumeroDeSerie(String NumeroDeSerie) {
            this.NumeroDeSerie = NumeroDeSerie;
        }

        /**
         * @return the EquipoTipo
         */
        public Dbe getEquipoTipo() {
            return EquipoTipo;
        }

        /**
         * @param EquipoTipo the EquipoTipo to set
         */
        public void setEquipoTipo(Dbe EquipoTipo) {
            this.EquipoTipo = EquipoTipo;
        }

        /**
         * @return the Modelo
         */
        public String getModelo() {
            return Modelo;
        }

        /**
         * @param Modelo the Modelo to set
         */
        public void setModelo(String Modelo) {
            this.Modelo = Modelo;
        }

        /**
         * @return the Marca
         */
        public Dbe getMarca() {
            return Marca;
        }

        /**
         * @param Marca the Marca to set
         */
        public void setMarca(Dbe Marca) {
            this.Marca = Marca;
        }

        /**
         * @return the Localizacion
         */
        public Dbe getLocalizacion() {
            return Localizacion;
        }

        /**
         * @param Localizacion the Localizacion to set
         */
        public void setLocalizacion(Dbe Localizacion) {
            this.Localizacion = Localizacion;
        }
    }
    
    private class Dbe
    {
        private int Id;

        private String Descripcion;

        private Date FechaRegistro;

        private int IdUsuario;

        private boolean Activo;

        /**
         * @return the Id
         */
        public int getId() {
            return Id;
        }

        /**
         * @param Id the Id to set
         */
        public void setId(int Id) {
            this.Id = Id;
        }

        /**
         * @return the Descripcion
         */
        public String getDescripcion() {
            return Descripcion;
        }

        /**
         * @param Descripcion the Descripcion to set
         */
        public void setDescripcion(String Descripcion) {
            this.Descripcion = Descripcion;
        }

        /**
         * @return the FechaRegistro
         */
        public Date getFechaRegistro() {
            return FechaRegistro;
        }

        /**
         * @param FechaRegistro the FechaRegistro to set
         */
        public void setFechaRegistro(Date FechaRegistro) {
            this.FechaRegistro = FechaRegistro;
        }

        /**
         * @return the IdUsuario
         */
        public int getIdUsuario() {
            return IdUsuario;
        }

        /**
         * @param IdUsuario the IdUsuario to set
         */
        public void setIdUsuario(int IdUsuario) {
            this.IdUsuario = IdUsuario;
        }

        /**
         * @return the Activo
         */
        public boolean isActivo() {
            return Activo;
        }

        /**
         * @param Activo the Activo to set
         */
        public void setActivo(boolean Activo) {
            this.Activo = Activo;
        }
    }
    
    private static class JsonDateDeserializer implements JsonDeserializer<Date> 
    {
        public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException 
        {
        String s = json.getAsJsonPrimitive().getAsString();
        long l = Long.parseLong(s.substring(6, s.length() - 2));
        Date d = new Date(l);
        return d;
        }
    } 

}