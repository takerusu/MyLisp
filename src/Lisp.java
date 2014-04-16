import java.util.ArrayList;


public class Lisp {

	public int lisp(String s){
		int index = 0;
		int sanum = 0;
		
		Tokenizer tn = new Tokenizer(s);
		tn.lAnalysis();
		
		for (int i = 0; i < tn.listCode.size(); i++) {
			System.out.print(tn.listCode.get(i) + " ");
		}
		System.out.println();
		
		ArrayList<Parser> saArrayList = new ArrayList<Parser>();
		do{
			Parser p = new Parser(tn.listCode);
			index = p.sAnalysis(p.cell, index)+1;
			if(index == -1) return -1;
			saArrayList.add(p);
			sanum++;
			
		}while(tn.listCode.get(index).equals("EOF") != true);
		int indexE = 0;
		Setq setq = new Setq();
		Defun defun = new Defun();
		boolean defunFlag = false;
		for(int i = 0; i < sanum; i++){

			Evaluator evaluator = new Evaluator();
			String eval = evaluator.eval(saArrayList.get(i).cell,setq,indexE,defun,defunFlag);
			indexE = evaluator.index;
			System.out.println(eval);
		}
		
		
		
		
		return 0;
		
	}
}
