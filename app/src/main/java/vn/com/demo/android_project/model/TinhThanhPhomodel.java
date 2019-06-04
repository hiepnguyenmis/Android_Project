package vn.com.demo.android_project.model;

public class TinhThanhPhomodel {
    private int mMatinhthanhpho;
    private String mTentinhthanhpho;

    public TinhThanhPhomodel() {
    }

    public TinhThanhPhomodel(int mMatinhthanhpho, String mTentinhthanhpho) {
        this.mMatinhthanhpho = mMatinhthanhpho;
        this.mTentinhthanhpho = mTentinhthanhpho;
    }

    public TinhThanhPhomodel(String mTentinhthanhpho) {
        this.mTentinhthanhpho = mTentinhthanhpho;
    }

    public int getmMatinhthanhpho() {
        return mMatinhthanhpho;
    }

    public void setmMatinhthanhpho(int mMatinhthanhpho) {
        this.mMatinhthanhpho = mMatinhthanhpho;
    }

    public String getmTentinhthanhpho() {
        return mTentinhthanhpho;
    }

    public void setmTentinhthanhpho(String mTentinhthanhpho) {
        this.mTentinhthanhpho = mTentinhthanhpho;
    }

    @Override
    public String toString() {
        return  mTentinhthanhpho;
    }
}
