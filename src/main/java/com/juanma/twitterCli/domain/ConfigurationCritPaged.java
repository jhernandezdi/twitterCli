
package com.juanma.twitterCli.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;


////START_{Import}
////END_{Import}
@SuppressWarnings("unused")
 public class ConfigurationCritPaged extends ConfigurationCrit implements Pageable, Serializable {
   private static final long serialVersionUID = 1L;
   
   private int offset;
   private int page;
   private int pageNumber;
   private int pageSize;
   private boolean paged;
   private boolean unpaged; 
   private int size;
   private Sort sort;

	@Override
	public int getPageNumber() {
	   return pageNumber;
	}
	
	@Override
	public int getPageSize() {
		return pageSize;
	}
	
	@Override
	public long getOffset() {
		return offset;
	}
	
	@Override
	public Sort getSort() {
		return sort;
	}
	
	@Override
	public Pageable next() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Pageable previousOrFirst() {
		return null;
	}
	
	@Override
	public Pageable first() {
		return null;
	}
	
	@Override
	public boolean hasPrevious() {
		return false;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public boolean isPaged() {
		return paged;
	}

	public void setPaged(boolean paged) {
		this.paged = paged;
	}

	public boolean isUnpaged() {
		return unpaged;
	}

	public void setUnpaged(boolean unpaged) {
		this.unpaged = unpaged;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public void setSort(String [] sOrders) {
		Sort.Order order;
		List<Sort.Order> orders = new ArrayList<Sort.Order>();
		for (String o : sOrders){
			String [] parts = o.split(",");
			String field = parts[0];
			String dir = parts[1];
			order = new Sort.Order(Sort.Direction.fromString(dir),field);
			orders.add(order);
		}
		this.sort = Sort.by(orders);
	}
	
	public String toString()
	{
		return "ConfigurationCritPaged{ "+super.toString()+
			", Pageable{" +
			"pagesize = " + getPageSize() + 
			", pagenumber = " + getPageNumber() + 
			", offset = " + getOffset() +
			", size = " + getSize() +
			", sort = " + getSort() + 
			", page = " + getPage() + 
			"}}";  
	}
	
	public ConfigurationCritPaged()
	{
		super();
	}
	
	public ConfigurationCrit getCrit()
	{
		return this;
	}

	public Pageable getPag()
	{
		PageRequest pr = PageRequest.of(getPage(), getSize(), getSort());
		return pr;
	}
}

