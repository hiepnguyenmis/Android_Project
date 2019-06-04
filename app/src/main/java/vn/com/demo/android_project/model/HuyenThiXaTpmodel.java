package vn.com.demo.android_project.model;

public class HuyenThiXaTpmodel {


    private int mMahuyenThixa;
    private String mTenhuyenthixa;

    public HuyenThiXaTpmodel() {
    }
    public int getmMahuyenThixa() {
        return mMahuyenThixa;
    }

    public void setmMahuyenThixa(int mMahuyenThixa) {
        this.mMahuyenThixa = mMahuyenThixa;
    }

    public String getmTenhuyenthixa() {
        return mTenhuyenthixa;
    }

    public void setmTenhuyenthixa(String mTenhuyenthixa) {
        this.mTenhuyenthixa = mTenhuyenthixa;
    }

    public HuyenThiXaTpmodel(String mTenhuyenthixa) {
        this.mTenhuyenthixa = mTenhuyenthixa;
    }

    public HuyenThiXaTpmodel(int mMahuyenThixa, String mTenhuyenthixa) {
        this.mMahuyenThixa = mMahuyenThixa;
        this.mTenhuyenthixa = mTenhuyenthixa;
    }

    @Override
    public String toString() {
        return  mTenhuyenthixa ;
    }
}
