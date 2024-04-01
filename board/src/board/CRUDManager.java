package board;

public interface CRUDManager<T> {
	public void create(T element);
	public void read(T element);
	public void update(T element);
	public void delete(T element);
}
