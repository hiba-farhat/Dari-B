package tn.dari.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.dari.spring.entity.Notification;
import tn.dari.spring.repository.NotificationRepository;

@Service
public class NotificationServiceImpl implements NotificationService  {
	@Autowired
	NotificationRepository NotificationRepository;

	@Override
	public List<Notification> retrieveAllNotifications() {
		return (List<Notification>) NotificationRepository.findAll();
		
	}

	@Override
	public Notification addNotification(Notification n) {
		return NotificationRepository.save(n);
	}

	@Override
	public void deleteNotification(Long id) {
		NotificationRepository.deleteById(id);
	}

	@Override
	public Notification updateNotification(Notification n,Long id) {
		return NotificationRepository.save(n);
	}

	@Override
	public Notification retrieveNotification(Long id) {
		Notification n=  NotificationRepository.findById(id).get();
		return n;
	}

	@Override
	public long countNotification() {
		// TODO Auto-generated method stub
		return 0;
	}



}
