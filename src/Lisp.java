import java.util.ArrayList;


public class Lisp {

	public int lisp(String s){
		int index = 0;
		int sanum = 0;
		
		LAnalysis la = new LAnalysis(s);
		la.lAnalysis();
		
		for (int i = 0; i < la.listCode.size(); i++) {
			System.out.print(la.listCode.get(i) + " ");
		}
		System.out.println();
		
		ArrayList<SAnalysis> saArrayList = new ArrayList<SAnalysis>();
		do{
			SAnalysis sa = new SAnalysis(la.listCode);
			index = sa.sAnalysis(sa.cell, index)+1;
			if(index == -1) return -1;
			saArrayList.add(sa);
			sanum++;
			
		}while(la.listCode.get(index).equals("EOF") != true);
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
