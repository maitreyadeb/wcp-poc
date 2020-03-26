package com.wcp.ProjectDeliverable.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.wcp.ProjectDeliverable.Model.ChangesModel;

@Repository
public interface ChangesRepo extends JpaRepository<ChangesModel,Integer>  {

	List<ChangesModel> findByCrNumberContaining(String crNumber);
	List<ChangesModel> findByBrdNumberContaining(String brdNumber);

}
