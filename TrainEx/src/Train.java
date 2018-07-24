
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
		int num=0;		
		Wagon<T> temp=head;
		Wagon<T> temp2;
		while(temp!=null) {
			num++;
			temp2=temp.getNext();
			temp=temp2;
		}		
		return num;
	}
	
	//8. Add a method appendWagon(Wagon<T>) to Train that puts the given Wagon at the end of the train. 
	//That is, the Wagon it was given will now be the final Wagon in the train.
	public void appendWagon(Wagon<T> end) {
		Wagon<T> temp=head;
		Wagon<T> temp2;
		while(temp.getNext()!=null) {
			temp2=temp.getNext();
			temp=temp2;
		}		
		//temp holds last, because temp.next=null
		temp.insertAfter(end);
		
	}
	
	//9. Add a method Wagon<T> getWagon(int i) to Train that returns the ith Wagon of the train. 
	//You may want to modify Wagon while you do this
	public Wagon<T> getWagon(int i){ //assuming i is valid
		Wagon<T> temp=head;
		Wagon<T> temp2;		
		for(int n=1;n<i;n++) {  //the n starting point determines if i starts at 0 or 1 >>it starts at 1
			temp2=temp.getNext();
			temp=temp2;
		}		
		return temp;
	}

	
	//10. Add a method int findWagon(T) to Train that finds the position of the first Wagon holding a value 
	//that is equal (.equals) to the value given, or returns -1 if there is no such Wagon.
	public int findWagon(T val) {
		Wagon<T> temp=head;
		Wagon<T> temp2;
		boolean equal=false;
		int num=-1;
		while(!equal) {
			
		}
		
		return num;
	}
	
}

