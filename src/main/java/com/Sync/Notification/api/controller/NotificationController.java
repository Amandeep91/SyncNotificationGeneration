package com.Sync.Notification.api.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Sync.Notification.api.entity.NotifyHistory;
import com.Sync.Notification.api.entity.ResponseStatus;
import com.Sync.Notification.api.service.CommonService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("api/notification")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class NotificationController {

	@Autowired
	private CommonService commonService;

//	@GetMapping(value = "/getNotification")
//	public ResponseEntity<ResponseStatus<List<NotifyHistory>>> GetNotificationDetail() throws Exception {
//
//		ResponseStatus<List<NotifyHistory>> responseStatus = new ResponseStatus<List<NotifyHistory>>();
//		try {
//			responseStatus = this.commonService.GetNotificationService();
//			return new ResponseEntity<ResponseStatus<List<NotifyHistory>>>(responseStatus, (HttpStatus.OK));
//		} catch (Exception e) {
//			e.printStackTrace();
//			log.error("exception occured while calling in CommonApiController method GetNotificationDetail(): "
//					+ e.getMessage());
//			return new ResponseEntity<ResponseStatus<List<NotifyHistory>>>(HttpStatus.BAD_REQUEST);
//		}
//	}
//
//	@GetMapping(value = "/getNotificationList")
//	public List<NotifyHistory> GetNotificationDetailList() {
//		return commonService.GetNotificationServiceList();
//
//	}

	@GetMapping(value = "/getNotification/{NotificationDate}")
	public ResponseEntity<ResponseStatus<List<NotifyHistory>>> GetNotificationDetail(
			@PathVariable("NotificationDate") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) throws Exception {

		ResponseStatus<List<NotifyHistory>> responseStatus = new ResponseStatus<List<NotifyHistory>>();
		try {
			responseStatus = this.commonService.GetNotificationService(date);
			return new ResponseEntity<ResponseStatus<List<NotifyHistory>>>(responseStatus, (HttpStatus.OK));
		} catch (Exception e) {
			e.printStackTrace();
			log.error("exception occured while calling in CommonApiController method GetNotificationDetail(): "
					+ e.getMessage());
			return new ResponseEntity<ResponseStatus<List<NotifyHistory>>>(HttpStatus.BAD_REQUEST);
		}
	}
}
