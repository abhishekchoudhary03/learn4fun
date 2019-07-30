/**
 * 
 */
package ac.search.controller;

import ac.worker.WorkerThread;

/**
 * @author abhishek.choudhary
 *
 */
public abstract class SearchController extends WorkerThread {
	protected ISearchResult fResult;
	private String fTerm;
	public final void initialize(String term) {
		fTerm = term;
	}
	@Override
	public final void start() {
		super.start();
	}

	@Override
	public final void run() {
		try {
			executeSearch(fTerm);
		} catch (Exception e) {
			
		} finally {
			terminated();
		}
		
	}
	
	protected abstract void executeSearch(String term);

	private void terminated() {
		
	}
	
	public ISearchResult getSearchResult() {
		return fResult;
	}
}
