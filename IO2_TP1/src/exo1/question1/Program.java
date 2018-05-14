package exo1.question1;

import java.util.ArrayList;
import java.util.List;

public class Program {
	List<Command> commands;

	public Program() {
		this.commands = new ArrayList<>();
	}

	public void add(Command c) {
		this.commands.add(c);
	}

	public void evaluate(Context context) {
		for (Command c : this.commands) {
			c.executer(context);
		}
	}

}
