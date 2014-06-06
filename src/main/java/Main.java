import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.kohsuke.args4j.Argument;
import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;


class Main  {
	@Argument
	private List<String> folders = new ArrayList<String>();

	EclipseAstParser parser = new EclipseAstParser();

	public void visitFile(File f) throws IOException {
		if (f.isDirectory()) {
			for (File child : f.listFiles()) {
				visitFile(child);
			}
		}
		if (f.getName().endsWith(".java")) {
			AstVisitor v = parser.visitFile(f);
			for (MethodDeclaration method : v.methods)
				System.out.format("%s: %s\n", f.getName(), method.getName());
		}
	}

	public void doMain(String[] args) throws CmdLineException, IOException {
		CmdLineParser argParser = new CmdLineParser(this);
		argParser.parseArgument(args);

		for (String folder : folders) {
			visitFile(new File(folder));
		}
		System.out.println("hi?");
	}
	public static void main(String[] args) throws IOException, CmdLineException {
		new Main().doMain(args);
	}
}
