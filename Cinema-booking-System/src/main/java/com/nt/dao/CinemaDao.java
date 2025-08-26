package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.nt.CinemaBookingSystemApplication;
import com.nt.model.Shows;

@Repository // optional but recommended for Spring component scanning
public class CinemaDao implements IDao
{
    @Autowired
    private DataSource ds;

    private static final String QUERY_BY_CITY = """
        SELECT m.title AS movie_title,
          t.name AS theater_name,
               t.city AS theater_city,
               s.show_time
        FROM shows s
        JOIN movies m ON s.movie_id = m.id
        JOIN theaters t ON s.theater_id = t.id
        WHERE t.city = ?
    """;
    
    
    private static final String QUERY_BY_THEATER = """
    	    SELECT m.title AS movie_title,
    	           t.name AS theater_name,
    	           t.city AS theater_city,
    	           s.show_time
    	    FROM shows s
    	    JOIN movies m ON s.movie_id = m.id
    	    JOIN theaters t ON s.theater_id = t.id
    	    WHERE t.name = ?
    	""";
    
    
    @Override
    public List<Shows> getshowBycity(String city) throws Exception {
        List<Shows> sList = new ArrayList<>();

        try (Connection con = ds.getConnection();
             PreparedStatement ps = con.prepareStatement(QUERY_BY_CITY)) {

            // ✅ Set the parameter here
            ps.setString(1, city);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Shows shows = new Shows();
                    shows.setMovieTitle(rs.getString("movie_title"));
                    shows.setTheaterName(rs.getString("theater_name"));
                    shows.setCity(rs.getString("theater_city"));
                    shows.setShowTime(rs.getTime("show_time").toLocalTime());

                    sList.add(shows);
                }
            }

        } catch (SQLException e) {
            throw new Exception("Failed to fetch shows by city", e);
        }

        return sList;
    }

	@Override
	public List<Shows> getshowsBytheater(String theater) throws Exception 
	{
		List<Shows>nList=new ArrayList<Shows>();
		
		
		try(Connection con=ds.getConnection();
				PreparedStatement ps=con.prepareStatement(QUERY_BY_THEATER);)
		{
			ps.setString(1, theater);
			 
			try(ResultSet rs= ps.executeQuery())
			{
			while(rs.next())
			{
				Shows show= new Shows();
				 show.setMovieTitle(rs.getString("movie_title"));
	                show.setTheaterName(rs.getString("theater_name"));
	                show.setCity(rs.getString("theater_city"));
	                show.setShowTime(rs.getTime("show_time").toLocalTime());
	                
	                nList.add(show);
			}
			}
			catch (SQLException e) 
			{
				throw e;
			}
			catch (Exception e) 
			{
				throw e;
			}
		}
		return nList;
	}


}
