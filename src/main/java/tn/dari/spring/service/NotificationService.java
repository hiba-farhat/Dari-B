package tn.dari.spring.service;

import java.util.List;

import tn.dari.spring.entity.Notification;

public interface NotificationService {	
	
		List<Notification> retrieveAllNotifications();

		Notification addNotification(Notification n);

		void deleteNotification(Long id);
		
		Notification updateNotification(Notification n, Long id );
		
		Notification retrieveNotification(Long id);
		long countNotification();

}
