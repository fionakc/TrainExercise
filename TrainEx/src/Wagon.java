
public class Wagon <Q>{ 					//v

	private Q value; 						//v
	private Wagon<Q> next;  				//v
	
	public Wagon (Q val, Wagon<Q> nxt) { 	//v
		value=val;							//v
		next=nxt;							//v
	
	}										//v
	
	public Wagon (Wagon<Q> q) {
		value=q.value;
		next=q.next;
	}
	
	//3. Add a method insertAfter to Wagon that allows coupling a new Wagon after this Wagon, 
	//and before the following Wagon. Ensure that all the Wagons are still part of the train afterwards. 
	//That is, if there are Wagons connected A -> B -> C -> D, B.insertAfter(X) should leave 
	//Wagons connected A -> B -> X -> C -> D.
	public void insertAfter(Wagon<Q> X) { 	//v 
		X.next=this.next;					//v	
		this.next=X;						//v
				
	}

	public Q getValue() {
		return value;
	}

	public void setValue(Q value) {
		this.value = value;
	}

	public Wagon<Q> getNext() {
		return next;
	}

	public void setNext(Wagon<Q> next) {
		this.next = next;
	} 
	
	//6. Add a method int size() to Wagon that gives the size of the chain of Wagons starting from this one. 
	//That is, it returns one more than the size of the chain starting from the next Wagon, 
	//and when there is no next Wagon it returns 1.
	
	public int size() {		
		
		if(this.next==null) {				//v using recursion
			return 1;						//v
		} else {							//v
			return 1+ this.next.size();		//v
		}									//v
		
		
	//	int num=1;
	//	Wagon<Q> temp=next;
	//	Wagon<Q> temp2;
	//	while(temp!=null) {
	//		num++;
	//		temp2=temp.next;
	//		temp=temp2;
	//	}
	//	return num;
		
	}
	
}
