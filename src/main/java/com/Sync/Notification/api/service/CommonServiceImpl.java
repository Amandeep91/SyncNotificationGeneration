package com.Sync.Notification.api.service;

import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Sync.Notification.api.entity.NotifyHistory;
import com.Sync.Notification.api.entity.ResponseStatus;
import com.Sync.Notification.api.repository.CommonRepository;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CommonServiceImpl implements CommonService {

	@Autowired
	private CommonRepository commonRepository;

	@Override
	public ResponseStatus<List<NotifyHistory>> GetNotificationService() throws Exception {
		ResponseStatus<List<NotifyHistory>> responseStatus = new ResponseStatus<List<NotifyHistory>>();
		List<NotifyHistory> projectTypeDetails;

		try {
			projectTypeDetails = commonRepository.GetNotificationRepo();
			responseStatus.setBody(projectTypeDetails);
			responseStatus.setStatus(true);
			responseStatus.setDescription("Success");
		} catch (Exception e) {
			e.printStackTrace();
			log.error("exception occured while calling in CommonServiceImpl method GetNotificationService(): "
					+ e.getMessage());
			responseStatus.setStatus(false);
			responseStatus.setDescription(e.getMessage());
			responseStatus.setBody(null);
			throw new Exception("GetNotificationService failed.");
		}
		return responseStatus;
	}

	@Override
	public List<NotifyHistory> GetNotificationServiceList() {
		List<NotifyHistory> notificationServiceList;
		try {
			notificationServiceList = commonRepository.GetNotificationRepo();
			return notificationServiceList;

		} catch (Exception e) {
			log.error("Something went wrong in getting all inventory items" + e.getMessage());
		}
		return null;
	}

	@Override
	public ResponseStatus<List<NotifyHistory>> GetNotificationService(LocalDate date) throws Exception {
		ResponseStatus<List<NotifyHistory>> responseStatus = new ResponseStatus<List<NotifyHistory>>();
		List<NotifyHistory> projectTypeDetails;

		try {
			projectTypeDetails = commonRepository.GetNotificationByDateRepo(date);
			responseStatus.setBody(projectTypeDetails);
			responseStatus.setStatus(true);
			responseStatus.setDescription("Success");
		} catch (Exception e) {
			e.printStackTrace();
			log.error("exception occured while calling in CommonServiceImpl method GetNotificationService(): "
					+ e.getMessage());
			responseStatus.setStatus(false);
			responseStatus.setDescription(e.getMessage());
			responseStatus.setBody(null);
			throw new Exception("GetNotificationService failed.");
		}
		return responseStatus;
	}
}
