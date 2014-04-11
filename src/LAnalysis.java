import java.util.ArrayList;


public class LAnalysis {

	public String lcode;
	public int index = 0;
	public ArrayList<String> listCode = new ArrayList<String>();

	public LAnalysis(String lcode){
		this.lcode = lcode;
	}

	public void lAnalysis(){
		while (index < lcode.length()) {
			int letter = 0;
			int pflag = 0;
				while (lcode.charAt(index) != ' ') {
					letter++;
					index++;
					if(index >= lcode.length()) break;
					if(lcode.charAt(index-1) == '(') {
						pflag++;
						break;
					}
					if(lcode.charAt(index) == ')') {
						pflag++;
						break;
					}
				}
		if(letter != 0) listCode.add(lcode.substring(index-letter, index));
			if(pflag==0) index++;
		}
		listCode.add("EOF");
	}
	
}
