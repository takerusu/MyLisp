
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
	
/*	public Object clone(){
		try{
			new STree((STree)car.clone(), (STree)cdr.clone());
			
		}catch(CloneNotSupportedException e){
			throw new InternalError(e.toString());
		}
	}*/

}
