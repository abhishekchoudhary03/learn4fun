package ac.search.orchestrator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import ac.search.controller.ISearchResult;
import ac.search.controller.SearchController;
import ac.search.types.KeywordSearch;
import ac.search.types.NERSearch;
import ac.search.types.SnippetSearch;

/**
 * @author abhishek.choudhary
 *
 */

public class SearchOrchestrator {
	private List<SearchController> fSearchControllers;
	
	public SearchOrchestrator() {
		fSearchControllers = new ArrayList<SearchController>();
		fSearchControllers.add(new NERSearch());
		fSearchControllers.add(new SnippetSearch());
		fSearchControllers.add(new KeywordSearch());
		
	}
	
	public Stream<ISearchResult> search(String term) {
		List<ISearchResult> results = new ArrayList<ISearchResult>();
		for(SearchController sc : fSearchControllers) {
			sc.initialize(term);
			sc.start();
//			TODO: look for a method in WorkerThread which returns result after completion of thread execution
			results.add(sc.getSearchResult());
		}
		return boostAndRank(results);
	}
	
	public Stream<ISearchResult> boostAndRank(List<ISearchResult> res) {
		//TODO call Boost and Rank API
		return res.stream();
	}
}
