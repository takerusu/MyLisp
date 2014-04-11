import java.util.ArrayList;


public class Setq {
	public ArrayList<String> symbol = new ArrayList<String>();
	public ArrayList<String> value = new ArrayList<String>();;
	
	public Setq(){
		
	}
	public void setq(String symbol,String value){
		this.symbol.add(symbol);
		this.value.add(value);
		
	}
}
