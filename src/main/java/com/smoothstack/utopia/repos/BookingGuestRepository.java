package com.smoothstack.utopia.repos;

import com.smoothstack.utopia.entities.BookingGuest;
import com.smoothstack.utopia.ids.BookingGuestId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Interface for accessing BookingGuest data from the database.
 *
 * @author matthew.crowell
 */
@Repository
public interface BookingGuestRepository extends JpaRepository<BookingGuest, BookingGuestId> {
}
