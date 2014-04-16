import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class InteractiveShell {

	public static void main(String[] args) throws IOException {
		String s;
		do{
			BufferedReader input =new BufferedReader(new InputStreamReader(System.in));
			s = input.readLine();
			if(s.equals("end")) break;
			
		}while(true);

	}
}

