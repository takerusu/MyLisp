
public class STree implements Cloneable {
	public String value;
	public STree car;
	public STree cdr;
	
	public STree(){
		
	}
	public STree(String value){
		this.value = value;
	}
	
	public STree(STree car, STree cdr){
		this.car = car;
		this.cdr = cdr;
	}
	
	public Object clone(){
		STree myself = this;
		STree clone = new STree();
		STree firstClone = new STree();
		firstClone = clone;
		while(myself.value.equals("Nil") != true){
			if(myself.value.equals("car")){
				clone.value = myself.value;
				STree car = new STree();
				car = (STree)myself.car.clone();
				clone.car = car;
				STree cdr = new STree();
				clone.cdr = cdr;
				clone = clone.cdr;
			}else{
				clone.value = myself.value;
				STree cdr = new STree();
				cdr.value = myself.cdr.value;
				clone.cdr = cdr;
				clone = clone.cdr;
			}
			myself = myself.cdr;
		}
		clone.value = myself.value;
		return firstClone;
		
	}

}
