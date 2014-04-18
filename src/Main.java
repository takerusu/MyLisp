import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {

		File file = null;
		if (args.length != 0) {
			file = new File(args[0]);
			String str = " ";
			if (file != null) {
				try {
					BufferedReader br = new BufferedReader(new FileReader(file));
					String toRead = br.readLine();
					while (toRead != null) {
						str = str + toRead + " ";
						toRead = br.readLine();
					}
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			// String s =
			// "(defun fib (n) (if (< n 3) 1 (+ (fib (- n 1)) (fib (- n 2)))) ) (fib 25)";
			if (!str.equals(" ")) {
				Lisp lisp = new Lisp();
				lisp.lisp(str);
			}
		} else {
			InteractiveShell is = new InteractiveShell();
			is.main();
		}
	}

}

// "(defun fib (n) (if (< n 3) 1 (+ (fib (- n 1)) (fib (- n 2)))) ) (fib 36)"

// "(defun tak (x y z) (if (<= x y) y (tak (tak (- x 1) y z) (tak (- y 1) z x) (tak (- z 1) x y))))"
// + " (tak 12 6 0)"

// "(defun test (x y) (+ x y)) (test 1 2)"

// "(defun test2 (n) (if (< n 3) 3 ( + (test2 (- n 1)) (test2 (- n 2)))) ) "
// + "(test2 3) "