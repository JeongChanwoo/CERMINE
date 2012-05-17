package pl.edu.icm.yadda.analysis.relations.pj.clues_occurence;

import java.util.HashSet;

import pl.edu.icm.yadda.analysis.relations.constants.RelConstants;


public class Feature7CoISSN extends AggregateDisambiguator{

	@Override
	public String id() {
		return "co-issn";
	}

	@Override
	protected void initializeQuery(String c1, String c2) {
		askWho = "issn";
		
		queryString[0] = "" +
		" 			SELECT issn " +
	    " 			FROM " +
	    "				{doc1} <"+RelConstants.RL_HAS_CONTRIBUTOR+"> {<"+c1+">}," +
	    "				{doc1} <"+RelConstants.RL_HAS_ISSN+"> {issn}" +	    
		"";
	    
	    
		queryString[1] = "" +
		" 			SELECT issn " +
	    " 			FROM " +
	    "				{doc2} <"+RelConstants.RL_HAS_CONTRIBUTOR+"> {<"+c2+">}," +
	    "				{doc2} <"+RelConstants.RL_HAS_ISSN+"> {issn}" +	    
		"";
	}

	@Override
	protected String postprocess(String prefix, HashSet<String> emails) {
		emails.add(prefix);
		return prefix;
	}
}
