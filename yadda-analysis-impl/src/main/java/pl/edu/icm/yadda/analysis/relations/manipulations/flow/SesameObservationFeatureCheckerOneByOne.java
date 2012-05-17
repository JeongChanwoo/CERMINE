//package pl.edu.icm.yadda.analysis.relations.manipulations.flow;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.OutputStream;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.List;
//
//import org.openrdf.repository.Repository;
//import org.openrdf.repository.sail.SailRepository;
//import org.openrdf.sail.nativerdf.NativeStore;
//
//import pl.edu.icm.yadda.analysis.relations.manipulations.manipulators.SesameManipulator;
//import pl.edu.icm.yadda.analysis.relations.manipulations.operations._3ObservationsFeatureChecker;
//import pl.edu.icm.yadda.analysis.relations.manipulations.operations._4Observations2CSV;
//import pl.edu.icm.yadda.analysis.relations.pj.auxil.PJDisambiguator;
//import pl.edu.icm.yadda.analysis.relations.pj.clues.PJEmailPrefixClue;
//import pl.edu.icm.yadda.analysis.relations.pj.proofs.PJEmailProof;
//
//public class SesameObservationFeatureCheckerOneByOne {
//
//	static SesameManipulator m2, m3;
////	static String filePath2 = "/home/pdendek/sample/repo_v4";
//	static String filePath2 = "/tmp/repo_v4_7670225395728";
//	static Repository repository; 
//	
//	public static void setUp() throws Exception {		
//		File dstFolder = new File("/tmp/repo_v4_7670225395728_"+System.nanoTime());
//		dstFolder.mkdirs();
//		copyFolder(new File(filePath2),dstFolder);
//	
//		NativeStore store=new NativeStore(dstFolder);		
//		SailRepository rep=new SailRepository(store);
//		rep.initialize();
//		repository=rep;
//		m2 = new SesameManipulator(repository, new _3ObservationsFeatureChecker());
//		m3 = new SesameManipulator(repository, new _4Observations2CSV());
//	}
//
//	public static void main(String[] args) throws Exception {
//		
//		System.out.println("start: "+new Date());
//		
//		setUp();
//		
//		try {
//			Exception e;
//			
//			HashMap<String,Object> hm = new HashMap<String,Object>();
//			List<PJDisambiguator> pjdislist = new ArrayList<PJDisambiguator>();
//			hm.put("disambiguatorList", pjdislist);
//			
//			System.out.println("first feature: "+new Date());
//			
//			PJEmailProof f0 = new PJEmailProof();
//			f0.setRepository(repository);
//			pjdislist.add(f0);
//			e = (Exception) m2.execute(hm);
//			if(e!=null) throw e;
//			
//			System.out.println("second feature: "+new Date());
//			
//			hm.clear();
//			PJEmailPrefixClue f1 = new PJEmailPrefixClue();
//			f1.setRepository(repository);
//			pjdislist.add(f1);
//			e = (Exception) m2.execute(hm);
//			if(e!=null) throw e;
//			
//			System.out.println("5 start: "+new Date());
//			
//			hm.clear();
//			hm.put("featureNum", 2);
//			hm.put("csvFilePath", "/tmp/repo_v4.csv");
//			e = (Exception) m3.execute(hm);
//			if(e!=null) throw e;
//			
//			System.out.println("stop: "+new Date());
//			
//		} catch (Exception e) {
//		}
//	}
//	
//	
//	public static void copyFolder(File src, File dest) throws IOException{
//
//		if(src.isDirectory()){
//	
//			//if directory not exists, create it
//			if(!dest.exists()){
//			   dest.mkdir();
//			   System.out.println("Directory copied from " 
//	                          + src + "  to " + dest);
//			}
//	
//			//list all the directory contents
//			String files[] = src.list();
//	
//			for (String file : files) {
//			   //construct the src and dest file structure
//			   File srcFile = new File(src, file);
//			   File destFile = new File(dest, file);
//			   //recursive copy
//			   copyFolder(srcFile,destFile);
//			}
//	
//		}else{
//			//if file, then copy it
//			//Use bytes stream to support all file types
//			InputStream in = new FileInputStream(src);
//		        OutputStream out = new FileOutputStream(dest); 
//	
//		        byte[] buffer = new byte[1024];
//	
//		        int length;
//		        //copy the file content in bytes 
//		        while ((length = in.read(buffer)) > 0){
//		    	   out.write(buffer, 0, length);
//		        }
//	
//		        in.close();
//		        out.close();
//		        System.out.println("File copied from " + src + " to " + dest);
//		}
//	}
//}
