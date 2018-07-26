
public class test {

	public static void main(String[] args) {					//v
		Wagon<String> wb=new Wagon<>("b",null);					//v
		Wagon<String> wa=new Wagon<>("a",wb);					//v
		Train<String>  t=new Train<>(wa);						//v
		
		//System.out.println("testing adding Wagons and getValues");
		//System.out.println(wa.getValue());						//v
		//System.out.println(wb.getValue());						//v
		//System.out.println(wa.getNext().getValue());			//v
		
		Wagon<String> wX =new Wagon<>("X",null);				//v
		wa.insertAfter(wX);										//v
		
		//System.out.println("Testing insertAfter");
		//System.out.println(wa.getNext().getValue());			//v
		//System.out.println(wa.getNext().getNext().getValue());	//v
		
		//System.out.println("Testing size functions");
		//System.out.println(wa.size());		
		//System.out.println(wX.size());
		//System.out.println(wb.size());
		//System.out.println(t.size());
		
		Wagon<String> end=new Wagon<>("e",null);
		t.appendWagon(end);
		//System.out.println("Testing adding end unit");
		//System.out.println(t.size());
		
		//System.out.println("Testing getWagon number");
		//Wagon<String> wT=new Wagon<>(t.getWagon(3));
		//System.out.println(wT.getValue());
		//Wagon<String> wT3=new Wagon<>(t.getWagon(4));				
		//System.out.println(wT3.getValue());
		
		t.prepend("d");
		//System.out.println("Testing adding new front wagon");
		//System.out.println(t.size());
		//Wagon<String> wT1=new Wagon<>(t.getWagon(1));
		//System.out.println(wT1.getValue());
		//Wagon<String> wT2=new Wagon<>(t.getWagon(2));
		//System.out.println(wT2.getValue());
		
//		System.out.println("List");
//		for(int i=0;i<t.size();i++) {
//			System.out.println(t.get(i));
//		}
		
//		System.out.println("Testing findWagon");
//		System.out.println(t.findWagon("a"));
//		System.out.println(t.findWagon("d"));
//		System.out.println(t.findWagon("e"));
//		System.out.println(t.findWagon("h"));
		
		//System.out.println("Testing remove");
		//System.out.println(t.getWagon(0).getValue());
		//System.out.println(t.getWagon(1).getValue());
		//t.remove(0);
		//System.out.println(t.getWagon(0).getValue());
		//System.out.println(t.getWagon(1).getValue());
		
		//System.out.println("Testing Train get");
		//System.out.println(t.get(2));
		//System.out.println(t.get(4));
		//System.out.println(t.get(5));
		
		//System.out.println("List");
		//for(int i=0;i<t.size();i++) {
		//	System.out.println(t.get(i));
		//}
		
		//System.out.println("Testing Train add");
		t.add("f");
		//System.out.println(t.get(4));
		//System.out.println(t.get(5));
		
		//System.out.println("Testing set");
		//System.out.println(t.set(7, "c"));
		
//		System.out.println("List");
//		for(int i=0;i<t.size();i++) {
//			System.out.println(t.get(i));
//		}
		
		Wagon<String> t23=new Wagon<>("c",null);
		Wagon<String> t21=new Wagon<>("b",t23);					
		Wagon<String> t22=new Wagon<>("a",t21);					
		Train<String>  t2=new Train<>(t22);
		t.addAll(t2);
		System.out.println("List");
		for(int i=0;i<t.size();i++) {
			System.out.println(t.get(i));
		}
		
//		System.out.println("Testing lastIndexOf");
//		System.out.println(t.lastIndexOf("a"));
//		System.out.println(t.lastIndexOf("g"));
//		System.out.println(t.lastIndexOf("e"));
		
		//Train<String> t3=new Train<>(null);
		//t3=t.reversed();
		//System.out.println("Reversed");
		//for(int i=0;i<t.size();i++) {
		//	System.out.println(t3.get(i));
		//}
		
//		System.out.println("Testing reverse in place");
//		t.reverse();
//		System.out.println("List");
//		for(int i=0;i<t.size();i++) {
//			System.out.println(t.get(i));
//		}
		
		//System.out.println("Testing add");
		//t.add(11,"T");
		
		//System.out.println("Testing remove first instance");
		//t.remove("t");
		
		//Object[] tArray=t.toArray();
//		
//		System.out.println("Testing Non-generic Array");
//		for(int i=0;i<tArray.length;i++) {
//			System.out.println(tArray[i]);
//		}
//		
//		
//		System.out.println("List");
//		for(int i=0;i<t.size();i++) {
//			System.out.println(t.get(i));
//		}
		String[] testArray=new String[2];
		
		Object[] tArray2=t.toArray(testArray);
		
		System.out.println("Testing generic Array");
		for(int i=0;i<tArray2.length;i++) {
			System.out.println(tArray2[i]);
		}
		
		
		System.out.println("List");
		for(int i=0;i<t.size();i++) {
			System.out.println(t.get(i));
		}
		
		
		
	} //end main
	
	
} //end class
