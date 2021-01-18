package iterator;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import javax.persistence.EntityManager;

import com.example.demo.model.Employee;

public class JpaIterator implements Iterable<Employee>{
	private  EntityManager entityManager;
	@Override
	public Iterator<Employee> iterator() {
		
		return iterator(100);
	}

	
	
	 public Iterator<Employee> iterator(int batchSize) {
		    return new EmployeeIterator(batchSize);
		  }
	 
	 
	 private class EmployeeIterator implements Iterator<Employee> {
		    private final int pageSize;

		    private int firstResult = 0;
		    private Iterator<Employee> employeeIterator;

		    EmployeeIterator(int pageSize) {
		      this.pageSize = pageSize;
		    }

		    @Override
		    public boolean hasNext() {
		      if(employeeIterator == null || !employeeIterator.hasNext()) {
		        loadNextPage();
		      }

		      return employeeIterator.hasNext();
		    }

		    @Override
		    public Employee next() {
		      if(!hasNext()) {
		        throw new NoSuchElementException("No more elements");
		      }
		      return employeeIterator.next();
		    }

		    private void loadNextPage() {
		      final List<Employee> Page = entityManager
		        .createQuery("from Product order by id", Employee.class)
		        .setFirstResult(firstResult)
		        .setMaxResults(pageSize)
		        .getResultList();

		      firstResult += Page.size();
		      employeeIterator = Page.iterator();
		    }
		  }


}
