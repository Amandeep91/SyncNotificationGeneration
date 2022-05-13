package com.Sync.Notification.api.service;

import java.time.LocalDate;
import java.util.List;
import org.springframework.stereotype.Service;

import com.Sync.Notification.api.entity.NotifyHistory;
import com.Sync.Notification.api.entity.ResponseStatus;

@Service
public interface CommonService {

	public ResponseStatus<List<NotifyHistory>> GetNotificationService() throws Exception;

	public List<NotifyHistory> GetNotificationServiceList();
	
	public ResponseStatus<List<NotifyHistory>> GetNotificationService(LocalDate date) throws Exception;
}
