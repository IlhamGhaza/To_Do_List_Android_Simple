package com.example.to_do_list;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<String> todoList = new ArrayList<>();
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.listView);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, todoList);
        listView.setAdapter(adapter);
    }

    // Method to add a to-do item
    public void addTodoList(View view) {
        EditText todoEditText = findViewById(R.id.editTextTodo);

        String todo = todoEditText.getText().toString().trim();
        if (!todo.isEmpty()) {
            todoList.add(todo);
            adapter.notifyDataSetChanged();
            todoEditText.setText(""); // Clear the input field
        } else {
            Toast.makeText(this, "Please enter a to-do item.", Toast.LENGTH_SHORT).show();
        }
    }

    // Method to remove a to-do item
    public void removeTodoList(View view) {
        EditText indexEditText = findViewById(R.id.editTextIndex);

        try {
            int index = Integer.parseInt(indexEditText.getText().toString()) - 1;
            if (index >= 0 && index < todoList.size()) {
                todoList.remove(index);
                adapter.notifyDataSetChanged();
                indexEditText.setText(""); // Clear the input field
            } else {
                Toast.makeText(this, "Invalid index.", Toast.LENGTH_SHORT).show();
            }
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Please enter a valid index.", Toast.LENGTH_SHORT).show();
        }
    }

}