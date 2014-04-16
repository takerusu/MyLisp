import java.util.ArrayList;




public class Evaluator {
	public boolean setqFlag = false;
	public int index;
	public String eval(STree cell, Setq setq, int indexE, Defun defun, Boolean defunFlag){
		index = indexE;
		int value = 0;
		int flag = 0;
		String ans;
		STree car = new STree();
		car = cell;
		
		while (cell.value.equals("Nil") != true && cell.value.equals("if") != true) {
			if(cell.value.equals("defun")){				//defun 定義
				cell = cell.cdr;
				if(cell.value.equals("Nil")) return "ERROR";
				if(cell.cdr.value.equals("car") != true) return "ERROR";
				if(cell.cdr.cdr.value.equals("car") != true) return "ERROR";
				if(cell.cdr.cdr.cdr.value.equals("Nil") != true) return "ERROR";
				defun.name.add(cell.value);
				cell = cell.cdr;
				STree loopCell = new STree();
				loopCell = cell.car;
				ArrayList<String> thisSymbol = new ArrayList<String>();
				while(loopCell.value.equals("Nil") != true){
					thisSymbol.add(loopCell.value);
					loopCell = loopCell.cdr;
				}
				defun.symbol.add(thisSymbol);
				cell = cell.cdr;
				defun.cell.add(cell);
				
				return defun.name.get(defun.name.size()-1);
				
			}else if(cell.value.equals("car")){
				cell.value = eval(cell.car,setq,index,defun,defunFlag);
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
		if( cell.value.equals("if")){
			cell.cdr.value = eval(cell.cdr.car,setq,index,defun,defunFlag);
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
				if(cell.cdr.cdr.value.equals("car")){
					ans = eval(cell.cdr.cdr,setq,index,defun,false);
				}else{
					ans = cell.cdr.cdr.value;
				}
			}else{
				if(cell.cdr.value.equals("car")){
					ans = eval(cell.cdr,setq,index,defun,false);
				}else{
					ans = cell.cdr.value;
				}
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
			if(defunFlag == false){
				if(defun.name.size() == 0) return "ERROR";
				for(int i = 0; i < defun.name.size(); i++){
					if(car.value.equals(defun.name.get(i))){
						defunFlag = true;
						STree loopCell = new STree();
						loopCell = cell;
						ArrayList<String> thisValue = new ArrayList<String>();
						for (int j = 0; j < defun.symbol.get(i).size(); j++) {
							if(loopCell.value.equals("Nil")) return "ERROR";
							thisValue.add(loopCell.value);
							loopCell = loopCell.cdr;
						}
						STree defunCell = new STree();
						defunCell = (STree)defun.cell.get(i).clone();
						cell = defunCell;
						cell.cdr = loopCell;
						STree loopCellFirst = new STree();
						loopCell = cell.car;
						loopCellFirst = cell.car;
						changeValue(loopCell, i, defun, thisValue);
						cell.car = loopCellFirst;
					}
				}
				if(defunFlag){
					return cell.value = eval(cell.car,setq,index,defun,true);
				}else{
					return car.value;
				}
				
			}
			return "car";
//			return "ERROR";
		}
		return String.valueOf(value);
	}
	
	public void changeValue(STree loopCell,int i, Defun defun, ArrayList<String> thisValue){
		while(loopCell.value.equals("Nil") != true){
			if(loopCell.value.equals("car")){
				changeValue(loopCell.car, i, defun, thisValue);
			}else{
				for(int k = 0; k < defun.symbol.get(i).size(); k++){
					if(defun.symbol.get(i).get(k).equals(loopCell.value)){
						loopCell.value = thisValue.get(k);
					}
				}
			}
			loopCell = loopCell.cdr;
		}
		
	}
	
//	public int searchFunc(STree cell ,Defun defun){
//		STree startCell = new STree();
//		startCell = cell;
//		while (cell.cdr.value.equals("Nil") != true) {
//			if(cell.cdr.value.equals("car")){
//				searchFunc(cell.cdr.car,defun);
//			}else{
//				for(int i = 0; i < defun.name.size(); i++){
//					if(cell.cdr.value.equals(defun.name.get(i))){
//						STree loopCell = new STree();
//						loopCell = cell.cdr.cdr.car;
//						ArrayList<String> thisValue = new ArrayList<String>();
//						for (int j = 0; j < defun.symbol.get(i).size(); j++) {
//							if(loopCell.value.equals("Nil")) return -1;
//							thisValue.add(loopCell.value);
//							loopCell = loopCell.cdr;
//						}
//						cell.cdr = loopCell;
//						cell.car = defun.cell;
//						
//					}
//					
//				}
//			}
//		}
//
//	}

}
