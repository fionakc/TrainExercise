
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
		}
		
		
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
		//Wagon<T> temp2;		
		for(int n=1;n<i;n++) {  //the n starting point determines if i starts at 0 or 1 >>it starts at 1
			temp=temp.getNext();
			//temp=temp2;
		}		
		return temp;
	}

	
	//10. Add a method int findWagon(T) to Train that finds the position of the first Wagon holding a value 
	//that is equal (.equals) to the value given, or returns -1 if there is no such Wagon.
	public int findWagon(T val) { //not working yet, may need recursion, working on size recursion as precurser
		//T value=val;
		Wagon<T> temp=head; //it's always returning 2 >> cos i'm not recursing it, duh
		int num=1; 			//now always returning 1
		
		//if(temp.getNext()==null) {
		//	return -1;
		//} else if (!temp.equals(val)){
		//	num++;
		//	temp=temp.getNext();
			//return 1+temp.findWagon(val);
		//}
		//System.out.println(val);
		//System.out.println(temp.getValue());
		
		while(!temp.getValue().equals(val)) {
			//System.out.println(temp.getValue());
			if(temp.getNext()==null) {
				return -1;
			} else {			
				num++;
				//System.out.println(num);
				//if(!temp.equals(val)) {			//still not working, doesn't like the recursion thang i tried here
					//return 1+temp.findWagon(val);
					temp=temp.getNext();
					//ntemp.findWagon(val);
					//System.out.println(temp.getValue());
				//}
			}
		}
		//System.out.println("done");
		return num;
		//Wagon<T> temp2;
		//boolean equal=false;
		//int num=0;
		//while(!equal) {
		//while(temp.getNext()!=null) {
		//	if(temp.equals(val)) {
						
		//	} else {
		//		temp=temp.getNext();
		//		num++;
		//	}
			
		//}
		
		//if(num>0) {
		//	return num;
		//} else {
		//	return -1;
		//}
				
	} //end findWagon
	
}

