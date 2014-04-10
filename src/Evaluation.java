

public class Evaluation {
	public int value = 0;
	public String eval(STree cell){
		int carFlag = 0;
		STree car = new STree();
		car = cell;
		while (cell.value.equals("Nil") != true) {
			if(cell.value.equals("car")){
				eval(cell.car);
				carFlag++;
			}
			if(carFlag == 0) cell = cell.cdr;
			
		}
		cell = car.cdr;
		switch (car.value) {
		case "+":
			while(cell.value.equals("Nil") != true){
				value = value + Integer.parseInt(cell.value);;
				cell = cell.cdr;
			}
			break;
		case "-":
			
			break;
		case "*":
			
			break;
		case "/":
			
			break;
			
		default:
			break;
		}
		car.value = String.valueOf(value);
		return car.value;
	}

}
