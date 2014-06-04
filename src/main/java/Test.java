import java.io.File;
import java.io.IOException;

import org.eclipse.jdt.core.dom.MethodDeclaration;


public class Test {
	public static void main(String[] args) throws IOException {
		EclipseAstParser parser = new EclipseAstParser();
		File file = new File(System.getProperty("user.home") + "/projects/folly/src/main/java/EclipseAstParser.java");
		AstVisitor v = parser.visitFile(file);
		for (MethodDeclaration method : v.methods)
			System.out.println(method.getName());
		System.out.println("hi");
	}
}
