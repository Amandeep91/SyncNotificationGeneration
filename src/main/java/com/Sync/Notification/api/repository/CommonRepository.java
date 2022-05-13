package com.Sync.Notification.api.repository;

import java.time.LocalDate;
import java.util.List;
import org.springframework.stereotype.Repository;

import com.Sync.Notification.api.entity.NotifyHistory;

@Repository
public interface CommonRepository {

	public List<NotifyHistory> GetNotificationRepo() throws Exception;
	
	public List<NotifyHistory> GetNotificationByDateRepo(LocalDate date) throws Exception;
}
