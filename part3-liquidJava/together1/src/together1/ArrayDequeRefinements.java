package together1;

import repair.regen.specification.ExternalRefinementsFor;
import repair.regen.specification.Ghost;
import repair.regen.specification.Refinement;
import repair.regen.specification.StateRefinement;

@ExternalRefinementsFor("java.util.ArrayDeque")
@Ghost("int size")
public interface ArrayDequeRefinements<E> {

	public void ArrayDeque();

	@StateRefinement(to="size(this) == (size(old(this)) + 1)")
	public boolean add(E elem);

	@StateRefinement(to="size(this) == (size(old(this)) + 1)")
	public boolean offerFirst(E elem);

	@StateRefinement(from="size(this) > 0", to = "size(this) == (size(old(this)))")
	public E getFirst();

	@StateRefinement(from="size(this) > 0", to = "size(this) == (size(old(this)))")
	public E getLast();

	@StateRefinement(from="size(this)> 0", to="size(this) == (size(old(this)) - 1)")
	public void remove();

	@StateRefinement(from="size(this)> 0", to="size(this) == (size(old(this)) - 1)")
	public E pop();

	@Refinement("_ == size(this)")
	public int size();

	@Refinement("_ == (size(this) <= 0)")
	public boolean isEmpty();

}
