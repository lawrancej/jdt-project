import java.util.Map;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;

class Main implements IApplication {
	public static void main(String[] args) throws CoreException {
		
		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		IProject project = root.getProject("folly");
		project.create(null);
		project.open(null);
	}

	@Override
	public Object start(IApplicationContext context) throws Exception {
		System.out.println("Hello World!");
		final Map args = context.getArguments();
		final String[] appArgs = (String[]) args.get("application.args");
		main(appArgs);
		// TODO Auto-generated method stub
		return IApplication.EXIT_OK;
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub
		
	}
}
