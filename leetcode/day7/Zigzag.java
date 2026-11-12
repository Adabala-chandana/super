package day7;

public class Zigzag {
public String convert(String s, int numRows) {
	 StringBuilder[] rows = new StringBuilder[numRows];
	int presentArray=0;
	boolean down= true;
	boolean up = false;
	 for (int i = 0; i < numRows; i++) {
        rows[i] = new StringBuilder();
    }
	for(char c:s.toCharArray()) {
       if (numRows == 1 || numRows >= s.length()) {
          return s;
         }
		rows[presentArray].append(c);
		if(presentArray == numRows-1)
		{
			up=true;
			down=false;
		}
		if(presentArray == 0)
		{
			down=true;
			up=false;
		}
		if(down) {
			presentArray++;
		}
		if(up) {
			presentArray--;
		}	
	}
	 StringBuilder result = new StringBuilder();

    for (StringBuilder row : rows) {
        result.append(row);
    }

    return result.toString(); 
}
}
