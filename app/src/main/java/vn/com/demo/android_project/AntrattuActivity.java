package vn.com.demo.android_project;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

import vn.com.demo.android_project.data.DBManager;
import vn.com.demo.android_project.model.DonVimodel;
import vn.com.demo.android_project.model.HuyenThiXaTpmodel;
import vn.com.demo.android_project.model.Phuongxamodel;
import vn.com.demo.android_project.model.TinhThanhPhomodel;

public class AntrattuActivity extends AppCompatActivity {
    String strXP="";
    String strHT="";
    String strTP="";
    ImageButton btnSearch;
    ListView lvAntt;
    Spinner sprXaPhuong,sprHuyenThi,sprTinhthanh;
    ArrayList<DonVimodel> listdonvi;
    ArrayList<Phuongxamodel> listPhuongxa;


    ArrayList<HuyenThiXaTpmodel> listhuyen;

    ArrayList<TinhThanhPhomodel> listTinhthanh;

    ArrayAdapter<Phuongxamodel> adapterPx;
    ArrayAdapter<HuyenThiXaTpmodel> adapterHT;
    ArrayAdapter<TinhThanhPhomodel> adapterTinhThanh;

    donViAdapter adapter;

    String DATABASE_NAME="donvi_manager";
    SQLiteDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_antrattu);
        lvAntt = (ListView) findViewById(R.id.lvTratTu);
        listdonvi=new ArrayList<DonVimodel>();

        listdonvi= new ArrayList<>();
        listPhuongxa=new ArrayList<>();
        listTinhthanh=new ArrayList<>();
        listhuyen=new ArrayList<>();

        btnSearch=findViewById(R.id.btnsearch);
        btnSearch();

        adapter=new donViAdapter(listdonvi,getApplicationContext());
        lvAntt.setAdapter(adapter);
//        getdata();
        try{
            lvAntt.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    String str=listdonvi.get(position).getmSdt();
                    Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:"+str));
                startActivity(intent);
                }
            });
        }catch (Exception ex){
            throw  ex;
        }
        /*Spiner Phuongxa*/
        sprXaPhuong=(Spinner) findViewById(R.id.sprXa);
        adapterPx=new ArrayAdapter<>(AntrattuActivity.this,android.R.layout.simple_spinner_item,listPhuongxa);
        sprXaPhuong.setAdapter(adapterPx);
        adapterPx.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        getdataSpinerPhuongxa();

        /*event */
       sprXaPhuong.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
           @Override
           public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
               Toast.makeText(AntrattuActivity.this,listPhuongxa.get(position).getmTenPhuongxa(),Toast.LENGTH_LONG).show();
           }

           @Override
           public void onNothingSelected(AdapterView<?> parent) {

           }
       });

        /*Spinser Huyen Thi*/
        sprHuyenThi=(Spinner) findViewById(R.id.sprHuyen);
        adapterHT=new ArrayAdapter<>(AntrattuActivity.this,android.R.layout.simple_spinner_item,listhuyen);
        sprHuyenThi.setAdapter(adapterHT);
        adapterHT.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        getdataSpinerQuanHuyen();

        /*Spiner Tinh Thanh*/
        sprTinhthanh=(Spinner) findViewById(R.id.sprTinh);
        adapterTinhThanh=new ArrayAdapter<>(AntrattuActivity.this,android.R.layout.simple_spinner_item,listTinhthanh);
        sprTinhthanh.setAdapter(adapterTinhThanh);
        adapterTinhThanh.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        getdataSpinerTinhthanh();
    }


    /**get Spinser Tinh thành**/
    private void getdataSpinerTinhthanh() {
        database=openOrCreateDatabase(DATABASE_NAME,MODE_PRIVATE,null);
        Cursor cursor=database.rawQuery("SELECT * fROM tinhthanhpho ",null);
        listTinhthanh.clear();
        while (cursor.moveToNext()){
            listTinhthanh.add(new TinhThanhPhomodel(cursor.getString(1).toString()));

        }
        cursor.close();
        adapterTinhThanh.notifyDataSetChanged();
    }


    /*get Spinser Huyen Thi*/
    private void getdataSpinerQuanHuyen() {
        database=openOrCreateDatabase(DATABASE_NAME,MODE_PRIVATE,null);
        Cursor cursor=database.rawQuery("SELECT * fROM huyenthixathanhpho ",null);
        listhuyen.clear();
        while (cursor.moveToNext()){
            listhuyen.add(new HuyenThiXaTpmodel(cursor.getString(1).toString()));

        }
        cursor.close();
        adapterHT.notifyDataSetChanged();
    }


    /*get Spinser phuong xa*/
    private void getdataSpinerPhuongxa() {
        database=openOrCreateDatabase(DATABASE_NAME,MODE_PRIVATE,null);
        Cursor cursor=database.rawQuery("SELECT * fROM xaphuong ",null);
        listPhuongxa.clear();
        int i=0;
        while (cursor.moveToNext()){
            listPhuongxa.add(new Phuongxamodel(cursor.getString(1).toString()));

        }

        cursor.close();
        adapterPx.notifyDataSetChanged();

    }

//    private void getdata() {
//        database=openOrCreateDatabase(DATABASE_NAME,MODE_PRIVATE,null);
//        Cursor cursor=database.rawQuery("SELECT * FROM donvi where ", null);
//        listdonvi.clear();
//        while (cursor.moveToNext()){
//            listdonvi.add(new DonVimodel(cursor.getInt(0),
//            cursor.getString(1),
//            cursor.getString(2),
//            cursor.getInt(3),
//            cursor.getInt(4),
//            cursor.getInt(5),
//            cursor.getInt(6)));
//            adapter.notifyDataSetChanged();
//        }
//        cursor.close();
//    }

   public void btnSearch(){
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                strXP=sprXaPhuong.getSelectedItem().toString();
                strHT=sprHuyenThi.getSelectedItem().toString();
                strTP=sprTinhthanh.getSelectedItem().toString();

                database=openOrCreateDatabase(DATABASE_NAME,MODE_PRIVATE,null);
                Cursor cursor=database.rawQuery("SELECT dv.madonvi,dv.tendonvi, dv.sdt,dv.maloaidonvi,dv.matinhtp,dv.quanhuyentxtp,dv.maxaphuongttran, xp.xaphuong, h.huyenthixathanhpho, tp.tentinhthanhpho FROM donvi dv, xaphuong xp, tinhthanhpho tp, huyenthixathanhpho h WHERE dv.maxaphuongttran=xp.maxaphuong and dv.matinhtp=tp.matinhthanhpho and dv.quanhuyentxtp=h.mahuyenthixathanhpho and xp.xaphuong='"+strXP+"' and tp.tentinhthanhpho= '"+strTP+"' and h.huyenthixathanhpho='"+strHT+"' and dv.maloaidonvi=1",null);
                listdonvi.clear();
                String Diachi="";
                while (cursor.moveToNext()){
                    Diachi=cursor.getString(7)+","+cursor.getString(8)+","+cursor.getString(9);
                    listdonvi.add(new DonVimodel(cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getInt(3),
                    cursor.getInt(4),
                    cursor.getInt(5),
                    cursor.getInt(6),Diachi));
                }

                cursor.close();
                adapter.notifyDataSetChanged();
            }
        });
   }

}
