package vn.com.demo.android_project.model;

public class ThanhVienmodel {
    private int mMathanhvien;
    private String mTenThanhVien;
    private String mMatkhau;

    public ThanhVienmodel(int mMathanhvien, String mTenThanhVien, String mMatkhau) {
        this.mMathanhvien = mMathanhvien;
        this.mTenThanhVien = mTenThanhVien;
        this.mMatkhau = mMatkhau;
    }

    public ThanhVienmodel(String mTenThanhVien, String mMatkhau) {
        this.mTenThanhVien = mTenThanhVien;
        this.mMatkhau = mMatkhau;
    }

    public int getmMathanhvien(int anInt) {
        return mMathanhvien;
    }

    public ThanhVienmodel() {
    }

    public void setmMathanhvien(int mMathanhvien) {
        this.mMathanhvien = mMathanhvien;
    }

    public String getmTenThanhVien() {
        return mTenThanhVien;
    }

    public void setmTenThanhVien(String mTenThanhVien) {
        this.mTenThanhVien = mTenThanhVien;
    }

    public String getmMatkhau() {
        return mMatkhau;
    }

    public void setmMatkhau(String mMatkhau) {
        this.mMatkhau = mMatkhau;
    }
}
