
public class Main {

	public static void main(String[] args) {
		String s = "(setq x 3) (setq y 5) (setq x 8) (+  3 x y)";
		Lisp lisp = new Lisp();
		lisp.lisp(s);


	}

}
