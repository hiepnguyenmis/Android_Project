package vn.com.demo.android_project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import vn.com.demo.android_project.data.DBManager;
import vn.com.demo.android_project.model.HuyenThiXaTpmodel;
import vn.com.demo.android_project.model.LoaiDVmodel;
import vn.com.demo.android_project.model.Phuongxamodel;
import vn.com.demo.android_project.model.ThanhVienmodel;
import vn.com.demo.android_project.model.TinhThanhPhomodel;

public class tinhthanhActivity extends AppCompatActivity {
    DBManager dbManager=new DBManager(this);

    Button btnthemdiachi;
    EditText edtinh,edhuyen,edxaphuong,edloaidv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tinhthanh);
        btnthemdiachi=(Button) findViewById(R.id.btnthemtinhthanh);
        edtinh=(EditText) findViewById(R.id.edtinh);
        edhuyen=(EditText) findViewById(R.id.edtHuyen);
        edxaphuong=(EditText) findViewById(R.id.edphuongxa);
        edloaidv=(EditText) findViewById(R.id.edploaidv);
        btnthemdiachi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TinhThanhPhomodel tinhThanhPhomodel=createTinhThanh();
                HuyenThiXaTpmodel huyenThiXaTpmodel=createHuyenThi();
                Phuongxamodel phuongxamodel=createPhuongxa();
                LoaiDVmodel loaiDVmodel=createLoaiDV();
                if(tinhThanhPhomodel!=null){
                    try{
                        dbManager.addTinhThanhPho(tinhThanhPhomodel);
                        edtinh.setText("");

                    }catch (Exception e){
                        Toast.makeText(tinhthanhActivity.this,"Thêm Tỉnh không thành công ",Toast.LENGTH_LONG).show();
                    }

                }else{
                    Toast.makeText(tinhthanhActivity.this,"Thêm Tỉnh không thành công",Toast.LENGTH_LONG).show();
                }

                if(huyenThiXaTpmodel!=null){
                    try{
                        dbManager.addHuyenTXTP(huyenThiXaTpmodel);
                        edhuyen.setText("");

                    }catch (Exception e){
                        Toast.makeText(tinhthanhActivity.this,"Thêm Huyện không thành công ",Toast.LENGTH_LONG).show();
                    }

                }else{
                    Toast.makeText(tinhthanhActivity.this,"Thêm Huyện không thành công",Toast.LENGTH_LONG).show();
                }

                if(phuongxamodel!=null){
                    try{
                        dbManager.addPhuongXa(phuongxamodel);
                        edxaphuong.setText("");
                    }catch (Exception e){
                        Toast.makeText(tinhthanhActivity.this,"Thêm Xã không thành công ",Toast.LENGTH_LONG).show();
                    }

                }else{
                    Toast.makeText(tinhthanhActivity.this,"Thêm Xã không thành công",Toast.LENGTH_LONG).show();
                }

                if(loaiDVmodel!=null){
                    try{
                        dbManager.addLoaiDonVi(loaiDVmodel);
                        edloaidv.setText("");
                    }catch (Exception e){
                        Toast.makeText(tinhthanhActivity.this,"Thêm lọai đơn vị không thành công ",Toast.LENGTH_LONG).show();
                    }

                }else{
                    Toast.makeText(tinhthanhActivity.this,"Thêm lọai đơn vị không thành công",Toast.LENGTH_LONG).show();
                }

            }
        });
    }
    private TinhThanhPhomodel createTinhThanh(){
        String tinh=edtinh.getText().toString();

        TinhThanhPhomodel tinhThanhPhomodel=new TinhThanhPhomodel(tinh);
        return tinhThanhPhomodel;
    }

    private HuyenThiXaTpmodel createHuyenThi(){
        String huyen=edhuyen.getText().toString();

        HuyenThiXaTpmodel huyenThiXaTpmodel=new HuyenThiXaTpmodel(huyen);
        return huyenThiXaTpmodel;
    }

    private Phuongxamodel createPhuongxa(){
        String phuongxa=edxaphuong.getText().toString();

        Phuongxamodel phuongxamodel=new Phuongxamodel(phuongxa);
        return phuongxamodel;
    }
    private LoaiDVmodel createLoaiDV(){
        String loaidv=edloaidv.getText().toString();

        LoaiDVmodel loaiDVmodel=new LoaiDVmodel(loaidv);
        return loaiDVmodel;
    }
}
