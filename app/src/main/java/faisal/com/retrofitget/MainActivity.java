package faisal.com.retrofitget;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import faisal.com.retrofitget.generator.ServiceGenerator;
import faisal.com.retrofitget.models.FaisalModel;
import faisal.com.retrofitget.services.ChuckService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    ChuckService chuckService;
    TextView txtData;
    ImageView imgChuck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        chuckService = ServiceGenerator.createService(ChuckService.class);
        txtData = (TextView) findViewById(R.id.txtData);
        imgChuck = (ImageView) findViewById(R.id.imgChuck);
        Call<FaisalModel> call = chuckService.getQuote();
        call.enqueue(new Callback<FaisalModel>() {
            @Override
            public void onResponse(Call<FaisalModel> call, Response<FaisalModel> response) {
                txtData.setText(response.body().getValue());
                Picasso.with(getApplicationContext()).load(response.body().getIconUrl()).into(imgChuck);
            }

            @Override
            public void onFailure(Call<FaisalModel> call, Throwable t) {
                txtData.setText(t.getMessage());
            }
        });

    }
}
