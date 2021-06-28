package org.sine95.kernel.base.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface RepositoryBase<T extends Object,ID> extends JpaRepository<T, ID>, QueryByExampleExecutor<T>,JpaSpecificationExecutor<T> {

}
