

import java.io.File;

import polyglot.ast.Node;
import polyglot.frontend.SourceJob;
import polyglot.visit.NodeVisitor;
import soot.Scene;
import soot.javaToJimple.ppa.PPAEngine;
import soot.javaToJimple.ppa.jj.PPAExtensionInfo;
import soot.options.Options;

public class SimpleAST {

private final static String RT_CLASSPATH = "java-rt-jar-stubs-1.5.0.jar";
	
	private final static String SRC_CLASSPATH = "examples/src/";
	
	private final static String CLASS_TO_ANALYZE = "test.ppa.C";
	
	private final static String OUTPUT_DIR = "examples/output";
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scene scene = null;
		Options opt = Options.v();
		String classpath = RT_CLASSPATH + File.pathSeparator + SRC_CLASSPATH;
		opt.set_allow_phantom_refs(true);
		opt.set_output_format(Options.output_format_jimple);
		opt.set_output_dir(OUTPUT_DIR);
		opt.set_src_prec(Options.src_prec_java);
		opt.set_soot_classpath(classpath);
		opt.classes().add(CLASS_TO_ANALYZE);
		scene = Scene.v();
		scene.loadNecessaryClasses();
		
		PPAExtensionInfo ppaInfo = PPAEngine.v().getExtensionInfo();
		for (Object oJob : ppaInfo.sourceJobMap().values()) {
			SourceJob sJob = (SourceJob) oJob;
			Node node = sJob.ast();
			PrintVisitor visitor = new PrintVisitor();
			node.visit(visitor);
		}
	}
	
}

class PrintVisitor extends NodeVisitor {

	@Override
	public Node leave(Node old, Node n, NodeVisitor v) {
		System.out.println(n.getClass().toString());
		return super.leave(old, n, v);
	}
	
}
