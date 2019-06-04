package vn.com.demo.android_project.model;

public class Phuongxamodel {
    private int mMaPhuongxa;
    private String mTenPhuongxa;

    public int getmMaPhuongxa() {
        return mMaPhuongxa;
    }

    public Phuongxamodel() {
    }

    public void setmMaPhuongxa(int mMaPhuongxa) {
        this.mMaPhuongxa = mMaPhuongxa;
    }

    public String getmTenPhuongxa() {
        return mTenPhuongxa;
    }

    public void setmTenPhuongxa(String mTenPhuongxa) {
        this.mTenPhuongxa = mTenPhuongxa;
    }

    public Phuongxamodel(String mTenPhuongxa) {
        this.mTenPhuongxa = mTenPhuongxa;
    }

    public Phuongxamodel(int mMaPhuongxa, String mTenPhuongxa) {
        this.mMaPhuongxa = mMaPhuongxa;
        this.mTenPhuongxa = mTenPhuongxa;
    }

    @Override
    public String toString() {
        return mTenPhuongxa;
    }
}
