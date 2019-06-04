package vn.com.demo.android_project.model;

public class LoaiDVmodel {
    private int mMaLoai;
    private String mTenLoai;

    public LoaiDVmodel() {
    }

    public LoaiDVmodel(String mTenLoai) {
        this.mTenLoai = mTenLoai;
    }

    public LoaiDVmodel(int mMaLoai, String mTenLoai) {
        this.mMaLoai = mMaLoai;
        this.mTenLoai = mTenLoai;
    }

    public int getmMaLoai() {
        return mMaLoai;
    }

    public void setmMaLoai(int mMaLoai) {
        this.mMaLoai = mMaLoai;
    }

    public String getmTenLoai() {
        return mTenLoai;
    }

    public void setmTenLoai(String mTenLoai) {
        this.mTenLoai = mTenLoai;
    }

    @Override
    public String toString() {
        return  mTenLoai;
    }
}
