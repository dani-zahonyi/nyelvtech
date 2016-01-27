package csaladfa_DOM;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.*;

import java.io.*;
import java.util.ArrayList;

public class DOM {
	private Document doc;
	private ArrayList<Szemely> csaladfa = new ArrayList<Szemely>();
	
	public void parse(String filename){
		DocumentBuilderFactory factory =
				DocumentBuilderFactory.newInstance();
				try {
					
					
					 File inputFile = new File(filename);
			         DocumentBuilderFactory dbFactory 
			            = DocumentBuilderFactory.newInstance();
			         DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			         Document doc = dBuilder.parse(inputFile);
					 
						doc.getDocumentElement().normalize();
				      System.out.println("Családfa");
				         NodeList nList = doc.getElementsByTagName("szemely");
				         System.out.println("-----------------------");
				         for (int temp = 0; temp < nList.getLength(); temp++) {
				        	 StringBuilder nev= new StringBuilder();
								String szuletesi_ido;
								ArrayList<String> testverekid = new ArrayList<String>();
								 ArrayList<String> gyerekekid = new ArrayList<String>();
								 String hazastarsid=null;
								
								String id;
								String nem;
								
				            Node nNode = nList.item(temp);
				            
				            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				               Element eElement = (Element) nNode;
				               System.out.println("\nid : " 
				                  + eElement.getAttributes().getNamedItem("id").getNodeValue());
				               
				              id=eElement.getAttributes().getNamedItem("id").getNodeValue();
				              
				               System.out.println("Vezetéknév : " 
				                  + eElement
				                  .getElementsByTagName("vezeteknev")
				                  .item(0)
				                  .getTextContent());
				               
				               nev.append(eElement.getElementsByTagName("vezeteknev").item(0).getTextContent());
				               
				               
				               System.out.println("Keresztnév : " 
				               + eElement
				                  .getElementsByTagName("keresztnev")
				                  .item(0)
				                  .getTextContent());
				               
				               nev.append(" "+eElement.getElementsByTagName("keresztnev").item(0).getTextContent());
				               
				               System.out.println("Született : " 
				               + eElement
				                  .getElementsByTagName("szuletesi_ido")
				                  .item(0)
				                  .getTextContent());
				              
				               szuletesi_ido=eElement.getElementsByTagName("szuletesi_ido").item(0).getTextContent();
				               
				               NodeList gyList = eElement.getElementsByTagName("gyerek");
						      
						         for (int tempgy = 0; tempgy < gyList.getLength(); tempgy++) {
						            Node gyNode = gyList.item(tempgy);
						            System.out.println("\nGyerekek : ");
						            System.out.println(gyNode.getAttributes().getNamedItem("id"));
						            gyerekekid.add(gyNode.getAttributes().getNamedItem("id").getNodeValue());
						            
						         }
						         
						         NodeList tList = eElement.getElementsByTagName("testver");
						         for (int tempt = 0; tempt < tList.getLength(); tempt++) {
							            Node tNode = tList.item(tempt);
							            System.out.println("Testvérek : ");
							            System.out.println(tNode.getAttributes().getNamedItem("id").getNodeValue());
							            
							            testverekid.add(tNode.getAttributes().getNamedItem("id").getNodeValue());
							            
							         }
						         
						         if(eElement.getElementsByTagName("hazastars").getLength()>0)
						         {System.out.println("Házastárs:");
						        	 System.out.println(eElement.getElementsByTagName("hazastars").item(0).getAttributes().getNamedItem("id"));
						         hazastarsid= eElement.getElementsByTagName("hazastars").item(0).getAttributes().getNamedItem("id").getNodeValue();
						         }   
						         
						         nem= eElement.getAttributeNode("sex").getValue();
						         
						         csaladfa.add(new Szemely(nev.toString(),szuletesi_ido,id,nem).setGyerekekid(gyerekekid).setTestverekid(testverekid).setHazastarsid(hazastarsid));
						         
						         
						         
				            }
				         }
					
				         
				       for(Szemely e:csaladfa){
				    	   
				    	   for(String f : e.getGyerekekid()){
				    		   for(Szemely g:csaladfa){
				    			   if(g.getId().equals(f)){
				    				   e.addGyerek(g);
				    			   }
				    		   }
				    		  
				    		   
				    	   }
				    	   for(Szemely g:csaladfa){
				    	   for(String f : e.getTestverekid()){
				    			   if(g.getId().equals(f)){
				    				   e.addTestver(g);
				    			   }
				    		   }}
				    	   
				    	   if(e.hazastarsid!=null){
				    		   for(Szemely g:csaladfa){
				    			   if(g.getId().equals(e.hazastarsid))
				    				   e.setHazastars(g);
				    		   }
				    	   }
				       }
				} catch (ParserConfigurationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SAXException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
				
	}
		
	public ArrayList<Szemely> getCsaladfa() {
		return csaladfa;
	}
	
}
