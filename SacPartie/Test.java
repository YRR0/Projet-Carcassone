
import java.util.*;
import java.math.*;
public class Test {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		 * Scanner a = new Scanner(System.in);
		 
		String rep = a.next();
		a = new Scanner(System.in);
		rep = a.next();
		a.close();
		System.out.println(rep);
		int val = 10;
		aff(10);
		//a.close();
		 * */
		ArrayList<Integer> a = new ArrayList<>();
		a.add(1);
		a.add(3);
		a.add(5);
		int rand = (int)(Math.random() * a.size());
		Random r = new Random();
		int rand2 = r.nextInt(10);
		
		//System.out.println(a.get(rand));
		//System.out.println(rand2); 
		
		int [] t = randTab();
		//afficher(t);
		
		int[] t1 = {0,0,0};
		int[] t2 = {1,1,1};
		int[] t3 = {2,2,3};
		int [] t4 = {2,2,2};
				
		Tuile tuile = new Tuile(t1,t2,t3,t4);
		Tuile tuile2 = new Tuile(t1,t4,t3,t2);
		Plateau plateau = new Plateau();
		ArrayList<Tuile> arr = new ArrayList<>();
		arr.add(tuile);
		plateau.cases.add(arr);
		//plateau.ajouter(tuile2, 0, 1);
		arr.add(tuile2);
		//plateau.afficher();
		System.out.println(tuile2.corresponds(plateau, 0, 0));
		
	}
	
	public static void afficher(int[] tab) {
		for(int i=0 ; i<tab.length;i++) {
			System.out.println(tab[i]);
		}
	}
	
	public static void aff(int n) {
		while(n>0) {
			System.out.println(n);
			n--;
		}
	}
	
	public static int[] randTab() {
		Random rand = new Random();
		int i = rand.nextInt(10), j = rand.nextInt(10), k = rand.nextInt(10);
		int[] t = {i,j,k};
		return t;
	}
	
}
