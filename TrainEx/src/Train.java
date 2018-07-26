import java.util.Iterator;

public class Train <T> {		//v

	private Wagon<T> head;		//v
	
	public Train(Wagon<T> front) {		//v
		head=front;						//v
	}
	
	//4. Add a method prepend(Wagon<T>) to Train that allows adding a new head Wagon to the train
	public void prepend(Wagon<T> front) { 		//v
		front.setNext(head);					//v
		head=front;								//v
	}
	
	//5. Add a method prepend(T) to Train that allows adding a new head Wagon to the train. 
	//This method overloads the previous one, with different parameter types.
	public void prepend(T front) {
		Wagon<T> temp=new Wagon<T>(head.getValue(), head.getNext());
		head.insertAfter(temp);
		head.setValue(front);

	}
	
	//7. Add a method int size() to Train that returns the number of Wagons in the train.
	public int size() {
		Wagon<T> temp=head; //this seems to work, but not sure why?? i keep resetting temp??
		if(temp.getNext()==null) {
			return 1;
		} else {
			return 1+temp.getNext().size();
		} //there are 5 wagons of positions i=0-4
		
		
		//can i use recursion here? - mebbeh??
	//	int num=0;		
		
		//Wagon<T> temp2;
	//	while(temp!=null) {
	//		num++;
	//		temp=temp.getNext();
			//temp=temp2;
	//	}		
	//	return num;
	}
	
	//8. Add a method appendWagon(Wagon<T>) to Train that puts the given Wagon at the end of the train. 
	//That is, the Wagon it was given will now be the final Wagon in the train.
	public void appendWagon(Wagon<T> end) {
		Wagon<T> temp=head;	
		while(temp.getNext()!=null) {
			temp=temp.getNext();
		}		
		//temp holds last, because temp.next=null
		temp.insertAfter(end);
		
	}
	
	//9. Add a method Wagon<T> getWagon(int i) to Train that returns the ith Wagon of the train. 
	//You may want to modify Wagon while you do this
	public Wagon<T> getWagon(int i){ 
		Wagon<T> temp=head;		
		if(i>=0 && i<size()) {
			for(int n=0;n<i;n++) {  //the n starting point determines if i starts at 0 or 1 >>it starts at 0
				temp=temp.getNext();
			}				
		} else {
			System.out.println("Index "+i+" is out of bounds, returning last wagon");	
			temp=getWagon(size()-1);
		}
		return temp;
	}

	
	//10. Add a method int findWagon(T) to Train that finds the position of the first Wagon holding a value 
	//that is equal (.equals) to the value given, or returns -1 if there is no such Wagon.
	public int findWagon(T val) { 	
		Wagon<T> temp=head; 
		int num=0; 							
		while(!temp.getValue().equals(val)) {			
			if(temp.getNext()==null) {
				return -1;
			} else {			
				num++;					
				temp=temp.getNext();						
			}
		}		
		return num;		
	}
	
	//11. Add a method remove(int i) to Train that removes the ith Wagon from the train. 
	//That is, if there are Wagons connected A -> B -> C -> D, 
	//after remove(2) there should be Wagons connected A -> B -> D
	public void remove(int i) { //use getWagon		
		if(i==0) {
			head=getWagon(1);
		}		
		if(i<size()-1 && i>0) {
			Wagon<T> before=getWagon(i-1);
			Wagon<T> after=getWagon(i+1);
			before.setNext(after);
		}		
		if(i==size()-1) {
			Wagon<T> before=getWagon(i-1);
			before.setNext(null);
		}		
	}
	
	//12. Add a method T get(int i) to Train that returns the data item in the ith Wagon of the train
	public T get(int i) {
		Wagon<T> temp=getWagon(i);
		return temp.getValue();
			
	}
	
	//13. Add a method add(T) to Train that adds a new Wagon with the given data item at the end of the train.
	public void add(T wag) {
		Wagon<T> temp=new Wagon<T>(wag,null);
		appendWagon(temp);		
	}
	
	//14. Add a method T set(i, T) to Train that replaces the data item held by the ith Wagon of the train.
	//Return the old value you removed
	public T set(int i,T wag) {
		T oldValue=wag;
		if(i>=0 && i<size()) {
			oldValue=get(i);
			getWagon(i).setValue(wag);
		} else {
			System.out.println("Index "+i+" is out of bounds, returning given value");
		}
		return oldValue;
	}
	
	//15. Add a method addAll(Train<T>) to Train that joins the chain of wagons of the given Train 
	//onto the end of the current chain
	public void addAll(Train<T> t2) {
		Wagon<T> temp=getWagon(size()-1);
		temp.setNext(t2.head);
	}
	
	//16. Add a method int lastIndexOf(Object x) to Train that returns the position of 
	//the last Wagon whose data item is equal (.equals()) to x.
	public int lastIndexOf(Object val) {
		Wagon<T> temp=head;
		int num=-1;		
		for(int i=0;i<size();i++) {
			if(temp.getValue().equals(val)) {
				num=i;
			}
			temp=temp.getNext();
		}
		return num;
	}
	
	//17. Add a method Train<T> reversed() to Train that returns 
	//a new Train with all the same data items in reverse order
	public Train<T> reversed(){  	
		Wagon<T> temp=new Wagon<T>(head.getValue(),null);;
		Train<T> tRev=new Train<T>(temp);
		for(int i=1;i<size();i++) {			
			temp=new Wagon<T>(get(i),null);
			tRev.prepend(temp);		
		}
		return tRev;
	}
	
	//18. Add a method void reverse() to Train that reverses the Wagons of the train in-place. 
	//That is, the last Wagon of the train will now come first, 
	//and the second-to-last Wagon will come second, and so on. 
	//The Train will have the same number of Wagons and the same data items afterwards, 
	//just in a different order.
	public void reverse() {
		int num=(int)(size()/2);
		for(int i=0;i<num;i++) { //<num so don't hit middle value
			//Wagon<T> temp=new Wagon<T>(getWagon(i)); //make copy of first wagon
			//T temp=get(i);
			int swapVal=size()-1-i;
			T temp=set(i,get(swapVal));
			temp=set(swapVal,temp);
		}
		
		
	}
	
	//19. Add a method add(int,T) to Train that adds a new Wagon with the given data 
	//item as the ith Wagon in the train. Be sure that t.add(0,x) and t.add(t.size(), x) both work
	public void add(int i, T wag) {
		Wagon<T> insert=new Wagon<T>(wag,null);
		if(i==0) {
			prepend(wag);
		}
		if(i>0 && i<size()) {
			Wagon<T> temp=getWagon(i);
			temp.insertAfter(insert);			
		} else {
			System.out.println("Index "+i+" is out of bounds, inserting at end");
			appendWagon(insert);
		}		
	}
	
	//20. There is no 20 anymore
	
	//21. Add a method remove(Object o) to Train that removes the first Wagon 
	//from the train whose data item is equal (.equals()) to o, retaining all other Wagons.
	public void remove(Object val) {		
//		int i=findWagon(val);
//		if(i>=0) {
//			remove(i);
//		} else {
//			System.out.println("There is no "+val+" to be removed");
//		}		
		
		Wagon<T> temp=head; 
		 int num=0;							
		while(!temp.getValue().equals(val)) {			
			if(temp.getNext()==null) {
				System.out.println("There is no "+val+" to be removed");
				num=-1;
				break;
			} else {									
				temp=temp.getNext();
				num++;
			}
		}		
		if(num>=0) {
			remove(num);
		} 
		
		
	}
	
	//22. Add a method Object[] toArray() to Train that returns all the data items 
	//in the train in an array of the right size  >>non-generic array
	public Object[] toArray() {
		Object [] tList=new Object[size()];
		for(int i=0;i<size();i++) {
			tList[i]=get(i); //array holds data items
		}
		return tList;
	}
	
	//23. Add a method T[] toArray(T[]) to Train that returns all the data items 
	//in the train in an array of the right size and type   >>generic array, will have to cast values
	public T[] toArray(T[] wag) {		//ignore array coming in, give back array of T[], cast 
		@SuppressWarnings("unchecked")	//to stop unchecked warning
		T[] tList=(T[]) new Object[size()]; //cast this
		for(int i=0;i<size();i++) {
			tList[i]=get(i);
		}		
		return tList;
	}
	
	//24. Add a method Iterator<T> iterator() to Train that allows iterating 
	//through all the data items in the train. 
	//An Iterator object allows asking for the next item in turn, 
	//and whether there are items remaining, and can be used with foreach loops. 
	//The Iterator<E> interface has three methods: boolean hasNext(), E next(), 
	//and void remove(); implement all of these. You may wish to use an inner class 
	//(a class written inside another); objects made from an inner class can see 
	//the private fields and methods of the object of the surrounding class inside which they were created.
	public Iterator<T> iterator(){
		
		return new Repeat();
		
	}
	
	//inner class
	public class Repeat implements Iterator<T>{
		
		private int index=0;
		
		public boolean hasNext() { 		//to check if there is a next object
		if(index<size()) {				//if the index value is less than the size of the train
				return true;			//return true
			} else {					//if the index value is outside
				return false;			//return false
			}
		}
		
		public T next(){				//to return the next object
			if(this.hasNext()) {		//first see if there is a next object				
				@SuppressWarnings("unchecked")
				T[] testArray=(T[]) new Object[size()];		//need to return an array object
				T[] tArray2=toArray(testArray);
				return tArray2[index++];	//if yes, return the next indexed item
			} else {					//otherwise
				return null;			//return nothing
			}
		}
		
		public void remove() {
			
		}
	} //end inner class
	
}

