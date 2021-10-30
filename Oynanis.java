//Ahmed said yuksek
//181101047    
import java.util.ArrayList;

public class Oynanis {
	
		ArrayList<Integer>kirik_taslar_beyazlar =new ArrayList<Integer>();
		ArrayList<Integer>kirik_taslar_kirmizilar =new ArrayList<Integer>();

		Tas[] taslar=new Tas[24];
		Oynanis() {
	
			basla();
		}
		public void basla() {
			int sayi2=0;
			int sayi3=0;
	
			for(int i=0;i<24;i++) {
				taslar[i]=new Tas();			
			}
			 
			for(int i=0;i<5;i++) {
				taslar[5].derinlik[i]=1;			
				taslar[11].derinlik[i]=2;			
				taslar[12].derinlik[i]=1;			
				taslar[18].derinlik[i]=2;
			
				if(i%3==0) {				
					taslar[0].derinlik[sayi3]=2;				
					taslar[23].derinlik[sayi3]=1;	
					sayi3++;
				}
				if(i%2==0) {				
					taslar[7].derinlik[sayi2]=1;					
					taslar[16].derinlik[sayi2]=2;	
					sayi2++;
				}
				
			}		
		}
		public int random() {
			return (int)(Math.random()*5+1);
		}
		public void tavla_hamle(int a,int b,int c) {
			boolean yap=false;
			
			System.out.println("ilk zar "+a+"   ikinci zar "+b);
			if(c==1) {
				
				if(!hamle_beyaz(a)) {yap=true;}
				hamle_beyaz(b);
				if(yap) {hamle_beyaz(a);}
				
			}
			else {
				
					if(!hamle_kirmizi(a))yap=true;
					hamle_kirmizi(b);
					if(yap)hamle_kirmizi(a);
				
			}
		}
		public boolean hamle_kirmizi(int a) {
			boolean dongu=true;
			int sayi=0;
			while(dongu) {
				if(taslar[sayi].son_tas()>0&taslar[sayi].derinlik[0]==2&sayi+a<=23) {

					if(taslar[sayi+a].son_tas()<1/*|taslar[sayi+a].derinlik[1]==2*/|taslar[sayi+a].derinlik[0]==2) {

						
						 taslar[sayi+a].derinlik[taslar[sayi+a].son_tas()]=2;
						 taslar[sayi].derinlik[taslar[sayi].son_tas()-1]=0;
						// kirik_taslar_beyazlar.add(1);						 
						return true;						
					}
					else if(taslar[sayi+a].derinlik[0]==1&&taslar[sayi+a].derinlik[1]!=1) {

						taslar[sayi].derinlik[taslar[sayi].son_tas()-1]=0;
						kirik_taslar_beyazlar.add(1);
						taslar[sayi+a].derinlik[0]=2;
						return true;
					}
				}sayi++;if(sayi==24) {break;}
			}
			return false;
		}
		public boolean hamle_beyaz(int a) {
			boolean dongu=true;
			int sayi=23;
			while(dongu) {
				if(taslar[sayi].son_tas()>0&taslar[sayi].derinlik[0]==1&sayi-a>=0) {

					if(taslar[sayi-a].son_tas()<1 /*|taslar[sayi-a].derinlik[1]==1*/|taslar[sayi-a].derinlik[0]==1) {
						 taslar[sayi-a].derinlik[taslar[sayi-a].son_tas()]=1;
						 taslar[sayi].derinlik[taslar[sayi].son_tas()-1]=0;
					
						return true;
					}
					else if(taslar[sayi-a].derinlik[0]==2&taslar[sayi-a].derinlik[1]==0) {
						
						taslar[sayi].derinlik[taslar[sayi].son_tas()-1]=0;
						kirik_taslar_kirmizilar.add(2);
						
						taslar[sayi-a].derinlik[0]=1;
						return true;
					}
				}if(sayi==0) {break;}sayi--;
			}/*System.out.println("olmadi"+a);*/return false;
		}
		public boolean kirik_yerlestirme_kirmizi(int a) {
			
			
				if(kirik_taslar_kirmizilar.size()>0&taslar[a].derinlik[1]!=1) {
					kirik_taslar_kirmizilar.remove(0);
					if(taslar[a].derinlik[0]==1) {
						kirik_taslar_beyazlar.add(1);
						taslar[a].derinlik[0]=2;
					}
					 taslar[a].derinlik[taslar[a].son_tas()]=2;
					 return true;
				}
			
			return false;
		}
		public boolean kirik_yerlestirme_beyaz(int a) {
			a=23-a;
			if(kirik_taslar_beyazlar.size()>0&taslar[a].derinlik[1]!=2) {
				kirik_taslar_beyazlar.remove(0);
				if(taslar[a].derinlik[0]==2) {
					kirik_taslar_kirmizilar.add(2);
					taslar[a].derinlik[0]=1;
					}
				taslar[a].derinlik[taslar[a].son_tas()]=1;
				 return true;
			}
			return false;
		}
		public boolean tas_toplayabilir_mi_kirmizi() {
			for(int i=0;i<18;i++) {
				if(taslar[i].derinlik[0]==2) {
					return false;
				}
			}
			if(kirik_taslar_kirmizilar.size()>0) {
				return false;
			}
			return true;
		}
		public boolean tas_toplayabilir_mi_beyaz() {
			for(int i=17;i>=0;i--) {
				if(taslar[i].derinlik[0]==1) {
					return false;
				}
			}
			if(kirik_taslar_beyazlar.size()>0) {
				return false;
			}
			return true;
		}
		public void tos_topla_kirmizi(int a) {
		
			for(int i=5;i>=0;i--) {
				if(taslar[i].derinlik[0]==2&a>=i) {
					System.out.println("zar "+a);
					taslar[i].derinlik[taslar[i].son_tas()-1]=0;
					i=-88;
					
				}else {hamle_beyaz(a);	System.out.println("zar "+a);i=-88;
				}				
			}				
			}
		
		public void tos_topla_beyaz(int a) {
			
			for(int i=17;i<24;i++) {
				if(taslar[i].derinlik[0]==1&a>=(22-i)) {
					
					System.out.println("zar "+a);
					taslar[i].derinlik[taslar[i].son_tas()-1]=0;
					i=88;
					
				}
				else {hamle_beyaz(a);	
				System.out.println("zar "+a);
				i=88;
				}
				
			}
			
		}
		public boolean kontrol(int a) {
			for(int i=0;i<24;i++) {
				if(taslar[i].derinlik[0]==a) {
					return false;
				}
			}
			return true;
		}
		
		public void The_game_kirmizi() {
			int a=(int)(Math.random()*5+1);
			int b=(int)(Math.random()*5+1);
			if(tas_toplayabilir_mi_kirmizi()) {
				tos_topla_kirmizi(a);
				tos_topla_kirmizi(b);
				if(a==b) {
					tos_topla_kirmizi(a);
					tos_topla_kirmizi(b);
				}
			}
			else {
				if(!kirik_yerlestirme_kirmizi(a)&&!kirik_yerlestirme_kirmizi(b)) {
					tavla_hamle(a,b,2);
				}
				
				}
				if(a==b) {
					if(!kirik_yerlestirme_kirmizi(a)&&!kirik_yerlestirme_kirmizi(b)) {
						tavla_hamle(a,b,2);
					}
					
				}				
			}
			
		public void The_game_beyaz() {
			int a=(int)(Math.random()*5+1);
			int b=(int)(Math.random()*5+1);
			if(tas_toplayabilir_mi_beyaz()) {
				tos_topla_beyaz(a);
				tos_topla_beyaz(b);
				if(a==b) {
					tos_topla_beyaz(a);
					tos_topla_beyaz(b);
				}
			}
			else {
				if(!kirik_yerlestirme_beyaz(a)&&!kirik_yerlestirme_beyaz(b)) {
					tavla_hamle(a,b,1);
				}
				
				if(a==b) {
					if(!kirik_yerlestirme_beyaz(a)&&!kirik_yerlestirme_beyaz(b)) {
						tavla_hamle(a,b,1);
					}
						
			}
		}
		}
		
		
	

}
