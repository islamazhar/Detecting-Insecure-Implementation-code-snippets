package ppa;

import polyglot.ast.Node;
import polyglot.ast.Stmt;
import polyglot.frontend.SourceJob;
import polyglot.visit.NodeVisitor;
import soot.Body;
import soot.BodyTransformer;
import soot.PackManager;
import soot.Scene;
import soot.SootClass;
import soot.Transform;
import soot.Unit;
import soot.javaToJimple.ppa.PPAEngine;
import soot.javaToJimple.ppa.jj.PPAExtensionInfo;
import soot.jimple.internal.JIfStmt;
import soot.jimple.internal.JInvokeStmt;
import soot.options.Options;
import soot.tagkit.AbstractHost;
import soot.tagkit.LineNumberTag;

// import org.eclipse.jdt.core.dom.PPAEngine;

import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import soot.BodyTransformer;




public class CreateJimpleFromSource extends BodyTransformer{

private final static String RT_CLASSPATH = "/home/islamazhar/eclipse-workspace/jar_files/java-rt-jar-stubs-1.5.0.jar";
	
	private final static String SRC_CLASSPATH = "/home/islamazhar/eclipse-workspace/PPA/src/";
	
	//private final static String CLASS_TO_ANALYZE = "ppa.HelloThread";
	private final static String CLASS_TO_ANALYZE = "examples.usingHTTP.class_131";
	
	private final static String OUTPUT_DIR = "examples/output";
	
	/**
	 * @param args
	 */
	public static void main(String[] args)  {
		Scene scene = null;
		Options opt = Options.v();
		String classpath = RT_CLASSPATH + File.pathSeparator + SRC_CLASSPATH;
		opt.set_allow_phantom_refs(true);
		opt.set_output_format(Options.output_format_jimple);
		opt.set_output_dir(OUTPUT_DIR);
		opt.set_src_prec(Options.src_prec_java);
		opt.set_soot_classpath(classpath);
		opt.set_keep_line_number(true);
		opt.classes().add(CLASS_TO_ANALYZE);
		scene = Scene.v();
		scene.loadNecessaryClasses();
		
		
		//System.out.println(scene);
		/*
		PPAExtensionInfo ppaInfo = PPAEngine.v().getExtensionInfo();
		
		for (Object oJob : ppaInfo.sourceJobMap().values()) {
			SourceJob sJob = (SourceJob) oJob;
			Node node = sJob.ast();
			PrintVisitor visitor = new PrintVisitor();
			node.visit(visitor);
		}
	//	*/
		/*
		CreateJimpleFromSource analysis = new CreateJimpleFromSource();
        PackManager.v().getPack("jtp").add(new Transform("jtp.TestSoot", analysis));
        
      //load and set main class
        Options.v().set_app(true);
        String mainclass = "HelloThread";
        SootClass appclass = Scene.v().loadClassAndSupport(mainclass);
       
        Scene.v().loadNecessaryClasses();
		*/
        //start working
		CreateJimpleFromSource analysis = new CreateJimpleFromSource();
		PackManager.v().getPack("jtp").add(new Transform("jtp.TestSoot", analysis));
		
		Options.v().set_app(true);
		SootClass appclass = Scene.v().loadClassAndSupport(CLASS_TO_ANALYZE);
		scene.setMainClass(appclass);
		PackManager.v().runPacks();
		// getting heSoot class of interests...
		
		
	}
	@Override
	protected void internalTransform(Body b, String phaseName, Map options) {
			Iterator<Unit> it = b.getUnits().snapshotIterator();
		    while(it.hasNext()){
		    	Object stmt = it.next();
		    	//System.out.println(it.next().getClass());
		    	//System.out.println(stmt.toString());
		    //	System.out.println(stmt.getClass());
		    	System.out.println(stmt);
		    	/*
		    	if (stmt.getClass() == JInvokeStmt.class) {
		    		JInvokeStmt jInvokStmt = (JInvokeStmt) stmt;
		    		//System.out.println(jInvokStmt.toString());
		    		
		    		List arguments = jInvokStmt.getInvokeExpr().getUseBoxes();
		    		
		    		if (arguments.size() > 1) {
		    			//System.out.println(arguments);
		    			System.out.println(stmt);
		    			if (((AbstractHost) stmt).hasTag("LineNumberTag")) {
		    				LineNumberTag tag = (LineNumberTag) ((AbstractHost) stmt).getTag(("LineNumberTag"));
		    				System.out.println(tag + "Hello ");
		    			}
		    			else {
		    				System.out.println(((AbstractHost) stmt).getTags());
		    				//System.out.println("Has no line numbers");
		    			}
						System.out.println(arguments.get(0));
					//	System.out.println(arguments.get(2));
					//	System.out.println("==========================");
						
					}
		    	}
		    	*/
		    }
	}
}