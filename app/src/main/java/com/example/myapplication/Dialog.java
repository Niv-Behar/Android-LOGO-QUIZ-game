package com.example.myapplication;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.Html;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.PermissionChecker;

import com.muddzdev.styleabletoast.StyleableToast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamConstants;
import java.util.Objects;
import java.util.regex.Pattern;

import de.hdodenhof.circleimageview.CircleImageView;

import static androidx.appcompat.app.AppCompatActivity.*;

public class Dialog extends AppCompatDialogFragment {

    private EditText editTextUsername;
    String username;
    private EditText editTextMail;
    String email;
    private RadioGroup radioGroup;
    private CircleImageView img;
    RadioButton radioButton1;
    RadioButton radioButton2;
    private int gender;
    private Button camera_btn;
    private ExampleDialogListener listener;
    Person person;

    ImageView imageView;
    Button myChoosebtn;
    private static final int IMAGE_PICK_CODE=1000;
    private static final int PERMISSION_CODE=1001;
    Uri imageUri;

    Bitmap bitmapImage;
    final int CAMERA_REQUEST=1002;

    @NonNull
    @Override
    public android.app.Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        AlertDialog.Builder builder=new AlertDialog.Builder(Objects.requireNonNull(getActivity()),R.style.CustomDialog);
        LayoutInflater inflater=getActivity().getLayoutInflater();
        final View view=inflater.inflate(R.layout.dialog,null);

        imageView=view.findViewById(R.id.img_view);
        editTextUsername = view.findViewById(R.id.edit_username);
        editTextMail = view.findViewById(R.id.edit_mail);
        radioGroup=view.findViewById(R.id.radio);
        radioButton1 = view.findViewById(R.id.male);
        radioButton2 = view.findViewById(R.id.female);
        myChoosebtn=view.findViewById(R.id.choose_image_btn);
        camera_btn=view.findViewById(R.id.camera);

        camera_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent,CAMERA_REQUEST);
            }
        });

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                ImageView gender_img=view.findViewById(R.id.gender);
                if (radioButton1.getId() == checkedId) {
                    gender = 10;
                    gender_img.setImageResource(R.drawable.male);
                } else {
                    gender = 20;
                    gender_img.setImageResource(R.drawable.female);
                }
            }
        });

        myChoosebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int permissionCheck = ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.READ_EXTERNAL_STORAGE);
                if (permissionCheck == PackageManager.PERMISSION_GRANTED) {
                    pickFromGallery();
                } else {
                    ActivityCompat.requestPermissions(getActivity(),
                            new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                            2000);
                }
            }
        });

        builder.setView(view).setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                MediaPlayer back_btn= MediaPlayer.create(view.getContext(),R.raw.cancel);
                back_btn.start();
            }
        });

        builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
            @SuppressLint("UseCompatLoadingForDrawables")
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                username = editTextUsername.getText().toString();
                email = editTextMail.getText().toString();
                FileInputStream fis = null;
                try {
                    fis = getActivity().openFileInput("person");
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                if(fis!=null) {
                    ObjectInputStream ois = null;
                    try {
                        ois = new ObjectInputStream(fis);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    Person person = null;
                    try {
                        person = (Person) ois.readObject();
                    } catch (ClassNotFoundException | IOException e) {
                        e.printStackTrace();
                    }
                    if (person != null) {
                        if (username.length() >= 3) {
                            if (isValid(email)) {
                                if (radioButton2.isChecked() || radioButton1.isChecked()) {
                                    person.setUsername(username);
                                    person.setEmail(email);
                                    person.setPhoto(bitmapImage);
                                    person.setGender(gender);
                                    try {
                                        FileOutputStream fos = getActivity().openFileOutput("person", MODE_PRIVATE);
                                        ObjectOutputStream oos = new ObjectOutputStream(fos);
                                        oos.writeObject(person);
                                        oos.close();
                                        editTextUsername.setText("");
                                        editTextMail.setText("");
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                    try {
                                        listener.applyTexts(username);
                                    } catch (IOException | ClassNotFoundException e) {
                                        e.printStackTrace();
                                    }
                                }
                                else{
                                    StyleableToast.makeText(Objects.requireNonNull(getContext()), "Gender isn't selected", R.style.toast).show();
                                }
                            } else {
                                StyleableToast.makeText(Objects.requireNonNull(getContext()), "Email is not valid!", R.style.toast).show();
                            }
                        } else {
                            StyleableToast.makeText(Objects.requireNonNull(getContext()), "Username got to be at least 3 letters!", R.style.toast).show();
                        }
                    }
                    else{
                        if (username.length() >= 3) {
                            if (isValid(email)) {
                                if (radioButton2.isChecked() || radioButton1.isChecked()) {
                                    person = new Person(username, email, bitmapImage, gender);
                                    try {
                                        FileOutputStream fos = getActivity().openFileOutput("person", MODE_PRIVATE);
                                        ObjectOutputStream oos = new ObjectOutputStream(fos);
                                        oos.writeObject(person);
                                        oos.close();
                                        editTextUsername.setText("");
                                        editTextMail.setText("");
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                    try {
                                        listener.applyTexts(username);
                                    } catch (IOException | ClassNotFoundException e) {
                                        e.printStackTrace();
                                    }
                                }
                                else{
                                    StyleableToast.makeText(Objects.requireNonNull(getContext()), "Gender isn't selected", R.style.toast).show();
                                }
                            } else {
                                StyleableToast.makeText(Objects.requireNonNull(getContext()), "Email is not valid!", R.style.toast).show();
                            }
                        } else {
                            StyleableToast.makeText(Objects.requireNonNull(getContext()), "Username got to be at least 3 letters!", R.style.toast).show();
                        }
                    }
                }
                MediaPlayer back_btn = MediaPlayer.create(view.getContext(), R.raw.ok_btn);
                back_btn.start();
            }
        });
        Button delete=view.findViewById(R.id.delete);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView.setImageResource(R.drawable.del);
                bitmapImage=null;
            }
        });

        FileInputStream fis = null;
        try {
            fis = getActivity().openFileInput("person");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        if(fis!=null) {
            ObjectInputStream ois = null;
            try {
                ois = new ObjectInputStream(fis);
            } catch (IOException e) {
                e.printStackTrace();
            }
            Person person = null;
            try {
                person = (Person) ois.readObject();
            } catch (ClassNotFoundException | IOException e) {
                e.printStackTrace();
            }
            if (person != null) {
                if (person.getPhoto() != null) {
                    imageView.setImageBitmap(person.getPhoto());
                    bitmapImage = person.getPhoto();
                }
                if (person.getGender() == 20)
                    radioButton2.setChecked(true);
                else radioButton1.setChecked(true);
                editTextUsername.setText(person.getUsername());
                editTextMail.setText(person.getEmail());
            }
        }
        return  builder.create();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode){
            case PERMISSION_CODE:{
                if(grantResults.length>0 && grantResults[0]==PackageManager.PERMISSION_DENIED){
                    pickFromGallery();
                }
                else {
                    Toast.makeText(getActivity(),"Permission denied...!", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }

    private void pickFromGallery(){

        Intent cameraIntent = new Intent(Intent.ACTION_GET_CONTENT);
        cameraIntent.setType("image/*");
        if (cameraIntent.resolveActivity(getActivity().getPackageManager()) != null) {
            startActivityForResult(cameraIntent, 1000);
        }
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try {
            listener=(ExampleDialogListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()+"must implement ExampleDialogListener");
        }
    }

    public interface ExampleDialogListener{
        void applyTexts(String username) throws IOException, ClassNotFoundException;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //super method removed
        if(requestCode==CAMERA_REQUEST && resultCode==RESULT_OK)
        {
            bitmapImage=(Bitmap)data.getExtras().get("data");
            imageView.setImageBitmap(bitmapImage);
        }
        else if(resultCode == RESULT_OK) {
            if(requestCode == 1000){
                Uri returnUri = data.getData();
                try {
                    bitmapImage = MediaStore.Images.Media.getBitmap(getActivity().getContentResolver(), returnUri);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                imageView.setImageBitmap(bitmapImage);
            }
        }
    }


    public static boolean isValid(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";

        Pattern pat = Pattern.compile(emailRegex);
        if (email == null)
            return false;
        return pat.matcher(email).matches();
    }
}
