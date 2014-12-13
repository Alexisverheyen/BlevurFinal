package Reseau;

import java.io.*;
import java.net.*;

public class MonClient extends Socket implements Runnable{
	private BufferedReader inClient;
	private PrintWriter outClient;
	private String info;
	private Socket Client;
	private int port;
	private String ip;
	
	public MonClient(String ip, int port) throws Exception {
		super(ip, port);
		this.port = port;
		this.ip= ip;
	}
	
	public void creerClient(){
		try{
			this.Client = new Socket(this.ip, this.port);
			System.out.println("zudfgh");
		} catch (Exception e) {
			System.out.println("erreur creation client");
			}
	}
	
	public String getInfo(){
		return this.info;
	}
	
	public Socket getClient(){
		return this.Client;
	}
	
	public synchronized void envoiInfo(String infoSortie) throws IOException{
		if (Client != null && Client.isConnected()){
			outClient = new PrintWriter (Client.getOutputStream());
			outClient.println(infoSortie);
			outClient.flush();
		}
	}
	
	public void lectureInfo(){
		try{
			inClient = new BufferedReader(new InputStreamReader(Client.getInputStream()));
			String tmp = inClient.readLine();
			this.info = tmp;
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * On met un sleep pour laisser le temps au serveur de se lancer 
	 * 
	 */
	public void run(){
		try{
			Thread.sleep(100);
		}catch (Exception e) {}
		
		while (Client == null){
			creerClient();
		}
		
		while (!Client.isClosed()){
			if (Client.isConnected()){
				lectureInfo();
			}
		}
	}

}
