
public class test {

	public static void main(String[] args) {					//v
		Wagon<String> wb=new Wagon<>("b",null);					//v
		Wagon<String> wa=new Wagon<>("a",wb);					//v
		Train<String>  t=new Train<>(wa);						//v
		
		
		System.out.println(wa.getValue());						//v
		System.out.println(wb.getValue());						//v
		System.out.println(wa.getNext().getValue());			//v
		
		Wagon<String> wX =new Wagon<>("X",null);				//v
		wa.insertAfter(wX);										//v
		
		System.out.println(wa.getNext().getValue());			//v
		System.out.println(wa.getNext().getNext().getValue());	//v
		
		System.out.println(wa.size());		
		System.out.println(wX.size());
		System.out.println(wb.size());
		System.out.println(t.size());
		
		Wagon<String> end=new Wagon<>("e",null);
		t.appendWagon(end);
		System.out.println(t.size());
		
		Wagon<String> wT=new Wagon<>(t.getWagon(2));
		System.out.println(wT.getValue());
		
		t.prepend("d");
		System.out.println(t.size());
		Wagon<String> wT1=new Wagon<>(t.getWagon(1));
		System.out.println(wT1.getValue());
		Wagon<String> wT2=new Wagon<>(t.getWagon(2));
		System.out.println(wT2.getValue());
	}
	
}
