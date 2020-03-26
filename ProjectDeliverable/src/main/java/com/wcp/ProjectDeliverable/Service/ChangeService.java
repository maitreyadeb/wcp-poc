package com.wcp.ProjectDeliverable.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.wcp.ProjectDeliverable.Model.ChangesModel;
import com.wcp.ProjectDeliverable.Repository.ChangesRepo;
import com.wcp.ProjectDeliverable.TransferObject.ChangesTO;

@Service
public class ChangeService extends UtilService {
	
	@Autowired
	ChangesRepo changesRepo;
	
	@Autowired
	ChangesModel changesModel;
		
	public void addChanges(ChangesTO changesTo) {
		changesModel.setCrNumber(changesTo.getCrNumber());
		changesModel.setBrdNumber(changesTo.getBrdNumber());
		changesModel.setCrDescription(changesTo.getCrDescription());
		changesModel.setAuthorName(changesTo.getAuthorName());
		changesModel.setCrCreationTime(UtilService.getDate().toString());
		changesRepo.save(changesModel);
	}

	public List<ChangesModel> addChanges() {
		List<ChangesModel>  listChanges = (List<ChangesModel>) this.changesRepo.findAll();
		return listChanges;
	}
	
	
	

}
