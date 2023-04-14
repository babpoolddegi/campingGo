package com.example.camping.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.camping.model.Booking;
import com.example.camping.repository.BookingRepository;

@Service
public class BookingService {

	@Autowired
	private BookingRepository bookingRepository;
	
//	@Transactional
//	public  List<Booking> findById(Long num) {
//		 @SuppressWarnings("unchecked")
//		List<Booking> booking = (List<Booking>) bookingRepository.findById(num).get();
//		return booking;
//	}
	
	public void insert(Booking booking) {
		SimpleDateFormat sdfYMD = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date check_in = sdfYMD.parse(booking.getCheck_in());
			Date check_out = sdfYMD.parse(booking.getCheck_out());
			
			long diff = check_out.getTime() - check_in.getTime();
			
			TimeUnit time = TimeUnit.DAYS; 
		    long diffrence = time.convert(diff, TimeUnit.MILLISECONDS);
		    System.out.println("The difference in days is : "+diffrence);
		    booking.setDayCnt(diffrence);
			
		} catch (ParseException e) {
			e.printStackTrace();
		} 
		bookingRepository.save(booking);	
	}
	
	public List<Booking> list(Long member_id){
		
		return bookingRepository.findByMember(member_id);
	}
	
	public int count(Long member_id) {
		return bookingRepository.findByCount(member_id);
	}
	
	public List<Booking> alist(){
		return bookingRepository.findAll();
	}
	
	public Long acount() {
		return bookingRepository.count();
	}
	
	@Transactional
	public void update(Booking booking) {
		Booking b = bookingRepository.findById(booking.getBookNum()).get();
		b.setStatus(1l);
	}
	
	@Transactional
	public void cancle(Booking booking) {
		Booking b = bookingRepository.findById(booking.getBookNum()).get();
		b.setStatus(2l);
	}
}
