import java.util.HashMap;

class DoLoop extends Statement
{
	Statement statement;
	Expr expr;

	DoLoop(Statement s, Expr e)
	{
		statement = s;
		expr = e;
	}

	void printParseTree(String indent)
	{
		String indent1 = indent + " ";
		String indent2 = indent + "  ";
		
		super.printParseTree(indent);
		IO.displayln(indent1 + indent1.length() + " <do loop>");
		IO.displayln(indent2 + indent2.length() + " do");
		statement.printParseTree(indent2);
		IO.displayln(indent2 + indent2.length() + " while");
		expr.printParseTree(indent2);
	}

	@Override
	Val Eval(HashMap<String, Val> state) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	void emitInstructions() {
		// TODO Auto-generated method stub
		Compiler.varlabel++;
		IO.displayln(Compiler.varlabel+" :");

		statement.emitInstructions();

		expr.emitInstructions();	
		IO.displayln(Compiler.indent + "ifF goto "+Compiler.varlabel);

		IO.displayln(Compiler.varlabel+" :");
		

	}	
}

