package com.enfec.EMS.CustomerOrderAPI.model;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/************************************************
* Author: Chad Chai
* Assignment: Ticket Rowmapper for 'Tickets' table
* Class: TicketRowmapper
************************************************/

public class TicketRowmapper implements RowMapper<TicketTable>  {
	/**
     * Map each MySql column's content to ticket table
     * @param rs: ResultSet
     * @param rowNum
     * @throws SQLException when column doesn't exist in database 
     * @return TicketTable
     */
	@Override
	public TicketTable mapRow(ResultSet rs, int rowNum) throws SQLException{
		TicketTable ticketTable = new TicketTable();
		
		if (hasColumn(rs, "Ticket_ID")) {
			ticketTable.setTicketID(rs.getInt("Ticket_ID"));
		}
		if (hasColumn(rs, "COrder_ID")) {
			ticketTable.setCustomerOrderID(rs.getInt("COrder_ID"));
		}
		
		if (hasColumn(rs, "Event_ID")) {
			ticketTable.setEventID(rs.getInt("Event_ID"));
		}
		
		if (hasColumn(rs, "Room_ID")) {
			ticketTable.setRoomID(rs.getInt("Room_ID"));
		}
		
		if (hasColumn(rs, "Seat_ID")) {
			ticketTable.setSeatID(rs.getInt("Seat_ID"));
		}
		
		if (hasColumn(rs, "Discount_Type")) {
			ticketTable.setDiscountType(rs.getInt("Discount_Type"));	
		}
		
		if (hasColumn(rs, "RealPrice")) {
			ticketTable.setRealPrice(rs.getDouble("RealPrice"));
		}
		
		if (hasColumn(rs, "Price")) {
			if (rs.getDouble("Price") != 0) {
				ticketTable.setOriginalPrice(rs.getDouble("Price"));
			}
		}
		
		if (hasColumn(rs, "Percentage_Off")) {
			ticketTable.setPercentage_Off(rs.getDouble("Percentage_Off"));
		}

		
		return ticketTable;
	}
	
	
	/**
     * To check if the column in ResultSet is empty
     * @param rs: ResultSet
     * @param colulmnName
     * @return whether the column is empty or not
     */
	public static boolean hasColumn(ResultSet rs, String columnName) throws SQLException {
	    ResultSetMetaData rsmd = rs.getMetaData();
	    int columns = rsmd.getColumnCount();
	    for (int x = 1; x <= columns; x++) {
	        if (columnName.equals(rsmd.getColumnName(x))) {
	            return true;
	        }
	    }
	    return false;
	}
}
