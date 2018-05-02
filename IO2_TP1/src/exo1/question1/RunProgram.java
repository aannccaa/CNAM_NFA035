package exo1.question1;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

public class RunProgram {

	public static void main(String[] args) throws IOException {
		ProgramReader pr = new ProgramReader();
		Reader instructions = new StringReader("ADD 3 ADD 5 \n MULT 2 PRINT");
		pr.readProgram(instructions);
		Program prog = pr.getProgram();
		Context context = new Context();
		prog.evaluate(context);
		
		
	}
}
