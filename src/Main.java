


public class Main {

	public static void main(String[] args) {
		
		String s ="(setq x 12) "
				+ "(defun tak (x y z) (if (<= x y) y (tak (tak (- x 1) y z) (tak (- y 1) z x) (tak (- z 1) x y))))"
				+ " (tak x 6 0)";
		Lisp lisp = new Lisp();
		lisp.lisp(s);
	}
		
		
		


}


//"(defun fib (n) (if (< n 3) 1 (+ (fib (- n 1)) (fib (- n 2)))) ) (fib 25)"

//"(defun fib (n) (if (< n 3) 1 (+ (fib (- n 1)) (fib (- n 2)))) ) (fib 36)"




//"(defun test (x y) (+ x y)) (test 1 2)"

//"(defun test2 (n) (if (< n 3) 3 ( + (test2 (- n 1)) (test2 (- n 2)))) ) "
//+ "(test2 3) "