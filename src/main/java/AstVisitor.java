
import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.core.dom.*;

public class AstVisitor extends ASTVisitor {

	public boolean DEBUG;
	
	List<MethodDeclaration> methods = new ArrayList<MethodDeclaration>();

	@Override
	public boolean visit(MethodDeclaration node) {
		methods.add(node);
		return super.visit(node);
	}

	public List<MethodDeclaration> getMethods() {
		return methods;
	}
}
