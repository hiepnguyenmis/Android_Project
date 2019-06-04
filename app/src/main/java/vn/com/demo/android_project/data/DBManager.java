package vn.com.demo.android_project.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

import vn.com.demo.android_project.model.DonVimodel;
import vn.com.demo.android_project.model.HuyenThiXaTpmodel;
import vn.com.demo.android_project.model.LoaiDVmodel;
import vn.com.demo.android_project.model.Phuongxamodel;
import vn.com.demo.android_project.model.ThanhVienmodel;
import vn.com.demo.android_project.model.TinhThanhPhomodel;

public class DBManager extends SQLiteOpenHelper {
    /*Database Don vi*/
    private static final String DATABASE_NAME="donvi_manager";

    /*Table sdt*/
    private static final String TABLE_DONVI="donvi";
    private static final String MADV="madonvi";
    private static final String TENDV="tendonvi";
    private static final String SDT="sdt";
    private static final String MALOAIDV="maloaidonvi";
    private static final String MATINHTP="matinhtp";
    private static final String MAQUANHUYENTXTP="quanhuyentxtp";
    private static final String MAXAPHUONGTTRAN="maxaphuongttran";

    /*table loaidv*/
    private static final String TABLE_LOAIDONVI="loaidonvi";
    private static final String MALOAI="maloaidonvi";
    private static final String TENLOAIDV="tenloaidonvi";

    /*table tỉnh, thành phố*/
    private static final String TABLE_TINHTHANHPHO="tinhthanhpho";
    private static final String MATINHTHANHPHO="matinhthanhpho";
    private static final String TENTINHTP="tentinhthanhpho";

    /*table huyện thị xã thành phố*/
    private static final String TABLE_HUYENTHIXATHANHPHO="huyenthixathanhpho";
    private static final String MAHUYENTHXATHANHPHO="mahuyenthixathanhpho";
    private static final String TENHUYENTHXATHANHPHO="huyenthixathanhpho";

    /*table xã phường*/
    private static final String TABLE_PHUONGXA="xaphuong";
    private static final String MAPHUONGXA="maxaphuong";
    private static final String TENPHUONGXA="xaphuong";

    /*table User*/
    private static final String TABLE_THANHVIEN="thanhvien";
    private static final String MATHANHVIEN="mathanhien";
    private static final String TENDANGNHAP="tendangnhap";
    private static final String MATKHAU="matkhau";

    private static int Version=1;

    private Context context;
    /*Query create table*/
    private String SQLQueryCREATE_TABLE_DONVI="CREATE TABLE "+TABLE_DONVI+"("+
            MADV+" integer primary key autoincrement, "+
            TENDV+" TEXT, "+
            SDT+" TEXT, "+
            MALOAIDV+" INTEGER, "+
            MATINHTP+" INTETGER, "+
            MAQUANHUYENTXTP+" INTEGER, "+
            MAXAPHUONGTTRAN+" INTEGER) ";

    private String SQLQueryCREATE_TABLE_LOAIDONVI="CREATE TABLE "+TABLE_LOAIDONVI+"("+
            MALOAI+" integer primary key autoincrement, "+
            TENLOAIDV+" TEXT)";

    private String SQLQueryCREATE_TABLE_HUYENTHIXATHANHPHO="CREATE TABLE "+TABLE_HUYENTHIXATHANHPHO+"("+
             MAHUYENTHXATHANHPHO+" integer primary key autoincrement, "+
             TENHUYENTHXATHANHPHO+" TEXT)";

    private String SQLQueryCREATE_TABLE_PHUONGXA="CREATE TABLE "+TABLE_PHUONGXA+"("+
             MAPHUONGXA+" integer primary key autoincrement, "+
             TENPHUONGXA+" TEXT)";

    private String SQLQueryCREATE_TABLE_TINHTHANHPHO="CREATE TABLE "+TABLE_TINHTHANHPHO+"("+
            MATINHTHANHPHO+" integer primary key autoincrement, "+
            TENTINHTP+" TEXT)";

    private String SQLQueryCREATE_TABLE_THANHVIEN="CREATE TABLE "+TABLE_THANHVIEN+"("+
            MATHANHVIEN+" integer primary key autoincrement, "+
            TENDANGNHAP+" TEXT, "+
            MATKHAU+" TEXT)";


    public DBManager(Context context) {
        super(context, DATABASE_NAME, null, Version);
        this.context=context;
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(SQLQueryCREATE_TABLE_DONVI);
        db.execSQL(SQLQueryCREATE_TABLE_HUYENTHIXATHANHPHO);
        db.execSQL(SQLQueryCREATE_TABLE_PHUONGXA);
        db.execSQL(SQLQueryCREATE_TABLE_TINHTHANHPHO);
        db.execSQL(SQLQueryCREATE_TABLE_THANHVIEN);
        db.execSQL(SQLQueryCREATE_TABLE_LOAIDONVI);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_TINHTHANHPHO);
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_LOAIDONVI);
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_DONVI);
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_HUYENTHIXATHANHPHO);
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_PHUONGXA);
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_THANHVIEN);
        onCreate(db);


    }
/*Them du lieu*/
    public void addDonvi(DonVimodel donVimodel){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(TENDV,donVimodel.getmTenDV());
        values.put(SDT,donVimodel.getmSdt());
        values.put(MALOAIDV,donVimodel.getmMaLoaiDv());
        values.put(MATINHTP,donVimodel.getmMaTinhTP());
        values.put(MAQUANHUYENTXTP,donVimodel.getmMaQuanHuyenTxTp());
        values.put(MAXAPHUONGTTRAN,donVimodel.getmMaXaPhuongTTran());

        db.insert(TABLE_DONVI,null,values);
        db.close();
    }

    public void addThanhvien(ThanhVienmodel thanhVienmodel){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values= new ContentValues();
        values.put(TENDANGNHAP,thanhVienmodel.getmTenThanhVien());
        values.put(MATKHAU,thanhVienmodel.getmMatkhau());
        db.insert(TABLE_THANHVIEN,null,values);
        db.close();
    }

    public void addLoaiDonVi(LoaiDVmodel loaiDVmodel){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(TENLOAIDV,loaiDVmodel.getmTenLoai());
        db.insert(TABLE_LOAIDONVI,null,values);
        db.close();
    }

    public void addTinhThanhPho(TinhThanhPhomodel tinhThanhPhomodel){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(TENTINHTP,tinhThanhPhomodel.getmTentinhthanhpho());
        db.insert(TABLE_TINHTHANHPHO,null,values);
        db.close();

    }

    public void addPhuongXa(Phuongxamodel phuongxamodel){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(TENPHUONGXA,phuongxamodel.getmTenPhuongxa());
        db.insert(TABLE_PHUONGXA,null,values);
        db.close();
    }

    public void addHuyenTXTP(HuyenThiXaTpmodel huyenThiXaTpmodel){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(TENHUYENTHXATHANHPHO,huyenThiXaTpmodel.getmTenhuyenthixa());
        db.insert(TABLE_HUYENTHIXATHANHPHO,null,values);
        db.close();
    }
/*Truy vấn xữ lý*/
    public ArrayList<ThanhVienmodel> getThanhVien(){
        ArrayList<ThanhVienmodel> ListThanhVien=new ArrayList<>();

        String selectQuery="SELECT * FROM "+ TABLE_THANHVIEN;
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor=db.rawQuery(selectQuery,null);
        if(cursor.moveToFirst()){
            do{
                ThanhVienmodel thanhVienmodel=new ThanhVienmodel();
                thanhVienmodel.setmMathanhvien(cursor.getInt(0));
                thanhVienmodel.setmTenThanhVien(cursor.getString(1));
                thanhVienmodel.setmMatkhau(cursor.getString(2));
                ListThanhVien.add(thanhVienmodel);
            }while(cursor.moveToNext());
        }
        cursor.close();
        db.close();

        return ListThanhVien;
    }

    public ArrayList<TinhThanhPhomodel> getTinhThanh(){
        ArrayList<TinhThanhPhomodel> ListThanhPho=new ArrayList<>();

        String selectQuery="SELECT * FROM "+ TABLE_TINHTHANHPHO;
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor=db.rawQuery(selectQuery,null);
        if(cursor.moveToFirst()){
            do{
                TinhThanhPhomodel tinhThanhPhomodel=new TinhThanhPhomodel();
                tinhThanhPhomodel.setmMatinhthanhpho(cursor.getInt(0));
                tinhThanhPhomodel.setmTentinhthanhpho(cursor.getString(1));
                ListThanhPho.add(tinhThanhPhomodel);
            }while(cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return ListThanhPho;
    }

    public ArrayList<Phuongxamodel> getPhuongXa(){
        ArrayList<Phuongxamodel> ListXaPhuong=new ArrayList<>();

        String selectQuery="SELECT * FROM "+ TABLE_PHUONGXA;
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor=db.rawQuery(selectQuery,null);
        if(cursor.moveToFirst()){
            do{
                Phuongxamodel phuongxamodel=new Phuongxamodel();
                phuongxamodel.setmMaPhuongxa(cursor.getInt(0));
                phuongxamodel.setmTenPhuongxa(cursor.getString(1));
                ListXaPhuong.add(phuongxamodel);
            }while(cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return ListXaPhuong;
    }

    public ArrayList<HuyenThiXaTpmodel> getHuyenThiXaTp(){
        ArrayList<HuyenThiXaTpmodel> ListHuyenThiXaTp=new ArrayList<>();

        String selectQuery="SELECT * FROM "+ TABLE_HUYENTHIXATHANHPHO;
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor=db.rawQuery(selectQuery,null);
        if(cursor.moveToFirst()){
            do{
                HuyenThiXaTpmodel huyenThiXaTpmodel=new HuyenThiXaTpmodel();
                huyenThiXaTpmodel.setmMahuyenThixa(cursor.getInt(0));
                huyenThiXaTpmodel.setmTenhuyenthixa(cursor.getString(1));
                ListHuyenThiXaTp.add(huyenThiXaTpmodel);
            }while(cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return ListHuyenThiXaTp;
    }

    public ArrayList<LoaiDVmodel> getLoaiDV(){
        ArrayList<LoaiDVmodel> ListLoaiDV=new ArrayList<>();

        String selectQuery="SELECT * FROM "+ TABLE_LOAIDONVI;
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor=db.rawQuery(selectQuery,null);
        if(cursor.moveToFirst()){
            do{
                LoaiDVmodel loaiDVmodel=new LoaiDVmodel();
                loaiDVmodel.setmMaLoai(cursor.getInt(0));
                loaiDVmodel.setmTenLoai(cursor.getString(1));
                ListLoaiDV.add(loaiDVmodel);
            }while(cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return ListLoaiDV;
    }

    public ArrayList<DonVimodel> getDonvi(){
        ArrayList<DonVimodel> DonVimodel=new ArrayList<>();

        String selectQuery="SELECT * FROM "+ TABLE_DONVI;

        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor=db.rawQuery(selectQuery,null);
        if(cursor.moveToFirst()){
            do{
                DonVimodel donVimodel=new DonVimodel();

                donVimodel.setmMaDv(cursor.getInt(0));
                donVimodel.setmTenDV(cursor.getString(1));
                donVimodel.setmSdt(cursor.getString(2));
                donVimodel.setmMaLoaiDv(cursor.getInt(3));
                donVimodel.setmMaTinhTP(cursor.getInt(4));
                donVimodel.setmMaQuanHuyenTxTp(cursor.getInt(5));
                donVimodel.setmMaXaPhuongTTran(cursor.getInt(6));
                DonVimodel.add(donVimodel);

            }while(cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return DonVimodel;
    }
}
