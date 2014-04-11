


public class Evaluation {
	public boolean setqFlag = false;
	public int index;
	public String eval(STree cell, Setq setq, int indexE){
		index = indexE;
		int value = 0;
		int flag = 0;
		String ans;
		STree car = new STree();
		car = cell;
		while (cell.value.equals("Nil") != true) {
			if(cell.value.equals("car")){
				cell.value = eval(cell.car,setq,index);
			}else{
				if(cell.value.equals("setq")) setqFlag = true;
				if(index > 0 && setqFlag != true){
					for(int i = 0; i < index; i++){
						if(setq.symbol.get(i).equals(cell.value)){
							cell.value = setq.value.get(i);
						}
					}
				}
			}
			cell = cell.cdr;
		}
		setqFlag = false;
		cell = car.cdr;
		switch (car.value) {
		case "Nil":
			return "NIL";

		case "+":
			value = 0;
			while(cell.value.equals("Nil") != true){
				value = value + Integer.parseInt(cell.value);
				cell = cell.cdr;
			}
			break;
		case "-":
			value = Integer.parseInt(cell.value);
			cell = cell.cdr;
			while(cell.value.equals("Nil") != true){
				value = value - Integer.parseInt(cell.value);
				cell = cell.cdr;
			}
			break;
		case "*":
			value = 1;
			while(cell.value.equals("Nil") != true){
				value = value * Integer.parseInt(cell.value);
				cell = cell.cdr;
			}
			break;
		case "/":
			value = Integer.parseInt(cell.value);
			cell = cell.cdr;
			while(cell.value.equals("Nil") != true){
				value = value / Integer.parseInt(cell.value);
				cell = cell.cdr;
			}
			break;
		case "=":
			while(cell.cdr.value.equals("Nil") != true){
				if(cell.value.equals(cell.cdr.value) != true) flag = 1;
				cell = cell.cdr;
			}
			if(flag == 0){
				return "T";
			}else{
				return "NIL";
			}
		case "/=":
			while(cell.cdr.value.equals("Nil") != true){
				if(cell.value.equals(cell.cdr.value) != true) flag = 1;
				cell = cell.cdr;
			}
			if(flag == 0){
				return "NIL";
			}else{
				return "T";
			}
		case "<":
			while(cell.cdr.value.equals("Nil") != true){
				if(Integer.parseInt(cell.value) >= Integer.parseInt(cell.cdr.value)) flag =1;
				cell = cell.cdr;
			}
			if(flag == 0){
				return "T";
			}else{
				return "NIL";
			}
		case ">":
			while(cell.cdr.value.equals("Nil") != true){
				if(Integer.parseInt(cell.value) <= Integer.parseInt(cell.cdr.value)) flag =1;
				cell = cell.cdr;
			}
			if(flag == 0){
				return "T";
			}else{
				return "NIL";
			}
		case "<=":
			while(cell.cdr.value.equals("Nil") != true){
				if(Integer.parseInt(cell.value) > Integer.parseInt(cell.cdr.value)) flag =1;
				cell = cell.cdr;
			}
			if(flag == 0){
				return "T";
			}else{
				return "NIL";
			}
		case ">=":
			while(cell.cdr.value.equals("Nil") != true){
				if(Integer.parseInt(cell.value) < Integer.parseInt(cell.cdr.value)) flag =1;
				cell = cell.cdr;
			}
			if(flag == 0){
				return "T";
			}else{
				return "NIL";
			}
		case "if":
			if(cell.value.equals("Nil")) return "ERROR";
			if(cell.cdr.value.equals("Nil")) return "ERROR";
			if(cell.value.equals("NIL")){
				ans = cell.cdr.cdr.value;
			}else{
				ans = cell.cdr.value;
			}
			while(cell.cdr.value.equals("Nil") != true){
				cell = cell.cdr;
			}
			return ans;
		case "setq":
			if(cell.value.equals("Nil")) return "ERROR";
			if(cell.cdr.value.equals("Nil")) return "ERROR";
			if(cell.cdr.cdr.value.equals("Nil") != true) return "ERROR";
			if(index > 0){
				for(int i = 0; i < index; i++){
					if(setq.symbol.get(i).equals(cell.value)){
						setq.value.set(i, cell.cdr.value);
						return setq.value.get(i);
					}
				}
			}
			setq.setq(cell.value,cell.cdr.value);
			index++;
			cell = cell.cdr.cdr;
			
			return setq.value.get(index-1);
			
		default:
			break;
//			return "ERROR";
		}
		return String.valueOf(value);
	}

}
