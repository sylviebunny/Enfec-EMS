package com.enfec.sb.refundapi.repository;

import java.util.List;

import com.enfec.sb.refundapi.model.OOrderRefundTable;

public interface RefundRepository {
	
	public Object getEventInfo(Integer event_id, String event_name, String type_code, Boolean free_or_commercial,
			Integer organizer_id, Integer venue_id); 
	
	public int createEvent(OOrderRefundTable organizerTable);
	public int updateEvent(OOrderRefundTable organizerTable);
	
	public int deleteEvent(int event_id);


	
}