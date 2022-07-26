package com.esraa.CancerJourney.SkinDetection;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;
import com.google.gson.Gson;
import com.esraa.CancerJourneyApp.R;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class SkinActivity extends AppCompatActivity {

    public static final String TAG = SkinActivity.class.getSimpleName();

    private static final int INTENT_REQUEST_CODE = 100;

    public static final String URL = "http://15.236.134.100";

    private Button mBtImageSelect;
    private Button mBtImageShow;
    ImageView imageviewPlace;
    private ProgressBar mProgressBar;
    private String mImageUrl = "";
    TextView resView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skin);
        //  setSupportActionBar();

        initViews();




    }

    private void initViews() {

        mBtImageSelect = findViewById(R.id.btn_select_image);
        mBtImageShow = findViewById(R.id.btn_show_image);
        mProgressBar = findViewById(R.id.progress);
        resView = findViewById(R.id.image_result);
        imageviewPlace = findViewById(R.id.imageviewPlace);

        mBtImageSelect.setOnClickListener((View view) -> {

            mBtImageShow.setVisibility(View.GONE);




            imageChooser();

        });

     /*   mBtImageShow.setOnClickListener(view -> {

            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse(mImageUrl));
            startActivity(intent);

        });*/
    }

    void imageChooser() {

        // create an instance of the
        // intent of the type image
        Intent i = new Intent();
        i.setType("image/*");
        i.setAction(Intent.ACTION_GET_CONTENT);
        try {
            startActivityForResult(Intent.createChooser(i, "Select Picture"), INTENT_REQUEST_CODE);

        } catch (ActivityNotFoundException e) {

            e.printStackTrace();
        }
        // pass the constant to compare it
        // with the returned requestCode
     // startActivityForResult(Intent.createChooser(i, "Select Picture"), SELECT_PICTURE);
    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == INTENT_REQUEST_CODE) {

            if (resultCode == RESULT_OK) {

                try {

                    InputStream is = getContentResolver().openInputStream(data.getData());

                    uploadImage(getBytes(is));

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        if (resultCode == RESULT_OK) {

            // compare the resultCode with the
            // SELECT_PICTURE constant
            if (requestCode == INTENT_REQUEST_CODE) {
                // Get the url of the image from data
                Uri selectedImageUri = data.getData();
                if (null != selectedImageUri) {
                    // update the preview image in the layout
                    imageviewPlace.setImageURI(selectedImageUri);
                }
            }
        }

    }

    public byte[] getBytes(InputStream is) throws IOException {
        ByteArrayOutputStream byteBuff = new ByteArrayOutputStream();

        int buffSize = 1024;
        byte[] buff = new byte[buffSize];

        int len = 0;
        while ((len = is.read(buff)) != -1) {
            byteBuff.write(buff, 0, len);
        }

        return byteBuff.toByteArray();
    }

    private void uploadImage(byte[] imageBytes) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RetrofitInterface retrofitInterface = retrofit.create(RetrofitInterface.class);

        RequestBody requestFile = RequestBody.create(MediaType.parse("image/jpeg"), imageBytes);

        MultipartBody.Part body = MultipartBody.Part.createFormData("image", "image.jpg", requestFile);
        Call<Response> call = retrofitInterface.uploadImage(body);
        mProgressBar.setVisibility(View.VISIBLE);
        call.enqueue(new Callback<Response>() {
            @Override
            public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {

                mProgressBar.setVisibility(View.GONE);

                if (response.isSuccessful()) {

                    Response responseBody = response.body();
                 //   mBtImageShow.setVisibility(View.VISIBLE);
                    mImageUrl = URL + responseBody.getPath();
                    Snackbar.make(findViewById(R.id.content), responseBody.getMessage(), Snackbar.LENGTH_SHORT).show();
                    Toast.makeText(getApplicationContext(), "Image sent", Toast.LENGTH_SHORT).show();
                    resView.setText(responseBody.getResult());
                } else {

                    ResponseBody errorBody = response.errorBody();

                    Gson gson = new Gson();

                    try {

                        Response errorResponse = gson.fromJson(errorBody.string(), Response.class);
                        Snackbar.make(findViewById(R.id.content), errorResponse.getMessage(), Snackbar.LENGTH_SHORT).show();

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<Response> call, Throwable t) {

                mProgressBar.setVisibility(View.GONE);
                Log.d(TAG, "onFailure: " + t.getLocalizedMessage());
            }
        });
    }
}