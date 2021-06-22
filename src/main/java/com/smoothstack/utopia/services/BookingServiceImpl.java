package com.smoothstack.utopia.services;

import com.smoothstack.utopia.entities.Booking;
import com.smoothstack.utopia.repos.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class BookingServiceImpl implements BookingService {
	@Autowired
	private BookingRepository bookingRepository;

	@Override
	@Transactional
	public Booking addBooking(Booking booking) {
		return bookingRepository.save(booking);
	}

	@Override
	@Transactional
	public List<Booking> getBookings() {
		return bookingRepository.findAll();
	}

	@Override
	@Transactional
	public List<Booking> getActiveBookings() {
		return bookingRepository.findActiveBookings();
	}

	@Override
	@Transactional
	public Booking getBookingByConfirmationCode(String confirmationCode) {
		return bookingRepository.findBookingByConfirmationCode(confirmationCode);
	}

	@Override
	@Transactional
	public Booking updateBooking(Booking booking) {
		Optional<Booking> updatedBooking = bookingRepository.findById(booking.getId());
		if(updatedBooking.isPresent()){
			if(booking.getIsActive()){
				updatedBooking.get().setIsActive(true);
			}

			if(booking.getId() > 0){
				updatedBooking.get().setId(booking.getId());
			}

			if(booking.getConfirmationCode().length() > 0){
				updatedBooking.get().setConfirmationCode(booking.getConfirmationCode());
			}
			booking = bookingRepository.save(updatedBooking.get());
		}
		return booking;
	}

	@Override
	@Transactional
	public Booking deleteBooking(int id) {
		Optional<Booking> booking = bookingRepository.findById(id);
		if(booking.isPresent()){
			bookingRepository.deleteById(id);
		}
		return booking.orElse(null);
	}
}
