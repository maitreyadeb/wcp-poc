package com.wcp.ProjectDeliverable.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.wcp.ProjectDeliverable.Model.ChangesModel;

@Repository
public interface ChangesRepo extends CrudRepository<ChangesModel,Integer>  {

}
