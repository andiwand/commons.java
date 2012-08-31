package at.andiwand.common.math.graph;

public abstract class AbstractHypergraph<V, E extends AbstractHyperedge> extends
		AbstractGraph<V, E> implements Hypergraph<V, E> {
	
	public boolean removeAllEdges(E edge) {
		return removeEdge(edge);
	}
	
}