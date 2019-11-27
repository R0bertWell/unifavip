import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.GsonConverterFactory;
import retrofit2.Response;
import retrofit2.Retrofit;

public class Teste {
	
	public static void main(String[] args) {
		
		Retrofit retrofit = new Retrofit.Builder()
			    .baseUrl("https://api.openweathermap.org/data/2.5/")
			    .addConverterFactory(GsonConverterFactory.create())
			    .build();
		
		CityService cityService = retrofit.create(CityService.class);
		
		Call<City> call = cityService.getByName("Caruaru", "COLOQUE AQUI SUA CHAVE DE API DO OPEN WEATHER", "metric");
		call.enqueue(new Callback<City>() {
			
			@Override
			public void onResponse(Call<City> call, Response<City> response) {
				City city = response.body();
				System.out.println(city.getCod() + " - " + city.getName());
				System.out.println("Temperatura: " + city.getMain().getTemp());
			}
			
			@Override
			public void onFailure(Call<City> call, Throwable t) {
				System.out.println("Deu ruim.");
			}
		});
		
	}

}
