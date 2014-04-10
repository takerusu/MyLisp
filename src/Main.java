
public class Main {

	public static void main(String[] args) {
		LAnalysis la = new LAnalysis("(+ 2 3 (+ 3 4))");
		la.lAnalysis();
		
		for (int i = 0; i < la.listCode.size(); i++) {
			System.out.print(la.listCode.get(i) + " ");
		}
		
		SAnalysis sa = new SAnalysis(la.listCode);
		sa.sAnalysis(sa.cell, 0);
		Evaluation evaluation = new Evaluation();
		String s = evaluation.eval(sa.cell);
		System.out.println(s);

	}

}
