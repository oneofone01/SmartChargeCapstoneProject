package com.example.smartchargecapstoneproject;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.widget.EditText;

import android.content.Context;

import android.view.View;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatDialogFragment;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ExampleDialog extends AppCompatDialogFragment {
    private EditText editRoomName, editRoomDescription;

    private ExampleDialogListener listener;

    DatabaseReference databaseReference;
    RoomList roomList;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.layout_dialog, null);

        final EditText editRoomName = view.findViewById(R.id.edit_roomName);
        final EditText editRoomDescription = view.findViewById(R.id.edit_roomDescription);

        /*editRoomName = (EditText) view.findViewById(R.id.edit_roomName);
        EditText editRoomDescription = view.findViewById(R.id.edit_roomDescription);*/


        builder.setView(view)
                //.setTitle("Create a room")
                .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .setPositiveButton("Save", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        FirebaseDatabase database = FirebaseDatabase.getInstance();
                        DatabaseReference myRef = database.getReference();

                        //String roomName = editRoomName

//                        myRef.addValueEventListener(new ValueEventListener() {
//                            @Override
//                            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                                Object value = snapshot.getValue();
//                            }
//
//                            @Override
//                            public void onCancelled(@NonNull DatabaseError error) {
//                            }
//                        });

                        //myRef.child("Users").child(editRoomName.getText().toString()).child("Room Name").setValue(editRoomName.getText().toString());
                        //myRef.child("Users").child(editRoomDescription.getText().toString()).child("Room Description").setValue(editRoomDescription.getText().toString());

                        FirebaseDatabase.getInstance().getReference("Users").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child("rooms").child(editRoomName.getText().toString()).child("RoomName").setValue(editRoomName.getText().toString());
                        FirebaseDatabase.getInstance().getReference("Users").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child("rooms").child(editRoomName.getText().toString()).child("RoomDescription").setValue(editRoomDescription.getText().toString());

                        /*String edit_roomName = editRoomName.getText().toString();
                        String roomDescription = editRoomDescription.getText().toString();
                        listener.applyTexts(roomName,roomDescription);*/

                        //String edit_roomName = editRoomName.getText().toString();
                        //String edit_roomDescription = editRoomDescription.getText().toString();

                        /*listener.applyTexts(roomName, roomDescription);
                        roomList = new RoomList(roomName,roomDescription);
                        roomList.setRoom_name(roomName);
                        roomList.setRoom_description(roomDescription);
                        databaseReference.push().setValue(roomList);*/
                        //Toast.makeText(Rooms.class,"data inserted successfully", Toast.LENGTH_LONG).show();

                        /*if (edit_roomName.isEmpty()){
                            editRoomName.setError("Please enter room name");
                            editRoomName.requestFocus();
                        }*/
                    }
                });

        /*editRoomName = view.findViewById(R.id.edit_roomName);
        editRoomDescription = view.findViewById(R.id.edit_roomDescription);*/

        //databaseReference= FirebaseDatabase.getInstance().getReference().child("RoomList");

        //roomList = new RoomList(roomName,roomDescription);

        return builder.create();
    }

    public interface ExampleDialogListener {
        void applyTexts(String roomName, String roomDescription);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            listener = (ExampleDialogListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() +
                    "must implement ExampleDialogListener");
        }
    }


}
