import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface CityService {

	@GET("weather")
	Call<City> getByName(
			@Query("q") String q, 
			@Query("APPID") String APPID,
			@Query("units") String units);
	
}
