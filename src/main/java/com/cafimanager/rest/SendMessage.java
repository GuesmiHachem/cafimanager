package com.cafimanager.rest;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.cafimanager.configuration.SmsConfig;



@Service("sendMessage")
public class SendMessage {
 
	
    static final String URL_CREATE_EMPLOYEE = "https://api.orange.com/smsmessaging/v1/outbound/tel:+21654349839/requests";
 
    /*static final String address="tel:+21697983181";
    static final String senderAddress="tel:+21697983181";
    static final String message="Bienvenu! hachem cv";
    */
      public String author="Bearer DwAoC28rpHWJEv8dydTdFCiyOz2v";
     public String contentType="application/json";
    
    
    public static void main(String[] args)  throws IOException {
    	
    	SendMessage mes =new SendMessage();
    	//mes.send("tel:+21697983181", "tel:+21654349839", "Bienvenu! hachem cv");
    		
    	mes.solde();
    }
 

    public  void send(String address,String senderAddress,String message)  throws IOException {
    	 
  	  final String POST_PARAMS = "{ \"outboundSMSMessageRequest\": {\r\n" + 
  	  		"		\"address\": \"" +address+"\",\r\n" + 
  	  		"		\"senderAddress\":\""+senderAddress+"\",\r\n" + 
  	  		"		\"outboundSMSTextMessage\": {\r\n" + 
  	  		"			\"message\": \""+message+"\"\r\n" + 
  	  		"		}\r\n" + 
  	  		"	}\r\n" + 
  	  		"} ";
  	  
  	  
  		    //System.out.println(POST_PARAMS);
  		    URL obj = new URL(URL_CREATE_EMPLOYEE);
  		    HttpURLConnection postConnection = (HttpURLConnection) obj.openConnection();
  		    postConnection.setRequestMethod("POST");
  		    postConnection.setRequestProperty("Authorization", author);
  		    postConnection.setRequestProperty("Content-Type", contentType);
  		    postConnection.setDoOutput(true);
  		    OutputStream os = postConnection.getOutputStream();
  		    os.write(POST_PARAMS.getBytes());
  		    os.flush();
  		    os.close();
  		    int responseCode = postConnection.getResponseCode();
  		    System.out.println("POST Response Code :  " + responseCode);
  		    System.out.println("POST Response Message : " + postConnection.getResponseMessage());
  		    if (responseCode == HttpURLConnection.HTTP_CREATED) { //success
  		        BufferedReader in = new BufferedReader(new InputStreamReader(
  		            postConnection.getInputStream()));
  		        String inputLine;
  		        StringBuffer response = new StringBuffer();
  		        while ((inputLine = in .readLine()) != null) {
  		            response.append(inputLine);
  		        } in .close();
  		        // print result
  		        System.out.println(response.toString());
  		    } else {
  		        System.out.println("POST NOT WORKED");
  		    }

  }

    
    public  void solde() throws IOException {
        URL urlForGetRequest = new URL("https://api.orange.com/sms/admin/v1/contracts");
        String readLine = null;
        HttpURLConnection conection = (HttpURLConnection) urlForGetRequest.openConnection();
        conection.setRequestMethod("GET");
        //smsConfig.getAuthor();
        conection.setRequestProperty("Authorization", author); // set userId its a sample here
        int responseCode = conection.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(
                new InputStreamReader(conection.getInputStream()));
            StringBuffer response = new StringBuffer();
            while ((readLine = in .readLine()) != null) {
                response.append(readLine);
            } in .close();
            // print result
            System.out.println("JSON String Result " + response.toString());
            //GetAndPost.POSTRequest(response.toString());
        } else {
        	
           System.out.println("GET NOT WORKED"+author+"**");
        }
    }
    
}
    
    