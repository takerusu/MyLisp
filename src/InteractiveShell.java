import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InteractiveShell {

	public void main() throws IOException {
		String s;
		Setq setq = new Setq();
		Defun defun = new Defun();
		boolean defunFlag = false;
		int index = 0;
		do {
			BufferedReader input = new BufferedReader(new InputStreamReader(
					System.in));
			s = input.readLine();
			if (s.isEmpty())
				break;
			Tokenizer tn = new Tokenizer(s);
			tn.lAnalysis();
			Parser p = new Parser(tn.listCode);
			p.sAnalysis(p.cell, 0);
			Evaluator evaluator = new Evaluator();
			String eval = evaluator.eval(p.cell, setq, index, defun, defunFlag);
			index = evaluator.index;
			System.out.println(eval);
		} while (true);

	}
}
