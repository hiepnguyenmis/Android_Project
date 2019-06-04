package vn.com.demo.android_project.model;

public class DonVimodel {
    private int mMaDv;
    private String mTenDV;
    private String mSdt;
    private int mMaLoaiDv;
    private int mMaTinhTP;
    private int mMaQuanHuyenTxTp;
    private int mMaXaPhuongTTran;
    private String mDiachi;

    public String getmDiachi() {
        return mDiachi;
    }

    public void setmDiachi(String mDiachi) {
        this.mDiachi = mDiachi;
    }

    public DonVimodel() {
    }

    public DonVimodel(int mMaDv, String mTenDV, String mSdt, int mMaLoaiDv, int mMaTinhTP, int mMaQuanHuyenTxTp, int mMaXaPhuongTTran, String mDiachi) {
        this.mMaDv = mMaDv;
        this.mTenDV = mTenDV;
        this.mSdt = mSdt;
        this.mMaLoaiDv = mMaLoaiDv;
        this.mMaTinhTP = mMaTinhTP;
        this.mMaQuanHuyenTxTp = mMaQuanHuyenTxTp;
        this.mMaXaPhuongTTran = mMaXaPhuongTTran;
        this.mDiachi = mDiachi;
    }
    public DonVimodel(int mMaDv, String mTenDV, String mSdt, int mMaLoaiDv, int mMaTinhTP, int mMaQuanHuyenTxTp, int mMaXaPhuongTTran) {
        this.mMaDv = mMaDv;
        this.mTenDV = mTenDV;
        this.mSdt = mSdt;
        this.mMaLoaiDv = mMaLoaiDv;
        this.mMaTinhTP = mMaTinhTP;
        this.mMaQuanHuyenTxTp = mMaQuanHuyenTxTp;
        this.mMaXaPhuongTTran = mMaXaPhuongTTran;

    }
    public DonVimodel(String mTenDV, String mSdt, int mMaLoaiDv, int mMaTinhTP, int mMaQuanHuyenTxTp, int mMaXaPhuongTTran) {
        this.mTenDV = mTenDV;
        this.mSdt = mSdt;
        this.mMaLoaiDv = mMaLoaiDv;
        this.mMaTinhTP = mMaTinhTP;
        this.mMaQuanHuyenTxTp = mMaQuanHuyenTxTp;
        this.mMaXaPhuongTTran = mMaXaPhuongTTran;

    }


    public int getmMaDv() {
        return mMaDv;
    }

    public void setmMaDv(int mMaDv) {
        this.mMaDv = mMaDv;
    }

    public String getmTenDV() {
        return mTenDV;
    }

    public void setmTenDV(String mTenDV) {
        this.mTenDV = mTenDV;
    }

    public String getmSdt() {
        return mSdt;
    }

    public void setmSdt(String mSdt) {
        this.mSdt = mSdt;
    }

    public int getmMaLoaiDv() {
        return mMaLoaiDv;
    }

    public void setmMaLoaiDv(int mMaLoaiDv) {
        this.mMaLoaiDv = mMaLoaiDv;
    }

    public int getmMaTinhTP() {
        return mMaTinhTP;
    }

    public void setmMaTinhTP(int mMaTinhTP) {
        this.mMaTinhTP = mMaTinhTP;
    }

    public int getmMaQuanHuyenTxTp() {
        return mMaQuanHuyenTxTp;
    }

    public void setmMaQuanHuyenTxTp(int mMaQuanHuyenTxTp) {
        this.mMaQuanHuyenTxTp = mMaQuanHuyenTxTp;
    }

    public int getmMaXaPhuongTTran() {
        return mMaXaPhuongTTran;
    }

    public void setmMaXaPhuongTTran(int mMaXaPhuongTTran) {
        this.mMaXaPhuongTTran = mMaXaPhuongTTran;
    }
}
