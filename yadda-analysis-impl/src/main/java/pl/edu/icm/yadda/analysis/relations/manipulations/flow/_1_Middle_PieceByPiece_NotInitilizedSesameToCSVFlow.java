//package pl.edu.icm.yadda.analysis.relations.manipulations.flow;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.OutputStream;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.List;
//
//import org.openrdf.repository.Repository;
//import org.openrdf.repository.RepositoryException;
//import org.openrdf.repository.sail.SailRepository;
//import org.openrdf.rio.RDFFormat;
//import org.openrdf.rio.RDFHandlerException;
//import org.openrdf.rio.RDFWriter;
//import org.openrdf.rio.Rio;
//import org.openrdf.sail.nativerdf.NativeStore;
//
//import pl.edu.icm.yadda.analysis.relations.constants.RelConstants;
//import pl.edu.icm.yadda.analysis.relations.manipulations.manipulators.SesameManipulator;
//import pl.edu.icm.yadda.analysis.relations.manipulations.operations._1_PieceByPiece_ShardContribution2Observations;
//import pl.edu.icm.yadda.analysis.relations.manipulations.operations._2AreTheSameBooleanInitializer;
//import pl.edu.icm.yadda.analysis.relations.manipulations.operations._3ObservationsFeatureChecker;
//import pl.edu.icm.yadda.analysis.relations.manipulations.operations._4aPArtOfObservations2CSV;
//import pl.edu.icm.yadda.analysis.relations.pj.auxil.PJDisambiguator;
//import pl.edu.icm.yadda.analysis.relations.pj.clues_occurence.Feature1Email;
//import pl.edu.icm.yadda.analysis.relations.pj.clues_occurence.Feature2EmailPrefix;
//import pl.edu.icm.yadda.analysis.relations.pj.clues_occurence.Feature3CoContribution;
//import pl.edu.icm.yadda.analysis.relations.pj.clues_occurence.Feature4CoClassif;
//import pl.edu.icm.yadda.analysis.relations.pj.clues_occurence.Feature5CoKeywordWords;
//import pl.edu.icm.yadda.analysis.relations.pj.clues_occurence.Feature6CoReference;
//import pl.edu.icm.yadda.analysis.relations.pj.clues_occurence.Feature8Year;
//
//public class _1_Middle_PieceByPiece_NotInitilizedSesameToCSVFlow {
//
//	static int which = 0;
//	static SesameManipulator 
////	m0a,
//	m1a,m1b,m2, m3;
//	static String filePath2 = "/home/pdendek/repo_with_initialized_observations/";
//	static Repository repository; 
//	
//	public static void main(String[] args) throws Exception {
//		
//		System.out.println("start: "+new Date());
//		
//		try {
//			Exception e;
//			
////			e = (Exception) m0a.execute(null);
////			if(e!=null) throw e;
//			
//			
//			
//			Object obj = m1a.execute(null);
//			if(obj instanceof Exception){
//				if(obj!=null) throw (Exception)obj;
//			}
//			Repository[] reps = (Repository[]) obj;
//			
//			for(int i=0; i<reps.length;i++){
//				repository = reps[i];
//				which = 0;
//				List<PJDisambiguator> list = initializeList();
//				System.out.println("Rozpoczynam "+i+"/"+reps.length+" 100tys obserwacji. "+new Date());
//				HashMap<String,Object> hm = new HashMap<String,Object>();
//				for(PJDisambiguator d : list){
//					re_initRepository();
//					System.out.println("Rozpoczynam "+which+"/"+list.size()+" petle wskazowkowa. "+new Date());
//					
//					hm.clear();
//					hm.put("disambiguatorList", Arrays.asList(d));
//				
//					System.out.println("Zaczynam rozszerzanie repa o wskazowke. "+new Date());
//					
//					e = (Exception) m2.execute(hm);
//					if(e!=null) throw e;
//					
//					System.out.println("Eksportuje zmienione repozytorium do N3. "+new Date());
//					exportRepoToN3(repository,"/tmp/repo_s"+i+"."+which+".N3");
//					
//					System.out.println("Eksportuje zmienione repozytorium do CSV. "+new Date());
//					hm.clear();
//					hm.put("featureText",RelConstants.RL_OBSERVATION_FEATURE+0); 
//					hm.put("csvFilePath", "/tmp/repo_s"+i+"."+which+".csv");
//					e = (Exception) m3.execute(hm);
//					if(e!=null) throw e;
//				}
//				System.out.println("Skonczylem cechy - przechodze do wyliczania  "+new Date());
//				hm.clear();
//				hm.put("featureText",RelConstants.RL_OBSERVATION_CONTAINS_SAME_PERSON); 
//				hm.put("csvFilePath", "/tmp/repo_s"+i+".same.csv");
//				e = (Exception) m3.execute(hm);
//				if(e!=null) throw e;
//			}
//			System.out.println("stop: "+new Date());			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//	
//	
//	private static List<PJDisambiguator> initializeList() {
//		List<PJDisambiguator> pjdislist = new ArrayList<PJDisambiguator>();
//
//		PJDisambiguator f = new Feature1Email();
//		f.setRepository(repository);
//		pjdislist.add(f);
//
//		f = new Feature2EmailPrefix();
//		f.setRepository(repository);
//		pjdislist.add(f);
//		
//		f = new Feature3CoContribution();
//		f.setRepository(repository);
//		pjdislist.add(f);;
//		
//		f = new Feature4CoClassif();
//		f.setRepository(repository);
//		pjdislist.add(f);
//		
////		f = new Feature5CoKeywordPhrase();
////		f.setRepository(repository);
////		pjdislist.add(f);
//		
//		f = new Feature5CoKeywordWords();
//		f.setRepository(repository);
//		pjdislist.add(f);
//		
//		f = new Feature6CoReference();
//		f.setRepository(repository);
//		pjdislist.add(f);
//		
//		f = new Feature8Year();
//		f.setRepository(repository);
//		pjdislist.add(f);
//		
//		return pjdislist;
//	}
//
//
//	public static void copyFolder(File src, File dest) throws IOException{
//		if(src.isDirectory()){
//			if(!dest.exists()){
//			   dest.mkdir();
//			   System.out.println("Directory copied from " 
//	                          + src + "  to " + dest);
//			}
//			String files[] = src.list();
//			for (String file : files) {
//			   File srcFile = new File(src, file);
//			   File destFile = new File(dest, file);
//			   copyFolder(srcFile,destFile);
//			}
//		}else{
//			InputStream in = new FileInputStream(src);
//		        OutputStream out = new FileOutputStream(dest); 
//		        byte[] buffer = new byte[1024];
//		        int length; 
//		        while ((length = in.read(buffer)) > 0){
//		    	   out.write(buffer, 0, length);
//		        }
//		        in.close();
//		        out.close();
//		        System.out.println("File copied from " + src + " to " + dest);
//		}
//	}
//	
//	public static void exportRepoToN3(Repository rep, String filePath) throws RepositoryException, FileNotFoundException, RDFHandlerException{
//		File repoFile = new File(filePath);
//		FileOutputStream fosRepo = new FileOutputStream(repoFile);
//		RDFWriter repoWriter = Rio.createWriter(RDFFormat.N3, fosRepo);
//		rep.getConnection().export(repoWriter);
//	}
//	
//	public static void re_initRepository() throws Exception {
//		which++;
//		File dstFolder = new File("/tmp/repo_destiny_part_"+which+"_"+System.nanoTime());
//		dstFolder.mkdirs();
//		copyFolder(new File(filePath2),dstFolder);
//		NativeStore store=new NativeStore(dstFolder);	
//		SailRepository rep=new SailRepository(store);
//		rep.initialize();
//		repository=rep;
//		rep.getConnection().setAutoCommit(false);
////		m0a = new SesameManipulator(repository, new MultipleEmailRemover());
//		m1a = new SesameManipulator(repository, new _1_PieceByPiece_ShardContribution2Observations());
//		m1b = new SesameManipulator(repository, new _2AreTheSameBooleanInitializer());
//		m2 = new SesameManipulator(repository, new _3ObservationsFeatureChecker());
//		m3 = new SesameManipulator(repository, new _4aPArtOfObservations2CSV());
//	}
//	
//	public static int div(int shards, int division){
//		if(shards%division==0) return shards/division;
//		else return shards/division+1;
//	}
//}
//

