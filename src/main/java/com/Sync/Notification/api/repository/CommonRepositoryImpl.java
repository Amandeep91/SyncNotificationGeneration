package com.Sync.Notification.api.repository;

import java.time.LocalDate;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Sync.Notification.api.entity.NotifyHistory;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
@Transactional
public class CommonRepositoryImpl implements CommonRepository {

	@Autowired
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<NotifyHistory> GetNotificationRepo() throws Exception {
		List<NotifyHistory> projectTypedetail;

		try {

			StoredProcedureQuery query = entityManager.createStoredProcedureQuery("usp_Get_Notification_Result",NotifyHistory.class);

			projectTypedetail = query.getResultList();

			if (projectTypedetail != null && projectTypedetail.size() > 0) {
				log.info("Sync Notification data found.");
				System.out.println(projectTypedetail.get(0));
			} else {
				log.info("Sync Notification data not found.");
			}

		} catch (Exception e) {
			e.printStackTrace();
			log.error("Error in CommonRepositoryImpl=" + e.getMessage() + "");
			throw new Exception("Exception occured while calling method GetProjectTypeRepo() in CommonRepositoryImpl.");
		}
		return projectTypedetail;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<NotifyHistory> GetNotificationByDateRepo(LocalDate date) throws Exception {
		List<NotifyHistory> projectTypedetail;

		try {

			StoredProcedureQuery query = entityManager.createStoredProcedureQuery("usp_Get_Notification_Result", NotifyHistory.class);
			query.registerStoredProcedureParameter("pDate_Entered", LocalDate.class, ParameterMode.IN);
			query.setParameter("pDate_Entered", date);
			projectTypedetail = query.getResultList();

			if (projectTypedetail != null && projectTypedetail.size() > 0) {
				log.info("Sync Notification data found.");
				System.out.println(projectTypedetail.get(0));
			} else {
				log.info("Sync Notification data not found.");
			}

		} catch (Exception e) {
			e.printStackTrace();
			log.error("Error in CommonRepositoryImpl=" + e.getMessage() + "");
			throw new Exception("Exception occured while calling method GetProjectTypeRepo() in CommonRepositoryImpl.");
		}
		return projectTypedetail;
	}
}
