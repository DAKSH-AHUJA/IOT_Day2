package day2;


interface Atm
{
	abstract void with();
	abstract void depo();
}


public class Demo3 implements Atm {
	
	public void depo()
	{
		System.out.println("With");
	}
	
	public void with()
	{
		System.out.println("Depo");
	}
	
	public static void main(String[] args) {
		
		Demo3 v = new Demo3();
		v.depo();
		v.with();
		
	}
}
