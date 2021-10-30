//Ahmed said yuksek
//181101047    hocam kod tas toplarken toplamayi tamamlayamiyor ondan dolayi kod sonlanamiyor yoksa o kisim dogru
//Main method burada
//34-70. satirlarla saniye yazdirmaya çalistim ama olmadi baska bir sekilde yaptim sonra 
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Calendar;
import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
	
public class Tavla extends JFrame {
	
	
	Oynanis tavla_oyun=new Oynanis();
	 int giris_kontrol=2;
	 int a=0;
	 int saniye=0;
	ReentrantLock lock1 = new ReentrantLock(); 
	
	public class Kirmizi implements Runnable{
	
		int giris=2;
		
	
		public void run() {	
			
				while(true) {
//					System.out.println(System.currentTimeMillis()%1000);
					lock1.lock();
					
					if(giris_kontrol!=giris) {	
						if(tavla_oyun.kontrol(1)|tavla_oyun.kontrol(2)) {a++;break;}
						saniye=saniye+2;
					System.out.println("kirmizi oyuncu oynadi oyun :"+saniye+". saniyede");	
																		

					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					tavla_oyun.The_game_kirmizi();
					repaint();
					System.out.println("-------------------");
					giris_kontrol=giris;
								
			}	lock1.unlock();	}	
				
			}
		}	
		
	
	public class Beyaz implements Runnable{
		
		int giris=1;
		
	
		int zar1=(int)(Math.random()*5+1);
		int zar2=(int)(Math.random()*5+1);
		public void run() {
			System.out.println(System.currentTimeMillis()%1000);
			while(true) {
			//	System.out.println(System.currentTimeMillis()%1000);
				lock1.lock();
				
				if(giris_kontrol!=giris) {
					if(tavla_oyun.kontrol(1)|tavla_oyun.kontrol(2)) {a++;break;}
					saniye=saniye+2;
					System.out.println("beyaz oyuncu oynadi oyun :"+saniye+". saniyede");					
						
//			System.out.println("oluyor  "+giris);
			
			//	}
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				tavla_oyun.The_game_beyaz();
				repaint();
				System.out.println("-------------------");
				giris_kontrol=giris;
			
					
		}lock1.unlock();				}	
		}
	}

	
	
	public Tavla() {
		//tavla_oyun.basla();
		Thread Oynanis1=new Thread(new Kirmizi());
		Thread Oynanis2=new Thread(new Beyaz());
		
		
		setSize(1060,700);
		
		setVisible(true);
		Oynanis2.start();
		Oynanis1.start();
		if(a>=2) {
			setVisible(false);
		}
		
	}
	public void paint(Graphics g){
		
		g.setColor(Color.BLACK);
		g.fillRect(10,10,1040,680);
		g.setColor(Color.WHITE);
		
		g.drawLine(570, 350, 1045, 350);
		g.drawLine(15, 350, 490, 350);
		g.drawLine(490, 35, 490, 685);
		g.drawLine(570, 35, 570, 685);
		
		g.drawString("1", 1030, 670); 
		g.drawString("2", 940, 670);
		g.drawString("3", 850, 670);
		g.drawString("4", 760, 670);
		g.drawString("5", 670, 670);
		g.drawString("6", 580, 670);
		g.drawString("7", 470, 670);
		g.drawString("8", 380, 670);
		g.drawString("9", 290, 670);
		g.drawString("10", 200, 670);
		g.drawString("11", 110, 670);
		g.drawString("12", 20, 670);
		
		g.drawString("24", 1030, 50); 
		g.drawString("23", 940, 50);
		g.drawString("22", 850, 50);
		g.drawString("21", 760, 50);
		g.drawString("20", 670, 50);
		g.drawString("19", 580, 50);
		g.drawString("18", 470, 50);
		g.drawString("17", 380, 50);
		g.drawString("16", 290, 50);
		g.drawString("15", 200, 50);
		g.drawString("14", 110, 50);
		g.drawString("13", 20, 50);
		for(int i=0;i<6;i++) {
			for(int j=0;j<8;j++)
			if(tavla_oyun.taslar[i].derinlik[j]==2) {
				g.setColor(Color.RED);
				g.drawString("R", 1030-(90*i), 620-(j*30));
			}
			else if(tavla_oyun.taslar[i].derinlik[j]==1) {
				g.setColor(Color.WHITE);
				g.drawString("W", 1030-(90*i), 620-(j*30));
			}
			
		}
		for(int i=0;i<6;i++) {
			for(int j=0;j<8;j++)
			if(tavla_oyun.taslar[i+6].derinlik[j]==2) {
				g.setColor(Color.RED);
				g.drawString("R", 470-(90*i), 620-(j*30));
			}
			else if(tavla_oyun.taslar[i+6].derinlik[j]==1) {
				g.setColor(Color.WHITE);
				g.drawString("W", 470-(90*i), 620-(j*30));
			}			
		}
		
		
		for(int i=0;i<6;i++) {
			for(int j=0;j<8;j++)
			if(tavla_oyun.taslar[i+12].derinlik[j]==2) {
				g.setColor(Color.RED);
				g.drawString("R", 20+(90*i), 100+(j*30));
			}
			else if(tavla_oyun.taslar[i+12].derinlik[j]==1) {
				g.setColor(Color.WHITE);
				g.drawString("W", 20+(90*i), 100+(j*30));
			}
			
		}
		for(int i=0;i<6;i++) {
			for(int j=0;j<8;j++)
			if(tavla_oyun.taslar[i+18].derinlik[j]==1) {
				g.setColor(Color.WHITE);
				g.drawString("W", 580+(90*i), 100+(j*30));
			}
			else if(tavla_oyun.taslar[i+18].derinlik[j]==2) {
				g.setColor(Color.RED);
				g.drawString("R", 580+(90*i), 100+(j*30));
			}			
		}
		for(int i=0;i<tavla_oyun.kirik_taslar_beyazlar.size();i++) {			
			
			if(tavla_oyun.kirik_taslar_beyazlar.get(i).equals(1)) {
				g.setColor(Color.WHITE);
				g.drawString("W",530, 630-(i*30));
			}
					
		}
		for(int i=0;i<tavla_oyun.kirik_taslar_kirmizilar.size();i++) {
			
			if(tavla_oyun.kirik_taslar_kirmizilar.get(i).equals(2)) {
				g.setColor(Color.RED);
				g.drawString("R",530, 50+(i*30));
				}							
		}
		
	}
	public static void main(String[]args) {
		new Tavla();
	}
}
