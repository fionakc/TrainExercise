
public class Train <T> {		//v

	private Wagon<T> head;		//v
	//private Wagon<T> next;
	
	public Train(Wagon<T> front) {		//v
		head=front;						//v
		//next=head.getNext();
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
			//temp=temp.getNext();
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
		//Wagon<T> temp2;	
		while(temp.getNext()!=null) {
			temp=temp.getNext();
			//temp=temp2;
		}		
		//temp holds last, because temp.next=null
		temp.insertAfter(end);
		
	}
	
	//9. Add a method Wagon<T> getWagon(int i) to Train that returns the ith Wagon of the train. 
	//You may want to modify Wagon while you do this
	public Wagon<T> getWagon(int i){ //assuming i is valid
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
	
	
}

