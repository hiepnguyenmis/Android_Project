package vn.com.demo.android_project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import vn.com.demo.android_project.data.DBManager;
import vn.com.demo.android_project.model.ThanhVienmodel;

public class DangKyActivity extends AppCompatActivity {
    Button btnDk;
    private EditText txtuser,txtpass;
    DBManager dbManager=new DBManager(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_ky);
        btnDk=(Button) findViewById(R.id.btnDk);
        txtuser=(EditText) findViewById(R.id.txtUserNameDk);
        txtpass=(EditText) findViewById(R.id.txtPassWorddk);
        btnDk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ThanhVienmodel thanhVienmodel=createThanhVien();
                if(thanhVienmodel!=null){
                    try{
                        dbManager.addThanhvien(thanhVienmodel);
                        Intent intent=new Intent(DangKyActivity.this,LoginActivity.class);
                        startActivity(intent);
                    }catch (Exception e){
                        Toast.makeText(DangKyActivity.this,"Đăng Ký không thành công kiểm tra lại các trường",Toast.LENGTH_LONG).show();
                    }

                }else{
                    Toast.makeText(DangKyActivity.this,"Đăng Ký không thành công kiểm tra lại các trường",Toast.LENGTH_LONG).show();
                }

            }
        });
    }
    private ThanhVienmodel createThanhVien(){
        String username=txtuser.getText().toString();
        String password=txtpass.getText().toString();
        ThanhVienmodel thanhVienmodel=new ThanhVienmodel(username,password);
        return thanhVienmodel;
    }
}
