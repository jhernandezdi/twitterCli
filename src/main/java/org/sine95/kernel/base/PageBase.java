package org.sine95.kernel.base;

import java.util.Iterator;
import java.util.List;
import java.util.function.Function;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@SuppressWarnings("unused")
public class PageBase<T> implements org.springframework.data.domain.Page<T> {
	
	private int totalElements;
	private int maxElementsPerPage;
	private int page;
	private List<T> lista;
	
	

	public PageBase(int totalElements, int maxElementsPerPage, int page, List<T> lista) {
		super();
		this.totalElements = totalElements;
		this.maxElementsPerPage = maxElementsPerPage;
		this.page = page;
		this.lista = lista;
	}

	@Override
	public int getNumber() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getSize() {
		
		return 0;
	}

	@Override
	public int getNumberOfElements() {
		
		return lista.size();
	}

	@Override
	public List<T> getContent() {
		
		return lista;
	}

	@Override
	public boolean hasContent() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Sort getSort() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isFirst() {
		// TODO Auto-generated method stub
		return page==0;
	}

	@Override
	public boolean isLast() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean hasPrevious() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Pageable nextPageable() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pageable previousPageable() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<T> iterator() {
		
		return lista.iterator();
	}

	@Override
	public int getTotalPages() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long getTotalElements() {
		
		return totalElements;
	}

	@Override
	public <U> Page<U> map(Function<? super T, ? extends U> converter) {
		// TODO Auto-generated method stub
		return null;
	}

}
