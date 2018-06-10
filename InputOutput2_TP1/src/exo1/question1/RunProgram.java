package exo1.question1;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

public class RunProgram {

	public static void main(String[] args) throws IOException {
		ProgramReader pr = new ProgramReader();
		Reader instructions = new StringReader("ADD 3 ADD 5 \n MULT 2 PRINT SET V1 ADD V1 PRINT PRINTVAR V1");
		Program prog = pr.readProgram(instructions);
		Context context = new Context();
		prog.evaluate(context);
	}
}
