package tn.dari.spring.controller;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import tn.dari.spring.service.NotificationService;
import tn.dari.spring.entity.Notification;
import tn.dari.spring.entity.favoris;


@RestController
@RequestMapping("/Notification")
@Api(tags="Gestion des Notifications")
public class NotifRestControl {
	
	@Autowired
	NotificationService NotificationService;
	
	//URL : http://localhost:8081/SpringMVC/Notification/retrieve-all-Notifications
		@GetMapping("/retrieve-all-Notifications")
		public List<Notification> retrieveAllNotifications() {
			List<Notification> list = NotificationService.retrieveAllNotifications();
			return list;
		}
	
	//URL : http://localhost:8081/SpringMVC/Notification/add-Notifications
	@ResponseBody
	@PostMapping("/add-Notifications")
	public Notification addNotifications(@RequestBody Notification n) {
		return NotificationService.addNotification(n);
	}
	// public int add(@RequestBody NotificationType nottype , @RequestParam("userid") Long userId, @RequestParam("appid") Long appointmentId){
	    //    notificationService.add(nottype,appointmentId,userId);
	      //  return 1;
	  //  }

	
	// URL : http://Localhost:8081/SpringMVC/Notification/updateNotification/{id}
		@PutMapping("/updateNotification/{id}")
		public Notification updateNotification(@RequestBody Notification n, @PathVariable("id") Long id) {
			return NotificationService.updateNotification(n, id);
		}
		//URL : http://localhost:8081/SpringMVC/Notification/delete-Notifications
	@DeleteMapping("/delete-Notifications/{id}")
	public void deleteNotifications(@PathVariable("id") Long id) {
		NotificationService.deleteNotification(id);
	}
	//URL : http://localhost:8081/SpringMVC/Notification/numberOfNotification
			@GetMapping("/numberOfNotification")
		    @ResponseBody
		    public Long countNotification() {
		    	Long countNotification= NotificationService.countNotification() ;
		    	return countNotification;
		    }
	//http://localhost:8081/SpringMVC/Notification/retrieveNotification/{id}
		@GetMapping("/retrieveNotification/{id}")
		@ResponseBody
		public Notification retrieveNotification(@PathVariable("id") Long id) {
			return NotificationService.retrieveNotification(id);
		}
		// @PutMapping("/readNotification")
		   // public Notification read(@RequestParam("id") int id){
		      //  Notification notification = notifRep.findById(id).get();
		        //NotificationService.read(notification);
		     //   return notification;
		   // }
}

