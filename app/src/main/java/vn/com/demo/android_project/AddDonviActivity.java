package vn.com.demo.android_project;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

import vn.com.demo.android_project.data.DBManager;
import vn.com.demo.android_project.model.DonVimodel;
import vn.com.demo.android_project.model.HuyenThiXaTpmodel;
import vn.com.demo.android_project.model.LoaiDVmodel;
import vn.com.demo.android_project.model.Phuongxamodel;
import vn.com.demo.android_project.model.TinhThanhPhomodel;

public class AddDonviActivity extends AppCompatActivity {
    String strLoai="";
    String strTinh="";
    String strHuyen="";
    String strXa="";
    DBManager dbManager=new DBManager(this);

    String DATABASE_NAME="donvi_manager";
    private static final String TABLE_DONVI="donvi";
    private static final String MADV="madonvi";
    private static final String TENDV="tendonvi";
    private static final String SDT="sdt";
    private static final String MALOAIDV="maloaidonvi";
    private static final String MATINHTP="matinhtp";
    private static final String MAQUANHUYENTXTP="quanhuyentxtp";
    private static final String MAXAPHUONGTTRAN="maxaphuongttran";
    SQLiteDatabase database;

    ArrayAdapter<TinhThanhPhomodel> arrayAdapterTinh;
    ArrayAdapter<HuyenThiXaTpmodel> arrayAdapterHuyen;
    ArrayAdapter<Phuongxamodel> arrayAdapterXa;
    ArrayAdapter<LoaiDVmodel> arrayAdapterLoai;
    ArrayAdapter<DonVimodel> arrayAdapterDv;
    Adddvadapter adapter;

    ArrayList<TinhThanhPhomodel> listTinh;
    ArrayList<TinhThanhPhomodel> listidTinh;

    ArrayList<HuyenThiXaTpmodel> listHuyen;
    ArrayList<HuyenThiXaTpmodel> listidHuyen;

    ArrayList<Phuongxamodel> listXa;
    ArrayList<Phuongxamodel> listidXa;

    ArrayList<LoaiDVmodel> listLoai;
    ArrayList<LoaiDVmodel> listidLoai;

    ArrayList<DonVimodel> listdv;

    Button btnThemDv,btnThemDc;
    EditText txtTenDv,txtSdt,txtIddv;
    ListView lstDsDv;
    Spinner sprTinhthanh,sprPhuongxa,sprHuyenThi,sprLoai;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_donvi);
        listTinh= new ArrayList<>();
        listidTinh= new ArrayList<>();

        listHuyen= new ArrayList<>();
        listidHuyen= new ArrayList<>();

        listXa= new ArrayList<>();
        listidXa= new ArrayList<>();

        listLoai= new ArrayList<>();
        listidLoai= new ArrayList<>();

        listdv=new ArrayList<>();
        lstDsDv=findViewById(R.id.lseditdv);

        txtSdt=(EditText) findViewById(R.id.edsdtdv);
        txtTenDv=(EditText) findViewById(R.id.edTendv);
        btnThemDc=(Button) findViewById(R.id.btnadddiachi);
        btnThemDv=(Button) findViewById(R.id.btnadddv);
        /*list view*/
        adapter=new Adddvadapter(listdv,getApplicationContext());
        lstDsDv.setAdapter(adapter);

        getdata();
        /*Spiner database*/
        /*Spiner Tinh thanh*/
        sprTinhthanh=(Spinner) findViewById(R.id.sptinhthanh);
        arrayAdapterTinh=new ArrayAdapter<>(AddDonviActivity.this,android.R.layout.simple_spinner_item,listTinh);
        sprTinhthanh.setAdapter(arrayAdapterTinh);
        arrayAdapterTinh.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        getdataSpinerTinh();


        /*Spiner Huyen thi*/
        sprHuyenThi=(Spinner) findViewById(R.id.spquanhuyen);
        arrayAdapterHuyen=new ArrayAdapter<>(AddDonviActivity.this,android.R.layout.simple_spinner_item,listHuyen);
        sprHuyenThi.setAdapter(arrayAdapterHuyen);
        arrayAdapterHuyen.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        getdataSpinerHuyen();

        /*Spiner Xa phuong*/
        sprPhuongxa=(Spinner) findViewById(R.id.spPhuongxa);
        arrayAdapterXa=new ArrayAdapter<>(AddDonviActivity.this,android.R.layout.simple_spinner_item,listXa);
        sprPhuongxa.setAdapter(arrayAdapterXa);
        arrayAdapterXa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        getdataSpinerXaPhuong();
        /*Spiner Loai*/
        sprLoai=(Spinner) findViewById(R.id.sploaidv);
        arrayAdapterLoai=new ArrayAdapter<>(AddDonviActivity.this,android.R.layout.simple_spinner_item,listLoai);
        sprLoai.setAdapter(arrayAdapterLoai);
        arrayAdapterLoai.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        getdataSpinerLoai();
        lstDsDv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {

                AlertDialog.Builder builder = new AlertDialog.Builder(AddDonviActivity.this);
                builder.setTitle("Hỏi");
                builder.setMessage("Bạn thật sự muốn xóa?");
                builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // TODO Auto-generated method stub
                        database.delete(TABLE_DONVI,MADV+"=?",new String[]{listdv.get(position).getmMaDv()+""});
                        getdata();
                    }
                });
                builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // TODO Auto-generated method stub
                        dialog.dismiss();
                    }
                });

                builder.create().show();

            }

        });
        btnThemDc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(AddDonviActivity.this,tinhthanhActivity.class);
                startActivity(intent);
            }
        });
        /*event Spiner get Id Loai*/
        btnThemDv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                ArrayList<TinhThanhPhomodel> tinhThanhPhomodels =dbManager.getTinhThanh();
//                int positionmatinh=sprTinhthanh.getSelectedItemPosition();
//                int tinhthanh=tinhThanhPhomodels.get(positionmatinh).getmMatinhthanhpho();
//                Toast.makeText(getApplicationContext(), tinhthanh+"", Toast.LENGTH_LONG).show();
                final DonVimodel donVimodel=AdddonVi();
                if (donVimodel!=null){
                    try{
                        dbManager.addDonvi(donVimodel);
                        lstDsDv.setSelection(adapter.getCount()-1);

                        ///*/****
                        database=openOrCreateDatabase(DATABASE_NAME,MODE_PRIVATE,null);
                        Cursor cursor=database.rawQuery("SELECT * FROM donvi  ", null);
                        listdv.clear();
                        while (cursor.moveToNext()){
                            listdv.add(new DonVimodel(cursor.getInt(0),
                                    cursor.getString(1),
                                    cursor.getString(2),
                                    cursor.getInt(3),
                                    cursor.getInt(4),
                                    cursor.getInt(5),
                                    cursor.getInt(6)));
                            adapter.notifyDataSetChanged();

                        }
                        cursor.close();

                    }catch (Exception ex){
                        Toast.makeText(AddDonviActivity.this,"Thêm Không Thành Công",Toast.LENGTH_LONG).show();
                    }
                }else{
                    Toast.makeText(AddDonviActivity.this,"Thêm Không Thành Công",Toast.LENGTH_LONG).show();
                }

                /*event listview*/

                /*lstDsDv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
                    @Override
                    public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {

                        AlertDialog.Builder builder = new AlertDialog.Builder(AddDonviActivity.this);
                        builder.setTitle("Hỏi");
                        builder.setMessage("Bạn thật sự muốn xóa?");
                        builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // TODO Auto-generated method stub
                                DonVimodel donVimodel1=listdv.get(position);
                                dbManager.deleteDonvi(donVimodel.getmMaDv());
                            }
                        });
                        builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // TODO Auto-generated method stub
                                dialog.dismiss();
                            }
                        });
                        builder.create().show();
                        return false;
                    }
                });*/
            }
        });

    }
    /*Create don vi*/
    private DonVimodel AdddonVi(){


        String txtTenDichv=txtTenDv.getText().toString();
        String txtSodt=txtSdt.getText().toString();

        ArrayList<LoaiDVmodel> listDVModel=dbManager.getLoaiDV();
        int positionmaloai=sprLoai.getSelectedItemPosition();
        int donVi=listDVModel.get(positionmaloai).getmMaLoai();

        ArrayList<TinhThanhPhomodel> tinhThanhPhomodels =dbManager.getTinhThanh();
        int positionmatinh=sprTinhthanh.getSelectedItemPosition();
        int tinhthanh=tinhThanhPhomodels.get(positionmatinh).getmMatinhthanhpho();

        ArrayList<HuyenThiXaTpmodel> huyenThiXaTpmodels =dbManager.getHuyenThiXaTp();
        int positionmahuyen=sprHuyenThi.getSelectedItemPosition();
        int huyenthi=huyenThiXaTpmodels.get(positionmahuyen).getmMahuyenThixa();

        ArrayList<Phuongxamodel>phuongxamodels =dbManager.getPhuongXa();
        int positionmaxa=sprPhuongxa.getSelectedItemPosition();
        int phuongxa=phuongxamodels.get(positionmaxa).getmMaPhuongxa();

        DonVimodel donVimodel=new  DonVimodel(txtTenDichv,txtSodt,donVi,tinhthanh,huyenthi,phuongxa);
        return donVimodel;



  }
    /*Lay data*/
    private void getdataSpinerLoai() {
        database=openOrCreateDatabase(DATABASE_NAME,MODE_PRIVATE,null);
        Cursor cursor=database.rawQuery("SELECT * fROM loaidonvi ",null);
        listLoai.clear();

        while (cursor.moveToNext()){
            listLoai.add(new LoaiDVmodel(cursor.getString(1).toString()));

        }

        cursor.close();
        arrayAdapterLoai.notifyDataSetChanged();
    }

    private void getdataSpinerXaPhuong() {
        database=openOrCreateDatabase(DATABASE_NAME,MODE_PRIVATE,null);
        Cursor cursor=database.rawQuery("SELECT * fROM xaphuong ",null);
        listXa.clear();

        while (cursor.moveToNext()){
            listXa.add(new Phuongxamodel(cursor.getString(1).toString()));

        }

        cursor.close();
        arrayAdapterXa.notifyDataSetChanged();
    }

    /*get spiner huyen*/
    private void getdataSpinerHuyen() {
        database=openOrCreateDatabase(DATABASE_NAME,MODE_PRIVATE,null);
        Cursor cursor=database.rawQuery("SELECT * fROM huyenthixathanhpho ",null);
        listHuyen.clear();
        while (cursor.moveToNext()){
            listHuyen.add(new HuyenThiXaTpmodel(cursor.getString(1).toString()));

        }
        cursor.close();
        arrayAdapterHuyen.notifyDataSetChanged();
    }
/*get spiner tinh*/
    private void getdataSpinerTinh() {
        database=openOrCreateDatabase(DATABASE_NAME,MODE_PRIVATE,null);
        Cursor cursor=database.rawQuery("SELECT * fROM tinhthanhpho ",null);
        listTinh.clear();
        while (cursor.moveToNext()){
            listTinh.add(new TinhThanhPhomodel(cursor.getString(1).toString()));

        }
        cursor.close();
        arrayAdapterTinh.notifyDataSetChanged();
    }
    /*get Lisview*/
    private void getdata() {
        database=openOrCreateDatabase(DATABASE_NAME,MODE_PRIVATE,null);
        Cursor cursor=database.rawQuery("SELECT * FROM donvi  ", null);
        listdv.clear();
        while (cursor.moveToNext()){
            listdv.add(new DonVimodel(cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getInt(3),
                    cursor.getInt(4),
                    cursor.getInt(5),
                    cursor.getInt(6)));
            adapter.notifyDataSetChanged();

        }
        cursor.close();
    }


}
