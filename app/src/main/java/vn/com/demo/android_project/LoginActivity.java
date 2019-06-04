package vn.com.demo.android_project;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import vn.com.demo.android_project.data.DBManager;
import vn.com.demo.android_project.model.ThanhVienmodel;

public class LoginActivity extends AppCompatActivity {
    Button btnDN,btndangnhap;
    EditText txtUser,txtPass;
    MenuItem menuItemadd;

    TextView lblErr;
    DBManager dbManager=new DBManager(this);
    ArrayList<ThanhVienmodel> thanhVienmodels=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btnDN=(Button) findViewById(R.id.btnLogin);
        txtPass=(EditText) findViewById(R.id.txtPassWord);
        txtUser=(EditText) findViewById(R.id.txtUserName);
        lblErr=(TextView) findViewById(R.id.lblErr);


        thanhVienmodels=dbManager.getThanhVien();
        btnDN.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {

                for(int i=0;i<thanhVienmodels.size();i++){
                    if(txtUser.getText().toString().equals(thanhVienmodels.get(i).getmTenThanhVien())&&txtPass.getText().toString().equals(thanhVienmodels.get(i).getmMatkhau())){
                        Intent intent=new Intent(LoginActivity.this,MainActivity.class);
                        startActivity(intent);
                    }else if(txtUser.getText().toString().equals("admin")&&txtPass.getText().toString().equals("1234")){
                        Intent intent=new Intent(LoginActivity.this,AddDonviActivity.class);
                        startActivity(intent);
                    }
                    else {
                        lblErr.setText("Đăng Nhập Không Thành công");
                    }
                }
            }
        });

    }

}
