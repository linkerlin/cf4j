package cf4j.algorithms.knn.itemToItem.neighbors;

import cf4j.data.DataModel;
import cf4j.data.TestItem;
import cf4j.process.TestItemsPartible;

/**
 * <p>This abstracts class calculates the neighbors of each test item. If you want to compute
 * your own algorithm to compute item neighbors, you must extend this class and redefine 
 * neighbors method.</p>
 * 
 * <p>Neighbors are store at every test item map with the key <b>"neighbors"</b>. This key
 * points to an array of integers containing the indexes of the items that are neighbors of 
 * the test item.</p>
 * 
 * @author Fernando Ortega
 */
public abstract class ItemNeighbors implements TestItemsPartible {

	/**
	 * Number of neighbors to be calculated
	 */
	protected int k;
	
	/**
	 * Class constructor
	 * @param k Number of neighbors to calculate
	 */
	public ItemNeighbors (int k) {
		this.k = k;
	}
	
	@Override
	public void beforeRun() { }

	@Override
	public void run (int testItemIndex) {
		TestItem testItem = DataModel.getInstance().getTestItemByIndex(testItemIndex);
		int [] neighbors = this.neighbors(testItem);
		testItem.setNeighbors(neighbors);
	}

	@Override
	public void afterRun() { }
	
	/**
	 * Computes neighbors of a test item.
	 * @param testItem Active item
	 * @return Array of integer with indexes of the training items that are neighbors
	 *     of the active item. Fill with -1 if there is not more neighbors.  
	 */
	public abstract int [] neighbors (TestItem testItem);
}