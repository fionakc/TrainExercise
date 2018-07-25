
public class test {

	public static void main(String[] args) {					//v
		Wagon<String> wb=new Wagon<>("b",null);					//v
		Wagon<String> wa=new Wagon<>("a",wb);					//v
		Train<String>  t=new Train<>(wa);						//v
		
		System.out.println("testing adding Wagons and getValues");
		System.out.println(wa.getValue());						//v
		System.out.println(wb.getValue());						//v
		System.out.println(wa.getNext().getValue());			//v
		
		Wagon<String> wX =new Wagon<>("X",null);				//v
		wa.insertAfter(wX);										//v
		
		System.out.println("Testing insertAfter");
		System.out.println(wa.getNext().getValue());			//v
		System.out.println(wa.getNext().getNext().getValue());	//v
		
		System.out.println("Testing size functions");
		System.out.println(wa.size());		
		System.out.println(wX.size());
		System.out.println(wb.size());
		System.out.println(t.size());
		
		Wagon<String> end=new Wagon<>("e",null);
		t.appendWagon(end);
		System.out.println("Testing adding end unit");
		System.out.println(t.size());
		
		Wagon<String> wT=new Wagon<>(t.getWagon(2));
		System.out.println("Testing getWagon number");
		System.out.println(wT.getValue());
		
		t.prepend("d");
		System.out.println("Testing adding new front wagon");
		System.out.println(t.size());
		Wagon<String> wT1=new Wagon<>(t.getWagon(1));
		System.out.println(wT1.getValue());
		Wagon<String> wT2=new Wagon<>(t.getWagon(2));
		System.out.println(wT2.getValue());
		
		System.out.println("Testing findWagon");
		System.out.println(t.findWagon("a"));
		System.out.println(t.findWagon("d"));
		System.out.println(t.findWagon("e"));
		System.out.println(t.findWagon("h"));
	}
	
}
