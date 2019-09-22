package com.example.aninterface;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

public class DialogFactory {
    Context context;


    public interface DialogFactoryInteraction{
        void onAcceptButtonClicked(String... strings);
        void onDeniedButtonClicked(boolean cancel_dialog);
    }

    public DialogFactory(Context context) {
        this.context = context;
    }


      public  void createConfirmExitDialog2(DialogFactoryInteraction listener,View root){

          View customLayout = LayoutInflater.from(context).inflate(R.layout.report_issue_dialog1, (ViewGroup) root, false);


          //define views inside of dialog
          EditText edt_title = customLayout.findViewById(R.id.edt_title);
          EditText edt_description = customLayout.findViewById(R.id.edt_description);
          TextView btn_send = customLayout.findViewById(R.id.btn_send_dialog);
          TextView btn_cancel_dialog = customLayout.findViewById(R.id.btn_cancel_dialog);

          //set default values of views
//          edt_title.setTypeface(Typeface.createFromAsset(context.getAssets(), "fonts/BYekan.ttf"));
//          edt_description.setTypeface(Typeface.createFromAsset(context.getAssets(), "fonts/BYekan.ttf"));



          AlertDialog.Builder builder = new AlertDialog.Builder(context);
          builder.setView(customLayout);

          //create dialog and set background transparent
          AlertDialog dialog = builder.create();
          if (dialog.getWindow() != null) {
              dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
          }

          //set click listener for views inside of dialog

          btn_send.setOnClickListener(view -> {

              listener.onAcceptButtonClicked(edt_title.getText().toString(), edt_description.getText().toString());
              dialog.dismiss();
          });

          btn_cancel_dialog.setOnClickListener(view ->{
              listener.onDeniedButtonClicked(false);
              dialog.dismiss();});

          dialog.show();

      }
}
