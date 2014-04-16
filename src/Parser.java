import java.util.ArrayList;


public class Parser {

	public int index = 0;
	ArrayList<String> listCode = new ArrayList<String>();
	STree cell = new STree();
	public Parser(ArrayList<String> listCode){
		this.listCode = listCode;
	}
	public int sAnalysis(STree cell,int index){
		if(listCode.get(index).equals("(") != true && index == 0){
			return -1;
		}
		index++;
		while(listCode.get(index).equals(")") != true){
			if(index >= listCode.size()) break;
			if(listCode.get(index).equals("(")){
				cell.value = "car";
				STree car = new STree("car");
				STree cdr = new STree();
				cell.car = car;
				index = sAnalysis(cell.car, index);
				cell.cdr = cdr;
				cell = cell.cdr;
			}else{
				cell.value = listCode.get(index);
				STree cdr = new STree();
				cell.cdr = cdr;
				cell = cell.cdr;
			}
			index++;
		}
		cell.value = "Nil";
		return index;
	}
}
