package ppa;



import java.util.Iterator;
import java.util.List;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Set;

import soot.Body;
import soot.SootClass;
import soot.SootMethod;
import soot.Unit;
import soot.jimple.parser.*;
import soot.toolkits.graph.ExceptionalUnitGraph;
import soot.toolkits.graph.UnitGraph;
import soot.jimple.internal.JInvokeStmt;
import soot.tagkit.LineNumberTag;


/* Given a jimple code it can find the invokeStmt */
public class AnalyzeJimpleCode {
	public static void main(String args[]) {
		String file_location = "/home/islamazhar/eclipse-workspace/PPA/src/test.ppa.C.jimple";
		FileInputStream aJIS;
		try {
			aJIS = new FileInputStream(new File(file_location));
			JimpleAST jimpleAST = new JimpleAST(aJIS);
			SootClass soot_class = jimpleAST.createSootClass();
			List methods = soot_class.getMethods();
			Iterator it = methods.iterator();
			/*
			while (it.hasNext()) {
				final SootMethod method = (SootMethod) it.next();
				System.out.println(method);
				Body initBody  = jimpleAST.getBody(method);
				System.out.println(initBody);
			}
			*/
			SootClass sClass = soot_class;
			for (Object oMethod : methods) {
				SootMethod sMethod = (SootMethod) oMethod;
				
				for (Object oUnit : sMethod.retrieveActiveBody().getUnits()) {
					Unit unit = (Unit) oUnit; // this unit interface is implemented by ASTifElseNode, ASTifNode, ASTMethodNode.. etc.
					if (unit.getClass() == JInvokeStmt.class) {
						//System.out.println(unit.getClass());
						//System.out.println("  " + unit.toString());
						// this a unit
						//String classString = stmt.getInvokeExpr().getClass().toString();
						//System.out.println("Method signature is "+ sMethod.getSignature());
						JInvokeStmt jInvokStmt = (JInvokeStmt) unit;
						List arguments = jInvokStmt.getInvokeExpr().getUseBoxes();
						//System.out.println(arguments);
						//System.out.println("Tags --> " + jInvokStmt.getTags());
						//System.out.println("Tags --> " + unit.getTags());
						
						//System.out.println(jInvokStmt.getInvokeExpr());
						// How can I get the line number: Do I need to keep the line number while generating the Jimple code..caz right now there is not gets LineNumberTag 
						// u.getTag("LineNumberTag");
						//  I have generated the Jimple using command line I need to do this using code... Look at Sazzad vai code on how he generats the jimple code...
						/*
						 * soot.Main.main(new String[]
					      {
					      "--keep-line-number", // other options you need in your analysis
					      "-p", "jb",  "use-original-names:true" //phase options
					      });
						 */
						/*
						 * java -jar ppa_0.1.jar -src-prec java -f jimple -allow-phantom-refs -d examples/output -cp rt.jar:examples/src test.ppa.A
						 */
						if (arguments.size() > 2) {
							System.out.println(arguments.get(1));
							System.out.println(arguments.get(2));
							System.out.println("==========================");
							/*
							 *  SecretKeySpec sks = new SecretKeySpec("MyDifficultPassw".getBytes(),"AES");
          						Cipher cipher = Cipher.getInstance("AES");
          						
          						SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
                				Cipher cipher = Cipher.getInstance("AES");
							 */
							
						}		
					}
				}
				//break;
			}
			
			//System.out.println(methods[1]);
			//jimpleAST.getBody()
			/*
			SootClass soot_class = jimpleAST.createSootClass();
			//jimpleAST.getSkeleton(soot_class);
			//System.out.println(soot_class);
			List methods = soot_class.getMethods();
			Iterator it = methods.iterator();
			
			while (it.hasNext()) {
				final SootMethod method = (SootMethod) it.next();
				Body initBody  = jimpleAST.getBody(method);
				UnitGraph graph = new ExceptionalUnitGraph(initBody);
				if(graph != null) { 
					System.out.println(graph);
				}
				
				for (Object aGraph : graph) {
					System.out.println(aGraph);
				}
				
			}
			*/
			/*
			for (String method: methods) {
				System.out.println(jimpleAST.getBody(cst));
			}
			//System.out.println(jimpleAST.getCstPool());
			//String[] methods = soot_class.getMethods();
			*/
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
