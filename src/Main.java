
public class Main {

	public static void main(String[] args) {
		String s = "(defun test (x y) (+ x  y)) (defun test2 (x y) (- x  y)) (+ (test 2 3) (test2 5 4))";
		Lisp lisp = new Lisp();
		lisp.lisp(s);


	}

}
