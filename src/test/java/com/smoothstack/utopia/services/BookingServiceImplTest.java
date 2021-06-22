package com.smoothstack.utopia.services;

import com.smoothstack.utopia.entities.Booking;
import com.smoothstack.utopia.repos.BookingRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ContextConfiguration(classes = {BookingServiceImpl.class})
@ExtendWith(SpringExtension.class)
class BookingServiceImplTest {

	@MockBean
	private BookingRepository bookingRepository;

	@Autowired
	private BookingService bookingService;

	private Booking booking;
	private List<Booking> bookings;

	@BeforeEach
	void setUp() {
		booking = new Booking();
		booking.setId(1);
		booking.setIsActive(true);
		booking.setConfirmationCode("confirmed");
		bookings = new ArrayList<>();
		bookings.add(booking);
	}

	@Test
	void addBooking() {
		when(bookingRepository.save(any())).thenReturn(booking);
		assertSame(booking, bookingService.addBooking(booking));
		verify(bookingRepository).save((any()));
	}

	@Test
	void getBookings() {
		when(bookingRepository.findAll()).thenReturn(bookings);
		assertSame(bookings, bookingService.getBookings());
		verify(bookingRepository).findAll();
	}

	@Test
	void getActiveBookings() {
		when(bookingRepository.findActiveBookings()).thenReturn(bookings);
		assertSame(bookings, bookingService.getActiveBookings());
		verify(bookingRepository).findActiveBookings();
	}

	@Test
	void getBookingByConfirmationCode() {
		when(bookingRepository.findBookingByConfirmationCode(any()))
				.thenReturn(booking);
		assertSame(booking, bookingService
				.getBookingByConfirmationCode(booking.getConfirmationCode()));
		verify(bookingRepository).findBookingByConfirmationCode(any());

	}

	@Test
	void updateBooking() {
		Booking bookingB = new Booking();
		bookingB.setId(1);
		bookingB.setIsActive(false);
		bookingB.setConfirmationCode("confirmed");
		when(bookingRepository.findById(any())).thenReturn(Optional.of(bookingB));
		when(bookingRepository.save(any())).thenReturn(bookingB);
		assertSame(bookingB, bookingService.updateBooking(booking));
		verify(bookingRepository).findById(any());
		verify(bookingRepository).save(any());
	}

	@Test
	void deleteBooking() {
		when(bookingRepository.findById(any())).thenReturn(Optional.of(booking));
		doNothing().when(bookingRepository).deleteById(any());
		assertSame(booking, bookingService.deleteBooking(booking.getId()));
		verify(bookingRepository).findById(any());
		verify(bookingRepository).deleteById(any());
	}
}