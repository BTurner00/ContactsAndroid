package com.theironyard.contactsandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemLongClickListener {

    ArrayAdapter<Contact> contacts;

    EditText name;
    EditText number;
    Button addButton;
    ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        addButton = (Button) findViewById(R.id.add);
        name = (EditText) findViewById(R.id.name);
        number = (EditText) findViewById(R.id.number);
        list = (ListView) findViewById(R.id.list);

        //Contact contact = new Contact (name.toString(), number.toString());

        contacts = new ArrayAdapter<Contact>(this,android.R.layout.simple_list_item_1);
        list.setAdapter(contacts);

        addButton.setOnClickListener(this);
        list.setOnItemLongClickListener(this);



    }

    @Override
    public void onClick(View v) {
        String nameString = name.getText().toString();
        String numberString = number.getText().toString();
        Contact contact = new Contact (nameString, numberString);
        contacts.add(contact);
        name.setText("");
        number.setText("");
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        Contact contact = contacts.getItem(position);
        contacts.remove(contact);
        return true;
    }
}
