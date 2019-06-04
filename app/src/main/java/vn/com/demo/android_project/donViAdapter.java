package vn.com.demo.android_project;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import vn.com.demo.android_project.model.DonVimodel;

public class donViAdapter extends BaseAdapter {
//    Activity mContext;
//    int mLayout;

        ArrayList<DonVimodel> mArarayListDonVi;
    Context context;

//    public donViAdapter(Activity context, int layout, ArrayList<DonVimodel> ArarayListDonVi){
//        mContext=context;
//        mLayout=layout;
//        mArarayListDonVi=ArarayListDonVi;
//    }

    public donViAdapter(ArrayList<DonVimodel> mArarayListDonVi, Context context) {
        this.mArarayListDonVi = mArarayListDonVi;
        this.context = context;
    }

    @Override
    public int getCount() {
        return mArarayListDonVi.size();
    }

    @Override
    public Object getItem(int position) {
        return mArarayListDonVi.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    private  class ViewHolder{
        TextView txtTenDonVi;
        TextView txtSodt;
        TextView txtDiaChiDV;

    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder=null;
        if(convertView==null)
        {
            viewHolder= new ViewHolder();
            LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=inflater.inflate(R.layout.custom_item_lisview_contact,null);
            viewHolder.txtTenDonVi=(TextView) convertView.findViewById(R.id.lblTenDonVi);
            viewHolder.txtSodt=(TextView) convertView.findViewById(R.id.lblSodtDonVi);
            viewHolder.txtDiaChiDV=(TextView) convertView.findViewById(R.id.lblDiaChiDonVi);
            convertView.setTag(viewHolder);
        }
        else{
            viewHolder= (ViewHolder) convertView.getTag();
        }

        DonVimodel donVimodel= (DonVimodel) getItem(position);
        viewHolder.txtTenDonVi.setText(donVimodel.getmTenDV());
        viewHolder.txtSodt.setText(donVimodel.getmSdt());
        viewHolder.txtDiaChiDV.setText(donVimodel.getmDiachi());
        return convertView;

    }
}
