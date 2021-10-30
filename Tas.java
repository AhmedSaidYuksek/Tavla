//Ahmed said yuksek
//181101047   

import java.util.ArrayList;
import java.util.Calendar;

public class Tas {
	int[] derinlik= {0,0,0,0,0,0,0,0,0};
	
	public int son_tas() {
		
		for(int i=0;i<derinlik.length;i++) {
			if(derinlik[i]==0)
				return i;
		}		
		return 0;
	}        // 51
}
