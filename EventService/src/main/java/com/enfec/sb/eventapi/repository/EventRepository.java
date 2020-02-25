package com.enfec.sb.eventapi.repository;

import com.enfec.sb.eventapi.model.EventTable;
import java.rmi.NotBoundException;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

/**
 * Event repository class
 * @author heidihuo
 *
 */
public interface EventRepository {
	/**
	 * Creates an event in database
	 * @param eventTable event table to be created
	 * @return number of affected rows
	 */
	public int createEvent(EventTable eventTable);
	
	/**
	 * Updates an event in database
	 * @param eventTable event table to be updated with
	 * @return number of affected rows
	 */
	public int updateEvent(EventTable eventTable);
	
	/**
	 * Deletes an event in database
	 * @param event_id event id to delete
	 * @return number of affected rows
	 */
	public int deleteEvent(int event_id);

	/**
	 * Gets event list by refined zipcode
	 * @param allEvent events to be searched
	 * @param str refined zipcode
	 * @return result event list
	 * @throws NotBoundException
	 */
	public List<Map> getFilteredEventsByRefinedZipcode(List<EventTable> allEvent, String str) throws NotBoundException;
	
	/**
	 * Gets event list by start and end date
	 * @param allEvent events to be searched
	 * @param start_date start date
	 * @param end_date end date
	 * @return result event list
	 */
	public List<Map> getFilteredEvents(List<EventTable> allEvent, Timestamp start_date, Timestamp end_date);
	
	/**
	 * Gets event list by event type
	 * @param inputEvents events to be searched
	 * @param event_type specified event type
	 * @return result event list
	 */
	public List<Map> getEventByEventType(List<Map> inputEvents, String event_type);
	
	/**
     * Gets all events
     * @return result event list
     */
	public List<EventTable> getAllEvents(); 


	
}
