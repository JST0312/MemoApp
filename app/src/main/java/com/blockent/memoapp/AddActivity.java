package com.blockent.memoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.blockent.memoapp.data.DatabaseHandler;
import com.blockent.memoapp.model.Memo;

public class AddActivity extends AppCompatActivity {

    EditText editTitle;
    EditText editContent;
    Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        editTitle = findViewById(R.id.editTitle);
        editContent = findViewById(R.id.editContent);
        btnSave = findViewById(R.id.btnSave);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title = editTitle.getText().toString().trim();
                String content = editContent.getText().toString().trim();

                if (title.isEmpty() || content.isEmpty()){
                    Toast.makeText(AddActivity.this, "필수항목을 입력하세요.", Toast.LENGTH_SHORT).show();
                    return;
                }

                // 메모를 저장한다!
                Memo memo = new Memo(title, content);

                // 위의 메모를 디비에 저장한다.
                DatabaseHandler db = new DatabaseHandler(AddActivity.this);
                db.addMemo(memo);

                // 다 완료되면, 메모 생성 화면은 필요가 없다.
                // 따라서 이 액티비티는 종료한다.
                finish();
            }
        });

    }
}





