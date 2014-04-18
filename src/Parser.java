import java.util.ArrayList;


public class Parser {

	public int index = 0;
	ArrayList<String> listCode = new ArrayList<String>();
	ConsCell cell = new ConsCell();
	public Parser(ArrayList<String> listCode){
		this.listCode = listCode;
	}
	public int sAnalysis(ConsCell cell,int index){
		if(listCode.get(index).equals("(") != true && index == 0){
			return -1;
		}
		index++;
		while(listCode.get(index).equals(")") != true){
			if(index >= listCode.size()) break;
			if(listCode.get(index).equals("(")){
				cell.value = "car";
				ConsCell car = new ConsCell("car");
				ConsCell cdr = new ConsCell();
				cell.car = car;
				index = sAnalysis(cell.car, index);
				cell.cdr = cdr;
				cell = cell.cdr;
			}else{
				cell.value = listCode.get(index);
				ConsCell cdr = new ConsCell();
				cell.cdr = cdr;
				cell = cell.cdr;
			}
			index++;
		}
		cell.value = "Nil";
		return index;
	}
}
