package Reseau;

import java.io.*;
import java.net.*;
import java.util.ArrayList;

public class MonServeur extends ServerSocket implements Runnable {
	public Socket getClient() {
		return Client;
	}


	private BufferedReader inServ;
	private PrintWriter outServ;
	private String info;
	private Socket Client;
	

	public MonServeur(int port) throws Exception {
		super(port, 1, InetAddress.getLocalHost());
	}
	
	public synchronized void envoiInfo(String infoSortie) throws IOException{
		if (Client != null && Client.isConnected()){
			outServ = new PrintWriter (Client.getOutputStream());
			outServ.println(infoSortie);
			outServ.flush();
		}
	}
	
	public void lectureInfo(){
		try {
			inServ = new BufferedReader(new InputStreamReader(Client.getInputStream()));
			String tmp = inServ.readLine();
			if (tmp != null){
				this.info = tmp;
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	
	public String getInfo(){
		return this.info;
	}
	
	
	public void run(){
		try{ this.Client = this.accept();
		}catch (IOException e1) {
			e1.printStackTrace();
		}
		while(!this.isClosed()){
			if (Client != null && Client.isConnected()){
				lectureInfo();
			}
		}
	}
}
